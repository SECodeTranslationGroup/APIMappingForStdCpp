namespace CodeCsharp.Base.Regex;

using System.Text.RegularExpressions;

public class RegexEntry {
  public static void RegexProgram() {
    //initialize string
    string str = "foo.txt";
    //initialize regex pattern
    string regStr = "([a-z]+)\\.([a-z]+)";
    Regex pattern = new Regex(regStr, RegexOptions.Compiled);
    Regex wholePattern = new Regex(string.Format("^{0}$",regStr), RegexOptions.Compiled);
    //whether whole string match regex
    bool b1 = wholePattern.IsMatch(str);
    //whether some substring match regex
    bool b2 = pattern.IsMatch(str);
    Match match = pattern.Match(str);
    //size of match group
    int groupSize = match.Groups.Count;
    //whole matched string
    string matchStr = match.Groups[0].Value;
    //begin index of matched string
    int matchBeginIndex = match.Groups[0].Index;
    //length of matched string
    int matchLength = match.Groups[0].Length;
    //end index of matched string
    int matchEndIndex = match.Groups[0].Index + match.Groups[0].Length;
    //sub match string of group index
    string subMatchStr = match.Groups[1].Value;
    //begin index of sub matched string
    int subMatchBeginIndex = match.Groups[1].Index;
    //length of sub matched string
    int subMatchLength = match.Groups[1].Length;
    //end index of sub matched string
    int subMatchEndIndex = match.Groups[1].Index + match.Groups[1].Length;
    //replace first substring matches regex pattern
    string replaceFirstStr = pattern.Replace(str,"[$&]",1);
    //replace all substring matches regex pattern
    string replaceStr = pattern.Replace(str,"[$&]");
  }
  public static bool TestAll() {
    bool ret = true;
    if (!ret)
      Console.WriteLine("Regex Test Failed!");
    return ret;
  }
}