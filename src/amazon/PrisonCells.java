package amazon;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PrisonCells {

  // O(N*cells.length)
  public int[] prisonAfterNDaysNative(int[] cells, int N) {
    
    int[] temp = new int[cells.length];
    for(int i=0; i<N; i++) {
      for(int j=0; j<cells.length; j++) {
        if(j==0 || j == (cells.length - 1))
          temp[j] = 0;
        else
          temp[j] = ~(cells[j-1] ^ cells[j+1]);                
      }
      cells = temp;
    }
    return cells;
  }

  public int[] prisonAfterNDays(int[] cells, int N) {
    Map<Integer, Integer> seen = new HashMap<>();
    // state  = integer representing state of prison
    int state = 0;
    for (int i = 0; i < 8; ++i) {
      if (cells[i] > 0)
        state ^= 1 << i; // i=3 => 0010 ^ 1000 = 1010
    }

    // While days remaining, simulate a day
    while (N > 0) {
      // If this is a cycle, fast forward by
      // seen.get(state) - N, the period of the cycle.
      if (seen.containsKey(state)) {
        N %= seen.get(state) - N;
      }
      seen.put(state, N);

      if (N >= 1) {
        N--;
        state = nextDay(state);
      }
    }

    // Convert the state back to the required answer.
    int[] ans = new int[8];
    for (int i = 0; i < 8; ++i) {
      if (((state >> i) & 1) > 0) {
        ans[i] = 1;
      }
    }

    return ans;
  }

  public int nextDay(int state) {
    int ans = 0;

    // We only loop from 1 to 6 because 0 and 7 are impossible,
    // as those cells only have one neighbor.
    for (int i = 1; i <= 6; ++i) {
      if (((state >> (i-1)) & 1) == ((state >> (i+1)) & 1)) {
        ans ^= 1 << i;
      }
    }

    return ans;
  }

  public static void main(String[] args) {
    int[] cells = {0,1,0,1,1,0,0,1};
    PrisonCells prisonCells = new PrisonCells();
    System.out.println(Arrays.toString(prisonCells.prisonAfterNDays(cells, 7)));
  }
}
