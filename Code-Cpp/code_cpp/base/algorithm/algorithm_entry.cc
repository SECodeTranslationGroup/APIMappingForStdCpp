//
// Created by 85339 on 2022/10/19.
//

#include <vector>
#include <functional>
#include <optional>

#include "algorithm_entry.h"
void AlgorithmEntry::AlgorithmProgram() {
  std::vector<int> list{1, 2, 1, 2, 3};
  std::function<bool(int)> pred = [](int i) { return i > 1; };
  std::function<void(int)> con = [](int i) {};
  std::function<void(int &)> op = [](int &i) { i *= 2; };
  bool b1 = std::all_of(list.begin(), list.end(), pred);
  bool b2 = std::any_of(list.begin(), list.end(), pred);
  bool b3 = std::none_of(list.begin(), list.end(), pred);
  std::for_each(list.begin(), list.end(), con);
  std::for_each(list.begin(), list.end(), op);
  int i1 = std::count(list.begin(), list.end(), 1);
  int i2 = std::count_if(list.begin(), list.end(), pred);

  auto it1 = std::find(list.begin(), list.end(), 1);
  int i3 = it1 == list.end() ? -1 : it1 - list.begin();

  auto it2 = std::find_if(list.begin(), list.end(), pred);
  int i4 = it2 == list.end() ? -1 : it2 - list.begin();
  std::optional<int> res1 = it2 == list.end() ? std::make_optional(*it2) : std::nullopt;

  auto it3 = std::find_if_not(list.begin(), list.end(), pred);
  int i5 = it3 == list.end() ? -1 : it3 - list.begin();
  std::optional<int> res2 = it3 == list.end() ? std::make_optional(*it3) : std::nullopt;

  std::vector<int> to_list;
  std::copy(list.begin()+1, list.end() - 1, to_list.begin());
  std::copy_if(list.begin(), list.end(), to_list.begin(), pred);
  std::copy_n(list.begin(),  3, to_list.begin());
}
