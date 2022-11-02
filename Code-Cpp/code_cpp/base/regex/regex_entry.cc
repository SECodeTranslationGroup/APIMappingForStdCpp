#include "regex_entry.h"
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
  std::string replace_first_str =  std::regex_replace(str,pattern,"[$&]",std::regex_constants::format_first_only);
  //replace all substring matches regex pattern
  std::string replace_str =  std::regex_replace(str,pattern,"[$&]");
}
