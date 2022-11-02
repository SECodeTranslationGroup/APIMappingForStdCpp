#include "vector_entry.h"
#include <string>
#include <algorithm>

void VectorEntry::VectorProgram() {
  std::vector<std::string> vec;
  std::vector<std::string> vec1 = std::vector<std::string>{"aa", "bb", "cc", "dd"};

  vec.resize(10, "");
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

  auto it = std::find(vec.begin(), vec.end(), "bb");
  int index = it != vec.end() ? it - vec.begin() : -1;
  auto rit = std::find(vec.rbegin(), vec.rend(), "bb");
  int lastIndex = rit != vec.rend() ? (vec.rend() - rit) -1: -1;

  vec.pop_back();
  vec.erase(vec.begin()+3);

  it = std::find(vec.begin(), vec.end(), "cc");
  vec.erase(it);

  vec.erase(std::remove(vec.begin(),vec.end(),"cc"),vec.end());
  std::transform(vec.begin(),vec.end(),vec.begin(),[](auto e){return e+"1";});

  std::sort(vec.begin(),vec.end());
  std::sort(vec.begin(),vec.end(),[](auto s1,auto s2){return -s1.compare(s2);});

  std::vector<std::string> sublist = std::vector<std::string>(vec.begin()+1,vec.begin()+2);
}
