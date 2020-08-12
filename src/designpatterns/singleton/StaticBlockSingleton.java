package designpatterns.singleton;

import java.io.File;
import java.io.IOException;

public class StaticBlockSingleton {
  private StaticBlockSingleton() throws IOException {
    System.out.println("Singleton is initialized");
    File.createTempFile(".", "."); 
  }
  private static StaticBlockSingleton instance;
  
  static {
    try {
      instance = new StaticBlockSingleton();
    }
    catch(Exception e) {
      System.err.println("Failed to create Singleton");
    }
  }
  
  public static StaticBlockSingleton getInstance() {
    return instance;
  }
}
