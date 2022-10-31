using System.Diagnostics;
using System.Globalization;
using System.Text;

namespace CodeCsharp.Base.String;

using System;

public class StringEntry {
  public static void StringProgram() {
    char c = 'C';
    char[] cs = "123456789".ToCharArray();
    string s = "123456789";
    string myString = String.Empty;
    string s1 = new string(cs);
    string s2 = new string(c, 3);
    string s3 = new string(s1.ToCharArray(), 2, 5);
    string s4 = new string(cs, 0, 5);
    string s5 = new string(s);

    bool b1 = string.IsNullOrEmpty(myString); 
    myString = new string(cs);
    int size = myString.Length;
    char c1 = myString[1];
    char[] data = myString.ToCharArray();
    char cf = myString[0];
    char cb = myString[^1];

    string sRef = myString;
    string sub = myString.Substring(1, 2);
    bool b2 = myString.StartsWith(c);
    bool b3 = myString.StartsWith(new string(cs));
    bool b4 = myString.StartsWith(sub);
    bool b5 = myString.EndsWith(c);
    bool b6 = myString.EndsWith(new string(cs));
    bool b7 = myString.EndsWith(sub);
    bool b8 = myString.Contains(c);
    bool b9 = myString.Contains(new string(cs));
    bool b10 = myString.Contains(sub);

    int result = String.Compare(myString, s, StringComparison.Ordinal);

    int index1 = myString.IndexOf(s, 0, StringComparison.Ordinal);
    int index2 = myString.IndexOf(new string(cs), StringComparison.Ordinal);
    int index3 = myString.IndexOf(c, 1);
    int index4 = myString.IndexOf(c);
    int index5 = myString.LastIndexOf(s, StringComparison.Ordinal);
    int index6 = myString.LastIndexOf(new string(cs), 2, StringComparison.Ordinal);
    int index7 = myString.LastIndexOf(c, 2);
    int index8 = myString.LastIndexOf(c);

    myString = 12345.ToString();
    int intValue = int.Parse(myString);
    long longValue = long.Parse(myString);
    myString = 3.1415.ToString(CultureInfo.InvariantCulture);
    float floatValue = float.Parse(myString);
    double doubleValue = double.Parse(myString);

    StringBuilder emptyBuf = new StringBuilder();
    StringBuilder buf = new StringBuilder("New");
    buf.Clear();
    buf.Length = 10;

    buf.Clear();
    buf.Append(c, 10);

    buf.EnsureCapacity(100);
    int capacity = buf.Capacity;
    buf.Capacity = buf.Length;

    buf.Append(cs);
    buf.Append(s);
    buf.Append(s, 1, 4);
    buf.Append(cs, 1, 4);
    buf.Append(c, 10);

    buf.Append(c);
    buf.Remove(buf.Length - 1, 1);
    buf.Remove(3, 5);

    buf.Remove(1, 3);
    buf.Insert(1, cs);

    buf.Remove(1, 3);
    buf.Insert(1, s);

    buf.Remove(1, 3);
    buf.Insert(1, new string('A', 3));

    buf.Insert(1, s);
    buf.Insert(1, cs);
    buf.Insert(1, new string('A', 3));
    buf.Insert(1, s.ToCharArray(), 1, 1);

    string addString = myString + s; // s.Concat(s)
    string addString2 = myString + c;
    string addString3 = myString + 1;
  }
}