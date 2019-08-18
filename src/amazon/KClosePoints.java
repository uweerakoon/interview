package amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class KClosePoints {

  private static final Point ORIGIN = new Point(0,0);
  public int[][] kClosest(int[][] points, int K) {
      List<Point> pointList = new ArrayList<>();
      for(int i=0; i<points.length; i++) {
          pointList.add(new Point(points[i][0], points[i][1]));
      }
      Collections.sort(pointList, new Comparator<Point>() {
          @Override
          public int compare(Point p1, Point p2) {
              double dist1 = p1.distance(ORIGIN);
              double dist2 = p2.distance(ORIGIN);
              return Double.compare(dist1, dist2);
          }
      });
      int[][] results = new int[K][2];
      for(int i=0; i<K; i++) {
          Point p = pointList.get(i);
          results[i][0] = p.getX();
          results[i][1] = p.getY();
      }
      return results;
  }
  
  public static void main(String[] args) {
    int[][] input = {{1,3}, {-2,2}};
    KClosePoints kClosePoints = new KClosePoints();
    System.out.println(Arrays.deepToString(kClosePoints.kClosest(input, 1)));
  }
  
  
}

class Point {
  private int x, y;
  public Point(int x, int y){
      this.x = x;
      this.y = y;
  }
  public int getX(){ return x; }
  public int getY(){ return y; }
  public double distance(Point other) {
      return Math.sqrt(Math.pow(x-other.getX(),2)+Math.pow(y-other.getY(),2));
  }
}
