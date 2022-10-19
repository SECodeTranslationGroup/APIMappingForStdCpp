//
// Created by 85339 on 2022/10/19.
//

#include "string_view_entry.h"
void StringViewEntry::StringViewProgram() {
  std::string s = std::string("Example");
  std::string_view view = s;
  char c = view[1];
  int size = view.length();
  bool b1 = view.empty();
  std::string_view sub = view.substr(1,2);
  int result = view.compare(sub);
  std::string s1 = std::string(view);

}
