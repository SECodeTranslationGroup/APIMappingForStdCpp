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

bool EqualPQ(std::priority_queue<int, std::vector<int>, std::greater<>> a,
             std::priority_queue<int, std::vector<int>, std::greater<>> b){
  if (a.size() != b.size()) return false;
  for(int i = 0; i <a.size();i++) {
    if (a.top() != b.top()) return false;
    a.pop();b.pop();
  }
  return true;
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
  ret = c1.empty()
      && c4.size() == 5
      && c.top() == 0
      && EqualPQ(c2,
                 priority_queue<int, vector<int>, greater<>>(greater<>(), {1, 2, 3, 4, 5}))
      && EqualPQ(c3,
                 priority_queue<int, vector<int>, greater<>>(greater<>(), {2, 3, 4, 5}))
      && EqualPQ(c4,
                 priority_queue<int, vector<int>, greater<>>(greater<>(), {0, 2, 3, 4, 5}));
  if (!ret)
    cout << "Priority Queue Test Failed!"<< endl;
  return ret;
}
