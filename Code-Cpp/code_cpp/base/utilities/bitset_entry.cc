#include "bitset_entry.h"
#include <iostream>
#include <vector>

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
  //get a bit value
  bool value = bitset1[3];
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
  using namespace std;
  bitset<8> bs("11001001"), final_bs("11110000");
  bitset<8> bs1, bs2, bs3, bs4, bs5, bs6, bs7, bs8, bs9, bs10;
  bitset<8> bs11, bs12, bs13, bs14, bs15;
  bs1 = bs;
  bs1 &= final_bs;
  bs2 = bs;
  bs2 &= ~final_bs;
  bs3 = bs;
  bs3 |= final_bs;
  bs4 = bs;
  bs4 ^= final_bs;
  bs5 = bs;
  bs5.reset(6);
  bs6 = bs;
  bs6.set(5);
  bs7 = bs;
  bs7.flip(5);
  bs8 = bs;
  for (int i = 1; i < 5; i++) bs8.reset(i);
  bs9 = bs;
  for (int i = 1; i < 5; i++) bs9.set(i);
  bs10 = bs;
  for (int i = 1; i < 5; i++) bs10.flip(i);
  bs11 = bs;
  bs11.reset();
  bs12 = bs;
  bs12.set();
  bs13 = bs;
  bs13.flip();
  bs14 = bs;
  bs14 >>= 2;
  bs15 = bs;
  bs15 <<= 2;

  ret = !bs[1]
      && !bs.none()
      && bs11.none()
      && bs.any()
      && !bs11.any()
      && !bs.all()
      && bs12.all()
      && bs.size() == 8
      && bs.count() == 4
      && bs1 == bitset<8>{"11000000"}
      && bs2 == bitset<8>{"00001001"}
      && bs3 == bitset<8>{"11111001"}
      && bs4 == bitset<8>{"00111001"}
      && bs5 == bitset<8>{"10001001"}
      && bs6 == bitset<8>{"11101001"}
      && bs7 == bitset<8>{"11101001"}
      && bs8 == bitset<8>{"11000001"}
      && bs9 == bitset<8>{"11011111"}
      && bs10 == bitset<8>{"11010111"}
      && bs11 == bitset<8>{"00000000"}
      && bs12 == bitset<8>{"11111111"}
      && bs13 == bitset<8>{"00110110"}
      && bs14 == bitset<8>{"00110010"}
      && bs15 == bitset<8>{"00100100"};

  if (!ret)
    std::cout << "Bitset Test Failed!";
  return ret;
}
