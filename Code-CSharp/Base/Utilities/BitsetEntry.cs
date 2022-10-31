using System.Collections;

namespace CodeCsharp.Base.Utilities;

public class BitsetEntry {
  public static void BitsetProgram() {
    BitArray bitset1 = new BitArray(64);
    BitArray bitset2 = new BitArray(BitConverter.GetBytes(283492L));
    int size = bitset1.Count;
    bitset1.And(bitset2);
    bitset1.And(bitset2.Not());
    bitset1.Or(bitset2);
    bitset1.Xor(bitset2);
    int countTrue = bitset1.Cast<bool>().Count(b => b);

    bitset1 = (BitArray)bitset2.Clone();
    bool equals = bitset1.Equals(bitset2);

    bitset1.Set(3, false);
    for (int i = 3; i < 19; i++) {
      bitset1.Set(i, false);
    }

    bitset1.Set(3, true);
    for (int i = 3; i < 19; i++) {
      bitset1.Set(i, true);
    }

    bitset1.SetAll(false);
    bitset1.SetAll(true);

    bitset1.Set(3, !bitset1[3]);
    for (int i = 3; i < 19; i++) {
      bitset1.Set(i, !bitset1[i]);
    }

    bitset1.Not();

    bool value = bitset1[3];
    BitArray subset = new BitArray(bitset1.Cast<bool>().Skip(10).Take(16).ToArray());

    bool empty = bitset1.Cast<bool>().All(b => !b);
    bool any = bitset1.Cast<bool>().Any(b => b);
    bool all = bitset1.Cast<bool>().All(b => b);

    bitset1.RightShift(7);
    bitset1.LeftShift(7);
  }
}