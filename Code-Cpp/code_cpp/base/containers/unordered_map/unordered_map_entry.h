#ifndef CODE_CPP_CODE_CPP_BASE_UNORDERED_MAP_UNORDERED_MAP_ENTRY_H_
#define CODE_CPP_CODE_CPP_BASE_UNORDERED_MAP_UNORDERED_MAP_ENTRY_H_

#include <unordered_map>
#include "../../misc/example_object.h"

class UnorderedMapEntry {
private:
    static std::unordered_map<int,ExampleObject> hashmap_;
    static ExampleObject obj;
public:
    static void UnorderedMapProgram();

};


#endif //CODE_CPP_CODE_CPP_BASE_UNORDERED_MAP_UNORDERED_MAP_ENTRY_H_