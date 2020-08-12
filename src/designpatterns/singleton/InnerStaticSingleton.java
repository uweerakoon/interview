package designpatterns.singleton;

public class InnerStaticSingleton {
  private InnerStaticSingleton() { }
  
  private static class Impl {
    private static final InnerStaticSingleton instance = new InnerStaticSingleton();
    
  }
  // No need to worry about thread safety
  public InnerStaticSingleton getInstance() {
    return Impl.instance;
  }
}
