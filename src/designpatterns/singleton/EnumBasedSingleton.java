package designpatterns.singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
// All the feilds are not getting serialized
// once you de-serialized you will get value 42
// no inheritence
enum SingletonEnum {
  INSTANCE;
  
  SingletonEnum() {
    value = 42; 
  }
  
  private int value;

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }
  
}

public class EnumBasedSingleton {
  static void saveToFile(SingletonEnum singleton, String filename)
      throws Exception
    {
      try (FileOutputStream fileOut = new FileOutputStream(filename);
           ObjectOutputStream out = new ObjectOutputStream(fileOut))
      {
        out.writeObject(singleton);
      }
    }

    static SingletonEnum readFromFile(String filename)
      throws Exception
    {
      try (FileInputStream fileIn = new FileInputStream(filename);
           ObjectInputStream in = new ObjectInputStream(fileIn) )
      {
        return (SingletonEnum)in.readObject();
      }
    }

    public static void main(String[] args) throws Exception
    {
      SingletonEnum singleton = SingletonEnum.INSTANCE;
      singleton.setValue(111);

      String filename = "singleton.bin";
      saveToFile(singleton, filename);

      singleton.setValue(222);

      SingletonEnum singleton2 = readFromFile(filename);

      System.out.println(singleton == singleton2);

      System.out.println(singleton.getValue());
      System.out.println(singleton2.getValue());
    }
}