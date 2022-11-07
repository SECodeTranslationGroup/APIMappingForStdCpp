package codejava.base.string;

public class StringEntry {
  public static void StringProgram() {
    //initialize string with const literal
    String str = "123456789";
    //initialize empty string
    String myString = new String();
    //initialize with repeat chars
    String s1 = String.valueOf('c').repeat(3);
    //initialize with substring
    String s2 = new String(str.toCharArray(), 2, 5);
    //is string empty
    boolean b1 = myString.isEmpty();
    //copy string
    myString = new String(str);
    //length of string
    int size = myString.length();
    //get char by index of string
    char c1 = myString.charAt(1);
    //get char array
    char[] data = myString.toCharArray();
    //get first char
    char cf = myString.charAt(0);
    //get last char
    char cb = myString.charAt(myString.length() - 1);
    //get a sub string
    String sub = myString.substring(1, 1 + 2);
    //whether string starts with a char or another string
    boolean b2 = myString.startsWith(String.valueOf('c'));
    boolean b3 = myString.startsWith(str);
    //whether string ends with a char or another string
    boolean b4 = myString.endsWith(String.valueOf('c'));
    boolean b5 = myString.endsWith(str);
    //whether string contains a char or another string
    boolean b6 = myString.contains(String.valueOf('c'));
    boolean b7 = myString.contains(str);
    //compare with another string
    int result = myString.compareTo(str);
    //find first occurence of a char or a substring
    int i1 = myString.indexOf('c');
    int i2 = myString.indexOf(str);
    //find first occurence of a char or a substring from index
    int i3 = myString.indexOf('c', 1);
    int i4 = myString.indexOf(str, 1);
    //find last occurence of a char or a substring
    int i5 = myString.lastIndexOf('c');
    int i6 = myString.lastIndexOf(str);
    //find last occurence of a char or a substring from index
    int i7 = myString.lastIndexOf('c', 1);
    int i8 = myString.lastIndexOf(str, 1);
    //convert from integer to string
    myString = Integer.valueOf(12345).toString();
    //convert from string to integer or long
    int intValue = Integer.parseInt(myString);
    long longValue = Long.parseLong(myString);
    //convert from float to string
    myString = Double.valueOf(3.1415).toString();
    //convert from string to float or double
    float floatValue = Float.parseFloat(myString);
    double doubleValue = Double.parseDouble(myString);
    //initialize an empty string buffer
    StringBuilder emptyBuf = new StringBuilder();
    //initialize a string buffer from a string
    StringBuilder buf = new StringBuilder(str);
    //clear string buffer
    buf.setLength(0);
    //resize string buffer
    buf.setLength(10);
    //resize string buffer and fill with char
    buf.setLength(10);
    buf.replace(0, buf.length() - 1, String.valueOf('c').repeat(10));
    //reserve capacity
    buf.ensureCapacity(100);
    //capacity of string buffer
    int capacity = buf.capacity();
    //trim string buffer to size
    buf.trimToSize();
    //append string to buffer
    buf.append(str);
    //append substring to buffer
    buf.append(str, 1, 1 + 4);
    //append repeated char to buffer
    buf.append(String.valueOf('c').repeat(10));
    //append one char to buffer;
    buf.append('c');
    //delete last char
    buf.deleteCharAt(buf.length() - 1);
    //delete a range of chars
    buf.delete(3, 3 + 5);
    //replace a range of chars with string
    buf.replace(1, 1 + 3, str);
    //replace a range of chars with repeat chars
    buf.replace(1, 1 + 3, String.valueOf('c').repeat(3));
    //insert string at a position
    buf.insert(1, str);
    //insert repeat chars at a position
    buf.insert(1, String.valueOf('c').repeat(3));
    //insert sub string at a position
    buf.insert(1, str, 1, 1 + 1);
    //string concat another string
    String addString = myString + str; // str.concat(str);
    //string concat char
    String addString2 = myString + 'c';
    //string concat other type of values
    String addString3 = myString + 1;
  }

