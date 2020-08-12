package goldmansachs;

public class PowerOf2 {

  static boolean isPowerOfTwoLoop(int n) 
  { 
    if (n == 0) 
      return false; 

    while (n != 1) 
    { 
      if (n % 2 != 0) 
        return false; 
      n = n / 2; 
    } 
    return true; 
  } 

  static boolean isPowerOfTwoLog(int n) 
  { 
    if(n==0) 
      return false; 

    return (int)(Math.ceil((Math.log(n) / Math.log(2)))) ==  
        (int)(Math.floor(((Math.log(n) / Math.log(2))))); 
  }

  public static boolean isPower(int x, int y) 
  { 
    // The only power of 1 is 1 itself 
    if (x == 1) 
      return (y == 1); 

    // Repeatedly compute power of x 
    int pow = 1; 
    while (pow < y) 
      pow = pow * x; 

    // Check if power of x becomes y 
    return (pow == y); 
  } 

  static boolean isPowerLog(int x,int y) 
  { 
    // logarithm function to 
    // calculate value 
    int res1 = (int)Math.log(y) /  
        (int)Math.log(x); 

    // Note : this is double           
    double res2 = Math.log(y) /  
        Math.log(x);  

    // compare to the result1 or 
    // result2 both are equal 
    return (res1 == res2); 
  } 
}
