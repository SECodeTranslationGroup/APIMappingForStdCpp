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
    string str = "foo.aaa.bbb";
    string regStr = "([a-z]+)\\.([a-z]+)\\.([a-z]+)";
    Regex pattern = new Regex(regStr, RegexOptions.Compiled);
    Regex wholePattern = new Regex(string.Format("^{0}$",regStr), RegexOptions.Compiled);
    
    ret = wholePattern.IsMatch(str);
    string str1 = "1053foo.aaa.bbb0561";
    Match match = pattern.Match(str1);
    ret = ret
          && pattern.IsMatch(str1)
          && match.Groups.Count == 4
        && match.Groups[0].Value.Equals("foo.aaa.bbb")
        && match.Groups[0].Index == 4
        && match.Groups[0].Length== 11
        && match.Groups[0].Index+match.Groups[0].Length == 15
        && match.Groups[1].Value.Equals("foo")
        && match.Groups[1].Index  == 4
        && match.Groups[1].Length == 3
        && match.Groups[1].Index+match.Groups[1].Length == 7
        && match.Groups[2].Value.Equals("aaa");
    string str2 = "1053foo.aaa.bbb0561foo.aaa.bbb6941";
    ret = ret
          && "1053[foo.aaa.bbb]0561foo.aaa.bbb6941"
              .Equals(pattern.Replace(str2, "[$&]", 1))
          && "1053[foo.aaa.bbb]0561[foo.aaa.bbb]6941"
              .Equals(pattern.Replace(str2, "[$&]"));
    if (!ret)
      Console.WriteLine("Regex Test Failed!");
    return ret;
  }
}