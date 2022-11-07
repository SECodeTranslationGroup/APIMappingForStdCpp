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

  public static BitSet stringToBs(String s) {
    int len = s.length();
    BitSet bs = new BitSet(len);
    for (int i = 0; i < len; i++) {
      if (s.charAt(i) == '0')
        bs.clear(len - 1 - i);
      else
        bs.set(len - 1 - i);
    }
    return bs;
  }

  public static boolean less8BitsEqual(BitSet a, BitSet b) {
    for (int i = 0; i < 8; i++)
      if (a.get(i) != b.get(i))
        return false;
    return true;
  }

  public static boolean testAll() {
    boolean ret = true;
    BitSet bs = stringToBs("11001001");
    BitSet final_bs = stringToBs("11110000");
    BitSet bs1, bs2, bs3, bs4, bs5, bs6, bs7, bs8, bs9, bs10;
    BitSet bs11, bs12, bs13, bs14, bs15;
    bs1 = (BitSet) bs.clone();
    bs1.and(final_bs);
    bs2 = (BitSet) bs.clone();
    bs2.andNot(final_bs);
    bs3 = (BitSet) bs.clone();
    bs3.or(final_bs);
    bs4 = (BitSet) bs.clone();
    bs4.xor(final_bs);
    bs5 = (BitSet) bs.clone();
    bs5.clear(6);
    bs6 = (BitSet) bs.clone();
    bs6.set(5);
    bs7 = (BitSet) bs.clone();
    bs7.flip(5);
    bs8 = (BitSet) bs.clone();
    bs8.clear(1, 5);
    bs9 = (BitSet) bs.clone();
    bs9.set(1, 5);
    bs10 = (BitSet) bs.clone();
    bs10.flip(1, 5);
    bs11 = (BitSet) bs.clone();
    bs11.clear();
    bs12 = (BitSet) bs.clone();
    bs12.set(0, bs12.size());
    bs13 = (BitSet) bs.clone();
    bs13.flip(0, bs13.size());
    bs14 = (BitSet) bs.clone();
    BitSet tmp = new BitSet(bs14.size());
    bs14.stream().map(bitPos -> bitPos - 2).dropWhile(bitPos -> bitPos < 0)
        .forEach(tmp::set);
    bs14 = (BitSet) tmp.clone();
    bs15 = (BitSet) bs.clone();
    tmp = new BitSet(bs15.size());
    bs15.stream().map(bitPos -> bitPos + 2).dropWhile(bitPos -> bitPos > bs.size())
        .forEach(tmp::set);
    bs15 = (BitSet) tmp.clone();

    ret = !bs.get(1)
        && !bs.isEmpty()
        && bs11.isEmpty()
        && bs.cardinality() > 0
        && bs11.cardinality() == 0
        && bs.cardinality() != bs.size()
        && bs12.cardinality() == bs12.size()
        && bs.length() == 8
        && bs.cardinality() == 4
        && less8BitsEqual(bs1, stringToBs("11000000"))
        && less8BitsEqual(bs2, stringToBs("00001001"))
        && less8BitsEqual(bs3, stringToBs("11111001"))
        && less8BitsEqual(bs4, stringToBs("00111001"))
        && less8BitsEqual(bs5, stringToBs("10001001"))
        && less8BitsEqual(bs6, stringToBs("11101001"))
        && less8BitsEqual(bs7, stringToBs("11101001"))
        && less8BitsEqual(bs8, stringToBs("11000001"))
        && less8BitsEqual(bs9, stringToBs("11011111"))
        && less8BitsEqual(bs10, stringToBs("11010111"))
        && less8BitsEqual(bs11, stringToBs("00000000"))
        && less8BitsEqual(bs12, stringToBs("11111111"))
        && less8BitsEqual(bs13, stringToBs("00110110"))
        && less8BitsEqual(bs14, stringToBs("00110010"))
        && less8BitsEqual(bs15, stringToBs("00100100"));
    ;
    if (!ret)
      System.out.print("Bitset Test Failed!");
    return ret;
  }
}
