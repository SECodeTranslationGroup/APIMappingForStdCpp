#include "string_entry.h"
#include <iostream>
void StringEntry::StringProgram() {
  //initialize string with const literal
  std::string str = "123456789";
  //initialize empty string
  std::string my_string = std::string();
  //initialize with repeat chars
  std::string s1 = std::string(3, 'c');
  //initialize with substring
  std::string s2 = std::string(str, 2, 5);
  //is string empty
  bool b1 = my_string.empty();
  //copy string
  my_string = str;
  //length of string
  int size = my_string.length();
  //get char by index of string
  char c1 = my_string[1];
  //get char array
  char* data = my_string.data();
  //get first char
  char cf = my_string.front();
  //get last char
  char cb = my_string.back();
  //get a sub string
  std::string sub = my_string.substr(1,2);
  //whether string starts with a char or another string
  bool b2 = my_string.starts_with('c');
  bool b3 = my_string.starts_with(str);
  //whether string ends with a char or another string
  bool b4 = my_string.ends_with('c');
  bool b5 = my_string.ends_with(str);
  //whether string contains a char or another string
  bool b6 = my_string.contains('c');
  bool b7 = my_string.contains(str);
  //compare with another string
  int result = my_string.compare(str);
  //find first occurence of a char or a substring
  int i1 = my_string.find('c');
  int i2 = my_string.find(str);
  //find first occurence of a char or a substring from index
  int i3 = my_string.find('c',1);
  int i4 = my_string.find(str, 1);
  //find last occurence of a char or a substring
  int i5 = my_string.rfind('c');
  int i6 = my_string.rfind(str);
  //find last occurence of a char or a substring from index
  int i7 = my_string.rfind('c',1);
  int i8 = my_string.rfind(str, 1);
  //convert from integer to string
  my_string = std::to_string(12345);
  //convert from string to integer or long
  int int_value = stoi(my_string);
  long long_value = stol(my_string);
  //convert from float to string
  my_string = std::to_string(3.1415);
  //convert from string to float or double
  float float_value = stof(my_string);
  double double_value = stod(my_string);
  //initialize an empty string buffer
  std::string empty_buf;
  //initialize a string buffer from a string
  std::string buf(str);
  //clear string buffer
  buf.clear();
  //resize string buffer
  buf.resize(10);
  //resize string buffer and fill with char
  buf.resize(10,'c');
  //reserve capacity
  buf.reserve(100);
  //capacity of string buffer
  int capacity = buf.capacity();
  //trim string buffer to size
  buf.shrink_to_fit();
  //append string to buffer
  buf.append(str); //buf += str;
  //append substring to buffer
  buf.append(str, 1, 4);
  //append repeated char to buffer
  buf.append('c',10);
  //append one char to buffer
  str.push_back('c');
  //delete last char
  buf.pop_back();
  //delete a range of chars
  buf.erase(3,5);
  //replace a range of chars with string
  buf.replace(1, 3, str);
  //replace a range of chars with repeat chars
  buf.replace(1,3,3,'c');
  //insert string at a position
  buf.insert(1, str);
  //insert repeat chars at a position
  buf.insert(1,3,'c');
  //insert sub string at a position
  buf.insert(1, str, 1, 1);
  //string concat another string
  std::string add_string = str + s1;
  //string concat char
  std::string add_string2 = str + 'c';
  //string concat other type of values
  std::string add_string3 = str + std::to_string(1);

}
bool StringEntry::TestAll() {
  bool ret = true;
  if (!ret)
    std::cout << "String Test Failed!";
  return ret;
}
