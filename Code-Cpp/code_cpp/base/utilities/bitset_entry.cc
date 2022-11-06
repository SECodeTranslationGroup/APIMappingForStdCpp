#include "bitset_entry.h"
#include <iostream>
void BitsetEntry::BitsetProgram() {
  //initialize empty bitset
  std::bitset<64> bitset1;
  //initialize bitset from value
  std::bitset<64> bitset2(283492);
  //size of bitset
  int size = bitset1.size();
  //add, add not, or, xor
  bitset1 &= bitset2;
  bitset1 &= ~bitset2;
  bitset1 |= bitset2;
  bitset1 ^= bitset2;
  //count 1 bits in bistset
  int count_true = bitset1.count();
  //copy bitset
  bitset1 = bitset2;
  //whether bitset equal
  bool equals = bitset1 == bitset2;
  //set a bit to 0, to 1 or flip
  bitset1.reset(3);
  bitset1.set(3);
  bitset1.flip(3);
  //set a range of bits to 0, to 1 or flip
  for (int i = 3; i < 19; i++) bitset1.reset(i);
  for (int i = 3; i < 19; i++) bitset1.set(i);
  for (int i = 3; i < 19; i++) { bitset1.flip(i); }
  //set all bits to 0, to 1 or flip
  bitset1.reset();
  bitset1.set();
  bitset1.flip();
  //get bit value
  bool value = bitset1[3];
  //get a sub bitset
  std::bitset<16> subset(bitset2.to_string().substr(10, 16));
  //whether bitset all 0
  bool empty = bitset1.none();
  //whether bitset any 1
  bool any = bitset1.any();
  //whether bitset all 1
  bool all = bitset1.all();
  //right shift
  bitset1 >>= 7;
  //left shift
  bitset1 <<= 7;
}
bool BitsetEntry::TestAll() {
  bool ret = true;
  if (!ret)
    std::cout << "Bitset Test Failed!";
  return ret;
}
