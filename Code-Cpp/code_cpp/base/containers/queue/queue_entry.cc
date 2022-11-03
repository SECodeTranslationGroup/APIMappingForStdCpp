#include "queue_entry.h"
#include <string>
#include <deque>

void QueueEntry::QueueProgram() {
  std::queue<std::string> queue;
  std::deque<std::string> tmpDeque{"aa", "bb", "cc", "dd"};
  std::queue<std::string> queue1 = std::queue<std::string>(std::move(tmpDeque));
  queue = queue1;

  bool is_empty = queue.empty();

  queue.emplace("ee");
  queue.pop();

  int size = queue.size();

  bool b1 = queue == queue1;

  std::string element = queue.front();
  element = queue.back();
}
