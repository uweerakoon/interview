package amazon;

public class RollDice {

  // O(n)
  public int solution(int[] dices) {
    int res = dices.length * 2;
    int[] count = new int[6];
    for(int dice: dices) {
      count[dice- 1]++;
    }
    for(int i = 0; i < 6; i++) {
      res = Math.min(res, count[5 - i] + dices.length - count[i]);
    }
    return res;
  }
  
  public static void main(String[] args) {
    RollDice rollDice = new RollDice();
    int[] dices = {1, 6, 2, 3};
    System.out.println(rollDice.solution(dices));
  }
}
