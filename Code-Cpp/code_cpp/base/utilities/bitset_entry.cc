#include "bitset_entry.h"
void BitsetEntry::BitsetProgram() {
  std::bitset<64> bitset1;
  std::bitset<64> bitset2(283492);
  int size = bitset1.size();
  bitset1 &= bitset2;
  bitset1 &= ~bitset2;
  bitset1 |= bitset2;
  bitset1 ^= bitset2;
  int count_true = bitset1.count();

  bitset1 = bitset2;
  bool equals = bitset1 == bitset2;

  bitset1.reset(3);
  for(int i=3;i<19;i++){bitset1.reset(i);}
  bitset1.set(3);
  for(int i=3;i<19;i++){bitset1.set(i);}

  bitset1.reset();
  bitset1.set();

  bitset1.flip(3);
  for(int i=3;i<19;i++){bitset1.flip(i);}
  bitset1.flip();

  bool value = bitset1[3];
  std::bitset<16> subset(bitset2.to_string().substr(10,16));

  bool empty = bitset1.none();
  bool any = bitset1.any();
  bool all = bitset1.all();

  bitset1 >>= 7;
  bitset1 <<= 7;
}
