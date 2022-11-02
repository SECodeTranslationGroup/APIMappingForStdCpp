package codejava.base.string;

import java.nio.CharBuffer;

public class StringViewEntry {
  public static void StringViewProgram() {
    //initialize string
    String s = new String("Example");
    //initialize string view
    CharBuffer view = CharBuffer.wrap(s).asReadOnlyBuffer();
    //get char from view
    char c = view.charAt(1);
    //length of view
    int len = view.length();
    //whether view empty
    boolean b1 = view.isEmpty();
    //sub string view
    CharBuffer sub = view.slice(1,2);
    //compare string view
    int result = view.compareTo(sub);
    //build new string from view
    String s1 = view.toString();
  }
}
