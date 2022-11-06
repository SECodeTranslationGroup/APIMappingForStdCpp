#include "random_entry.h"
#include <iostream>
void RandomEntry::RandomProgram() {
  //initialize random generator
  std::random_device rd;
  std::default_random_engine eng(rd());
  //generator random int
  int random_int = std::uniform_int_distribution<>(3, 12)(eng);
  int random_int2 = std::uniform_int_distribution<>(1, 10)(eng);
  //generator random float
  double random_double = std::uniform_real_distribution<>(3, 12)(eng);
  double random_double2 = std::uniform_real_distribution<>(1, 10)(eng);
  //generator random int list
  std::vector<int> list(10);
  std::uniform_int_distribution<int> dist(0, 10);
  std::generate(list.begin(), list.end(), [&]()mutable { return dist(eng); });
  //generator random double list
  std::vector<double> list2(10);
  std::uniform_real_distribution<double> dist2(0, 10);
  std::generate(list.begin(), list.end(), [&]()mutable { return dist2(eng); });
}
bool RandomEntry::TestAll() {
  bool ret = true;
  using namespace std;
  random_device rd;
  default_random_engine eng(rd());
  int random_int = uniform_int_distribution<>(3, 12)(eng);
  ret = ret && random_int >= 3 && random_int <= 12;
  double random_double = uniform_real_distribution<>(17, 22)(eng);
  ret = ret && random_double >= 17 && random_double <= 22;
  vector<int> list(10);
  uniform_int_distribution<int> dist(0, 10);
  generate(list.begin(), list.end(), [&]()mutable { return dist(eng); });
  ret = ret && all_of(list.begin(), list.end(), [](auto i) { return i >= 0 && i <= 10; });
  if (!ret)
    cout << "Random Test Failed!";
  return ret;
}
