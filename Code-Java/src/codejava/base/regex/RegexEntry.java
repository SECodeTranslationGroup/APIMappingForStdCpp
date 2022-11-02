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
    String replaceFirstStr = match.replaceFirst("[$&]");
    //replace all substring matches regex pattern
    String replaceStr = match.replaceAll("[$&]");
  }
}
