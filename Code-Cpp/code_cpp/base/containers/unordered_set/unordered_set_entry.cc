#include "unordered_set_entry.h"
#include <string>
#include <vector>

void VectorEntry::UnorderedSetProgram() {
  std::unordered_set<std::string> hash_set;
  std::unordered_set<std::string> hash_set1{"aa", "bb", "cc", "dd"};
  hash_set = hash_set1;

  bool is_empty = hash_set.empty();
  hash_set.clear();

  hash_set.emplace("ee");

  std::vector<std::string> vec{"aa", "bb", "cc", "dd"};
  hash_set.insert(vec.begin(), vec.end());

  int size = hash_set.size();

  bool b1 = hash_set.count("bb") > 0; // set.contains("bb");
  const std::unordered_set<std::string> &kConstHashSetRef = hash_set;
  bool b2 = hash_set == hash_set1;

  hash_set.erase("dd");
}
