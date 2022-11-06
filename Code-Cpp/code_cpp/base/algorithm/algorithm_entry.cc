#include <vector>
#include <functional>
#include <optional>
#include <random>
#include <iostream>
#include "algorithm_entry.h"

void AlgorithmEntry::AlgorithmProgram() {
  //initialize first list
  std::vector<int> list{1, 2, 1, 2, 3};
  //whether all elements satisfy condition
  bool b1 = std::all_of(list.begin(), list.end(), [](auto i) { return i > 1; });
  //whether any element satisfy condition
  bool b2 = std::any_of(list.begin(), list.end(), [](auto i) { return i > 1; });
  //whether no element satisfy condition
  bool b3 = std::none_of(list.begin(), list.end(), [](auto i) { return i > 1; });
  //for each element do function
  std::for_each(list.begin(), list.end(), [](auto i) { std::cout << i << std::endl; });
  //transform each element with function
  std::transform(list.begin(), list.end(), list.begin(), [](auto i) { return i * 2; });
  //count how many elements equal value
  int i1 = std::count(list.begin(), list.end(), 1);
  //count how many elements satisfy condition
  int i2 = std::count_if(list.begin(), list.end(), [](auto i) { return i > 1; });
  //find index of first element equals value, or else -1
  auto it1 = std::find(list.begin(), list.end(), 1);
  int i3 = it1 != list.end() ? it1 - list.begin() : -1;
  //find index of last element equals value, or else -1
  auto it2 = std::find(list.rbegin(), list.rend(), 1);
  int i4 = it2 != list.rend() ? list.rend() - it2 - 1 : -1;
  //find index of first element satisfies condition, or else -1
  auto it3 = std::find_if(list.begin(), list.end(),
                          [](auto i) { return i > 1; });
  int i5 = it3 != list.end() ? it3 - list.begin() : -1;
  //find index of first element satisfies condition using optional
  std::optional<int> res1 = it3 != list.end() ? std::make_optional(*it3) : std::nullopt;
  //find index of first element doesn't satisfy condition, or else -1
  auto it4 = std::find_if_not(list.begin(), list.end(),
                              [](auto i) { return i > 1; });
  int i6 = it4 == list.end() ? -1 : it4 - list.begin();
  //find index of first element doesn't satisfy condition using optional
  std::optional<int> res2 = it4 == list.end() ? std::make_optional(*it4) : std::nullopt;
  //initialize another list
  std::vector<int> to_list;
  //copy a sublist to another list
  std::copy(list.begin() + 1, list.end() - 1, std::back_inserter(to_list));
  //copy all elements satisfy condition to another list
  to_list.clear();
  std::copy_if(list.begin(), list.end(), std::back_inserter(to_list),
               [](auto i) { return i > 1; });
  //copy a sublist to another list with length
  to_list.clear();
  std::copy_n(list.begin(), 3, std::back_inserter(to_list));
  //fill a list with value
  std::fill(list.begin(), list.end(), 1);
  //fill a list with length and value
  std::fill_n(list.begin() + 1, 3, 1);
  //remove all elements equal value
  list.erase(std::remove(list.begin(), list.end(), 1), list.end());//std::erase(list,1);
  //remove all elements satisfy condition
  list.erase(std::remove_if(list.begin(), list.end(),
                            [](auto i) { return i > 1; }),
             list.end());//std::erase_if(list,[](auto i) { return i > 1; });
  //copy a list removes all elements equal value to another list
  to_list.clear();
  std::remove_copy(list.begin(), list.end(), std::back_inserter(to_list), 1);
  //copy a list removes all elements satisfy condition to another list
  to_list.clear();
  std::remove_copy_if(list.begin(), list.end(), std::back_inserter(to_list),
                      [](auto i) { return i > 1; });
  //replace all elements equal value to new value
  std::replace(list.begin(), list.end(), 1, 2);
  //replace all elements satisfy condition to new value
  std::replace_if(list.begin(), list.end(), [](auto i) { return i > 1; }, 2);
  //copy a list replace all elements equal value to new value to another list
  to_list.clear();
  std::replace_copy(list.begin(), list.end(), std::back_inserter(to_list), 1, 2);
  //copy a list replace all elements satisfy condition to new value to another list
  to_list.clear();
  std::replace_copy_if(list.begin(), list.end(), std::back_inserter(to_list),
                       [](auto i) { return i > 1; }, 2);
  //swap two element at two index values
  std::iter_swap(list.begin() + 1, list.begin() + 2);
  //reverse list
  std::reverse(list.begin(), list.end());
  //copy a reversed list to another list
  to_list.clear();
  std::reverse_copy(list.begin(), list.end(), std::back_inserter(to_list));
  //rotate right with distance
  std::rotate(list.begin(), list.end() - 1, list.end());
  //copy a list rotate right with distance to another list
  to_list.clear();
  std::rotate_copy(list.begin(), list.end() - 1, list.end(), std::back_inserter(to_list));
  //initialize random generator
  std::random_device rd;
  std::default_random_engine rng(rd());
  //random shuffle
  std::shuffle(list.begin(), list.end(), rng);
  //random sample
  to_list.clear();
  std::sample(list.begin(), list.end(), std::back_inserter(to_list), 3, rng);
  //initialize partition lists
  std::vector<int> list1, list2;
  //partition to two lists with condition
  std::partition_copy(list.begin(), list.end(),
                      std::back_inserter(list1),
                      std::back_inserter(list2),
                      [](auto i) { return i > 1; });
  //sort list
  std::sort(list.begin(), list.end());
  //sort list with compare function
  std::sort(list.begin(), list.end(),
            [](int a, int b) { return a * a + 2 * a < b * b + 2 * b; });
  //copy a list sorted to another list
  to_list.resize(list.size());
  std::partial_sort_copy(list.begin(), list.end(),
                         to_list.begin(), to_list.end());
  //binary search whether value exist
  bool b4 = std::binary_search(list.begin(), list.end(), 1);
  //max element of 2 values
  int max = std::max(1, 2);
  //max element of a list with optional(in case list is empty)
  auto max_it = std::max_element(list.begin(), list.end());
  std::optional<int> max_element = max_it == list.end() ? std::nullopt : std::make_optional(*max_it);
  //max element with compare function of a list with optional(in case list is empty)
  max_it = std::max_element(list.begin(), list.end(),
                            [](auto a, auto b) { return a * a + 2 * a < b * b + 2 * b; });
  max_element = max_it != list.end() ? std::make_optional(*max_it) : std::nullopt;
  //min element of 2 values
  int min = std::min(1, 2);
  //min element of a list with optional(in case list is empty)
  auto min_it = std::min_element(list.begin(), list.end());
  std::optional<int> min_element = min_it == list.end() ? std::nullopt : std::make_optional(*(min_it));
  //min element with compare function of a list with optional(in case list is empty)
  min_it = std::min_element(list.begin(), list.end(),
                            [](auto a, auto b) { return a * a + 2 * a < b * b + 2 * b; });
  min_element = min_it == list.end() ? std::nullopt : std::make_optional(*min_it);
  //clamp function
  int clamp = std::clamp(5, 0, 100);
  //fill list with range start with 1
  std::iota(list.begin(), list.end(), 1);
  //fill list with range start with value
  std::iota(list.begin(), list.end(), -3);
  //initialize calculate lists
  std::vector<int> c_list = std::vector<int>(list), c_list_2 = std::vector<int>(list);
  //sum of the list
  int add_sum = std::accumulate(c_list.begin(), c_list.end(), 0);
  //sum of the list using reduce function
  int multiply_sum = std::accumulate(c_list.begin(), c_list.end(), 1,
                                     [](auto a, auto b) { return a * b; });
  //inner product of two lists
  int inner_product_sum = std::inner_product(c_list.begin(), c_list.end(), c_list_2.begin(), 0);
  //inner product of two lists using reduce and transform function
  int product_add_sum = std::inner_product(c_list.begin(), c_list.end(), c_list_2.begin(),
                                           1, [](auto a, auto b) { return a * b; },
                                           [](auto a, auto b) { return a + b; });
  //copy adjacent difference of list to another list
  to_list.clear();
  std::adjacent_difference(c_list.begin(), c_list.end(), std::back_inserter(to_list));
  //copy adjacent difference of list using difference function to another list
  to_list.clear();
  std::adjacent_difference(c_list.begin(), c_list.end(), std::back_inserter(to_list),
                           [](auto a, auto b) { return a * b; });
  //copy partial sum of list to another list
  to_list.clear();
  std::partial_sum(c_list.begin(), c_list.end(), std::back_inserter(to_list));
  //copy partial sum of list using reduce function to another list
  to_list.clear();
  std::partial_sum(c_list.begin(), c_list.end(), std::back_inserter(to_list),
                   [](auto a, auto b) { return a * b; });
}
bool AlgorithmEntry::TestAll() {
  bool ret = true;
  using namespace std;
  vector<int> l{1, 3, 5, 7, 9, 9, 7, 5, 3, 1};
  vector<int> l1{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
  vector<int> l2, l3, l4, l5, l6, l7, l8, l9, l10;
  vector<int> l11, l12, l13, l14, l15, l16, l17, l18;
  vector<int> l19, l20, l21, l22, l23, l24, l25, l26;
  vector<int> l27, l28, l29, l30, l31, l32;
  for_each(l.begin(), l.end(), [&l2](auto i) { l2.emplace_back(i * 2); });
  vector<pair<bool, bool>> bool_result_list = {
      {all_of(l.begin(), l.end(), [](auto i) { return i > 0; }),
       true},
      {all_of(l.begin(), l.end(), [](auto i) { return i > 5; }),
       false},
      {any_of(l.begin(), l.end(), [](auto i) { return i > 5; }),
       true},
      {any_of(l.begin(), l.end(), [](auto i) { return i > 10; }),
       false},
      {none_of(l.begin(), l.end(), [](auto i) { return i > 10; }),
       true},
      {none_of(l.begin(), l.end(), [](auto i) { return i > 5; }),
       false},
      {binary_search(l1.begin(), l1.end(), 5),
       true},
      {binary_search(l1.begin(), l1.end(), 0),
       false},
  };
  vector<pair<int, int>> int_result_list = {
      {count(l.begin(), l.end(), 1),
       2},
      {count_if(l.begin(), l.end(), [](auto i) { return i > 5; }),
       4},
      {find(l.begin(), l.end(), 5) - l.begin(),
       2},
      {l.rend() - find(l.rbegin(), l.rend(), 5) - 1,
       7},
      {find_if(l.begin(), l.end(), [](auto i) { return i > 4; }) - l.begin(),
       2},
      {find_if_not(l.begin(), l.end(), [](auto i) { return i < 4; }) - l.begin(),
       2},
      {max(1, 2),
       2},
      {*max_element(l.begin(), l.end()),
       9},
      {*max_element(l.begin(), l.end(),
                    [](auto a, auto b) { return abs(a - 4) < abs(b - 4); }),
       9},
      {min(1, 2),
       1},
      {*min_element(l.begin(), l.end()),
       1},
      {*min_element(l.begin(), l.end(),
                    [](auto a, auto b) { return abs(a - 5) < abs(b - 5); }),
       5},
      {clamp(5, 0, 100),
       5},
      {clamp(5, 0, 3),
       3},
      {clamp(5, 6, 100),
       6},
      {accumulate(l.begin(), l.end(), 0),
       50},
      {accumulate(l.begin(), l.end(), 1, [](auto a, auto b) { return a * b; }),
       893025},
      {inner_product(l.begin(), l.end(), l.begin(), 0),
       330},
      {inner_product(l.begin(), l.end(), l.begin(),
                     1, [](auto a, auto b) { return a * b; },
                     [](auto a, auto b) { return a + b; }),
       914457600}
  };
  transform(l2.begin(), l2.end(), back_inserter(l3),
            [](auto i) { return i + 1; });
  copy(l2.begin() + 1, l2.end() - 1, back_inserter(l4));
  copy_if(l2.begin(), l2.end(), back_inserter(l5),
          [](auto i) { return i > 6; });
  copy_n(l2.begin(), 5, back_inserter(l6));
  l7.resize(10, 0);
  fill(l7.begin(), l7.end(), 1);
  l8.resize(10, 0);
  fill_n(l8.begin(), 5, 1);
  l9 = l2;
  l9.erase(remove(l9.begin(), l9.end(), 6), l9.end());
  l10 = l2;
  l10.erase(remove_if(l10.begin(), l10.end(),
                      [](auto i) { return i > 6; }), l10.end());
  remove_copy(l2.begin(), l2.end(), back_inserter(l11), 6);
  remove_copy_if(l2.begin(), l2.end(), back_inserter(l12),
                 [](auto i) { return i > 6; });
  l13 = l2;
  l14 = l2;
  replace(l13.begin(), l13.end(), 2, 3);
  replace_if(l14.begin(), l14.end(), [](auto i) { return i > 6; }, 3);
  replace_copy(l2.begin(), l2.end(), back_inserter(l15), 2, 3);
  replace_copy_if(l2.begin(), l2.end(), back_inserter(l16),
                  [](auto i) { return i > 6; }, 3);
  l17 = l2;
  iter_swap(l17.begin() + 1, l17.begin() + 2);
  l18 = l17;
  reverse(l18.begin(), l18.end());
  reverse_copy(l17.begin(), l17.end(), back_inserter(l19));
  l20 = l2;
  rotate(l20.begin(), l20.end() - 1, l20.end());
  rotate_copy(l2.begin(), l2.end() - 1, l2.end(), back_inserter(l21));
  partition_copy(l2.begin(), l2.end(),
                 std::back_inserter(l22),
                 std::back_inserter(l23),
                 [](auto i) { return i > 6; });
  l24 = l2;
  sort(l24.begin(), l24.end());
  l25 = l2;
  sort(l25.begin(), l25.end(),
       [](int a, int b) { return abs(a - 7) < abs(b - 7); });
  l26.resize(10, 0);
  partial_sort_copy(l2.begin(), l2.end(), l26.begin(), l26.end());
  l27.resize(10);
  iota(l27.begin(), l27.end(), 1);
  l28.resize(10);
  iota(l28.begin(), l28.end(), -3);
  adjacent_difference(l2.begin(), l2.end(), back_inserter(l29));
  adjacent_difference(l2.begin(), l2.end(), back_inserter(l30),
                      [](auto a, auto b) { return a * b; });
  partial_sum(l2.begin(), l2.end(), back_inserter(l31));
  partial_sum(l1.begin(), l1.end(), back_inserter(l32), [](auto a, auto b) { return a * b; });
  vector<pair<vector<int>, vector<int>>> vector_result_list = {
      {l2,
       {2, 6, 10, 14, 18, 18, 14, 10, 6, 2}},
      {l3,
       {3, 7, 11, 15, 19, 19, 15, 11, 7, 3}},
      {l4,
       {6, 10, 14, 18, 18, 14, 10, 6}},
      {l5,
       {10, 14, 18, 18, 14, 10}},
      {l6,
       {2, 6, 10, 14, 18}},
      {l7,
       {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}},
      {l8,
       {1, 1, 1, 1, 1, 0, 0, 0, 0, 0}},
      {l9,
       {2, 10, 14, 18, 18, 14, 10, 2}},
      {l10,
       {2, 6, 6, 2}},
      {l11,
       {2, 10, 14, 18, 18, 14, 10, 2}},
      {l12,
       {2, 6, 6, 2}},
      {l13,
       {3, 6, 10, 14, 18, 18, 14, 10, 6, 3}},
      {l14,
       {2, 6, 3, 3, 3, 3, 3, 3, 6, 2}},
      {l15,
       {3, 6, 10, 14, 18, 18, 14, 10, 6, 3}},
      {l16,
       {2, 6, 3, 3, 3, 3, 3, 3, 6, 2}},
      {l17,
       {2, 10, 6, 14, 18, 18, 14, 10, 6, 2}},
      {l18,
       {2, 6, 10, 14, 18, 18, 14, 6, 10, 2}},
      {l19,
       {2, 6, 10, 14, 18, 18, 14, 6, 10, 2}},
      {l20,
       {2, 2, 6, 10, 14, 18, 18, 14, 10, 6}},
      {l21,
       {2, 2, 6, 10, 14, 18, 18, 14, 10, 6}},
      {l22,
       {10, 14, 18, 18, 14, 10}},
      {l23,
       {2, 6, 6, 2}},
      {l24,
       {2, 2, 6, 6, 10, 10, 14, 14, 18, 18}},
      {l25,
       {6, 6, 10, 10, 2, 2, 14, 14, 18, 18}},
      {l26,
       {2, 2, 6, 6, 10, 10, 14, 14, 18, 18}},
      {l27,
       {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}},
      {l28,
       {-3, -2, -1, 0, 1, 2, 3, 4, 5, 6}},
      {l29,
       {2, 4, 4, 4, 4, 0, -4, -4, -4, -4}},
      {l30,
       {2, 12, 60, 140, 252, 324, 252, 140, 60, 12}},
      {l31,
       {2, 8, 18, 32, 50, 68, 82, 92, 98, 100}},
      {l32,
       {1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800}}
  };
  for (const auto &it : vector_result_list) {
    ret = ret && it.first == it.second;
  }
  for (auto it : bool_result_list) {
    ret = ret && it.first == it.second;
  }
  for (auto it : int_result_list) {
    ret = ret && it.first == it.second;
  }
  if (!ret)
    std::cout << "Algorithm Test Failed!";
  return ret;
}