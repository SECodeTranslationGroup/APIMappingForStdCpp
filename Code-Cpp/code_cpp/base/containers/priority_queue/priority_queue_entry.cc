#include "priority_queue_entry.h"
#include <string>
#include <vector>

void PriorityQueueEntry::PriorityQueueProgram() {
  //initialize a priority queue
  std::priority_queue<std::string, std::vector<std::string>, std::greater<>> heap;
  //initialize a priority queue with value
  std::vector<std::string> tmpVec{"aa", "bb", "cc", "dd"};
  std::priority_queue<std::string, std::vector<std::string>, std::greater<>> heap1 =
      std::priority_queue<std::string, std::vector<std::string>, std::greater<>>(
          std::greater<>(), std::move(tmpVec));
  //copy priority queue
  heap = heap1;
  //whether priority queue is empty
  bool is_empty = heap.empty();
  //clear priority queue
  heap = {};
  //insert element
  heap.emplace("ee");
  //remove smallest element
  heap.pop();
  //get size of priority queue
  int size = heap.size();
  //get smallest element
  std::string element = heap.top();
}
bool PriorityQueueEntry::TestAll() {
  bool ret = true;
  using namespace std;
  priority_queue<int, vector<int>, greater<>> c, c1, c2, c3, c4;
  vector<int> vec{2, 4, 3, 1, 5};
  c1 = {};
  c = priority_queue<int, vector<int>, greater<>>(greater<>(), vec);
  c2 = c;
  c.pop();
  c3 = c;
  c.emplace(0);
  c4 = c;
  vector<pair<bool, bool>> bool_result_list = {
      {c1.empty(), true}
  };
  vector<pair<priority_queue<int, vector<int>, greater<>>,
              priority_queue<int, vector<int>, greater<>>>> container_result_list = {
      {c2,
       priority_queue<int, vector<int>, greater<>>(greater<>(), {1, 2, 3, 4, 5})},
      {c3,
       priority_queue<int, vector<int>, greater<>>(greater<>(), {2, 3, 4, 5})},
      {c4,
       priority_queue<int, vector<int>, greater<>>(greater<>(), {0, 2, 3, 4, 5})},
  };
  vector<pair<int, int>> int_result_list = {
      {c4.size(), 5},
      {c.top(), 0}
  };
  for (auto &it : container_result_list) {
    ret = ret && it.first.size() == it.second.size();
    for(int i = 0; i < min(it.first.size(),it.second.size());i++)
      ret = ret && it.first.top() == it.second.top();
      it.first.pop();
      it.second.pop();
  }
  for (auto it : bool_result_list) {
    ret = ret && it.first == it.second;
  }
  for (auto it : int_result_list) {
    ret = ret && it.first == it.second;
  }
  if (!ret)
    std::cout << "Priority Queue Test Failed!";
  return ret;
}
