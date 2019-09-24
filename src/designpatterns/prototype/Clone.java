package designpatterns.prototype;

import java.util.Arrays;
// This is not good, because of the deep copying.
// clone only good for shallow copying
// clonable is normally protected
public class Clone {
  public static void main(String[] args) throws Exception {
    Person john = new Person(new String[] {"John", "Smith"}, new Address("London Road", 123));
    Person jane = (Person) john.clone();
    jane.names[0] = "Jane";
    jane.address.houseNumber = 124;
    System.out.println(john);
    System.out.println(jane);
    
  }
}

class Address implements Cloneable {
  public String streetName;
  public int houseNumber;
  public Address(String streetName, int houseNumber) {
    this.streetName = streetName;
    this.houseNumber = houseNumber;
  }
  @Override
  public String toString() {
    return "Address [streetName=" + streetName + ", houseNumber=" + houseNumber + "]";
  }
  
  @Override
  protected Object clone() throws CloneNotSupportedException {
//    return super.clone(); // shallow copy
    return new Address(streetName, houseNumber); // deep copy
  }
}

class Person implements Cloneable  {
  public String[] names;
  public Address address;
  public Person(String[] names, Address address) {
    this.names = names;
    this.address = address;
  }
  @Override
  public String toString() {
    return "Person [names=" + Arrays.toString(names) + ", address=" + address + "]";
  }
  
  @Override
  public Object clone() throws CloneNotSupportedException {
//    return new Person(names, address); // shallow copy
    return new Person(names.clone(), (Address) address.clone());
  }
}
