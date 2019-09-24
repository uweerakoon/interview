package designpatterns.singleton;

public class LazyAndThreadSafety {

  private static LazyAndThreadSafety instance;
  private LazyAndThreadSafety() {
    System.out.println("Initializing a lazy singleton");
  }
  /*public static synchronized LazyAndThreadSafety getInstance() { // thread safe, heavy use of resources
    if(instance == null) {
      instance = new LazyAndThreadSafety();
    }
    return instance;
  }*/
  
  // double-checked locking - outdated
  public static LazyAndThreadSafety getInstance() {
    if(instance == null) {
      synchronized (LazyAndThreadSafety.class) {
        if(instance == null) {
          instance = new LazyAndThreadSafety();
        }
      }
    }
    return instance;
  }
}
