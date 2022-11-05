#include "stack_entry.h"
#include <string>
#include <deque>

void StackEntry::StackProgram() {
  //initialize a stack
  std::stack<std::string> stack;
  //initialize a stack with value
  std::deque<std::string> tmpDeque{"aa", "bb", "cc", "dd"};
  std::stack<std::string> stack1 = std::stack<std::string>(std::move(tmpDeque));
  //copy stack
  stack = stack1;
  //whether stack is empty
  bool is_empty = stack.empty();
  //clear stack
  stack = {};
  //insert element at first
  stack.emplace("ee");
  //remove first element
  stack.pop();
  //get size of stack
  int size = stack.size();
  //whether two stacks equal
  bool b1 = stack == stack1;
  //get first element
  std::string element = stack.top();
}
