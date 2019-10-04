package designpatterns.composite;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// A mechanism for treating individual (scalar) objects
// and compositions of objects in a uniform manner
public class GeometricShapes {
  public static void main(String[] args) {
    GraphicObject drawing = new GraphicObject();
    drawing.setName("My Drawing");
    drawing.children.add(new Square("Red"));
    drawing.children.add(new Circle("Yellow"));
    
    GraphicObject group = new GraphicObject();
    group.children.add(new Square("Blue"));
    group.children.add(new Circle("Blue"));
    
    drawing.children.add(group);
    
    System.out.println(drawing );
  }
}

class GraphicObject {
  protected String name = "Group";

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
  
  public GraphicObject() {
    
  }
  
  public String color;
  public List<GraphicObject> children = new ArrayList<>();
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    print(sb, 0);
    return sb.toString();
  }
  
  private void print(StringBuilder sb, int depth) {
    sb.append(String.join("", Collections.nCopies(depth, "*")))
      .append(depth > 0 ? " " : "")
      .append((color == null || color.isEmpty()) ? "" : color + " ")
      .append(getName())
      .append(System.lineSeparator());
    for(GraphicObject child : children) {
      child.print(sb, depth+1);
    }
    
  }
}

class Circle extends GraphicObject {
  public Circle(String color) {
    name = "Circle";
    this.color = color;
  }
}

class Square extends GraphicObject {
  public Square(String color) {
    name = "Square";
    this.color = color;
  }
}