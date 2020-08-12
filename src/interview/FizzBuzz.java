package interview;

public class FizzBuzz {

  public void fizzBuzz(int n) {
    for(int i=1; i<=n; i++) {
      if(i%15 == 0)
        System.out.println("FizzBuzz \n");
      else if(i%3 == 0)
        System.out.println("Fizz \n");
      else if(i%5 == 0)
        System.out.println("Buzz \n");
      else
        System.out.println(i+"\n");
    }
  }
  
  public static void main(String[] args) {
    FizzBuzz fizzBuzz = new FizzBuzz();
    fizzBuzz.fizzBuzz(25);
  }
}
