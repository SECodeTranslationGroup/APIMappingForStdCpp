#include "string_entry.h"
void StringEntry::StringProgram() {
  char c = 'C';
  char cs[] = "123456789";
  std::string s = "123456789";
  std::string my_string = std::string();
  std::string s1 = std::string(cs);
  std::string s2 = std::string(3, c);
  std::string s3 = std::string(s,2,5);
  std::string s4 = std::string(cs, 5);
  std::string s5 = s; // s6 = std::string(s);

  bool b1 = my_string.empty();
  my_string = cs;
  int size = my_string.length();
  char c1 = my_string[1];
  char* data = my_string.data();
  char cf = my_string.front();
  char cb = my_string.back();

  std::string& ref = my_string;
  std::string sub = my_string.substr(1,2);
  bool b2 = my_string.starts_with(c);
  bool b3 = my_string.starts_with(cs);
  bool b4 = my_string.starts_with(s);
  bool b5 = my_string.ends_with(c);
  bool b6 = my_string.ends_with(cs);
  bool b7 = my_string.ends_with(s);
  bool b8 = my_string.contains(c);
  bool b9 = my_string.contains(cs);
  bool b10 = my_string.contains(s);

  int result = my_string.compare(s);

  int index1 = my_string.find(s,0);
  int index2 = my_string.find(cs);
  int index3 = my_string.find(c,1);
  int index4 = my_string.find(c);
  int index5 = my_string.rfind(s);
  int index6 = my_string.rfind(cs,2);
  int index7 = my_string.rfind(c,2);
  int index8 = my_string.rfind(c);

  my_string = std::to_string(12345);
  int int_value = stoi(my_string);
  long long_value = stol(my_string);
  my_string = std::to_string(3.1415);
  float float_value = stof(my_string);
  double double_value = stod(my_string);

  std::string empty_buf;
  std::string buf(cs);
  buf.clear();
  buf.resize(10);

  buf.resize(10,c);

  buf.reserve(100);
  int capacity = buf.capacity();
  buf.shrink_to_fit();

  buf.append(cs); //buf += cs;
  buf.append(s); //buf += s;
  buf.append (cs,1,4);
  buf.append(s,1,4);
  buf.append(c,10);

  buf += c; //buf.append(c,1); s.push_back(c);
  buf.pop_back();
  buf.erase(3,5);

  buf.replace(1,3,cs);

  buf.replace(1,3,s);

  buf.replace(1,3,3,c);

  buf.insert(1,cs);
  buf.insert(1,s);
  buf.insert(1,3,c);
  buf.insert(1,s,1,1);

  std::string add_string = s + s1;
  std::string add_string2 = s + c;
  std::string add_string3 = s + std::to_string(1);

}
