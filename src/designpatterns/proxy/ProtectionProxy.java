package designpatterns.proxy;
/**
 * A class that functions as an interface to 
 * a particular resource. That resource
 * may be remote, expensive to construct, 
 * or may require logging or some other
 * added functionality
 * @author udaraweerakoon
 *
 */
public class ProtectionProxy {
  public static void main(String[] args) {
    Car car = new Car(new Driver(12));
    car.drive();
    // above is wrong, below is correct
    car = new CarProxy(new Driver(12));
    car.drive();
  }
}

interface Drivable {
  void drive();
}

class Car implements Drivable {
  protected Driver driver;

  public Car(Driver driver) {
    super();
    this.driver = driver;
  }
  @Override
  public void drive() {
    System.out.println("Car being driven");
  }
}

class Driver {
  public int age;

  public Driver(int age) {
    super();
    this.age = age;
  }
}

class CarProxy extends Car {
  public CarProxy(Driver driver) {
    super(driver);
  }
  
  @Override
  public void drive() {
    if(driver.age >= 16)
      super.drive();
    else 
      System.out.println("Driver too young!");
  }
}