#include <iostream>
#include "weak_ptr_entry.h"

std::weak_ptr<ExampleObject> WeakPtrEntry::weak_;
std::shared_ptr<ExampleObject> WeakPtrEntry::strong_;

void WeakPtrEntry::WeakPtrProgram() {
  strong_ = std::make_shared<ExampleObject>();
  weak_ = std::weak_ptr<ExampleObject>(strong_);
  ExampleObject obj = *weak_.lock();
  int objValue = weak_.lock()->GetVal();
  weak_.reset();
  bool expired = weak_.expired();
}
