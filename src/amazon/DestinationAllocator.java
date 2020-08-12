package amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DestinationAllocator {
  
  private static final Destination TRUCK_ORIGIN = new Destination(0,0);

  public List<List<Integer>> getCloseDestinations(int numDestinations, List<List<Integer>> allLocations, int numDeliveries) {
    if(numDestinations < 1 
        || allLocations == null
        || allLocations.isEmpty()
        || numDeliveries < 1
        || numDeliveries > numDestinations
        || numDestinations != allLocations.size()) {
      return null;
    }
    List<List<Integer>> results = new ArrayList<List<Integer>>();
    List<Destination> allDestinations = new ArrayList<Destination>();
    for(List<Integer> location : allLocations) {
      allDestinations.add(new Destination(location.get(0), location.get(1)));
    }
    Collections.sort(allDestinations, new Comparator<Destination>() {
      @Override
      public int compare(final Destination dest1, final Destination dest2) {
        
        double distance1 = dest1.distance(TRUCK_ORIGIN);
        double distance2 = dest2.distance(TRUCK_ORIGIN);
        return Double.compare(distance1,distance2);
      }
    });
    for(int i = 0; i< numDeliveries; i++) {
      Destination dest = allDestinations.get(i);
      results.add(Arrays.asList(dest.getX(), dest.getY()));
    }
    return results;
  }
  
  public static void main(String[] args) {
    List<List<Integer>> allLocations = new ArrayList<>();
    allLocations.add(Arrays.asList(1,2));
    allLocations.add(Arrays.asList(3,4));
    allLocations.add(Arrays.asList(1,-1));
    DestinationAllocator destinationAllocator = new DestinationAllocator();
    System.out.println(destinationAllocator.getCloseDestinations(3, allLocations, 2));
  }
}

class Destination {
  private int x;
  private int y;
  private Destination() { }
  public Destination(int x, int y) {
    this.x = x;
    this.y = y;
  }
  public int getX() { return x; }
  public int getY() { return y; }
  public double distance(Destination origin) {
    if(origin.getX() < 0 || origin.getY() < 0) {
      throw new IllegalArgumentException("Origin cannot have negative coordinations");
    }
    double distance = Math.sqrt(Math.pow(x-origin.getX(), 2) + Math.pow(y - origin.getY(),2));
    return distance;
  }
}
