#include "list_entry.h"
#include <string>
#include <vector>
#include <algorithm>

void ListEntry::ListProgram() {
  //initialize a list
  std::list<std::string> list;
  //initialize a list with value
  std::list<std::string> list1{"aa", "bb", "cc", "dd"};
  //copy list
  list = list1;
  //resize list, trunc additional size or fill with default value
  list.resize(20, "");
  //whether list is empty
  bool is_empty = list.empty();
  //clear list
  list.clear();
  //insert element at begin
  list.emplace_front("ee");
  //insert element at end
  list.emplace_back("ee");
  //insert element at given position
  list.emplace(std::next(list.begin(), 1), "ff");
  //initialize a vector contains values
  std::vector<std::string> vec = std::vector<std::string>{"aa", "bb", "cc", "dd"};
  //insert a range of elements at end
  list.insert(list.end(), vec.begin(), vec.end());
  //insert a range of elements at given position
  list.insert(std::next(list.begin(), 1), vec.begin(), vec.end());
  //get size of list
  int size = list.size();
  //whether list contains element
  bool b1 = std::find(list.begin(), list.end(), "bb") != list.end();
  //create immutable reference of list
  const std::list<std::string> &kConstListRef = list;
  //whether two lists equal
  bool b2 = list == kConstListRef;
  //get first element
  std::string element = list.front();
  //get last element
  element = list.back();
  //remove first element
  list.pop_front();
  //remove last element
  list.pop_back();
  //remove element at given position
  list.erase(std::next(list.begin(), 3));
  //remove a range of elements at given position
  list.erase(std::next(list.begin(), 1), std::prev(list.end(), 1));
  //sort list
  list.sort();
  //reverse list
  list.reverse();
  //remove first elements equal value
  auto it = std::find(list.begin(), list.end(), "ff");
  if (it != list.end()) list.erase(it);
  list.remove("ff");
  //remove all elements equal value
  list.remove("ff");
  //remove all elements satisfy condition
  list.remove_if([](auto e) { return e > "dd"; });
}
bool ListEntry::TestAll() {
  bool ret = true;
  if (!ret)
    std::cout << "List Test Failed!";
  return ret;
}
