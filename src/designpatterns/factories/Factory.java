package designpatterns.factories;

public class Factory {
  public static void main(String[] args) {
    Point1 p = Point1.Factory.newCartesianPoint(3, 5);
    System.out.println(p);
  }
}

class Point1 {
  private double x,y;

  private Point1(double x, double y) { 
    this.x = x;
    this.y = y;
  }
  
  public static class Factory {
    public static Point1 newCartesianPoint(double x, double y) {
      return new Point1(x,y);
    }
    
    public static Point1 newPolarPoint(double rho, double theta) {
      return new Point1(rho * Math.cos(theta), rho * Math.sin(theta));
    }
  }
  
  @Override
  public String toString() {
    return "Point [x=" + x + ", y=" + y + "]";
  }
}
