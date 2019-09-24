package designpatterns.singleton;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

import com.google.common.collect.Iterables;
// do not use the live data, just need to test with dummy data because 
// unit tests runs on mocked data
// The answer is Singleton Dependency Injection
public class TestabilityIssues {
  public static void main(String[] args) {
    SingletonRecordFinder sf = new SingletonRecordFinder();
    List<String> names = Arrays.asList("Seoul", "Mexico City");
    int tp = sf.getTotalPopulation(names);
    System.out.println(tp);
    
    // dependency Injection
    DummyDatabase db = new DummyDatabase();
    ConfigurableRecordFinder rf = new ConfigurableRecordFinder(db);
    names = Arrays.asList("alpha", "gamma");
    tp = rf.getTotalPopulation(names);
    System.out.println(tp);
  } 
}

interface Database {
  int getPopulation(String name); 
}

// Dependency Injection
class ConfigurableRecordFinder {
  private Database database;
  public ConfigurableRecordFinder(Database database) {
    this.database = database;
  }
  public int getTotalPopulation(List<String> names) {
    int result = 0;
    for(String name : names) {
      result += database.getPopulation(name);
    }
    return result;
  }
}

class DummyDatabase implements Database {
  private Dictionary<String, Integer> data = new Hashtable<>(); 
  public DummyDatabase() {
    data.put("alpha", 1);
    data.put("beta", 1);
    data.put("gamma", 1);
  }
  
  @Override
  public int getPopulation(String name) {
    return data.get(name);
  }
}

class SingletonDatabase implements Database {
  private Dictionary<String, Integer> capitals = new Hashtable<>();
  private static int instanceCount = 0;
  public static int getCount() { return instanceCount; }
  
  private SingletonDatabase() {
    instanceCount++;
    System.out.println("Initializing Database");
    try {
      File file = new File(SingletonDatabase.class.getProtectionDomain().getCodeSource().getLocation().getPath());
      Path fullPath = Paths.get(file.getPath(), "capitals.txt");
      List<String> lines = Files.readAllLines(fullPath);
      
      Iterables.partition(lines, 2)
          .forEach(kv -> capitals.put(kv.get(0).trim(), Integer.parseInt(kv.get(1))));
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }
  
  private static final SingletonDatabase INSTANCE = new SingletonDatabase();
  
  public static SingletonDatabase getInstance() { return INSTANCE; }
  
  @Override
  public int getPopulation(String name) {
    return capitals.get(name);
  }
}

class SingletonRecordFinder {
  public int getTotalPopulation(List<String> names) {
    int result = 0;
    for(String name : names) {
      result += SingletonDatabase.getInstance().getPopulation(name);
    }
    return result;
  }
}
