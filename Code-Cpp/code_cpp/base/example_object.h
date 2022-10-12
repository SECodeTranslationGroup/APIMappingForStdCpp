#ifndef CODE_CPP_CODE_CPP_BASE_EXAMPLE_OBJECT_H_
#define CODE_CPP_CODE_CPP_BASE_EXAMPLE_OBJECT_H_

#include <string>

class ExampleObject {
 private:
  int val_;
 public:
  ExampleObject();
  int GetVal() const;
  void SetVal(int value);

};

#endif //CODE_CPP_CODE_CPP_BASE_EXAMPLE_OBJECT_H_
