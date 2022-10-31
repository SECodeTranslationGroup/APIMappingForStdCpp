package codejava.base.ultilities;

import java.util.BitSet;

public class BitsetEntry {
  public static void BitsetProgram() {
    BitSet bitset1 = new BitSet(64);
    BitSet bitset2 = BitSet.valueOf(new long[]{283492});
    int size = bitset1.size();
    bitset1.and(bitset2);
    bitset1.andNot(bitset2);
    bitset1.or(bitset2);
    bitset1.xor(bitset2);
    int countTrue = bitset1.cardinality();

    bitset1 = (BitSet) bitset2.clone();
    boolean equals = bitset1.equals(bitset2);

    bitset1.clear(3);
    bitset1.clear(3, 19);
    bitset1.set(3);
    bitset1.set(3,19);

    bitset1.clear();
    bitset1.set(0, bitset1.size() - 1);

    bitset1.flip(3);
    bitset1.flip(3,19);
    bitset1.flip(0, bitset1.size() - 1);

    boolean value = bitset1.get(3);
    BitSet subset = bitset1.get(10, 10 + 16);

    boolean empty = bitset1.isEmpty();
    boolean any = bitset1.cardinality() > 0;
    boolean all = bitset1.cardinality() == bitset1.size();

    BitSet tmp = new BitSet(bitset1.size());
    bitset1.stream().map(bitPos -> bitPos - 7).dropWhile(bitPos -> bitPos < 0)
        .forEach(tmp::set);
    bitset1 = tmp;

    BitSet tmp2 = new BitSet(bitset1.size());
    bitset1.stream().map(bitPos -> bitPos + 7).dropWhile(bitPos -> bitPos >= tmp2.size())
        .forEach(tmp2::set);
    bitset1 = tmp2;
  }
}
