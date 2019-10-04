package designpatterns.decorator;

public class DynamicDecoratorComposition {
  public static void main(String[] args) {
    Circle circle = new Circle(10);
    System.out.println(circle.info());
    
    ColoredShape blueSquare = new ColoredShape(new Square(20), "blue");
    System.out.println(blueSquare.info());
    
    TransparentShape  myCircle = new TransparentShape(new ColoredShape(new Circle(5), "green"), 50);
    System.out.println(myCircle.info());
  }
}

interface Shape {
  String info();
}

class Circle implements Shape {
  private float radius;

  public Circle() {
  }
  
  public Circle(float radius) {
    this.radius = radius;
  }
  
  void resize(float factor) {
    radius *= factor;
  }

  @Override
  public String info() {
    return "A circle of radius "+radius;
  }
}

class Square implements Shape {
  private float side;

  public Square() {
  }
  
  public Square(float side) {
    this.side = side;
  }
  
  void resize(float factor) {
    side *= factor;
  }

  @Override
  public String info() {
    return "A Square of side "+side;
  }
}

class ColoredShape implements Shape {
  private Shape shape;
  private String color;
  
  public ColoredShape(Shape shape, String color) {
    super();
    this.shape = shape;
    this.color = color;
  }

  @Override
  public String info() {
    return shape.info()+" has the color "+color ;
  }
  
}

class TransparentShape implements Shape {
  private Shape shape;
  private int transparency;
  public TransparentShape(Shape shape, int transparency) {
    super();
    this.shape = shape;
    this.transparency = transparency;
  } 
  @Override
  public String info() {
    return shape.info()+" has "+transparency + "% transparency" ;
  }
}
