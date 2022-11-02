#include <vector>
#include <functional>
#include <optional>
#include <random>
#include <iostream>
#include "algorithm_entry.h"

void AlgorithmEntry::AlgorithmProgram() {
  //initialize first list
  std::vector<int> list{1, 2, 1, 2, 3};
  //whether all element satisfy condition
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
  //find index of first element equals value, orelse -1
  auto it1 = std::find(list.begin(), list.end(), 1);
  int i3 = it1 != list.end() ? it1 - list.begin() : -1;
  //find index of last element equals value, orelse -1
  auto it2 = std::find(list.rbegin(), list.rend(), 1);
  int i4 = it2 != list.rend() ? list.rend() - it2 - 1 : -1;
  //find index of first element satisfies condition, orelse -1
  auto it3 = std::find_if(list.begin(), list.end(), [](auto i) { return i > 1; });
  int i5 = it3 != list.end() ? it3 - list.begin() : -1;
  //find index of first element satisfies condition using optional
  std::optional<int> res1 = it3 != list.end() ? std::make_optional(*it3) : std::nullopt;
  //find index of first element doesn't satisfy condition, orelse -1
  auto it4 = std::find_if_not(list.begin(), list.end(), [](auto i) { return i > 1; });
  int i6 = it4 == list.end() ? -1 : it4 - list.begin();
  //find index of first element doesn't satisfy condition using optional
  std::optional<int> res2 = it4 == list.end() ? std::make_optional(*it4) : std::nullopt;
  //initialize another list
  std::vector<int> to_list;
  //copy a sublist to another list
  std::copy(list.begin() + 1, list.end() - 1, to_list.begin());
  //copy all element satisfy condition to another list
  std::copy_if(list.begin(), list.end(), to_list.begin(), [](auto i) { return i > 1; });
  //copy a sublist to another list with length
  std::copy_n(list.begin(), 3, to_list.begin());
  //fill a list with value
  std::fill(list.begin(), list.end(), 1);
  //fill a list with length and value
  std::fill_n(list.begin()+1, 3, 1);
  //remove all element equal value
  list.erase(std::remove(list.begin(), list.end(), 1), list.end());
  //remove all element satisfy condition
  list.erase(std::remove_if(list.begin(), list.end(),
                            [](auto i) { return i > 1; }), list.end());
  //copy a list removes all element equal value to another list
  std::remove_copy(list.begin(), list.end(), to_list.begin(), 1);
  //copy a list removes all element satisfy condition to another list
  std::remove_copy_if(list.begin(), list.end(), to_list.begin(), [](auto i) { return i > 1; });
  //replace all element equal value to new value
  std::replace(list.begin(), list.end(), 1, 2);
  //replace all element satisfy condition to new value
  std::replace_if(list.begin(), list.end(), [](auto i) { return i > 1; }, 2);
  //copy a list replace all element equal value to new value to another list
  std::replace_copy(list.begin(), list.end(), to_list.begin(), 1, 2);
  //copy a list replace all element satisfy condition to new value to another list
  std::replace_copy_if(list.begin(), list.end(), to_list.begin(), [](auto i) { return i > 1; }, 2);
  //swap two element at two index values
  std::iter_swap(list.begin() + 1, list.begin() + 2);
  //reverse all element
  std::reverse(list.begin(), list.end());
  //copy a list reverse all element to another list
  std::reverse_copy(list.begin(), list.end(), to_list.begin());
  //rotate right with distance
  std::rotate(list.begin(), list.begin() + 1, list.end());
  //copy a list rotate right with distance to another list
  std::rotate_copy(list.begin(), list.begin() + 1, list.end(), to_list.begin());
  //initialize random generator
  std::random_device rd;
  std::default_random_engine rng(rd());
  //random shuffle
  std::shuffle(list.begin(), list.end(), rng);
  //random sample
  std::sample(list.begin(), list.end(), to_list.begin(), 3, rng);
  //initialize partition lists
  std::vector<int> list1, list2;
  //partition to two lists with condition
  std::partition_copy(list.begin(), list.end(), list1.begin(), list2.begin(), [](auto i) { return i > 1; });
  //sort list
  std::sort(list.begin(), list.end());
  //sort list with compare function
  std::sort(list.begin(), list.end(), [](int a, int b) { return a * a + 2 * a < b * b + 2 * b; });
  //copy a list sorted to another list
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
  max_it = std::max_element(list.begin(), list.end(), [](auto a, auto b) { return a * a + 2 * a < b * b + 2 * b; });
  max_element = max_it != list.end() ? std::make_optional(*max_it) : std::nullopt;
  //min element of 2 values
  int min = std::min(1, 2);
  //min element of a list with optional(in case list is empty)
  auto min_it = std::min_element(list.begin(), list.end());
  std::optional<int> min_element = min_it == list.end() ? std::nullopt : std::make_optional(*(min_it));
  //min element with compare function of a list with optional(in case list is empty)
  min_it = std::min_element(list.begin(), list.end(), [](auto a, auto b) { return a * a + 2 * a < b * b + 2 * b; });
  min_element = min_it == list.end() ? std::nullopt : std::make_optional(*min_it);
  //clamp function
  int clamp = std::clamp(5, 0, 100);
  //fill list with range start with 1
  std::iota(list.begin(), list.end(), 1);
  //fill list with range start with value
  std::iota(to_list.begin(), to_list.end(), -3);
  //initialize calculate lists
  std::vector<int> c_list = std::vector<int>(list), c_list_2 = std::vector<int>(list);
  //sum of the list
  int add_sum = std::accumulate(c_list.begin(), c_list.end(), 0);
  //sum of the list using reduce function
  int multiply_sum = std::accumulate(c_list.begin(), c_list.end(), 1, [](auto a, auto b) { return a * b; });
  //inner product of two lists
  int inner_product_sum = std::inner_product(c_list.begin(), c_list.end(), c_list_2.begin(), 0);
  //inner product of two lists using reduce and transform function
  int product_add_sum = std::inner_product(c_list.begin(), c_list.end(), c_list_2.begin(),
                                           1, [](auto a, auto b) { return a * b; },
                                           [](auto a, auto b) { return a + b; });
  //copy adjacent difference of list to another list
  std::adjacent_difference(c_list.begin(), c_list.end(), to_list.begin());
  //copy adjacent difference of list using difference function to another list
  std::adjacent_difference(c_list.begin(), c_list.end(), to_list.begin(),
                           [](auto a, auto b) { return a * b; });
  //copy partial sum of list to another list
  std::partial_sum(c_list.begin(), c_list.end(), to_list.begin());
  //copy partial sum of list using reduce function to another list
  std::partial_sum(c_list.begin(), c_list.end(), to_list.begin(), [](auto a, auto b) { return a * b; });
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
