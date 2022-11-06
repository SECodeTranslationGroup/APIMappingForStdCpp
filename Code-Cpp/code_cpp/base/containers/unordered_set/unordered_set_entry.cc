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
  if (!ret)
    std::cout << "Hash Set Test Failed!";
  return ret;
}
