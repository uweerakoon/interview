package designpatterns.interpreter;

import java.util.ArrayList;
import java.util.List;

/**
 * The component that processes structured 
 * text data. Does so by turning into separate 
 * lexical tokens (lexing) and then interpreting 
 * sequences of said tokens (Parsing)
 * @author udaraweerakoon
 *
 */
public class Interpreter {

  public static void main(String[] args) {
    String input = "(13+4)-(12+1)";
  }
  static List<Token> lex(String input) {
    List<Token> result = new ArrayList<>();
    for(int i=0; i < input.length(); i++) {
      switch(input.charAt(i)) {
        case '+':
          result.add(new Token(Type.PLUS, "+"));
          break;
        case '-':
          result.add(new Token(Type.MINUS, "-"));
          break;
        case '(':
          result.add(new Token(Type.LPAREN, "("));
          break;
        case ')':
          result.add(new Token(Type.RPAREN, ")"));
          break;
        default:
          StringBuilder sb = new StringBuilder(""+input.charAt(i));
          for(int j = i+1; j < input.length(); j++) {
            if(Character.isDigit(input.charAt(j))) {
              sb.append(input.charAt(j));
              i++;
            }
            else {
              result.add(new Token(Type.INTEGER, sb.toString()));
              break;
            }
          }
          break;
      }
    }
    return result;
  }
}

enum Type {
  INTEGER,
  PLUS,
  MINUS,
  LPAREN,
  RPAREN
}

class Token {
  public Type type;
  public String text;
  
  public Token(Type type, String text) {
    super();
    this.type = type;
    this.text = text;
  }

  @Override
  public String toString() {
    return "`" + text + "`";
  }
  
  
}