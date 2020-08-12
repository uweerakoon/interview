package amazon;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class LongestString3Consecutive {
  public static String generateString(Map<Character, Integer> map) {
    PriorityQueue<Map.Entry<Character, Integer>> maxHeap = 
        new PriorityQueue<Map.Entry<Character, Integer>>((a, b) -> b.getValue() - a.getValue());

    maxHeap.addAll(map.entrySet());

    Queue<Map.Entry<Character, Integer>> waitQueue = new LinkedList<Map.Entry<Character, Integer>>();

    StringBuilder sb = new StringBuilder();

    while(!maxHeap.isEmpty())
    {
      Map.Entry<Character, Integer> cur = maxHeap.poll();

      int len = sb.length();

      if(len >= 2 && sb.charAt(len-1) == sb.charAt(len-2) && sb.charAt(len-1) == cur.getKey()) {
        return "IMPOSSIBLE TO CONSTRUCT";
      }

      if(cur.getValue() >= 2) {
        sb.append(Character.toLowerCase(cur.getKey()));
        sb.append(Character.toLowerCase(cur.getKey()));
        cur.setValue(cur.getValue() - 2);
      } else if(cur.getValue() > 0) {
        sb.append(Character.toLowerCase(cur.getKey()));
        cur.setValue(cur.getValue() - 1);
      }

      if(cur.getValue() > 0)
        waitQueue.add(cur);

      if(sb.length() % 3 == 0 || maxHeap.isEmpty()) {
        if(!waitQueue.isEmpty())
        {
          Map.Entry<Character, Integer> front = waitQueue.poll();
          maxHeap.offer(front);
        }
      }
    }

    return sb.toString();
  }

  public static void main(String[] args) {
    LongestString3Consecutive longestString3Consecutive = new LongestString3Consecutive();
    Map<Character, Integer> map = new HashMap<Character, Integer>();
    map.put('A', 1);
    map.put('B', 2);
    map.put('C', 3);
    System.out.println(longestString3Consecutive.generateString(map));
  }
}
