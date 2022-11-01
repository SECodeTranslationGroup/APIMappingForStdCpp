#include "regex_entry.h"
void RegexEntry::RegexProgram() {
  std::string str("foo.txt");
  std::string reg_str("([a-z]+)\\.([a-z]+)");
  std::regex pattern(reg_str);
  std::smatch match;

  bool b1 = std::regex_match(str, pattern);
  bool b2 = std::regex_search(str, match, pattern);

  int group_size = match.size();
  std::string match_str = match[0].str();
  int match_begin_index = match.position(0);
  int match_length = match.length(0);
  int match_end_index = match.position(0) + match.length(0);

  int index = 1;
  std::string sub_match_str = match[index].str();
  int sub_match_begin_index = match.position(index);
  int sub_match_length = match.length(index);
  int sub_match_end_index = match.position(index) + match.length(index);

  std::string replace_first_str =  std::regex_replace(str,pattern,"[$&]",std::regex_constants::format_first_only);
  std::string replace_str =  std::regex_replace(str,pattern,"[$&]");
}
