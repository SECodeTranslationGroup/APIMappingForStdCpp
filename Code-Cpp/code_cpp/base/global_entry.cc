#include <iostream>
#include "global_entry.h"
#include "memory/weak_ptr_entry.h"
#include "cctype/ctype_entry.h"

void GlobalEntry::HelloWorldEntry() {
  std::cout << "Hello, World!" << std::endl;
}
void GlobalEntry::TestAllEntry() {
  bool test = true;
  test = test && WeakPtrEntry::TestAll();
  test = test && CtypeEntry::TestAll();
  if(test)
    std::cout << "Pass!" << std::endl;
  else
    std::cout << "Failed!" << std::endl;
}
