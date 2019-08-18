package amazon;

import java.util.PriorityQueue;

public class ConnectRopes {

  public int minCost(int[] ropes) {
    PriorityQueue<Integer> pQueue = new PriorityQueue<>();
    for(int rope: ropes) pQueue.add(rope);
    int cost = 0;
    while(pQueue.size() !=1) {
      //System.out.println(Arrays.toString(pQueue.toArray()));
      int temp = pQueue.poll() + pQueue.poll();
      cost += temp;
      pQueue.add(temp);
    }
    return cost;
  }
  
  public static void main(String[] args) {
    ConnectRopes connectRopes = new ConnectRopes();
    int[] ropes = {2, 2, 3, 3};
    System.out.println(connectRopes.minCost(ropes));
  }
}
