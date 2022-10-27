#include <iostream>
#include <cwctype>

#include <vector>
#include <map>

#include <string>

#include "code_cpp/base/global_entry.h"
#include "code_cpp/base/misc/example_object.h"

int main() {
  GlobalEntry::TestAllEntry();
  std::map<int,std::string> m;

  std::vector<int> v;

  std::vector<ExampleObject> v2,v3;

  v.insert(v.begin(),1);
  v.emplace(v.begin(),1);

  m.insert(std::make_pair(1,"1111"));
  m.emplace(1,"1111");
}
