package codejava.base.string;

import java.nio.CharBuffer;

public class StringViewEntry {
  public static void StringViewProgram() {
    String s = new String("Example");
    CharBuffer view = CharBuffer.wrap(s).asReadOnlyBuffer();
    char c = view.charAt(1);
    int len = view.length();
    boolean b1 = view.isEmpty();
    CharBuffer sub = view.slice(1,2);
    int result = view.compareTo(sub);
    String s1 = view.toString();
  }
}
