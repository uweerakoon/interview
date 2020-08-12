package designpatterns.flyweight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import com.google.common.base.Strings;

// avoid redundancy when stroing data
// MMORPG - big onlien game
// bold or italic text in the console

// A space optimization technique that lets us use less memory
// by stroing externally the data associated with similar objects

public class RepeatingUserNames {
  /*User user = new User("John Smith");
  User user2 = new User("Jane Smith");*/ // problem of saving 5 bits of second smith
  
  User2 user = new User2("John Smith");
  User2 user2 = new User2("Jane Smith");
}

class User {
  private String fullName;
  public User(String fullName) {
    this.fullName = fullName;
  }
}

class User2 {
  // big cache of nanmes
  static List<String> strings = new ArrayList<String>();
  // pointer to the names size of two
  private int[] names;
  public User2(String fullName) {
    Function<String, Integer> getOrAdd = (String s) -> {
      int idx = strings.indexOf(s);
      if(idx != -1) return idx;
      else {
        strings.add(s); 
        return strings.size() - 1;
      }
    };
    
    names = Arrays.stream(fullName.split(" "))
        .mapToInt(s -> getOrAdd.apply(s))
        .toArray();
  }
}
