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
  using namespace std;
  queue<int> c, c1, c2, c3, c4;
  c1 = {};
  c = queue<int>({2, 4, 3, 1, 5});
  c2 = c;
  c.emplace(6);
  c3 = c;
  c.pop();
  c4 = c;
  ret = c1.empty()
      && c4.size() == 5
      && c.front() == 4
      && c.back() == 6
      && c2 == queue<int>({2, 4, 3, 1, 5})
      && c3 == queue<int>({2, 4, 3, 1, 5, 6})
      && c4 == queue<int>({4, 3, 1, 5, 6});
  if (!ret)
    cout << "Queue Test Failed!"<< endl;
  return ret;
}
