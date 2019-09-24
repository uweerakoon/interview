package designpatterns.singleton;
// No body know what is going on, the instance creation time and its values
public class Monostate {
  public static void main(String[] args) {
    ChiefExecutiveOfficer ceo = new ChiefExecutiveOfficer();
    ceo.setName("Adam Smith");
    ceo.setAge(55);
    
    ChiefExecutiveOfficer ceo2 = new ChiefExecutiveOfficer();
    System.out.println(ceo2);
  }
}

class ChiefExecutiveOfficer {
  private static String name;
  private static int age;
  public String getName() {
    return name;
  }
  public void setName(String name) {
    ChiefExecutiveOfficer.name = name;
  }
  public int getAge() {
    return age;
  }
  public void setAge(int age) {
    ChiefExecutiveOfficer.age = age;
  }
  @Override
  public String toString() {
    return "ChiefExecutiveOfficer [name=" + name + ", age=" + age + "]";
  }
  
}