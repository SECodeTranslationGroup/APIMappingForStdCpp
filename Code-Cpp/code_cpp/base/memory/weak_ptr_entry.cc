#include "weak_ptr_entry.h"
#include "../misc/example_object.h"

void WeakPtrEntry::WeakPtrProgram() {
  //initialize strong ref
  std::shared_ptr<ExampleObject> strong = std::make_shared<ExampleObject>();
  //initialize weak ref
  std::weak_ptr<ExampleObject> weak = std::weak_ptr<ExampleObject>(strong);
  //get value from weak ref
  ExampleObject obj = *weak.lock();
  //call method from weak ref
  int objValue = weak.lock()->GetVal();
  //reset weak ref
  weak.reset();
  //whether weak ref contains value
  bool expired = weak.expired();
}

bool WeakPtrEntry::TestAll() {
  using namespace std;
  bool ret = true;
  auto strong = make_shared<ExampleObject>();
  auto weak = weak_ptr<ExampleObject>(strong);

  strong->SetVal(10);
  ExampleObject example_object = *weak.lock();
  ret = ret && (example_object.GetVal() == 10);

  weak.lock()->SetVal(10);
  ret = ret && (strong->GetVal() == 10);

  ret = ret && !weak.expired();
  weak.reset();
  ret = ret && weak.expired();

  weak = weak_ptr<ExampleObject>(strong);
  ret = ret && !weak.expired();
  strong = nullptr;
  ret = ret && weak.expired();

  auto strongInt = make_shared<int>(1);
  auto weakInt = weak_ptr<int>(strongInt);
  ret = ret && (*weakInt.lock() == 1);
  if (!ret)
    cout << "Weakptr Test Failed!";
  return ret;
}
