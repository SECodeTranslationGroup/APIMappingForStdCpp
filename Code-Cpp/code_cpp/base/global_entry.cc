#include <iostream>
#include "global_entry.h"
#include "memory/weak_ptr_entry.h"
#include "cctype/cctype_entry.h"
#include "algorithm/algorithm_entry.h"
#include "chrono/chrono_entry.h"
#include "cmath/cmath_entry.h"
#include "containers/list/list_entry.h"
#include "containers/map/map_entry.h"
#include "containers/priority_queue/priority_queue_entry.h"
#include "containers/queue/queue_entry.h"
#include "containers/set/set_entry.h"
#include "containers/stack/stack_entry.h"
#include "containers/unordered_map/unordered_map_entry.h"
#include "containers/unordered_set/unordered_set_entry.h"
#include "containers/vector/vector_entry.h"
#include "fstream/fstream_entry.h"
#include "random/random_entry.h"
#include "regex/regex_entry.h"
#include "string/string_entry.h"
#include "string/string_view_entry.h"
#include "utilities/bitset_entry.h"
#include "utilities/optional_entry.h"

void GlobalEntry::HelloWorldEntry() {
  std::cout << "Hello, World!" << std::endl;
}
void GlobalEntry::TestAllEntry() {
  bool test = true;
  test = test && AlgorithmEntry::TestAll();
  test = test && CctypeEntry::TestAll();
  test = test && ChronoEntry::TestAll();
  test = test && CmathEntry::TestAll();
  test = test && ListEntry::TestAll();
  test = test && MapEntry::TestAll();
  test = test && PriorityQueueEntry::TestAll();
  test = test && QueueEntry::TestAll();
  test = test && SetEntry::TestAll();
  test = test && StackEntry::TestAll();
  test = test && UnorderedMapEntry::TestAll();
  test = test && UnorderedSetEntry::TestAll();
  test = test && VectorEntry::TestAll();
  test = test && FstreamEntry::TestAll();
  test = test && WeakPtrEntry::TestAll();
  test = test && RandomEntry::TestAll();
  test = test && RegexEntry::TestAll();
  test = test && StringEntry::TestAll();
  test = test && StringViewEntry::TestAll();
  test = test && BitsetEntry::TestAll();
  test = test && OptionalEntry::TestAll();
  if(test)
    std::cout << "Pass!" << std::endl;
  else
    std::cout << "Failed!" << std::endl;
}
