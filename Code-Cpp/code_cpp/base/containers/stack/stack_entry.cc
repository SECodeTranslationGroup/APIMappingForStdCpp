#include "stack_entry.h"
#include <string>
#include <deque>

void StackEntry::StackProgram() {
  std::stack<std::string> stack;
  std::deque<std::string> tmpDeque{"aa", "bb", "cc", "dd"};
  std::stack<std::string> stack1 = std::stack<std::string>(std::move(tmpDeque));
  stack = stack1;

  bool is_empty = stack.empty();

  stack.emplace("ee");
  stack.pop();

  int size = stack.size();

  bool b1 = stack == stack1;

  std::string element = stack.top();
}
