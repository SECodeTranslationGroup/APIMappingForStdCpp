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
  in_file.get(cb,6);
  //create string from buffer
  str = std::string(cb,6);
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
  binary_out_file.write(str.data(),str.size());
  //write int data in binary
  int int_num = 10;
  binary_out_file.write(reinterpret_cast<const char *>(&int_num),sizeof(int_num));
  //write double data in binary
  double double_num = 3.14;
  binary_out_file.write(reinterpret_cast<const char *>(&double_num),sizeof(double_num));
  //close
  binary_out_file.close();
  //open binary input file stream
  std::ifstream binary_in_file("binaryfile.txt", std::ios::in | std::ios::binary);
  //read string data in binary
  binary_in_file.read(str.data(),str.size());
  //read int data in binary
  binary_in_file.read(reinterpret_cast<char *>(&int_num), sizeof(int_num));
  //read double data in binary
  binary_in_file.read(reinterpret_cast<char *>(&double_num), sizeof(double_num));
  //get byte length of binary file
  binary_in_file.seekg(0,std::ios::end);
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
  if (!ret)
    std::cout << "Fstream Test Failed!";
  return ret;
}
