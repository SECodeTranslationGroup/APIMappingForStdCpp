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
  vec.resize(20, "");
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
  vec.erase(vec.begin() + 3);
  //remove a range of elements at given position
  vec.erase(vec.begin() + 1, vec.begin() + 3);
}
bool VectorEntry::TestAll() {
  bool ret = true;
  using namespace std;
  vector<int> c, c1, c2, c3, c4, c5, c6, c7, c8, c9, c10;
  vector<int> vec{2, 4, 3, 1, 5};
  c = {1, 2, 3, 4, 5};
  c2 = c;
  c.resize(10, 0);
  c3 = c;
  c.clear();
  c1 = c;
  c.insert(c.end(), vec.begin(), vec.end());
  c4 = c;
  c.insert(c.begin() + 1, vec.begin(), vec.end());
  c5 = c;
  c.emplace(c.begin() + 1, -1);
  c6 = c;
  c.emplace_back(10);
  c7 = c;
  c.erase(c.begin() + 3);
  c8 = c;
  c.pop_back();
  c9 = c;
  c.erase(c.begin() + 1, c.begin() + 3);
  c10 = c;
  ret = c1.empty()
      && find(c.begin(), c.end(), 3) != c.end()
      && c7.size() == 12
      && c[2] == 1
      && c2 == vector<int>{1, 2, 3, 4, 5}
      && c3 == vector<int>{1, 2, 3, 4, 5, 0, 0, 0, 0, 0}
      && c4 == vector<int>{2, 4, 3, 1, 5}
      && c5 == vector<int>{2, 2, 4, 3, 1, 5, 4, 3, 1, 5}
      && c6 == vector<int>{2, -1, 2, 4, 3, 1, 5, 4, 3, 1, 5}
      && c7 == vector<int>{2, -1, 2, 4, 3, 1, 5, 4, 3, 1, 5, 10}
      && c8 == vector<int>{2, -1, 2, 3, 1, 5, 4, 3, 1, 5, 10}
      && c9 == vector<int>{2, -1, 2, 3, 1, 5, 4, 3, 1, 5}
      && c10 == vector<int>{2, 3, 1, 5, 4, 3, 1, 5};
  if (!ret)
    cout << "Vector Test Failed!";
  return ret;
}
