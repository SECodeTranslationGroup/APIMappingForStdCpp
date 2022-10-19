using System.Diagnostics;
using System.Globalization;
using System.Text;

namespace CodeCsharp.Base.String;

using System;

public class StringEntry {
  public static void StringProgram() {
    char[] charArray = "123456789".ToCharArray();
    string s = String.Empty;
    string s1 = new string(charArray);
    string s2 = new string('1', 3);
    string s3 = new string(s1.ToCharArray(), 2, 5);
    string s4 = new string(charArray, 0, 5);
    string s5 = new string(s1);

    bool b1 = string.IsNullOrEmpty(s);
    s = new string("ccc");
    int size = s.Length;
    char c = s[1];
    char[] data = s.ToCharArray();
    char cf = s[0];
    char cb = s[s.Length - 1];
    ReadOnlySpan<char> string_view = s.AsSpan();

    string sRef = s;
    string sub = s.Substring(1, 2);
    bool b2 = s.StartsWith('c');
    bool b3 = s.StartsWith("cc");
    bool b4 = s.StartsWith(sub);
    bool b5 = s.EndsWith('c');
    bool b6 = s.EndsWith("cc");
    bool b7 = s.EndsWith(sub);
    bool b8 = s.Contains('c');
    bool b9 = s.Contains("cc");
    bool b10 = s.Contains(sub);

    int result = String.Compare(s, "ccd", StringComparison.Ordinal);

    int index1 = s.IndexOf(sub, 0, StringComparison.Ordinal);
    int index2 = s.IndexOf("cc", StringComparison.Ordinal);
    int index3 = s.IndexOf('c', 1);
    int index4 = s.IndexOf('c');
    int index5 = s.LastIndexOf(sub, StringComparison.Ordinal);
    int index6 = s.LastIndexOf("cc", 2, StringComparison.Ordinal);
    int index7 = s.LastIndexOf('c', 2);
    int index8 = s.LastIndexOf('c');

    s = 12345.ToString();
    int intValue = int.Parse(s);
    long longValue = long.Parse(s);
    s = 3.1415.ToString(CultureInfo.InvariantCulture);
    float floatValue = float.Parse(s);
    double doubleValue = double.Parse(s);

    StringBuilder emptyBuf = new StringBuilder();
    StringBuilder buf = new StringBuilder("New");
    buf.Clear();
    buf.Length = 10;

    buf.Clear();
    buf.Append('A', 10);

    buf.EnsureCapacity(100);
    int capacity = buf.Capacity;
    buf.Capacity = buf.Length;

    buf.Append(" String ");
    buf.Append(s.ToCharArray());
    buf.Append("  String  ", 1, 4);
    buf.Append(s.ToCharArray(), 0, 3);
    buf.Append('A', 10);

    buf.Append('A');
    buf.Remove(buf.Length - 1, 1);
    buf.Remove(3, 5);

    buf.Remove(1, 3);
    buf.Insert(1, "AAA");

    buf.Remove(1, 3);
    buf.Insert(1, s);

    buf.Remove(1, 3);
    buf.Insert(1, new string('A', 3));

    buf.Insert(1, s.ToCharArray());
    buf.Insert(1, "AAA");
    buf.Insert(1, new string('A', 3));
    buf.Insert(1, s.ToCharArray(), 1, 1);

    string addString = s + s1; // s.Concat(s1)
    string addString2 = s + 'C';
    string addString3 = s + 1;
  }
}