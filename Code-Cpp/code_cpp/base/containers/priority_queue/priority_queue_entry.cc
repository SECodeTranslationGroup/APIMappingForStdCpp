#include "priority_queue_entry.h"
#include <string>
#include <vector>

void PriorityQueueEntry::PriorityQueueProgram() {
  //initialize a priority queue
  std::priority_queue<std::string> heap;
  //initialize a priority queue with value
  std::vector<std::string> tmpVec{"aa", "bb", "cc", "dd"};
  std::priority_queue<std::string> heap1 = std::priority_queue<std::string>(
      std::less<std::string>(), std::move(tmpVec));
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
  if (!ret)
    std::cout << "Priority Queue Test Failed!";
  return ret;
}
