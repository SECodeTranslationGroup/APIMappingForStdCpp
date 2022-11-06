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
  //remove all elements equal value
  list.remove("ff");
  //remove all elements satisfy condition
  list.remove_if([](auto e) { return e > "dd"; });
}
bool ListEntry::TestAll() {
  bool ret = true;
  using namespace std;
  list<int> c, c1, c2, c3, c4, c5, c6, c7, c8, c9, c10;
  list<int> c11, c12, c13, c14, c15, c16, c17;
  vector<int> vec{2, 4, 3, 1, 5};
  c = {1, 2, 3, 4, 5};
  c2 = c;
  c.resize(10, 0);
  c3 = c;
  c.clear();
  c1 = c;
  c.insert(c.end(), vec.begin(), vec.end());
  c4 = c;
  c.insert(next(c.begin(), 1), vec.begin(), vec.end());
  c5 = c;
  c.emplace_front(-1);
  c6 = c;
  c.emplace_back(10);
  c7 = c;
  c.pop_front();
  c8 = c;
  c.pop_back();
  c9 = c;
  c.erase(next(c.begin(), 3));
  c10 = c;
  c.erase(next(c.begin(), 3), prev(c.end(), 3));
  c11 = c;
  c.sort();
  c12 = c;
  c.reverse();
  c13 = c;
  c.emplace(next(c.begin(), 1), 2);
  c14 = c;
  auto it = find(c.begin(), c.end(), 2);
  if (it != c.end()) c.erase(it);
  c15 = c;
  c.remove(2);
  c16 = c;
  c.remove_if([](auto e) { return e >3 ;});
  c17 = c;
  vector<pair<bool, bool>> bool_result_list = {
      {c1.empty(), true},
      {find(c.begin(), c.end(), 3) != c.end(), true}
  };
  vector<pair<list<int>, list<int>>> container_result_list = {
      {c2,
       {1,2,3,4,5}},
      {c3,
       {1,2,3,4,5,0,0,0,0,0}},
      {c4,
       {2,4,3,1,5}},
      {c5,
       {2,2,4,3,1,5,4,3,1,5}},
      {c6,
       {-1,2,2,4,3,1,5,4,3,1,5}},
      {c7,
       {-1,2,2,4,3,1,5,4,3,1,5,10}},
      {c8,
       {2,2,4,3,1,5,4,3,1,5,10}},
      {c9,
       {2,2,4,3,1,5,4,3,1,5}},
      {c10,
       {2,2,4,1,5,4,3,1,5}},
      {c11,
       {2,2,4,3,1,5}},
      {c12,
       {1,2,2,3,4,5}},
      {c13,
       {5,4,3,2,2,1}},
      {c14,
       {5,2,4,3,2,2,1}},
      {c15,
       {5,4,3,2,2,1}},
      {c16,
       {5,4,3,1}},
      {c17,
       {3,1}}
  };
  vector<pair<int, int>> int_result_list = {
      {c7.size(), 12},
      {c.front(), 3},
      {c.back(), 1}
  };
  for (const auto &it : container_result_list) {
    ret = ret && it.first == it.second;
  }
  for (auto it : bool_result_list) {
    ret = ret && it.first == it.second;
  }
  for (auto it : int_result_list) {
    ret = ret && it.first == it.second;
  }
  if (!ret)
    std::cout << "List Test Failed!";
  return ret;
}
