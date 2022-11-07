using System.Globalization;
using System.Text;

namespace CodeCsharp.Base.String;

public class StringEntry {
  public static void StringProgram() {
    //initialize string with const literal
    string str = "123456789";
    //initialize empty string
    string myString = string.Empty;
    //initialize with repeat chars
    string s2 = new string('c', 3);
    //initialize with substring
    string s3 = new string(str.ToCharArray(), 2, 5);
    //is string empty
    bool b1 = string.IsNullOrEmpty(myString);
    //copy string
    myString = new string(str);
    //length of string
    int size = myString.Length;
    //get char by index of string
    char c1 = myString[1];
    //get char array
    char[] data = myString.ToCharArray();
    //get first char
    char cf = myString[0];
    //get last char
    char cb = myString[^1];
    //get a sub string
    string sub = myString.Substring(1, 2);
    //whether string starts with a char or another string
    bool b2 = myString.StartsWith('c');
    bool b4 = myString.StartsWith(str);
    //whether string ends with a char or another string
    bool b5 = myString.EndsWith('c');
    bool b7 = myString.EndsWith(str);
    //whether string contains a char or another string
    bool b8 = myString.Contains('c');
    bool b10 = myString.Contains(str);
    //compare with another string
    int result = string.CompareOrdinal(myString, str);
    //find first occurence of a char or a substring
    int i1 = myString.IndexOf(str, StringComparison.Ordinal);
    int i2 = myString.IndexOf('c');
    //find first occurence of a char or a substring from index
    int i3 = myString.IndexOf(str, 1, StringComparison.Ordinal);
    int i4 = myString.IndexOf('c', 1);
    //find last occurence of a char or a substring
    int i5 = myString.LastIndexOf(str, StringComparison.Ordinal);
    int i6 = myString.LastIndexOf('c');
    //find last occurence of a char or a substring from index
    int i7 = myString.LastIndexOf(str, 1, StringComparison.Ordinal);
    int i8 = myString.LastIndexOf('c', 1);
    //convert from integer to string
    myString = 12345.ToString();
    //convert from string to integer or long
    int intValue = int.Parse(myString);
    long longValue = long.Parse(myString);
    //convert from float to string
    myString = 3.1415.ToString(CultureInfo.InvariantCulture);
    //convert from string to float or double
    float floatValue = float.Parse(myString);
    double doubleValue = double.Parse(myString);
    //initialize an empty string buffer
    StringBuilder emptyBuf = new StringBuilder();
    //initialize a string buffer from a string
    StringBuilder buf = new StringBuilder(str);
    //clear string buffer
    buf.Clear();
    //resize string buffer
    buf.Length = 10;
    //resize string buffer and fill with char
    buf.Clear();
    buf.Append('c', 10);
    //reserve capacity
    buf.EnsureCapacity(100);
    //capacity of string buffer
    int capacity = buf.Capacity;
    //trim string buffer to size
    buf.Capacity = buf.Length;
    //append string to buffer
    buf.Append(str);
    //append substring to buffer
    buf.Append(str, 1, 4);
    //append repeated char to buffer
    buf.Append('c', 10);
    //append one char to buffer;
    buf.Append('c');
    //delete last char
    buf.Remove(buf.Length - 1, 1);
    //delete a range of chars
    buf.Remove(3, 5);
    //replace a range of chars with string
    buf.Remove(1, 3);
    buf.Insert(1, str);
    //replace a range of chars with repeat chars
    buf.Remove(1, 3);
    buf.Insert(1, new string('A', 3));
    //insert string at a position
    buf.Insert(1, str);
    //insert repeat chars at a position
    buf.Insert(1, new string('A', 3));
    //insert sub string at a position
    buf.Insert(1, str.ToCharArray(), 1, 1);
    //string concat another string
    string addString = myString + str; // s.Concat(s)
    //string concat char
    string addString2 = myString + 'c';
    //string concat other type of values
    string addString3 = myString + 1;
  }
  public static bool TestAll() {
    bool ret = true;
    string s, s1, s2, s3, s4, s5, s6, s7, s8, s9;
    StringBuilder sb, sb1, sb2, sb3, sb4, sb5, sb6, sb7, sb8;
    StringBuilder sb9, sb10, sb11, sb12, sb13, sb14, sb15;
    string str = "123456789";
    s = str;
    s1 = string.Empty;
    s2 = new string('c', 3);
    s3 = new string(str.ToCharArray(), 2, 5);
    s4 = s.Substring(2, 5);
    s5 = 12345.ToString();
    s6 = 3.1415.ToString();
    s7 = s + s2;
    s8 = s + 'c';
    s9 = s + 1;
    sb = new StringBuilder(str);
    sb.Clear();
    sb1 = new StringBuilder(sb.ToString());
    sb.Append('c', 5);
    sb2 = new StringBuilder(sb.ToString());
    sb3 = new StringBuilder(sb.ToString());
    sb3.EnsureCapacity(100);
    sb4 = new StringBuilder(sb3.ToString());
    sb4.EnsureCapacity(100);
    sb4.Capacity = sb4.Length;
    sb5 = new StringBuilder(sb.ToString());
    sb5.Append(str);
    sb6 = new StringBuilder(sb.ToString());
    sb6.Append(str, 2, 5);
    sb7 = new StringBuilder(sb.ToString());
    sb7.Append('b',5);
    sb.Append('a');
    sb8 = new StringBuilder(sb.ToString());
    sb.Remove(sb.Length - 1,1);
    sb9 = new StringBuilder(sb.ToString());
    sb.Remove(1, 2);
    sb10 = new StringBuilder(sb.ToString());
    sb11 = new StringBuilder(sb.ToString());
    sb11.Remove(1, 2);
    sb11.Insert(1, str);
    sb12 = new StringBuilder(sb.ToString());
    sb12.Remove(1, 2);
    sb12.Insert(1, new string('f', 5));
    sb13 = new StringBuilder(sb.ToString());
    sb13.Insert(2, str);
    sb14 = new StringBuilder(sb.ToString());
    sb14.Insert(2, new string('f', 5));
    sb15 = new StringBuilder(sb.ToString());
    sb15.Insert(2, str.ToArray(), 2, 5);
    ret = s1.Length == 0
        && s.StartsWith('1')
        && s.StartsWith("123")
        && s.EndsWith('9')
        && s.EndsWith("789")
        && s.Contains('5')
        && s.Contains("456")
        && sb1.Length == 0
        && sb3.Capacity >= 100
        && sb4.Capacity < 100
        && s.Length == 9
        && s[2] == '3'
        && s[0] == '1'
        && s[^1] == '9'
        &&  string.CompareOrdinal(s,str) == 0
        && s.IndexOf('1') == 0
        && s.IndexOf("345") == 2
        && s.LastIndexOf('1') == 0
        && s.LastIndexOf("345") == 2
        && int.Parse("123") == 123
        & double.Parse("3.1415") == 3.1415
        && s2.Equals("ccc")
        && s3.Equals("34567")
        && s4.Equals("34567")
        && s5.Equals("12345")
        && s6.Equals("3.1415")
        && s7.Equals("123456789ccc")
        && s8.Equals("123456789c")
        && s9.Equals("1234567891")
        && sb2.ToString().Equals("ccccc")
        && sb5.ToString().Equals("ccccc123456789")
        && sb6.ToString().Equals("ccccc34567")
        && sb7.ToString().Equals("cccccbbbbb")
        && sb8.ToString().Equals("ccccca")
        && sb9.ToString().Equals("ccccc")
        && sb10.ToString().Equals("ccc")
        && sb11.ToString().Equals("c123456789")
        && sb12.ToString().Equals("cfffff")
        && sb13.ToString().Equals("cc123456789c")
        && sb14.ToString().Equals("ccfffffc")
        && sb15.ToString().Equals("cc34567c");
    if (!ret)
      Console.WriteLine("String Test Failed!");
    return ret;
  }
}