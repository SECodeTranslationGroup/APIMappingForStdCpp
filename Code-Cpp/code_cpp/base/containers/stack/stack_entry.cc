#include "stack_entry.h"
#include <string>
#include <deque>
#include <vector>

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
bool StackEntry::TestAll() {
  bool ret = true;
  using namespace std;
  stack<int> c, c1, c2, c3, c4;
  c1 = {};
  c = stack<int>({2, 4, 3, 1, 5});
  c2 = c;
  c.emplace(6);
  c3 = c;
  c.pop();
  c4 = c;
  ret = c1.empty()
      && c4.size() == 5
      && c.top() == 5
      && c2 == stack<int>({2, 4, 3, 1, 5})
      && c3 == stack<int>({2, 4, 3, 1, 5, 6})
      && c4 == stack<int>({2, 4, 3, 1, 5});

  if (!ret)
    cout << "Stack Test Failed!"<< endl;
  return ret;
}
