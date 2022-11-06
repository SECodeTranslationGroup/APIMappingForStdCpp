#include "regex_entry.h"
#include <iostream>
void RegexEntry::RegexProgram() {
  //initialize string
  std::string str("foo.txt");
  //initialize regex pattern
  std::string reg_str("([a-z]+)\\.([a-z]+)");
  std::regex pattern(reg_str);
  //whether whole string match regex
  bool b1 = std::regex_match(str, pattern);
  //whether some substring match regex
  std::smatch match;
  bool b2 = std::regex_search(str, match, pattern);
  //size of match group
  int group_size = match.size();
  //whole matched string
  std::string match_str = match[0].str();
  //begin index of matched string
  int match_begin_index = match.position(0);
  //length of matched string
  int match_length = match.length(0);
  //end index of matched string
  int match_end_index = match.position(0) + match.length(0);
  //sub match string of group index
  std::string sub_match_str = match[1].str();
  //begin index of sub matched string
  int sub_match_begin_index = match.position(1);
  //length of sub matched string
  int sub_match_length = match.length(1);
  //end index of sub matched string
  int sub_match_end_index = match.position(1) + match.length(1);
  //replace first substring matches regex pattern
  std::string replace_first_str = std::regex_replace(str, pattern, "[$&]", std::regex_constants::format_first_only);
  //replace all substring matches regex pattern
  std::string replace_str = std::regex_replace(str, pattern, "[$&]");
}
bool RegexEntry::TestAll() {
  bool ret = true;
  using namespace std;
  string str("foo.aaa.bbb");
  string reg_str("([a-z]+)\\.([a-z]+)\\.([a-z]+)");
  regex pattern(reg_str);
  ret = ret && regex_match(str, pattern);
  smatch match;
  string str1("1053foo.aaa.bbb0561");
  ret = ret && regex_search(str1, match, pattern);
  ret = ret && match.size() == 4;
  ret = ret && match[0].str() == "foo.aaa.bbb";
  ret = ret && match.position(0) == 4;
  ret = ret && match.length(0) == 11;
  ret = ret && match.position(0) + match.length(0) == 15;
  ret = ret && match[1].str() == "foo";
  ret = ret && match.position(1) == 4;
  ret = ret && match.length(1) == 3;
  ret = ret && match.position(1) + match.length(1) == 7;
  ret = ret && match[2].str() == "aaa";
  auto s = regex_replace(str, pattern, "[$&]",
                           regex_constants::format_first_only);
  string str2("1053foo.aaa.bbb0561foo.aaa.bbb6941");
  ret = ret && "1053[foo.aaa.bbb]0561foo.aaa.bbb6941" ==
      regex_replace(str2, pattern, "[$&]",
                    regex_constants::format_first_only);
  ret = ret && "1053[foo.aaa.bbb]0561[foo.aaa.bbb]6941" ==
      regex_replace(str2, pattern, "[$&]");

  if (!ret)
    cout << "Regex Test Failed!";
  return ret;
}
