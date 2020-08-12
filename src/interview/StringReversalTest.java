package interview;

class StringReversalTest {
  
  private StringReversal stringReversal = new StringReversal();

  void test() {
    String expected = stringReversal.reverseByStringBuilder("udara");
    System.out.println(expected.equals("aradu"));
  }

}
