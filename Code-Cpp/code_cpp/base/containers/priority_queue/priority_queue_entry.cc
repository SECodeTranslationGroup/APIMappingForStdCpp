#include "priority_queue_entry.h"
#include <string>
#include <vector>

void PriorityQueueEntry::PriorityQueueProgram() {
  std::priority_queue<std::string> heap;
  std::vector<std::string> tmpVec{"aa", "bb", "cc", "dd"};
  std::priority_queue<std::string> heap1 = std::priority_queue<std::string>(
      std::less<std::string>(), std::move(tmpVec));
  heap = heap1;

  bool is_empty = heap.empty();
  heap = {};

  heap.emplace("ee");
  heap.pop();

  int size = heap.size();

  std::string element = heap.top();
}
