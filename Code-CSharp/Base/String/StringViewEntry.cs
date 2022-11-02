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
}