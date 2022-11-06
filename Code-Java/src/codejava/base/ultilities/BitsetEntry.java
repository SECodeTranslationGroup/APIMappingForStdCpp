package codejava.base.ultilities;

import java.util.BitSet;

public class BitsetEntry {
  public static void BitsetProgram() {
    //initialize empty bitset
    BitSet bitset1 = new BitSet(64);
    //initialize bitset from value
    BitSet bitset2 = BitSet.valueOf(new long[]{283492});
    //size of bitset
    int size = bitset1.size();
    //add, add not, or, xor
    bitset1.and(bitset2);
    bitset1.andNot(bitset2);
    bitset1.or(bitset2);
    bitset1.xor(bitset2);
    //count 1 bits in bistset
    int countTrue = bitset1.cardinality();
    //copy bitset
    bitset1 = (BitSet) bitset2.clone();
    //whether bitset equal
    boolean equals = bitset1.equals(bitset2);
    //set a bit to 0, to 1 or flip
    bitset1.clear(3);
    bitset1.set(3);
    bitset1.flip(3);
    //set a range of bits to 0, to 1 or flip
    bitset1.clear(3, 19);
    bitset1.set(3, 19);
    bitset1.flip(3, 19);
    //set all bits to 0, to 1 or flip
    bitset1.clear();
    bitset1.set(0, bitset1.size() - 1);
    bitset1.flip(0, bitset1.size() - 1);
    //get a bit value
    boolean value = bitset1.get(3);
    //whether bitset all 0
    boolean empty = bitset1.isEmpty();
    //whether bitset any 1
    boolean any = bitset1.cardinality() > 0;
    //whether bitset all 1
    boolean all = bitset1.cardinality() == bitset1.size();
    //right shift
    BitSet tmp = new BitSet(bitset1.size());
    bitset1.stream().map(bitPos -> bitPos - 7).dropWhile(bitPos -> bitPos < 0)
        .forEach(tmp::set);
    bitset1 = tmp;
    //left shift
    BitSet tmp2 = new BitSet(bitset1.size());
    bitset1.stream().map(bitPos -> bitPos + 7).dropWhile(bitPos -> bitPos >= tmp2.size())
        .forEach(tmp2::set);
    bitset1 = tmp2;
  }
}
