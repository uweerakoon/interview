package designpatterns.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;
/**
 * Proxy Vs Decorator
 * 1. Proxy provides an identical interface; decorator provides an enhance interface
 * 2. Decorator typically aggregates (or has reference to) what it is decorating; proxy doesn't have to
 * 3. Proxy might not even be working with a materialized object
 * 
 * Summary:
 * 1. A proxy has the same interface as the underlying object
 * 2. To create a proxy, simple replicate the existing interface of an object
 * 3. Add relevant functionality to the redeinfed member functions
 * 4. Different proxies (communicatin, logging, caching, etc.) have completely different behaviors
 * @author udaraweerakoon
 *
 */
public class DynamicProxyLogging {

  @SuppressWarnings("unchecked")
  public static <T> T withLogging(T target, Class<T> itf) {
    return (T) Proxy.newProxyInstance(itf.getClassLoader(), new Class<?>[] {itf}, new LoggingHandler(target));
  }
  public static void main(String[] args) {
    Person person = new Person();
    Human logged = withLogging(person, Human.class);
    logged.talk();
    logged.walk();
    logged.walk();
    System.out.println(logged);
  }
}
 
interface Human {
  void walk();
  void talk();
}

class Person implements Human {

  @Override
  public void walk() {
   System.out.println("I am walking");
  }

  @Override
  public void talk() {
    System.out.println("I am talking");
  }
}

class LoggingHandler implements InvocationHandler {
  private final Object target;
  private Map<String, Integer> calls = new HashMap<>();
  public LoggingHandler(Object target) {
    this.target = target; 
  }
  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    String name = method.getName();
    if(name.contains("toString")) {
      return calls.toString();
  }
    calls.merge(name, 1, Integer::sum);
    return method.invoke(target, args);
  }
  
}
