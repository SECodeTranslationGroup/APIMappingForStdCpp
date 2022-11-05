#include "vector_entry.h"
#include <string>
#include <algorithm>

void VectorEntry::VectorProgram() {
  //initialize a vector
  std::vector<std::string> vec;
  //initialize a vector with value
  std::vector<std::string> vec1{"aa", "bb", "cc", "dd"};
  //copy vector
  vec = vec1;
  //resize vector and fill with default value
  vec.assign(10, "");
  //resize vector, trunc additional size or fill with default value
  vec.resize(20,"");
  //whether vector is empty
  bool is_empty = vec.empty();
  //clear vector
  vec.clear();
  //insert element at end
  vec.emplace_back("ee");
  //insert element at given position
  vec.emplace(vec.begin() + 1, "ff");
  //insert a range of elements at end
  vec.insert(vec.end(), vec1.begin(), vec1.end());
  //insert a range of elements at given position
  vec.insert(vec.begin() + 1, vec1.begin(), vec1.end());
  //get size of list
  int size = vec.size();
  //whether list contains element
  bool b1 = std::find(vec.begin(), vec.end(), "bb") != vec.end();
  //create immutable reference of list
  const std::vector<std::string> &kConstVecRef = vec;
  //whether two lists equal
  bool b2 = vec == kConstVecRef;
  //get element at given position
  std::string element = vec[3];
  //update element
  vec[3] = "hh";
  //remove last element
  vec.pop_back();
  //remove element at given position
  vec.erase(vec.begin()+3);
  //remove a range of elements at given position
  vec.erase(vec.begin()+1,vec.begin()+3);
}
