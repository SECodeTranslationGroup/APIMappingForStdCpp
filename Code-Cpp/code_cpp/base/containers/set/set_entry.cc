#include "set_entry.h"
#include <string>
#include <vector>
#include <algorithm>
#include <optional>

void SetEntry::SetProgram() {
  std::set<std::string> set;
  std::set<std::string> set1{"aa", "bb", "cc", "dd"};
  set = set1;

  bool is_empty = set.empty();
  set.clear();
  set.emplace("ee");

  std::vector<std::string> vec{"aa", "bb", "cc", "dd"};
  set.insert(vec.begin(), vec.end());

  int size = set.size();

  bool b1 = set.count("bb") > 0; // set.contains("bb");
  const std::set<std::string> &kConstSetRef = set;
  bool b2 = set == kConstSetRef;

  set.erase("cc");
  
  std::set<std::string> result_set;
  std::set_difference(set.begin(), set.end(), set1.begin(),
                      set1.end(), std::inserter(result_set, result_set.begin()));
  result_set.clear();
  std::set_union(set.begin(), set.end(), set1.begin(),
                 set1.end(), std::inserter(result_set, result_set.begin()));
  result_set.clear();
  std::set_intersection(set.begin(), set.end(), set1.begin(),
                        set1.end(), std::inserter(result_set, result_set.begin()));
  result_set.clear();
  std::set_symmetric_difference(set.begin(), set.end(), set1.begin(),
                                set1.end(), std::inserter(result_set, result_set.begin()));

  std::set<std::string> subset;
  std::copy(set.find("bb"), set.find("dd"), std::inserter(subset, result_set.begin()));
  subset.clear();
  std::copy(set.find("bb"), set.end(), std::inserter(subset, result_set.begin()));
  subset.clear();
  std::copy(set.begin(), set.find("dd"), std::inserter(subset, result_set.begin()));

  auto it = set.lower_bound("cc");
  std::optional<std::string> result = it != set.end() ? std::make_optional(*it) : std::nullopt;
  it = set.upper_bound("cc");
  result = it != set.end() ? std::make_optional(*it) : std::nullopt;
}
