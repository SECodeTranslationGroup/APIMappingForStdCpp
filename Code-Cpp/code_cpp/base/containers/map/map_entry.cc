#include "map_entry.h"
#include <vector>
#include <algorithm>
#include <optional>

void MapEntry::MapProgram() {
  std::map<std::string, std::string> map;
  std::map<std::string, std::string> map1{{"aa", "a"}, {"bb", "b"}, {"cc", "c"}, {"dd", "d"}};
  map = map1;

  bool is_empty = map.empty();
  map.clear();
  map.try_emplace("ee", "e");
  map["ee"] = "e2";

  std::vector<std::pair<std::string, std::string>> vec{{"aa", "a"}, {"bb", "b"}, {"cc", "c"}, {"dd", "d"}};
  map.insert(vec.begin(), vec.end());

  int size = map.size();

  bool b1 = map.count("bb") > 0; // map.contains("bb");
  const std::map<std::string, std::string> &kConstMapRef = map;
  bool b2 = map == kConstMapRef;

  auto it = map.find("cc");
  std::optional<std::string> result = it != map.end() ? std::make_optional(it->second) : std::nullopt;
  it = map.lower_bound("cc");
  result = it != map.end() ? std::make_optional(it->second) : std::nullopt;
  it = map.upper_bound("cc");
  result = it != map.end() ? std::make_optional(it->second) : std::nullopt;
}
