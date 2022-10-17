#include <iostream>
#include <cwctype>

#include "code_cpp/base/global_entry.h"
#include "code_cpp/base/memory/weak_ptr_entry.h"

int main() {
//  GlobalEntry::HelloWorldEntry();
//  WeakPtrEntry::WeakPtrProgram();
  std::cout << ((iscntrl(L'\u2028') != 0) ? "true" : "false");
  return 0;
}
