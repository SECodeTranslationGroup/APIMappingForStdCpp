package codejava.base.string;

import java.nio.CharBuffer;

public class StringEntry {
  public static void StringProgram() {
    char c = 'C';
    char[] cs = "123456789".toCharArray();
    String s = "123456789";
    String myString = new String();
    String s1 = new String(cs);
    String s2 = String.valueOf(c).repeat(3);
    String s3 = new String(s.toCharArray(), 2, 5);
    String s4 = new String(cs, 0, 5);
    String s5 = new String(s);

    boolean b1 = myString.isEmpty();
    myString = String.valueOf(cs);
    int size = myString.length();
    char c1 = myString.charAt(1);
    char[] data = myString.toCharArray();
    char cf = myString.charAt(0);
    char cb = myString.charAt(myString.length() - 1);

    String sRef = myString;
    String sub = myString.substring(1, 1 + 2);
    boolean b2 = myString.startsWith(String.valueOf(c));
    boolean b3 = myString.startsWith(String.valueOf(cs));
    boolean b4 = myString.startsWith(sub);
    boolean b5 = myString.endsWith(String.valueOf(c));
    boolean b6 = myString.endsWith(String.valueOf(cs));
    boolean b7 = myString.endsWith(sub);
    boolean b8 = myString.contains(String.valueOf(c));
    boolean b9 = myString.contains(String.valueOf(cs));
    boolean b10 = myString.contains(sub);

    int result = myString.compareTo(s);

    int index1 = myString.indexOf(s, 0);
    int index2 = myString.indexOf(String.valueOf(cs));
    int index3 = myString.indexOf(c, 1);
    int index4 = myString.indexOf(c);
    int index5 = myString.lastIndexOf(s);
    int index6 = myString.lastIndexOf(String.valueOf(cs), 2);
    int index7 = myString.lastIndexOf(c, 2);
    int index8 = myString.lastIndexOf(c);

    myString = Integer.valueOf(12345).toString();
    int intValue = Integer.parseInt(myString);
    long longValue = Long.parseLong(myString);
    myString = Double.valueOf(3.1415).toString();
    float floatValue = Float.parseFloat(myString);
    double doubleValue = Double.parseDouble(myString);

    StringBuilder emptyBuf = new StringBuilder();
    StringBuilder buf = new StringBuilder(String.valueOf(cs));
    buf.setLength(0);
    buf.setLength(10);

    buf.replace(0, buf.length() - 1, String.valueOf(c).repeat(10));

    buf.ensureCapacity(100);
    int capacity = buf.capacity();
    buf.trimToSize();

    buf.append(cs);
    buf.append(s);
    buf.append(cs, 1, 4);
    buf.append(s, 1, 1+4);
    buf.append(String.valueOf(c).repeat(10));

    buf.append(c);
    buf.deleteCharAt(buf.length() - 1);
    buf.delete(3, 3 + 5);

    buf.replace(1,1+3, String.valueOf(cs));

    buf.replace(1,1+3,s);

    buf.replace(1,1+3,String.valueOf(c).repeat(3));

    buf.insert(1,cs);
    buf.insert(1,s);
    buf.insert(1,String.valueOf(c).repeat(3));
    buf.insert(1,s,1,1);

    String addString = myString + s; // s.concat(s);
    String addString2 = myString + c;
    String addString3 = myString + 1;

  }
}
