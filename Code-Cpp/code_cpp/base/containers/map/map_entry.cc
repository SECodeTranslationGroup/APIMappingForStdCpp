#include "map_entry.h"
#include <vector>
#include <optional>+

void MapEntry::MapProgram() {
  //initialize a map
  std::map<std::string, std::string> map;
  //initialize a map with value
  std::map<std::string, std::string> map1{{"aa", "a"}, {"bb", "b"}, {"cc", "c"}, {"dd", "d"}};
  //copy map
  map = map1;
  //whether map is empty
  bool is_empty = map.empty();
  //clear map
  map.clear();
  //insert element if not exist
  map.try_emplace("ee", "e");
  //insert or update element
  map["ee"] = "e2";
  //initialize a map contains values
  std::map<std::string, std::string> vec{{"aa", "a"}, {"bb", "b"}, {"cc", "c"}, {"dd", "d"}};
  //insert a range of elements if not exist
  map.merge(vec);
  //insert or update a range of elements
  for (const auto &p:vec)
    map[p.first]=p.second;
  //get size of map
  int size = map.size();
  //whether map contains element
  bool b1 = map.count("bb") > 0; // map.contains("bb");
  //create immutable reference of map
  const std::map<std::string, std::string> &kConstMapRef = map;
  //whether two maps equal
  bool b2 = map == kConstMapRef;
  //removes element equal key
  map.erase("cc");
  //get value of key or else default
  auto it = map.find("cc");
  std::string default_result =  map.find("cc") != map.end() ? it->second : "default";
  //get optional value of key
  std::optional<std::string> result = map.find("cc") != map.end() ? std::make_optional(it->second) : std::nullopt;
  //get optional value of first key lower or equal given key
  it = map.lower_bound("cc");
  result = it != map.end() ? std::make_optional(it->second) : std::nullopt;
  //get optional value of first key greater or equal given key
  it = map.upper_bound("cc");
  result = it != map.end() ? std::make_optional(it->second) : std::nullopt;
}
