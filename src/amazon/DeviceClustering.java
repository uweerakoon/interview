package amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class DeviceClustering {

  public List<List<Integer>> allocate(int deviceCapacity, List<List<Integer>> foregroundAppList,
    List<List<Integer>> backgroundAppList) {
    if(deviceCapacity <= 0
        || foregroundAppList == null || foregroundAppList.isEmpty()
        || backgroundAppList == null || backgroundAppList.isEmpty()) 
      return null;
    List<List<Integer>> results = new ArrayList<>();
    int diff = Integer.MAX_VALUE; // different between pair
    int resultForeground = 0, resultBackground = backgroundAppList.size() - 1;
    int l = 0, r = backgroundAppList.size() - 1;
    while(l < foregroundAppList.size() && r >= 0) {
      int diffTemp = Math.abs(foregroundAppList.get(l).get(1) + backgroundAppList.get(r).get(1) - deviceCapacity);
      if(diffTemp == 0) {
        results.add(Arrays.asList(foregroundAppList.get(l).get(0),backgroundAppList.get(r).get(0)));
      }
      if(diffTemp < diff) {
        diff = diffTemp;
        resultForeground = l;
        resultBackground = r;
      }
      int incrDiff = l+1 == foregroundAppList.size() ? Integer.MAX_VALUE :
        Math.abs(foregroundAppList.get(l+1).get(1) + backgroundAppList.get(r).get(1) - deviceCapacity);
      int decreDiff = r-1 < 0 ? Integer.MAX_VALUE :
        Math.abs(foregroundAppList.get(l).get(1) + backgroundAppList.get(r-1).get(1) - deviceCapacity);
      if(incrDiff < decreDiff) {
        l++;
      }
      else {
        r--;
      }
    }
    if(results.isEmpty()) 
      results.add(Arrays.asList(foregroundAppList.get(resultForeground).get(0),backgroundAppList.get(resultBackground).get(0)));
    return results;
  }

  public List<List<Integer>> calculateOptimalRoute(final List<List<Integer>> forwardList, final List<List<Integer>> returnList,int capacity)
  {
    //System.out.println(forwardList);
    //System.out.println(returnList);

    // sort forward list
    Collections.sort(forwardList, new Comparator<List<Integer>>() {
      @Override
      public int compare(List<Integer> o1, List<Integer> o2) {
        return o1.get(1) - o2.get(1);
      }
    });

    // sort return list
    Collections.sort(returnList, new Comparator<List<Integer>>() {
      public int compare(List<Integer> o1, List<Integer> o2) {
        return o1.get(1) - o2.get(1);
      }
    });

    int max = 0;
    int i = 0;
    int j = returnList.size() - 1;

    List<List<Integer>> result = null;
    while(i < forwardList.size() && j >= 0) {
      int currentSum = forwardList.get(i).get(1) + returnList.get(j).get(1);

      if ( currentSum> max && currentSum <= capacity) {
        max = forwardList.get(i).get(1) + returnList.get(j).get(1);
        result = new LinkedList<List<Integer>>();
        result.add(new ArrayList<Integer>(Arrays.asList(forwardList.get(i).get(0), returnList.get(j).get(0))));
        i++;
      }
      else if(forwardList.get(i).get(1) + returnList.get(j).get(1) == max)
      {
        // no need to reset result list
        result.add(new ArrayList<Integer>(Arrays.asList(forwardList.get(i).get(0), returnList.get(j).get(0))));
        i++;
      } else
      {
        j--;
      }
    }
    return result;
  }

  public static void main(String[] args) {
    List<List<Integer>> foregroundAppList = new ArrayList<>();
    List<List<Integer>> backgroundAppList = new ArrayList<>();
    foregroundAppList.add(Arrays.asList(1,2));
    foregroundAppList.add(Arrays.asList(2,4));
    foregroundAppList.add(Arrays.asList(3,6));
    backgroundAppList.add(Arrays.asList(1,2));
    DeviceClustering deviceClustering = new DeviceClustering();
    System.out.println(deviceClustering.allocate(7, foregroundAppList, backgroundAppList));
    foregroundAppList.clear();
    backgroundAppList.clear();
    foregroundAppList.add(Arrays.asList(1,3));
    foregroundAppList.add(Arrays.asList(2,5));
    foregroundAppList.add(Arrays.asList(3,7));
    foregroundAppList.add(Arrays.asList(4,10));
    backgroundAppList.add(Arrays.asList(1,2));
    backgroundAppList.add(Arrays.asList(2,3));
    backgroundAppList.add(Arrays.asList(3,4));
    backgroundAppList.add(Arrays.asList(4,5));
    System.out.println(deviceClustering.allocate(10, foregroundAppList, backgroundAppList));
  }
}
