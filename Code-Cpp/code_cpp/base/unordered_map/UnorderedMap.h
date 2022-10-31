#ifndef CODE_CPP_UNORDERED_MAP_H
#define CODE_CPP_UNORDERED_MAP_H

#include <unordered_map>
#include "../example_object.h"

class Unordered_map {
private:
    static std::unordered_map<int,ExampleObject> hashmap_;
    static ExampleObject obj;
public:
    static void UnorderedMapProgram();

};


#endif //CODE_CPP_UNORDERED_MAP_H
