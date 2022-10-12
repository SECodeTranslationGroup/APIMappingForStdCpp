#include <iostream>
#include "weak_ptr_entry.h"

std::weak_ptr<std::string> WeakPtrEntry::weak_;
std::shared_ptr<std::string> WeakPtrEntry::strong_;

void WeakPtrEntry::WeakPtrProgram() {
  strong_ = std::make_shared<std::string>("Example");
  weak_ = std::weak_ptr<std::string>(strong_);
  std::cout << ((weak_.lock() == nullptr) ? "null" : *weak_.lock()) << std::endl;
  std::cout << (weak_.expired() ? "expired" : "not expired") << std::endl;
  weak_.reset();
  std::cout << ((weak_.lock() == nullptr) ? "null" : *weak_.lock()) << std::endl;
  std::cout << (weak_.expired() ? "expired" : "not expired") << std::endl;
}
