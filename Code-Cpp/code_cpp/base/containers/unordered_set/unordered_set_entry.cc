#include "unordered_set_entry.h"
#include <string>
#include <vector>

void UnorderedSetEntry::UnorderedSetProgram() {
  //initialize a hash set
  std::unordered_set<std::string> hash_set;
  //initialize a hash set with value
  std::unordered_set<std::string> hash_set1{"aa", "bb", "cc", "dd"};
  //copy hash set
  hash_set = hash_set1;
  //whether hash set is empty
  bool is_empty = hash_set.empty();
  //clear hash set
  hash_set.clear();
  //insert element
  hash_set.emplace("ee");
  //initialize a vector contains values
  std::vector<std::string> vec{"aa", "bb", "cc", "dd"};
  //insert a range of elements
  hash_set.insert(vec.begin(), vec.end());
  //get size of hash set
  int size = hash_set.size();
  //whether hash set contains element
  bool b1 = hash_set.count("bb") > 0; // set.contains("bb");
  //create immutable reference of hash set
  const std::unordered_set<std::string> &kConstHashSetRef = hash_set;
  //whether two hash sets equal
  bool b2 = hash_set == hash_set1;
  //remove element equal value
  hash_set.erase("dd");
}
bool UnorderedSetEntry::TestAll() {
  bool ret = true;
  using namespace std;
  unordered_set<int> c, c1, c2, c3, c4;
  vector<int> vec{1, 3, 5, 7, 9};
  c = {1, 2, 3, 4, 5};
  c2 = c;
  c.clear();
  c1 = c;
  c.insert(vec.begin(), vec.end());
  c3 = c;
  c.erase(3);
  c4 = c;
  vector<pair<bool, bool>> bool_result_list = {
      {c1.empty(), true},
      {c.count(7) > 0, true}
  };
  vector<pair<unordered_set<int>, unordered_set<int>>> container_result_list = {
      {c2,
       {1, 2, 3, 4, 5}},
      {c3,
       {1, 3, 5, 7, 9}},
      {c4,
       {1, 5, 7, 9}}
  };
  vector<pair<int, int>> int_result_list = {
      {c4.size(), 4}
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
    std::cout << "Hash Set Test Failed!";
  return ret;
}
