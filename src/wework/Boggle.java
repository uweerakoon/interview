package wework;

import java.util.Arrays;
import java.util.List;

public class Boggle {

  //  G | I | Z
  //  U | E | K
  //  Q | S | E
  // dictionary[] = {"GEEKS", "FOR", "QUIZ", "GO"};
  // ANS: GEEKS, QUIZ
  
  private static final List<String> DICTIONARY = Arrays.asList("GEEKS", "FOR", "QUIZ", "GO");
  private static final int NO_ROWS = 3, NO_COLS = 3;
  
  private boolean isWord(String str) {
    if(str.length() < 3)
      return false;
    return DICTIONARY.contains(str);
  }
  
  public void findWords(char[][] boggle) {
    boolean[][] visited = new boolean[NO_ROWS][NO_COLS];
    String str = "";
    for(int i=0; i<NO_ROWS; i++) {
      for(int j=0; j<NO_COLS; j++) {
        findWords(boggle, visited, i, j, str);
      }
    }
  }
  
  private void findWords(char[][] boggle, boolean[][] visited, int row, int col, String str) {
    System.out.println("init row: "+row+" col: "+col);
    visited[row][col] = true;
    str = str + boggle[row][col];
    
    if(isWord(str)) {
      System.out.println("Find the String: "+str);
    }
    
    // find the adjacent 8 cells
    for(int i = row-1; i <= row+1; i++) {
      for(int j = col-1; j <= col+1 ; j++) {
        if(i >= 0 
            && j >= 0 
            && i < NO_ROWS
            && j < NO_COLS
            && !visited[i][j]) {
          System.out.println("In the loop: row: "+row+" i: "+i+" col: "+col+" j: "+j+" str: "+str);
          findWords(boggle, visited, i, j, str);
        }
      }
    }
    // Erase current character from string and mark visited 
    // of current cell as false 
    System.out.println("Reset the val row: "+row+" col: "+col+" str: "+str);
    str = "" + str.charAt(str.length()-1);
    visited[row][col] = false;
    
  }
  
  public static void main(String args[]) 
  { 
      char boggle[][] = { { 'G', 'I', 'Z' }, 
                          { 'U', 'E', 'K' }, 
                          { 'Q', 'S', 'E' } }; 

      System.out.println("Following words of dictionary are present"); 
      Boggle boggleGame = new Boggle();
      boggleGame.findWords(boggle); 
  } 
  
}
