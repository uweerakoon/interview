package designpatterns.solid;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

// Primary responsibility
// onhly have one reason to change
public class SingleResponsibilityPrinciple_SRP {
  public static void main(String[] args) throws Exception {
    Journal j = new Journal();
    j.addEntry("I cried today");
    j.addEntry("I ate a bug");
    System.out.println(j);
    
    Persistence persistence = new Persistence();
    String fileName = "journal.txt";
    persistence.saveToFile(j, fileName, true);
    Runtime.getRuntime().exec("vi "+ fileName);
  }
}

class Journal {
  private final List<String> entries = new ArrayList<String>();
  private static int count = 0;
  
  public void addEntry(String text) {
    entries.add(""+(++count)+": "+text);
  }
  
  public void removeEntry(int index) {
    entries.remove(index);
  }
  
  @Override
  public String toString() {
    return String.join(System.lineSeparator(), entries);
  }
  
  // Anti-pattern: consistence is a different thing, create 
  // a class called Persistence
  public void save(String fileName) throws FileNotFoundException {
    try(PrintStream out = new PrintStream(fileName)) {
      out.println(toString());
    }
  }
  
  public void load(String fileName) {}
  public void load(URL url) {}
}

class Persistence {
  public void saveToFile(Journal journal, String fileName, boolean overwrite) throws FileNotFoundException {
    if(overwrite || new File(fileName).exists()) {
      try(PrintStream out = new PrintStream(fileName)) {
        out.println(journal.toString());
      }
    }
  }
  public Journal load(String fileName) {
    return null;
  }
  public Journal load(URL url) {
    return null;
  }
}
