#include "unordered_map_entry.h"
#include <vector>
#include <optional>

void UnorderedMapEntry::UnorderedMapProgram() {
  std::unordered_map<std::string, std::string> hash_map;
  std::unordered_map<std::string, std::string> hash_map1{{"aa", "a"}, {"bb", "b"}, {"cc", "c"}, {"dd", "d"}};
  hash_map = hash_map1;

  bool is_empty = hash_map.empty();
  hash_map.clear();
  hash_map.try_emplace("ee", "e");
  hash_map["ee"] = "e2";

  std::vector<std::pair<std::string, std::string>> vec{{"aa", "a"}, {"bb", "b"}, {"cc", "c"}, {"dd", "d"}};
  hash_map.insert(vec.begin(), vec.end());

  int size = hash_map.size();

  bool b1 = hash_map.count("bb") > 0; // hash_map.contains("bb");
  const std::unordered_map<std::string, std::string> &kConstHashMapRef = hash_map;
  bool b2 = hash_map == kConstHashMapRef;

  auto it = hash_map.find("cc");
  std::optional<std::string> result = it != hash_map.end() ? std::make_optional(it->second) : std::nullopt;

  hash_map.erase("cc");
}
