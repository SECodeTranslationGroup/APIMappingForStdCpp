#include "unordered_map_entry.h"
#include <vector>
#include <optional>

void UnorderedMapEntry::UnorderedMapProgram() {
  //initialize a hash map
  std::unordered_map<std::string, std::string> hash_map;
  //initialize a hash map with value
  std::unordered_map<std::string, std::string> hash_map1{{"aa", "a"}, {"bb", "b"}, {"cc", "c"}, {"dd", "d"}};
  //copy hash map
  hash_map = hash_map1;
  //whether hash map is empty
  bool is_empty = hash_map.empty();
  //clear hash map
  hash_map.clear();
  //insert element if not exist
  hash_map.try_emplace("ee", "e");
  //insert or update element
  hash_map["ee"] = "e2";
  //initialize a hash map contains values
  std::unordered_map<std::string, std::string> vec{{"aa", "a"}, {"bb", "b"}, {"cc", "c"}, {"dd", "d"}};
  //insert a range of elements if not exist
  hash_map.merge(vec);
  //insert or update a range of elements
  for (const auto &p:vec)
    hash_map[p.first]=p.second;
  //get size of hash map
  int size = hash_map.size();
  //whether hash map contains element
  bool b1 = hash_map.count("bb") > 0; // hash_map.contains("bb");
  //create immutable reference of hash map
  const std::unordered_map<std::string, std::string> &kConstHashMapRef = hash_map;
  //whether two hash maps equal
  bool b2 = hash_map == kConstHashMapRef;
  //removes element equal key
  hash_map.erase("cc");
  //get value of key or else default
  auto it = hash_map.find("cc");
  std::string default_result =  it != hash_map.end() ? it->second : "default";
  //get optional value of key
  std::optional<std::string> result = it != hash_map.end() ? std::make_optional(it->second) : std::nullopt;
}
