package codejava.base.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexEntry {
  public static void RegexProgram() {
    String str = "foo.txt";
    String regStr = "([a-z]+)\\.([a-z]+)";
    Pattern pattern = Pattern.compile(regStr);
    Matcher match = pattern.matcher(str);

    boolean b1 = match.matches();
    boolean b2 = match.find();

    int groupSize = match.groupCount();
    String matchStr = match.group(0);
    int matchBeginIndex = match.start(0);
    int matchLength = match.end(0) - match.start(0);
    int matchEndIndex = match.end(0);

    int index = 1;
    String subMatchStr = match.group(index);
    int subMatchBeginIndex = match.start(index);
    int subMatchLength = match.end(index) - match.start(index);
    int subMatchEndIndex = match.end(index);

    String replaceFirstStr = match.replaceFirst("[$&]");
    String replaceStr = match.replaceAll("[$&]");
  }
}
