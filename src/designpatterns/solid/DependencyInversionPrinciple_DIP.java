package designpatterns.solid;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.javatuples.Triplet;

// A. High level modules should not depend on low-level modules
// both should depend on abstractions

// B. Abstractions should not depend on details.
// Details should depend on abstractions.
public class DependencyInversionPrinciple_DIP {

  public static void main(String[] args) {
    Person parent = new Person("John");
    Person child1 = new Person("Chris");
    Person child2 = new Person("Matt");
    
    Relationships relationships = new Relationships();
    relationships.addParentAndChild(parent, child1);
    relationships.addParentAndChild(parent, child2);
    
    new Research(relationships);
  }
}

enum Relationship {
  PARENT, CHILD, SIBLING;
}

class Person {
  public String name;

  public Person(String name) {
    this.name = name;
  }
  
  
}

interface RelationshipBrowser { // abstraction
  public List<Person> findAllChildrenOf(String name);
}


class Relationships implements RelationshipBrowser { // low-level - no business logic
  private List<Triplet<Person, Relationship, Person>> relations = new ArrayList<>();
  
  public void addParentAndChild(Person parent, Person child) {
    relations.add(new Triplet<>(parent, Relationship.PARENT, child));
    relations.add(new Triplet<>(child, Relationship.CHILD , parent));
  }

  public List<Triplet<Person, Relationship, Person>> getRelations() {
    return relations;
  } 
  
  @Override
  public List<Person> findAllChildrenOf(String name) {
    return relations.stream()
    .filter(x -> x.getValue0().name.equals("John")
      && x.getValue1() == Relationship.PARENT)
    .map(Triplet::getValue2)
    .collect(Collectors.toList());
  }
}

class Research { // high-level - allow perfomance of the low-level
  /*public Research(Relationships relationships) { // bad - high-level is depend on low-level at the construction levele
    List<Triplet<Person, Relationship, Person>> relations = relationships.getRelations();
    relations.stream()
      .filter(x -> x.getValue0().name.equals("John")
        && x.getValue1() == Relationship.PARENT)
      .forEach(ch -> System.out.println("John has a child called "+ch.getValue2().name));
  }*/
  
  public Research(RelationshipBrowser browser) { // good
    List<Person> children = browser.findAllChildrenOf("John");
    for(Person child : children) {
      System.out.println("John haa a child called: "+child.name);
    }
  }
}