package codejava.base.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexEntry {
  public static void RegexProgram() {
    //initialize string
    String str = "foo.txt";
    //initialize regex pattern
    String regStr = "([a-z]+)\\.([a-z]+)";
    Pattern pattern = Pattern.compile(regStr);
    Matcher match = pattern.matcher(str);
    //whether whole string match regex
    boolean b1 = match.matches();
    //whether some substring match regex
    boolean b2 = match.find();
    //size of match group
    int groupSize = match.groupCount();
    //whole matched string
    String matchStr = match.group(0);
    //begin index of matched string
    int matchBeginIndex = match.start(0);
    //length of matched string
    int matchLength = match.end(0) - match.start(0);
    //end index of matched string
    int matchEndIndex = match.end(0);
    //sub match string of group index
    String subMatchStr = match.group(1);
    //begin index of sub matched string
    int subMatchBeginIndex = match.start(1);
    //length of sub matched string
    int subMatchLength = match.end(1) - match.start(1);
    //end index of sub matched string
    int subMatchEndIndex = match.end(1);
    //replace first substring matches regex pattern
    String replaceFirstStr = match.replaceFirst("[$0]");
    //replace all substring matches regex pattern
    String replaceStr = match.replaceAll("[$0]");
  }

  public static boolean testAll() {
    boolean ret = true;
    String str = "foo.aaa.bbb";
    String regStr = "([a-z]+)\\.([a-z]+)\\.([a-z]+)";
    Pattern pattern = Pattern.compile(regStr);
    Matcher match = pattern.matcher(str);
    ret = match.matches();
    String str1 = "1053foo.aaa.bbb0561";
    match = pattern.matcher(str1);
    ret = ret
        && match.find()
        && match.groupCount() == 3
        && match.group(0).equals("foo.aaa.bbb")
        && match.start(0) == 4
        && match.end(0) - match.start(0) == 11
        && match.end(0) == 15
        && match.group(1).equals("foo")
        && match.start(1) == 4
        && match.end(1) - match.start(1) == 3
        && match.end(1) == 7
        && match.group(2).equals("aaa");
    String str2 = "1053foo.aaa.bbb0561foo.aaa.bbb6941";
    match = pattern.matcher(str2);
    ret = ret
        && "1053[foo.aaa.bbb]0561foo.aaa.bbb6941"
        .equals(match.replaceFirst("[$0]"))
        && "1053[foo.aaa.bbb]0561[foo.aaa.bbb]6941".
        equals(match.replaceAll("[$0]"));
    if (!ret)
      System.out.print("Regex Test Failed!");
    return ret;
  }
}
