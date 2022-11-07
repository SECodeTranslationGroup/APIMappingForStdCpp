#include "set_entry.h"
#include <string>
#include <vector>
#include <algorithm>
#include <optional>

void SetEntry::SetProgram() {
  //initialize a set
  std::set<std::string> set;
  //initialize a set with value
  std::set<std::string> set1{"aa", "bb", "cc", "dd"};
  //copy set
  set = set1;
  //whether set is empty
  bool is_empty = set.empty();
  //clear set
  set.clear();
  //insert element
  set.emplace("ee");
  //initialize a vector contains values
  std::vector<std::string> vec{"aa", "bb", "cc", "dd"};
  //insert a range of elements
  set.insert(vec.begin(), vec.end());
  //get size of set
  int size = set.size();
  //whether set contains element
  bool b1 = set.count("bb") > 0; // set.contains("bb");
  //create immutable reference of set
  const std::set<std::string> &kConstSetRef = set;
  //whether two sets equal
  bool b2 = set == kConstSetRef;
  //remove element equal value
  set.erase("cc");
  //initialize result set for calculation
  std::set<std::string> result_set;
  //set difference
  std::set_difference(set.begin(), set.end(), set1.begin(),
                      set1.end(), std::inserter(result_set, result_set.begin()));
  //set union
  result_set.clear();
  std::set_union(set.begin(), set.end(), set1.begin(),
                 set1.end(), std::inserter(result_set, result_set.begin()));
  //set intersection
  result_set.clear();
  std::set_intersection(set.begin(), set.end(), set1.begin(),
                        set1.end(), std::inserter(result_set, result_set.begin()));
  //set symmetric difference
  result_set.clear();
  std::set_symmetric_difference(set.begin(), set.end(), set1.begin(),
                                set1.end(), std::inserter(result_set, result_set.begin()));
  //initialize set for subset
  std::set<std::string> subset;
  //create a subset from given range
  std::copy(set.find("bb"), set.find("dd"), std::inserter(subset, result_set.begin()));
  //create a subset greater than given value
  subset.clear();
  std::copy(set.find("bb"), set.end(), std::inserter(subset, result_set.begin()));
  //create a subset less than given value
  subset.clear();
  std::copy(set.begin(), set.find("dd"), std::inserter(subset, result_set.begin()));
  //get optional of first value lower or equal given value
  auto it = --set.upper_bound("cc");
  std::optional<std::string> result = it != set.end() ? std::make_optional(*it) : std::nullopt;
  //get optional of first value greater or equal given value
  it = set.lower_bound("cc");
  result = it != set.end() ? std::make_optional(*it) : std::nullopt;
}
bool SetEntry::TestAll() {
  bool ret = true;
  using namespace std;
  set<int> c, c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11;
  vector<int> vec{1, 3, 5, 7, 9};
  c = {1, 2, 3, 4, 5};
  c2 = c;
  c.clear();
  c1 = c;
  c.insert(vec.begin(), vec.end());
  c3 = c;
  c.erase(3);
  c4 = c;
  set_difference(c.begin(), c.end(), c2.begin(), c2.end(),
                 inserter(c5, c5.begin()));
  set_union(c.begin(), c.end(), c2.begin(), c2.end(),
            inserter(c6, c6.begin()));
  set_intersection(c.begin(), c.end(), c2.begin(), c2.end(),
                   inserter(c7, c7.begin()));

  set_symmetric_difference(c.begin(), c.end(), c2.begin(), c2.end(),
                           inserter(c8, c8.begin()));
  copy(c.find(5), c.find(9), inserter(c9, c9.begin()));
  copy(c.find(5), c.end(), inserter(c10, c10.begin()));
  copy(c.begin(), c.find(9), inserter(c11, c11.begin()));
  ret = c1.empty()
      && c.count(7) > 0
      && c6.size() == 7
      && *(--c.upper_bound(6)) == 5
      && *c.lower_bound(6) == 7
      && c2 == set<int>{1, 2, 3, 4, 5}
      && c3 == set<int>{1, 3, 5, 7, 9}
      && c4 == set<int>{1, 5, 7, 9}
      && c5 == set<int>{7, 9}
      && c6 == set<int>{1, 2, 3, 4, 5, 7, 9}
      && c7 == set<int>{1, 5}
      && c8 == set<int>{2, 3, 4, 7, 9}
      && c9 == set<int>{5, 7}
      && c10 == set<int>{5, 7, 9}
      && c11 == set<int>{1, 5, 7};
  if (!ret)
    cout << "Set Test Failed!";
  return ret;
}
