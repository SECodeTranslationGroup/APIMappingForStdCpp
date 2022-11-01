#include "unordered_map_entry.h"

std::unordered_map<int,ExampleObject> UnorderedMapEntry::hashmap_;
ExampleObject UnorderedMapEntry::obj;

void UnorderedMapEntry::UnorderedMapProgram() {
    hashmap_ = std::unordered_map<int,ExampleObject>();
    obj = ExampleObject();
    bool isEmpty = hashmap_.empty();
    int size = hashmap_.size();
    hashmap_.clear();
    hashmap_.emplace(1,obj);
    bool isContained = hashmap_.contains(1);
    ExampleObject findObj = hashmap_[1];
    hashmap_.erase(1);
}
