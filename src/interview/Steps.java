package interview;

public class Steps {

  public String steps(int n) {
    if(n <=0)
      return null;
    StringBuilder sb = new StringBuilder();
    for(int row = 0; row < n; row++) {
      for(int column=0; column < n; column++) {
        if(column <= row)
          sb.append("#");
        else 
          sb.append(" ");
      }
      sb.append("\n");
    }
    return sb.toString();
  }
  
  public String steps(int n, int row, int column, StringBuilder sb) {
    if(n == row)
      return sb.toString();
    if(n == column) {
      return steps(n, ++row, 0, sb.append("\n"));
    }
    sb.append(column <= row ? "#" : " ");
    return steps(n, row, ++column, sb);
  }
  
  public static void main(String[] args) {
    Steps steps = new Steps();
    System.out.println(steps.steps(0));
    System.out.println(steps.steps(5,0,0,new StringBuilder()));
  }
}
