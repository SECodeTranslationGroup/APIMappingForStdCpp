cmake_minimum_required(VERSION 3.23)
project(Code_Cpp)

set(CMAKE_CXX_STANDARD 23)

add_executable(Code_Cpp main.cc code_cpp/base/global_entry.h code_cpp/base/global_entry.cc code_cpp/base/memory/weak_ptr_entry.cc code_cpp/base/memory/weak_ptr_entry.h code_cpp/base/misc/example_object.cc code_cpp/base/misc/example_object.h code_cpp/base/cctype/ctype_entry.cc code_cpp/base/cctype/ctype_entry.h code_cpp/base/string/string_entry.cc code_cpp/base/string/string_entry.h code_cpp/base/string/string_view_entry.cc code_cpp/base/string/string_view_entry.h)
