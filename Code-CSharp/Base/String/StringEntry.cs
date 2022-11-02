using System.Diagnostics;
using System.Globalization;
using System.Text;

namespace CodeCsharp.Base.String;

using System;

public class StringEntry {
  public static void StringProgram() {
    //initialize string with const literal
    string str = "123456789";
    //initialize empty string
    string myString = String.Empty;
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
    int result = String.CompareOrdinal(myString, str);
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
}