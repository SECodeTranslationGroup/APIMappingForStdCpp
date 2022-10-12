//
// Created by 85339 on 2022/10/12.
//

#include "example_object.h"

ExampleObject::ExampleObject() : val_(0) {}

int ExampleObject::GetValue() const {
  return val_;
}

void ExampleObject::SetValue(int value) {
  ExampleObject::val_ = value;
}

