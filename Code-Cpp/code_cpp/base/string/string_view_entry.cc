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
  using namespace std;
  string s = "Example";
  string_view view = s;
  ret = ret && view[1] == 'x';
  ret = ret && view.length() == 7;
  ret = ret && !view.empty();
  string_view sub = view.substr(1,2);
  ret = ret && sub == "xa";
  ret = ret && view.compare(sub) == -1;
  view = string_view(s.end(),s.end());
  ret = ret && view.empty();

  if (!ret)
    cout << "String View Test Failed!";
  return ret;
}
