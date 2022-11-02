package codejava.base.cctype;

public class CctypeEntry {  public static void CctypeProgram() {
    //initialize char
    char c = ' ';
    //whether char is letter or number
    boolean b1 = Character.isLetterOrDigit(c);
    //whether char is letter
    boolean b2 = Character.isLetter(c);
    //whether char is lowercase letter
    boolean b3 = Character.isLowerCase(c);
    //whether char is uppercase letter
    boolean b4 = Character.isUpperCase(c);
    //whether char is number
    boolean b5 = Character.isDigit(c);
    //whether char is hex number
    boolean b6 = !(Character.digit(c, 16) == -1);
    //whether char is control character
    boolean b7 = Character.isISOControl(c);
    //whether char is white space character
    boolean b8 = Character.isWhitespace(c);
    //whether char is space character
    boolean b9 = Character.isSpaceChar(c);
    //whether char is printable
    boolean b10 = !Character.isISOControl(c);
    //whether char has graph representation
    boolean b11 = !Character.isISOControl(c) && !Character.isSpaceChar(c);
    //whether char is punctuation character
    boolean b12 = Character.toString(c).matches("\\p{Punct}");
    //change uppercase letter to lowercase letter
    char c1 = Character.toLowerCase(c);
    //change uppercase letter to lowercase letter
    char c2 = Character.toUpperCase(c);
  }
}
