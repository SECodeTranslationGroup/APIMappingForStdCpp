#include "string_view_entry.h"
#include <iostream>
void StringViewEntry::StringViewProgram() {
  //initialize string
  std::string s = std::string("Example");
  //initialize string view
  std::string_view view = s;
  //get char from view
  char c = view[1];
  //length of view
  int size = view.length();
  //whether view empty
  bool b1 = view.empty();
  //sub string view
  std::string_view sub = view.substr(1,2);
  //compare string view
  int result = view.compare(sub);
  //build new string from view
  std::string s1 = std::string(view);
}
bool StringViewEntry::TestAll() {
  bool ret = true;
  if (!ret)
    std::cout << "String View Test Failed!";
  return ret;
}
