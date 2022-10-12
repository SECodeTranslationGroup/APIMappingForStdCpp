#ifndef CODE_CPP_CODE_CPP_BASE_MEMORY_WEAK_PTR_ENTRY_H_
#define CODE_CPP_CODE_CPP_BASE_MEMORY_WEAK_PTR_ENTRY_H_

#include <string>
#include <memory>
#include "../example_object.h"

class WeakPtrEntry {
 private:
  static std::weak_ptr<ExampleObject> weak_;
  static std::shared_ptr<ExampleObject> strong_;

 public:
  static void WeakPtrProgram();
};

#endif //CODE_CPP_CODE_CPP_BASE_MEMORY_WEAK_PTR_ENTRY_H_
