namespace CodeCsharp.Base.Regex;

using System.Text.RegularExpressions;

public class RegexEntry {
  public static void RegexProgram() {
    string str = "foo.txt";
    string regStr = "([a-z]+)\\.([a-z]+)";
    Regex pattern = new Regex(regStr, RegexOptions.Compiled);
    Regex wholePattern = new Regex(string.Format("^{0}$",regStr), RegexOptions.Compiled);

    bool b1 = wholePattern.IsMatch(str);
    bool b2 = pattern.IsMatch(str);

    Match match = pattern.Match(str);

    int groupSize = match.Groups.Count;
    string matchStr = match.Groups[0].Value;
    int matchBeginIndex = match.Groups[0].Index;
    int matchLength = match.Groups[0].Length;
    int matchEndIndex = match.Groups[0].Index + match.Groups[0].Length;

    int index = 1;
    string subMatchStr = match.Groups[index].Value;
    int subMatchBeginIndex = match.Groups[index].Index;
    int subMatchLength = match.Groups[index].Length;
    int subMatchEndIndex = match.Groups[index].Index + match.Groups[index].Length;

    string replaceFirstStr = pattern.Replace(str,"[$&]",1);
    string replaceStr = pattern.Replace(str,"[$&]");
  }
}