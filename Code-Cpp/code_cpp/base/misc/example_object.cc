#include "example_object.h"

ExampleObject::ExampleObject() : val_(0) {}

int ExampleObject::GetVal() const {
  return val_;
}

void ExampleObject::SetVal(int value) {
  ExampleObject::val_ = value;
}

