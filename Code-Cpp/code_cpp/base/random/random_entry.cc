#include "random_entry.h"
void RandomEntry::RandomProgram() {
  std::random_device rd;
  std::default_random_engine eng(rd());

  int random_int = std::uniform_int_distribution<>(3, 12)(eng);
  int random_int2 = std::uniform_int_distribution<>(1, 10)(eng);

  double random_double = std::uniform_real_distribution<>(3, 12)(eng);
  double random_double2 = std::uniform_real_distribution<>(1, 10)(eng);

  std::vector<int> list(10);
  std::uniform_int_distribution<int> dist(0, 10);
  std::generate(list.begin(), list.end(), [&]()mutable { return dist(eng); });

  std::vector<double> list2(10);
  std::uniform_real_distribution<double> dist2(0, 10);
  std::generate(list.begin(), list.end(), [&]()mutable { return dist2(eng); });
}
