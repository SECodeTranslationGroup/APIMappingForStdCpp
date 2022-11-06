#include "queue_entry.h"
#include <string>
#include <deque>

void QueueEntry::QueueProgram() {
  //initialize a queue
  std::queue<std::string> queue;
  //initialize a queue with value
  std::deque<std::string> tmpDeque{"aa", "bb", "cc", "dd"};
  std::queue<std::string> queue1 = std::queue<std::string>(std::move(tmpDeque));
  //copy queue
  queue = queue1;
  //whether queue is empty
  bool is_empty = queue.empty();
  //clear queue
  queue = {};
  //insert element at last
  queue.emplace("ee");
  //remove first element
  queue.pop();
  //get size of queue
  int size = queue.size();
  //whether two queues equal
  bool b1 = queue == queue1;
  //get first element
  std::string element = queue.front();
  //get last element
  element = queue.back();
}
bool QueueEntry::TestAll() {
  bool ret = true;
  if (!ret)
    std::cout << "Queue Test Failed!";
  return ret;
}
