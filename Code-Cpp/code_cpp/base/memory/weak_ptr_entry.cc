#include "weak_ptr_entry.h"
#include "../misc/example_object.h"

void WeakPtrEntry::WeakPtrProgram() {
  std::shared_ptr<ExampleObject> strong = std::make_shared<ExampleObject>();
  std::weak_ptr<ExampleObject> weak = std::weak_ptr<ExampleObject>(strong);
  ExampleObject obj = *weak.lock();
  int objValue = weak.lock()->GetVal();
  weak.reset();
  bool expired = weak.expired();
}

bool WeakPtrEntry::Test1() {
  bool ret = true;
  auto strong = std::make_shared<ExampleObject>();
  auto weak = std::weak_ptr<ExampleObject>(strong);
  ret = ret && !weak.expired();
  weak.reset();
  ret = ret && weak.expired();
  return ret;
}

bool WeakPtrEntry::Test2() {
  bool ret = true;
  auto strong = std::make_shared<ExampleObject>();
  auto weak = std::weak_ptr<ExampleObject>(strong);
  ret = ret && !weak.expired();
  strong = nullptr;
  ret = ret && weak.expired();
  return ret;
}

bool WeakPtrEntry::Test3() {
  bool ret = true;
  auto strong = std::make_shared<ExampleObject>();
  strong->SetVal(10);
  auto weak = std::weak_ptr<ExampleObject>(strong);
  ExampleObject example_object = *weak.lock();
  ret = ret && (example_object.GetVal() == 10);
  return ret;
}

bool WeakPtrEntry::Test4() {
  bool ret = true;
  auto strong = std::make_shared<ExampleObject>();
  auto weak = std::weak_ptr<ExampleObject>(strong);
  weak.lock()->SetVal(10);
  ret = ret && (strong->GetVal() == 10);
  return ret;
}

bool WeakPtrEntry::Test5() {
  bool ret = true;
  auto strong = std::make_shared<int>(1);
  auto weak = std::weak_ptr<int>(strong);
  ret = ret && (*weak.lock() == 1);
  return ret;
}

bool WeakPtrEntry::TestAll() {
  bool test = Test1() && Test2() && Test3() && Test4() && Test5();
  if (!test)
    std::cout << "WeakPtr Test Failed!";
  return test;
}
