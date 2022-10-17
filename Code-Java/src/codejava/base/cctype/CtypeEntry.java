package codejava.base.cctype;

public class CtypeEntry {
  private final static char CONST_CHAR = ' ';

  public static void CTypeProgram() {
    boolean b1 = Character.isLetterOrDigit(CONST_CHAR);
    boolean b2 = Character.isLetter(CONST_CHAR);
    boolean b3 = Character.isLowerCase(CONST_CHAR);
    boolean b4 = Character.isUpperCase(CONST_CHAR);
    boolean b5 = Character.isDigit(CONST_CHAR);
    boolean b6 = !(Character.digit(CONST_CHAR, 16) == -1);
    boolean b7 = Character.isISOControl(CONST_CHAR);
    boolean b8 = Character.isWhitespace(CONST_CHAR);
    boolean b9 = Character.isSpaceChar(CONST_CHAR);
    boolean b10 = !Character.isISOControl(CONST_CHAR);
    boolean b11 = !Character.isISOControl(CONST_CHAR) && !Character.isSpaceChar(CONST_CHAR);
    boolean b12 = Character.toString(CONST_CHAR).matches("\\p{Punct}");
    char c1 = Character.toLowerCase(CONST_CHAR);
    char c2 = Character.toUpperCase(CONST_CHAR);
  }
}
