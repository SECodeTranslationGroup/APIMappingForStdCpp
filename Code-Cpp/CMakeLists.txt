cmake_minimum_required(VERSION 3.23)
project(Code_Cpp)

set(CMAKE_CXX_STANDARD 23)

add_executable(Code_Cpp main.cc code_cpp/base/global_entry.h code_cpp/base/global_entry.cc code_cpp/base/memory/weak_ptr_entry.cc code_cpp/base/memory/weak_ptr_entry.h code_cpp/base/example_object.cc code_cpp/base/example_object.h code_cpp/base/arrray/array.h code_cpp/base/arrray/array.cpp code_cpp/base/stack/stack.cpp code_cpp/base/stack/stack.h code_cpp/base/vector/vector.cpp code_cpp/base/vector/vector.h code_cpp/base/list/List.cpp code_cpp/base/list/List.h code_cpp/base/queue/Queue.cpp code_cpp/base/queue/Queue.h code_cpp/base/unordered_map/UnorderedMap.cpp code_cpp/base/unordered_map/UnorderedMap.h code_cpp/base/map/Map.cpp code_cpp/base/map/Map.h code_cpp/base/priority_queue/PriorityQueue.cpp code_cpp/base/priority_queue/PriorityQueue.h code_cpp/base/unordered_set/UnorderedSet.cpp code_cpp/base/unordered_set/UnorderedSet.h code_cpp/base/set/Set.cpp code_cpp/base/set/Set.h)
