package codejava.base.string;

import java.nio.CharBuffer;

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
}
