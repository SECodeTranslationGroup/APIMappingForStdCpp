#include "list_entry.h"
#include <string>
#include <vector>
#include <algorithm>

void ListEntry::ListProgram() {
  std::list<std::string> list;
  std::list<std::string> list1{"aa", "bb", "cc", "dd"};
  list = list1;
  list.resize(20, "");

  bool is_empty = list.empty();
  list.clear();

  list.emplace_front("ee");
  list.emplace_back("ee");
  list.emplace(std::next(list.begin(), 1), "ff");

  std::vector<std::string> vec = std::vector<std::string>{"aa", "bb", "cc", "dd"};
  list.insert(list.end(), vec.begin(), vec.end());
  list.insert(std::next(list.begin(), 1), vec.begin(), vec.end());

  int size = list.size();

  bool b1 = std::find(list.begin(), list.end(), "bb") != list.end();
  const std::list<std::string> &kConstlistRef = list;
  bool b3 = list == kConstlistRef;
  std::string element = list.front();
  element = list.back();

  list.pop_front();
  list.pop_back();
  list.erase(std::next(list.begin(), 3));
  list.erase(std::next(list.begin(), 1),std::prev(list.end(), 1));

  list.sort();
  list1.sort();
  list.merge(list1);
  list.splice(std::next(list.begin(), 1),list1);
  list.unique();
  list.reverse();
  list.remove("ff");
  list.remove_if([](auto e){return e > "dd";});
}
