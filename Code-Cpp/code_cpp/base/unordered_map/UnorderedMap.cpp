#include "Unordered_map.h"

std::unordered_map<int,ExampleObject> Unordered_map::hashmap_;
ExampleObject Unordered_map::obj;

void Unordered_map::UnorderedMapProgram() {
    hashmap_ = std::unordered_map<int,ExampleObject>();
    obj = ExampleObject();
    bool isEmpty = hashmap_.empty();
    int size = hashmap_.size();
    hashmap_.clear();
    hashmap_.insert({1,obj});
    bool isContained = hashmap_.contains(1);
    ExampleObject findObj = hashmap_[1];
    hashmap_.erase(1);
}