  public static boolean testAll() {
    boolean ret = true;
    String s, s1, s2, s3, s4, s5, s6, s7, s8, s9;
    StringBuilder sb, sb1, sb2, sb3, sb4, sb5, sb6, sb7, sb8;
    StringBuilder sb9, sb10, sb11, sb12, sb13, sb14, sb15;
    String str = "123456789";
    s = str;
    s1 = "";
    s2 = String.valueOf('c').repeat(3);
    s3 = new String(str.toCharArray(), 2, 5);
    s4 = s.substring(2, 2 + 5);
    s5 = Integer.valueOf(12345).toString();
    s6 = Double.valueOf(3.1415).toString();
    s7 = s + s2;
    s8 = s + 'c';
    s9 = s + 1;
    sb = new StringBuilder(str);
    sb.setLength(0);
    sb1 = new StringBuilder(sb);
    sb.setLength(5);
    sb.replace(0, sb.length(), String.valueOf('c').repeat(sb.length()));
    sb2 = new StringBuilder(sb);
    sb3 = new StringBuilder(sb);
    sb3.ensureCapacity(100);
    sb4 = new StringBuilder(sb3);
    sb4.ensureCapacity(100);
    sb4.trimToSize();
    sb5 = new StringBuilder(sb);
    sb5.append(str);
    sb6 = new StringBuilder(sb);
    sb6.append(str, 2, 2 + 5);
    sb7 = new StringBuilder(sb);
    sb7.append(String.valueOf('b').repeat(5));
    sb.append('a');
    sb8 = new StringBuilder(sb);
    sb.deleteCharAt(sb.length() - 1);
    sb9 = new StringBuilder(sb);
    sb.delete(1, 1 + 2);
    sb10 = new StringBuilder(sb);
    sb11 = new StringBuilder(sb);
    sb11.replace(1, 1 + 2, str);
    sb12 = new StringBuilder(sb);
    sb12.replace(1, 1 + 2, String.valueOf('f').repeat(5));
    sb13 = new StringBuilder(sb);
    sb13.insert(2, str);
    sb14 = new StringBuilder(sb);
    sb14.insert(2, String.valueOf('f').repeat(5));
    sb15 = new StringBuilder(sb);
    sb15.insert(2, str, 2, 2 + 5);
    ret = s1.isEmpty()
        && s.startsWith(String.valueOf('1'))
        && s.startsWith("123")
        && s.endsWith(String.valueOf('9'))
        && s.endsWith("789")
        && s.contains(String.valueOf('5'))
        && s.contains("456")
        && sb1.isEmpty()
        && sb3.capacity() >= 100
        && sb4.capacity() < 100
        && s.length() == 9
        && s.charAt(2) == '3'
        && s.charAt(0) == '1'
        && s.charAt(s.length() - 1) == '9'
        && s.compareTo(str) == 0
        && s.indexOf('1') == 0
        && s.indexOf("345") == 2
        && s.lastIndexOf('1') == 0
        && s.lastIndexOf("345") == 2
        && Integer.parseInt("123") == 123
        && Double.parseDouble("3.1415") == 3.1415
        && s2.equals("ccc")
        && s3.equals("34567")
        && s4.equals("34567")
        && s5.equals("12345")
        && s6.equals("3.1415")
        && s7.equals("123456789ccc")
        && s8.equals("123456789c")
        && s9.equals("1234567891")
        && sb2.toString().equals("ccccc")
        && sb5.toString().equals("ccccc123456789")
        && sb6.toString().equals("ccccc34567")
        && sb7.toString().equals("cccccbbbbb")
        && sb8.toString().equals("ccccca")
        && sb9.toString().equals("ccccc")
        && sb10.toString().equals("ccc")
        && sb11.toString().equals("c123456789")
        && sb12.toString().equals("cfffff")
        && sb13.toString().equals("cc123456789c")
        && sb14.toString().equals("ccfffffc")
        && sb15.toString().equals("cc34567c");
    if (!ret)
      System.out.println("String Test Failed!");
    return ret;
  }
}
