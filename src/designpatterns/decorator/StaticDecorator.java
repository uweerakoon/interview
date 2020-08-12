package designpatterns.decorator;

import java.util.function.Supplier;

public class StaticDecorator {
  public static void main(String[] args) {
    ColoredShape1<Square> blueSquare = new ColoredShape1<>(() -> new Square(20), "blue"); 
    System.out.println(blueSquare.info());
    
    TransparentShape1<ColoredShape1<Circle>> myCircle =
        new TransparentShape1<>(() ->
          new ColoredShape1<>(() -> new Circle(5), "green"), 50);
    System.out.println(myCircle.info());
    // myCircle.resize() is prohibited because of the implementation limitation
  }
}

class ColoredShape1<T extends Shape> implements Shape {
  private Shape shape;
  private String color;
  
  public ColoredShape1(Supplier<? extends T> ctor, String color) {
    super();
    this.shape = ctor.get();
    this.color = color;
  }

  @Override
  public String info() {
    return shape.info()+" has the color "+color ;
  }
}

class TransparentShape1<T extends Shape> implements Shape {
  private Shape shape;
  private int transparency;
  public TransparentShape1(Supplier<? extends T> ctor, int transparency) {
    super();
    this.shape = ctor.get();
    this.transparency = transparency;
  } 
  @Override
  public String info() {
    return shape.info()+" has "+transparency + "% transparency" ;
  }
}
