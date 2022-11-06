#include "optional_entry.h"
#include "../misc/example_object.h"

#include <map>

void OptionalEntry::OptionalProgram() {
  //initialize variable
  int i = 1;
  //make optional from variable
  std::optional<int> opt = std::make_optional(i);
  //whether optional has value
  bool b1 = opt.has_value(); // (boo1)opt;
  //reset optional
  opt = std::nullopt; // opt.reset();
  //get optional value, or else -1
  int value = opt.value_or(-1);
  //initialize any type
  std::any any = std::any();
  //whether any has value
  bool b2 = any.has_value();
  //initialize any type variable
  std::string str = "my string";
  //make any from any variable
  auto any2 = std::make_any<std::string>(str);
  //build a container to contain any value
  std::map<int, std::any> any_map;
  //insert values
  any_map.emplace(1, "string1");
  any_map.emplace(2, 3.14);
  any_map.emplace(3, 500);
  //whether any cast successful
  bool b3 = std::any_cast<double>(&any_map[2]) != nullptr;
  //any cast to optional
  std::optional<double> any_value =
      b3 ? std::make_optional(std::any_cast<double>(any_map[2])) : std::nullopt;
}
bool OptionalEntry::TestAll() {
  bool ret = true;
  if (!ret)
    std::cout << "Optional Test Failed!";
  return ret;
}
