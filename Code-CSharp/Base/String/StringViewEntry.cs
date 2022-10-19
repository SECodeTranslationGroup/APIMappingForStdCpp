namespace CodeCsharp.Base.String; 

public class StringViewEntry {
  public static void StringViewProgram() {
    string s = string.Empty;
    ReadOnlySpan<char> view = s.AsSpan();
    char c = view[1];
    int len = view.Length;
    bool b1 = view.IsEmpty;
    ReadOnlySpan<char> sub = view.Slice(1,2);
    int result = view.CompareTo(sub,StringComparison.Ordinal);
    string s1 = view.ToString();

  }
}