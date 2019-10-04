package designpatterns.proxy;
/**
 * write all the logs for each assignment
 * @author udaraweerakoon
 *
 */
public class PropertyProxy {
  public static void main(String[] args) {
    // does not now the original value
    int x = 0;
    x = 5;
    
    Creature creature = new Creature();
    creature.setAgility(12);
  }
}

class Property<T> {
  private T value;
  public Property(T value) {
    this.value = value;
  }
  public T getValue() {
    return value;
  }
  public void setValue(T value) {
    // log the value using log4j
    System.out.println("orig value: "+this.value+" change to: "+value);
    this.value = value;
  }
  @Override
  public boolean equals(Object o) {
    if(this == o) return true;
    if(o == null || getClass() != o.getClass()) return false;
    Property<?> property = (Property<?>) o;
    return value != null 
        ? value.equals(property.value) : property.value == null; 
  }
}

class Creature {
  private Property<Integer> agility = new Property(10);
  
  public int getAgility() {
    return agility.getValue();
  }

  public void setAgility(int agility) {
    this.agility.setValue(agility);
  }
  
}
