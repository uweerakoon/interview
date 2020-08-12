package designpatterns.bridge;

public class Exercise {
  public static void main(String[] args) {
    System.out.println(new Square1(new VectorRenderer1()).toString());
  }
}

interface Renderer1
{
  public String whatToRenderAs();
}

abstract class Shape1
{
  private Renderer1 renderer;
  public String name;

  public Shape1(Renderer1 renderer)
  {
    this.renderer = renderer;
  }

  @Override
  public String toString()
  {
    return String.format("Drawing %s as %s",
      name, renderer.whatToRenderAs());
  }
}

class Triangle extends Shape1
{
  public Triangle(Renderer1 renderer)
  {
    super(renderer);
    name = "Triangle";
  }
}

class Square1 extends Shape1
{
  public Square1(Renderer1 renderer)
  {
    super(renderer);
    name = "Square";
  }
}

class RasterRenderer1 implements Renderer1
{

  @Override
  public String whatToRenderAs()
  {
    return "pixels";
  }
}

class VectorRenderer1 implements Renderer1
{
  @Override
  public String whatToRenderAs()
  {
    return "lines";
  }
}