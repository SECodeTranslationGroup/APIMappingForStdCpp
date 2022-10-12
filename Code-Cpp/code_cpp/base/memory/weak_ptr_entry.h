#ifndef CODE_CPP_CODE_CPP_BASE_MEMORY_WEAK_PTR_ENTRY_H_
#define CODE_CPP_CODE_CPP_BASE_MEMORY_WEAK_PTR_ENTRY_H_

#include <string>
#include <memory>

class WeakPtrEntry {
 private:
  static std::weak_ptr<std::string> weak_;
  static std::shared_ptr<std::string> strong_;

 public:
  static void WeakPtrProgram();
};

#endif //CODE_CPP_CODE_CPP_BASE_MEMORY_WEAK_PTR_ENTRY_H_
