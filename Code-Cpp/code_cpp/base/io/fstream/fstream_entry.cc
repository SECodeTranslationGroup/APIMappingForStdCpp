#include "fstream_entry.h"
#include <sstream>
void FstreamEntry::FstreamProgram() {
  std::string str = "output";

  std::fstream out_file("file.txt", std::ios::out | std::ios::trunc);
  bool is_open = !out_file;
  out_file.put('c');
  out_file << str;
  out_file.close();

  std::fstream in_file("file.txt", std::ios::in);
  char c1 = in_file.get();
  char c2 = in_file.peek();
  char cb[100];
  in_file.get(cb,str.size());
  str = std::string(cb);
//  std::stringstream buf;
//  buf << in_file.rdbuf();
  in_file.close();

  std::fstream app_file("file.txt", std::ios::out | std::ios::app);
  app_file.put('c');
  app_file.close();

  std::fstream binary_out_file("binaryfile.txt", std::ios::out | std::ios::trunc | std::ios::binary);
  binary_out_file.write(str.data(),str.size());
  int int_num = 10;
  binary_out_file.write(reinterpret_cast<const char *>(&int_num),sizeof(int_num));
  double double_num = 3.14;
  binary_out_file.write(reinterpret_cast<const char *>(&double_num),sizeof(double_num));
  binary_out_file.close();

  std::fstream binary_in_file("binaryfile.txt", std::ios::in | std::ios::binary);
  binary_out_file.read(str.data(),str.size());
  binary_out_file.read(reinterpret_cast<char *>(&int_num), sizeof(int_num));
  binary_out_file.read(reinterpret_cast<char *>(&double_num), sizeof(double_num));
  in_file.seekg(0,std::ios::end);
  long length = in_file.tellg();
  binary_out_file.close();

  std::fstream random_access_file("file.txt", std::ios::in | std::ios::out);
  random_access_file.seekg(3);
  char c3 = random_access_file.get();
  long pos = random_access_file.tellg();
  random_access_file.put('d');
  random_access_file.close();

}
