#include "optional_entry.h"
#include "../misc/example_object.h"

#include <map>

void OptionalEntry::OptionalProgram() {
  int non_ref = 1;
  std::optional<int> opt = std::make_optional(non_ref);
  bool b1 = opt.has_value(); // (boo1)opt;
  opt = std::nullopt; // opt.reset();
  int value = opt.value_or(-1);

  std::any any = std::any();
  bool b2 = any.has_value();
  std::string str = "my string";
  auto any2 = std::make_any<std::string>(str);
  std::map<int, std::any> any_map;
  any_map.emplace(1, "string1");
  any_map.emplace(2, 3.14);
  any_map.emplace(3, 500);
  bool b3 = std::any_cast<double>(&any_map[2]);
  std::optional<double> any_value = b3 ?
      std::make_optional(std::any_cast<double>(any_map[2])) : std::nullopt;
}
