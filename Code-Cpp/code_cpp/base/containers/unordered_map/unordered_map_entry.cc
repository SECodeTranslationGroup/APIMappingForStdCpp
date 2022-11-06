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
  //remove element equal key
  hash_map.erase("cc");
  //get value of key or else default
  auto it = hash_map.find("cc");
  std::string default_result =  it != hash_map.end() ? it->second : "default";
  //get optional value of key
  std::optional<std::string> result = it != hash_map.end() ? std::make_optional(it->second) : std::nullopt;
}
bool UnorderedMapEntry::TestAll() {
  bool ret = true;
  using namespace std;
  unordered_map<int, int> c, c1, c2, c3, c4, c5, c6, c7, c8;
  unordered_map<int, int> m{{1, 10}, {2, 8}, {3, 13}, {4, 9}};
  c = {{1, 10}, {2, 8}, {3, 13}, {4, 9}};
  c.clear();
  c1 = c;
  c = m;
  c2 = c;
  c.try_emplace(2,10);
  c3 = c;
  c.try_emplace(5,10);
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
  vector<pair<bool, bool>> bool_result_list = {
      {c1.empty(), true},
      {c.count(3) > 0, true}
  };
  vector<pair<unordered_map<int, int>, unordered_map<int, int>>> container_result_list = {
      {c2,
       {{1, 10}, {2, 8}, {3, 13}, {4, 9}}},
      {c3,
       {{1, 10}, {2, 8}, {3, 13}, {4, 9}}},
      {c4,
       {{1, 10}, {2, 8}, {3, 13}, {4, 9},{5,10}}},
      {c5,
       {{1, 10}, {2, 10}, {3, 13}, {4, 9},{5,10}}},
      {c6,
       {{0,3},{1, 10}, {2, 10}, {3, 13}, {4, 9},{5,10},{10,3}}},
      {c7,
       {{0,3},{1, 8}, {2, 7}, {3, 13}, {4, 9},{5,10},{10,3}}},
      {c8,
       {{0,3},{1, 8}, {3, 13}, {4, 9},{5,10},{10,3}}}
  };
  vector<pair<int, int>> int_result_list = {
      {c.find(3)->second, 13}
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
    std::cout << "Hash Map Test Failed!";
  return ret;
}
