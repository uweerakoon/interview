package designpatterns.factories;

public class FactoryMethod {
  public static void main(String[] args) {
    Point point = Point.newPolarPoint(2, 3);
    System.out.println(point);
  }
}

enum CoordinateSystem {
   CARTESIAN, POLAR
}

class Point {
  private double x,y;

  private Point(double x, double y) { 
    this.x = x;
    this.y = y;
  }
  
  /*public Point(double a, double b, CoordinateSystem cs) { // this is ugley
    switch (cs) {
      case CARTESIAN:
        this.x = a;
        this.y = b;
        break;
      case POLAR:
        x = a * Math.cos(b);
        y = a * Math.sin(b);
        break;
    }
  }*/
  
  /*public Point(double rho, double thera) { // Not allowed in Java
    x = rho * Math.cos(theta);
    y = rho * Math.sin(theta);
  }*/
  
  public static Point newCartesianPoint(double x, double y) {
    return new Point(x,y);
  }
  
  public static Point newPolarPoint(double rho, double theta) {
    return new Point(rho * Math.cos(theta), rho * Math.sin(theta));
  }

  @Override
  public String toString() {
    return "Point [x=" + x + ", y=" + y + "]";
  }
}