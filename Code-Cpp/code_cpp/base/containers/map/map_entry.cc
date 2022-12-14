#include "map_entry.h"
#include <vector>
#include <optional>

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
  for (const auto &p : vec)
    map[p.first] = p.second;
  //get size of map
  int size = map.size();
  //whether map contains element
  bool b1 = map.count("bb") > 0; // map.contains("bb");
  //create immutable reference of map
  const std::map<std::string, std::string> &kConstMapRef = map;
  //whether two maps equal
  bool b2 = map == kConstMapRef;
  //remove element equal key
  map.erase("cc");
  //get value of key or else default
  auto it = map.find("cc");
  std::string default_result = it != map.end() ? it->second : "default";
  //get optional value of key
  std::optional<std::string> result = it != map.end() ? std::make_optional(it->second) : std::nullopt;
  //get optional value of first key lower or equal given key
  it = --map.upper_bound("cc");
  result = it != map.end() ? std::make_optional(it->second) : std::nullopt;
  //get optional value of first key greater or equal given key
  it = map.lower_bound("cc");
  result = it != map.end() ? std::make_optional(it->second) : std::nullopt;
}
bool MapEntry::TestAll() {
  bool ret = true;
  using namespace std;
  map<int, int> c, c1, c2, c3, c4, c5, c6, c7, c8;
  map<int, int> m{{1, 10}, {2, 8}, {3, 13}, {4, 9}};
  c = {{1, 10}, {2, 8}, {3, 13}, {4, 9}};
  c.clear();
  c1 = c;
  c = m;
  c2 = c;
  c.try_emplace(2, 10);
  c3 = c;
  c.try_emplace(5, 10);
  c4 = c;
  c[2] = 10;
  c5 = c;
  m = {{0, 3}, {1, 8}, {2, 7}, {10, 3}};
  c.merge(m);
  c6 = c;
  for (const auto &p : m)
    c[p.first] = p.second;
  c7 = c;
  c.erase(2);
  c8 = c;
  ret = c1.empty()
      && c.count(3) > 0
      && c.find(3)->second == 13
      && c.lower_bound(2)->second == 13
      && (--c.upper_bound(2))->second == 8
      && c2 == map<int, int>{{1, 10}, {2, 8}, {3, 13}, {4, 9}}
      && c3 == map<int, int>{{1, 10}, {2, 8}, {3, 13}, {4, 9}}
      && c4 == map<int, int>{{1, 10}, {2, 8}, {3, 13}, {4, 9}, {5, 10}}
      && c5 == map<int, int>{{1, 10}, {2, 10}, {3, 13}, {4, 9}, {5, 10}}
      && c6 == map<int, int>{{0, 3}, {1, 10}, {2, 10}, {3, 13}, {4, 9}, {5, 10}, {10, 3}}
      && c7 == map<int, int>{{0, 3}, {1, 8}, {2, 7}, {3, 13}, {4, 9}, {5, 10}, {10, 3}}
      && c8 == map<int, int>{{0, 3}, {1, 8}, {3, 13}, {4, 9}, {5, 10}, {10, 3}};
  if (!ret)
    cout << "Map Test Failed!"<< endl;
  return ret;
}
