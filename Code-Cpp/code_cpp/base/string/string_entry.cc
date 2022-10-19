//
// Created by 85339 on 2022/10/13.
//

#include "string_entry.h"
void StringEntry::StringProgram() {
  char char_array[] = "123456789";
  std::string s = std::string();
  std::string s1 = std::string(char_array);
  std::string s2 = std::string(3, '1');
  std::string s3 = std::string(s1,2,5);
  std::string s4 = std::string(char_array,5);
  std::string s5 = s1; s5 = std::string(s1);

  bool b1 = s.empty();
  s = "ccc";
  int size = s.length();
  char c = s[1];
  char* data = s.data();
  char cf = s.front();
  char cb = s.back();

  std::string& s_ref = s;
  std::string sub = s.substr(1,2);
  bool b2 = s.starts_with('c');
  bool b3 = s.starts_with("cc");
  bool b4 = s.starts_with(sub);
  bool b5 = s.ends_with('c');
  bool b6 = s.ends_with("cc");
  bool b7 = s.ends_with(sub);
  bool b8 = s.contains('c');
  bool b9 = s.contains("cc");
  bool b10 = s.contains(sub);

  int result = s.compare("ccd");

  int index1 = s.find(sub,0);
  int index2 = s.find("cc");
  int index3 = s.find('c',1);
  int index4 = s.find('c');
  int index5 = s.rfind(sub);
  int index6 = s.rfind("cc",2);
  int index7 = s.rfind('c',2);
  int index8 = s.rfind('c');

  s = std::to_string(12345);
  int int_value = stoi(s);
  long long_value = stol(s);
  s = std::to_string(3.1415);
  float float_value = stof(s);
  double double_value = stod(s);

  std::string empty_buf;
  std::string buf("New");
  buf.clear();
  buf.resize(10);

  buf.resize('A',10);

  buf.reserve(100);
  int capacity = buf.capacity();
  buf.shrink_to_fit();

  buf.append(" String "); //buf += " String ";
  buf.append(s); //buf += s;
  buf.append ("  String  ",1,4);
  buf.append(s,0,3);
  buf.append('A',10);

  buf += 'A'; //buf.append('A',1); s.push_back('A');
  s.pop_back();
  s.erase(3,5);

  buf.replace(1,3,"AAA");

  buf.replace(1,3,s);

  buf.replace(1,3,3,'A');

  buf.insert(1,"AAA");
  buf.insert(1,s);
  buf.insert(1,3,'A');
  buf.insert(1,s,1,1);

  std::string add_string = s + s1;
  std::string add_string2 = s + 'C';
  std::string add_string3 = s + std::to_string(1);
}
