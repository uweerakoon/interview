package interview;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

class StringReversalTest {
  
  private StringReversal stringReversal = new StringReversal();

  @Test
  void test() {
    String expected = stringReversal.reverseByStringBuilder("udara");
    assertEquals(expected, "aradu");
  }

}
