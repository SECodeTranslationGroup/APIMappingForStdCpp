package codejava.base.cctype;

public class CctypeEntry {
  public static void CctypeProgram() {
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
    boolean b6 = Character.digit(c, 16) >= 0;
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

  public static boolean testAll() {
    boolean ret = true;
    final Character C = 'c';
    ret = C.toLowerCase('C') == 'c' && C.toLowerCase('c') == 'c'
        && C.toLowerCase('9') == '9' && C.toLowerCase('\0') == '\0'
        && C.toUpperCase('C') == 'C' && C.toUpperCase('c') == 'C'
        && C.toUpperCase('9') == '9' && C.toUpperCase('\0') == '\0'
        && C.isLetterOrDigit('7') && C.isLetterOrDigit('a') && C.isLetterOrDigit('A')
        && !C.isLetterOrDigit('\0') && !C.isLetterOrDigit(' ')
        && !C.isLetter('7') && C.isLetter('a') && C.isLetter('A')
        && !C.isLetter('\0') && !C.isLetter(' ')
        && C.isDigit('7') && !C.isDigit('a') && !C.isDigit('A')
        && !C.isDigit('x') && !C.isDigit('U')
        && C.digit('7', 16) >= 0 && C.digit('a', 16) >= 0 && C.digit('A', 16) >= 0
        && !(C.digit('X', 16) >= 0) && !(C.digit('U', 16) >= 0)
        && !C.isLowerCase('7') && C.isLowerCase('a') && !C.isLowerCase('A')
        && !C.isLowerCase('\0') && !C.isLowerCase(' ')
        && !C.isUpperCase('7') && !C.isUpperCase('a') && C.isUpperCase('A')
        && !C.isUpperCase('\0') && !C.isUpperCase(' ')
        && C.isISOControl('\0') && C.isISOControl('\b') && C.isISOControl('\t')
        && !C.isISOControl(' ') && !C.isISOControl('C')
        && C.isISOControl('\0') && C.isISOControl('\b') && C.isISOControl('\t')
        && !C.isISOControl(' ') && !C.isISOControl('C')
        && (C.isISOControl('\0') || C.isSpaceChar('\0'))
        && (C.isISOControl('\b') || C.isSpaceChar('\b'))
        && (C.isISOControl('\t') || C.isSpaceChar('\t'))
        && (C.isISOControl(' ') || C.isSpaceChar(' '))
        && !C.isISOControl('C') && !C.isSpaceChar('\0')
        && !C.isWhitespace('\0') && !C.isWhitespace('\b') && C.isWhitespace('\t')
        && C.isWhitespace(' ') && !C.isWhitespace('C')
        && !C.isSpaceChar('\0') && !C.isSpaceChar('\b') && !C.isSpaceChar('\t')
        && C.isSpaceChar(' ') && !C.isSpaceChar('c')
        && !C.toString('\0').matches("\\p{Punct}")
        && !C.toString('\b').matches("\\p{Punct}")
        && !C.toString('\t').matches("\\p{Punct}")
        && !C.toString(' ').matches("\\p{Punct}")
        && !C.toString('C').matches("\\p{Punct}")
        && C.toString(',').matches("\\p{Punct}")
        && C.toString('!').matches("\\p{Punct}")
        && C.toString('/').matches("\\p{Punct}")
        && C.toString(':').matches("\\p{Punct}")
        && C.toString('?').matches("\\p{Punct}");
    if (!ret)
      System.out.println("Ctype Test Failed!");
    return ret;
  }
}
