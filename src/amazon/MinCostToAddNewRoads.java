package amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class MinCostToAddNewRoads {

  private final Map<Integer, Integer> map = new HashMap<>();

  private void insert(int i){
    // initial insertion
    if(!map.containsKey(i)){
      map.put(i,i);
    }
  }

  private int find(int i){
    // find the top parent
    if(map.get(i) != i){
      map.put(i, find(map.get(i)));
    }
    return map.get(i);
  }

  private void union (int i , int j){
    // make i parent of j
    int x =  find(i);
    int y =  find(j);

    if(x != y){
      map.put(y,x);
    }
  }

  private int findCost(int numTotalAvailableCities, int numTotalAvailableRoads, List<List<Integer>> roadsAvailable, int roadsConstruct,
    List<List<Integer>> costRoadsAvailable){

    while (numTotalAvailableCities > 0){
      insert(numTotalAvailableCities--);
    }

    roadsAvailable.forEach(roads->{
      int i = roads.get(0);
      int j = roads.get(1);
      union(i, j);
    });

    PriorityQueue<List<Integer>> pq = new PriorityQueue<>((a, b) -> {
      return a.get(2).compareTo(b.get(2));
    });

    pq.addAll(costRoadsAvailable);

    int result = 0;

    while(pq.size() > 0){
      List<Integer> roadToAdd = pq.poll();
      int i = roadToAdd.get(0);
      int j = roadToAdd.get(1);
      int cost = roadToAdd.get(2);

      if( find(i) != find(j) ){
        union(i, j);
        result =  result + cost;

      }
    }

    return result;

  }

  public static void main(String[] args) {
    int numCities = 6;
    int numRoad = 3;
    int numNewRoad = 4;
    List<List<Integer>> roadsAvailable = new ArrayList<>();
    roadsAvailable.add(new ArrayList<>(Arrays.asList(1,4)));
    roadsAvailable.add(new ArrayList<>(Arrays.asList(5,4)));
    roadsAvailable.add(new ArrayList<>(Arrays.asList(2,3)));

    List<List<Integer>> cost = new ArrayList<>();
    cost.add(new ArrayList<>(Arrays.asList(1,2,5)));
    cost.add(new ArrayList<>(Arrays.asList(1,3,10)));
    cost.add(new ArrayList<>(Arrays.asList(1,6,2)));
    cost.add(new ArrayList<>(Arrays.asList(5,6,5)));

    MinCostToAddNewRoads minCostToAddNewRoads = new MinCostToAddNewRoads();
    System.out.println(minCostToAddNewRoads.findCost(numCities, numRoad, roadsAvailable,numNewRoad, cost));
  }
}
