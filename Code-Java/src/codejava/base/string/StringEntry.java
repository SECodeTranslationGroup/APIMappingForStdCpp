package codejava.base.string;

import java.nio.CharBuffer;

public class StringEntry {
  public static void StringProgram() {
    char[] charArray = "123456789".toCharArray();
    String s = new String();
    String s1 = new String(charArray);
    String s2 = "1".repeat(3);
    String s3 = new String(s1.toCharArray(), 2, 5);
    String s4 = new String(charArray, 0, 5);
    String s5 = new String(s1);

    boolean b1 = s.isEmpty();
    s = "ccc";
    int size = s.length();
    char c = s.charAt(1);
    char[] data = s.toCharArray();
    char cf = s.charAt(0);
    char cb = s.charAt(s.length() - 1);

    String sRef = s;
    String sub = s.substring(1, 1 + 2);
    boolean b2 = s.startsWith("c");
    boolean b3 = s.startsWith("cc");
    boolean b4 = s.startsWith(sub);
    boolean b5 = s.endsWith("c");
    boolean b6 = s.endsWith("cc");
    boolean b7 = s.endsWith(sub);
    boolean b8 = s.contains("c");
    boolean b9 = s.contains("cc");
    boolean b10 = s.contains(sub);

    int result = s.compareTo("ccd");

    int index1 = s.indexOf(sub, 0);
    int index2 = s.indexOf("cc");
    int index3 = s.indexOf('c', 1);
    int index4 = s.indexOf('c');
    int index5 = s.lastIndexOf(sub);
    int index6 = s.lastIndexOf("cc", 2);
    int index7 = s.lastIndexOf('c', 2);
    int index8 = s.lastIndexOf('c');

    s = Integer.valueOf(12345).toString();
    int intValue = Integer.parseInt(s);
    long longValue = Long.parseLong(s);
    s = Double.valueOf(3.1415).toString();
    float floatValue = Float.parseFloat(s);
    double doubleValue = Double.parseDouble(s);

    StringBuilder emptyBuf = new StringBuilder();
    StringBuilder buf = new StringBuilder("New");
    buf.setLength(0);
    buf.setLength(10);

    buf.replace(0, buf.length() - 1, "A".repeat(10));

    buf.ensureCapacity(100);
    int capacity = buf.capacity();
    buf.trimToSize();

    buf.append(" String ");
    buf.append(s.toCharArray());
    buf.append("  String  ", 1, 1 + 4);
    buf.append(s.toCharArray(), 0, 3);
    buf.append("A".repeat(10));

    buf.append('A');
    buf.deleteCharAt(buf.length() - 1);
    buf.delete(3, 3 + 5);

    buf.replace(1,1+3,"AAA");

    buf.replace(1,1+3,s);

    buf.replace(1,1+3,"A".repeat(3));

    buf.insert(1,s.toCharArray());
    buf.insert(1,"AAA");
    buf.insert(1,"A".repeat(3));
    buf.insert(1,s.toCharArray(),1,1);

    String addString = s + s1; // s.concat(s1);
    String addString2 = s + 'C';
    String addString3 = s + 1;

  }
}
