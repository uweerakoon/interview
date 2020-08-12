package leetcode.easy;

public class Sqrtx {

  public static float root1(int number) { 
    float root = 0.0f; 
    float square = root; 
    while (square < number) { 
      root++; square = root * root; 
    } 
    return root; 
  }

  public static float root2(int number) { 
    if (number < 0) return -1; 
    if (number == 0 || number == 1) return number; 
    float root = 0.0f; 
    float precision = 0.1f; 
    float square = root; 
    while (square < number) { 
      root = root + precision; 
      square = root * root; 
    } 
    return root; 
  }

  public static float sqrt(int number) { 
    if (number < 0) return -1; 
    if (number == 0 || number == 1) return number; 
    float start = 0.0f; 
    float end = number; 
    float precision = 0.001f; 
    float middle = start; 
    float difference = (float) Math.abs(Math.pow(middle, 2) - number); 
    while (difference >= precision) { 
      middle = (start + end) / 2.0f; 
      if (Math.pow(middle, 2) > number) { 
        end = middle; 
      } 
      else { 
        start = middle; 
      } 
      difference = (float) Math.abs(Math.pow(middle, 2) - number); 
    } 
    return middle; 
  }

  //  Newton-Raphson algorithm 
  public static double sqrt(double c) {
    if (c < 0) return Double.NaN;
    double EPSILON = 1E-15;
    double t = c;
    while (Math.abs(t - c/t) > EPSILON*t)
      t = (c/t + t) / 2.0;
    return t;
  }
  
  public static void main(String[] args) {
    int n = 25;
    Sqrtx s = new Sqrtx();
    System.out.println(s.sqrt(n));
    System.out.println(s.sqrt(25.00));
  }


}
