#include "vector_entry.h"
#include <string>
#include <algorithm>

void VectorEntry::VectorProgram() {
  std::vector<std::string> vec;
  std::vector<std::string> vec1 = std::vector<std::string>{"aa", "bb", "cc", "dd"};
  vec.assign(10, "");
  vec.resize(20,"");

  bool is_empty = vec.empty();
  vec.clear();

  vec.emplace_back("ee");
  vec.emplace(vec.begin() + 1, "ff");
  vec.insert(vec.end(), vec1.begin(), vec1.end());
  vec.insert(vec.begin() + 1, vec1.begin(), vec1.end());

  int size = vec.size();

  bool b1 = std::find(vec.begin(), vec.end(), "bb") != vec.end();
  const std::vector<std::string> &constVecRef = vec;
  bool b3 = vec == constVecRef;
  std::string element = vec[3];
  vec[3] = "hh";

  vec.pop_back();
  vec.erase(vec.begin()+3);
  vec.erase(vec.begin()+1,vec.begin()+3);
}
