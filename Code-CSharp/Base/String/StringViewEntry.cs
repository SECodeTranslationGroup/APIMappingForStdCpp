namespace CodeCsharp.Base.String; 

public class StringViewEntry {
  public static void StringViewProgram() {
    //initialize string
    string s = string.Empty;
    //initialize string view
    ReadOnlySpan<char> view = s.AsSpan();
    //get char from view
    char c = view[1];
    //length of view
    int len = view.Length;
    //whether view empty
    bool b1 = view.IsEmpty;
    //sub string view
    ReadOnlySpan<char> sub = view.Slice(1,2);
    //compare string view
    int result = view.CompareTo(sub,StringComparison.Ordinal);
    //build new string from view
    string s1 = view.ToString();
  }
  public static bool TestAll() {
    bool ret = true;
    string s = "Example";
    ReadOnlySpan<char> view = s.AsSpan();
    ret = view[1] == 'x'
          && view.Length == 7
          && !view.IsEmpty;
    ReadOnlySpan<char> sub = view.Slice(1, 2);
    ret = ret
          && sub.ToString().Equals("xa")
    && view.CompareTo(sub,StringComparison.Ordinal) < 0;
    string s2 = string.Empty;
    view = s2.AsSpan();
    ret = ret && view.IsEmpty;
    if (!ret)
      Console.WriteLine("String View Test Failed!");
    return ret;
  }
}