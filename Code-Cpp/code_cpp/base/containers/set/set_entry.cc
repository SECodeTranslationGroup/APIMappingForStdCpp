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
  //removes element equal value
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
  auto it = set.lower_bound("cc");
  std::optional<std::string> result = it != set.end() ? std::make_optional(*it) : std::nullopt;
  //get optional of first value greater or equal given value
  it = set.upper_bound("cc");
  result = it != set.end() ? std::make_optional(*it) : std::nullopt;
}
