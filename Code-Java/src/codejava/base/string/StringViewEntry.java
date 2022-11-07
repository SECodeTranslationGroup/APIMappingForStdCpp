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

  public static boolean testAll() {
    boolean ret = true;
    String s = "Example";
    CharBuffer view =  CharBuffer.wrap(s).asReadOnlyBuffer();
    ret = view.charAt(1) == 'x'
        && view.length() == 7
        && !view.isEmpty();
    CharBuffer sub = view.slice(1, 2);
    ret = ret
        && sub.toString().equals("xa")
        && view.compareTo(sub) < 0;
    String s2 = "";
    view = CharBuffer.wrap(s2).asReadOnlyBuffer();;
    ret = ret && view.isEmpty();
    if (!ret)
      System.out.print("String View Test Failed!");
    return ret;
  }
}
