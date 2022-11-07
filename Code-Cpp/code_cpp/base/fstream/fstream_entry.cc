#include "fstream_entry.h"
#include <iostream>
void FstreamEntry::FstreamProgram() {
  //initialize string
  std::string str = "output";
  //create file
  //open output file stream
  std::ofstream out_file("file.txt", std::ios::out | std::ios::trunc);
  //whether open operation succeeds
  bool is_open = !out_file;
  //write a char
  out_file.put('c');
  //write a string with line seperator
  out_file << str << std::endl;
  //close
  out_file.close();
  //open input file stream
  std::ifstream in_file("file.txt", std::ios::in);
  //get first char
  char c1 = in_file.get();
  //peek next char
  char c2 = in_file.peek();
  //intialize a buffer
  char cb[100];
  //read several char into buffer
  in_file.get(cb, 6 + 1);
  //create string from buffer
  str = std::string(cb, 6 + 1);
  //close
  in_file.close();
  //open append file stream
  std::ofstream app_file("file.txt", std::ios::out | std::ios::app);
  //append a char
  app_file.put('c');
  //close
  app_file.close();
  //open binary output file stream
  std::ofstream binary_out_file("binaryfile.txt", std::ios::out | std::ios::trunc | std::ios::binary);
  //write string data in binary
  binary_out_file.write(str.data(), str.size());
  //write int data in binary
  int int_num = 10;
  binary_out_file.write(reinterpret_cast<const char *>(&int_num), sizeof(int_num));
  //write double data in binary
  double double_num = 3.14;
  binary_out_file.write(reinterpret_cast<const char *>(&double_num), sizeof(double_num));
  //close
  binary_out_file.close();
  //open binary input file stream
  std::ifstream binary_in_file("binaryfile.txt", std::ios::in | std::ios::binary);
  //read string data in binary
  binary_in_file.read(str.data(), str.size());
  //read int data in binary
  binary_in_file.read(reinterpret_cast<char *>(&int_num), sizeof(int_num));
  //read double data in binary
  binary_in_file.read(reinterpret_cast<char *>(&double_num), sizeof(double_num));
  //get byte length of binary file
  binary_in_file.seekg(0, std::ios::end);
  long length = binary_in_file.tellg();
  //close
  binary_in_file.close();
  //open random access file stream
  std::fstream random_access_file("file.txt", std::ios::in | std::ios::out);
  //set position
  random_access_file.seekg(3);
  //get a char from position
  char c3 = random_access_file.get();
  //get position
  long pos = random_access_file.tellg();
  //write a char from position
  random_access_file.put('d');
  //close
  random_access_file.close();
}
bool FstreamEntry::TestAll() {
  bool ret = true;
  using namespace std;
  string str = "output";
  ofstream out_file("test.txt", ios::out | ios::trunc);
  ret = out_file.is_open();
  out_file.put('c');
  out_file << str << endl;
  out_file.close();
  ofstream app_file("test.txt", ios::out | ios::app);
  app_file.put('d');
  app_file.close();
  ifstream in_file("test.txt", ios::in);
  ret = ret && in_file.get() == 'c';
  ret = ret && in_file.peek() == 'o';
  char cb[100];
  in_file.get(cb, 6 + 1);
  string str2 = string(cb, 6 + 1);
  ret = ret && str == str2.substr(0, 6);
  ret = ret && in_file.get() == '\n';
  ret = ret && in_file.get() == 'd';
  in_file.close();

  std::ofstream binary_out_file("binary-test.txt", std::ios::out | std::ios::trunc | std::ios::binary);
  binary_out_file.write(str.data(), str.size());
  int int_num = 10;
  binary_out_file.write(reinterpret_cast<const char *>(&int_num), sizeof(int_num));
  double double_num = 3.14;
  binary_out_file.write(reinterpret_cast<const char *>(&double_num), sizeof(double_num));
  binary_out_file.close();
  std::ifstream binary_in_file("binary-test.txt", std::ios::in | std::ios::binary);
  binary_in_file.read(str2.data(), str.size());
  ret = ret && str == str2.substr(0, 6);
  binary_in_file.read(reinterpret_cast<char *>(&int_num), sizeof(int_num));
  ret = ret && int_num == 10;
  binary_in_file.read(reinterpret_cast<char *>(&double_num), sizeof(double_num));
  ret = ret && double_num == 3.14;
  binary_in_file.seekg(0, std::ios::end);
  long length = binary_in_file.tellg();
  ret = ret && length == 18;
  binary_in_file.close();

  std::fstream random_access_file("test.txt", std::ios::in | std::ios::out);
  random_access_file.seekg(3);
  ret = ret && random_access_file.get()=='t';
  ret = ret && random_access_file.tellg() == 4;
  random_access_file.seekg(4);
  random_access_file.put('e');
  random_access_file.seekg(4);
  ret = ret && random_access_file.get()=='e';
  random_access_file.close();

  if (!ret)
    cout << "Fstream Test Failed!";
  return ret;
}
