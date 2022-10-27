//
// Created by 85339 on 2022/10/19.
//

#include <vector>
#include <functional>
#include <optional>
#include <random>

#include "algorithm_entry.h"

void AlgorithmEntry::AlgorithmProgram() {
  std::vector<int> list{1, 2, 1, 2, 3};
  std::function<bool(int)> pred = [](auto i) { return i > 1; };
  std::function<void(int)> con = [](auto i) {};
  std::function<int(int)> op = [](auto i) { return i * 2; };
  bool b1 = std::all_of(list.begin(), list.end(), pred);
  bool b2 = std::any_of(list.begin(), list.end(), pred);
  bool b3 = std::none_of(list.begin(), list.end(), pred);
  std::for_each(list.begin(), list.end(), con);
  std::transform(list.begin(), list.end(), list.begin(), op);
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
  std::copy(list.begin() + 1, list.end() - 1, to_list.begin());
  std::copy_if(list.begin(), list.end(), to_list.begin(), pred);
  std::copy_n(list.begin(), 3, to_list.begin());

  std::fill(list.begin(), list.end(), 1);
  std::fill_n(list.begin(), 3, 1);

  std::remove(list.begin(), list.end(), 1);
  std::remove_if(list.begin(), list.end(), pred);

  std::remove_copy(list.begin(), list.end(), to_list.begin(), 1);
  std::remove_copy_if(list.begin(), list.end(), to_list.begin(), pred);

  std::replace(list.begin(), list.end(), 1, 2);
  std::replace_if(list.begin(), list.end(), pred, 2);

  std::replace_copy(list.begin(), list.end(), to_list.begin(), 1, 2);
  std::replace_copy_if(list.begin(), list.end(), to_list.begin(), pred, 2);

  std::iter_swap(list.begin() + 1, list.begin() + 2);

  std::reverse(list.begin(), list.end());

  std::reverse_copy(list.begin(), list.end(), to_list.begin());

  std::rotate(list.begin(), list.begin() + 1, list.end());

  std::rotate_copy(list.begin(), list.begin() + 1, list.end(), to_list.begin());

  std::random_device rd;
  std::default_random_engine rng(rd());
  std::shuffle(list.begin(), list.end(), rng);

  std::sample(list.begin(), list.end(), to_list.begin(), 3, rng);

  std::vector<int> list1, list2;
  std::partition_copy(list.begin(), list.end(), list1.begin(), list2.begin(), pred);

  std::sort(list.begin(), list.end(), [](int a, int b) { return a * a + 2 * a < b * b + 2 * b; });
  std::stable_sort(list.begin(), list.end());
  std::partial_sort_copy(list.begin(),
                         list.end(),
                         to_list.begin(),
                         to_list.end(),
                         [](int a, int b) { return a * a + 2 * a < b * b + 2 * b; });

  bool b4 = std::binary_search(list.begin(), list.end(), 1);

  int max = std::max(1, 2);
  auto max_it = std::max_element(list.begin(), list.end());
  std::optional<int> max_element = max_it == list.end() ? std::nullopt : std::make_optional(*max_it);
  max_it = std::max_element(list.begin(), list.end(), [](auto a, auto b) { return a * a + 2 * a < b * b + 2 * b; });
  max_element = max_it == list.end() ? std::nullopt : std::make_optional(*max_it);

  int min = std::min(1, 2);
  auto min_it = std::min_element(list.begin(), list.end());
  std::optional<int> min_element = min_it == list.end() ? std::nullopt : std::make_optional(*(min_it));
  min_it = std::min_element(list.begin(), list.end(), [](auto a, auto b) { return a * a + 2 * a < b * b + 2 * b; });
  min_element = min_it == list.end() ? std::nullopt : std::make_optional(*min_it);

  int clamp = std::clamp(5, 0, 100);

  std::iota(list.begin(), list.end(), 1);
  int add_sum = std::accumulate(list.begin(), list.end(), 0);
  int multiply_sum = std::accumulate(list.begin(), list.end(), 1, std::multiplies<int>());
  std::iota(to_list.begin(), to_list.end(), -3);

  int inner_product_sum = std::inner_product(list.begin(), list.end(), to_list.begin(), 0);
  std::adjacent_difference(list.begin(), list.end(), to_list.begin());

  std::partial_sum(list.begin(), list.end(), to_list.begin());
}
bool AlgorithmEntry::Test1() {
  std::vector<int> list1{1, 2, 1, 2, 3};
  std::vector<int> list2{1, 2, 1, 2, 3};

  int sum = std::inner_product(list1.begin(), list1.end(), list2.begin(),
                               1, [](auto a, auto b) { return a * b; },
                               [](auto a, auto b) { return a + b; });

  std::partial_sum(list1.begin(), list1.end(), list2.begin(),
                   [](auto a, auto b) { return a * b; });

  std::vector<int> list3, list4;
  std::partition_copy(list1.begin(), list1.end(),
                      list3.begin(), list4.begin(), [](auto i) { return i > 3; });

  return sum > 0;
}
