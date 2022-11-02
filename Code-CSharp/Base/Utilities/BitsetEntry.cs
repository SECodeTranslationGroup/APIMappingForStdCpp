using System.Collections;

namespace CodeCsharp.Base.Utilities;

public class BitsetEntry {
  public static void BitsetProgram() {
    //initialize empty bitset
    BitArray bitset1 = new BitArray(64);
    //initialize bitset from value
    BitArray bitset2 = new BitArray(BitConverter.GetBytes(283492L));
    //size of bitset
    int size = bitset1.Count;
    //add, add not, or, xor
    bitset1.And(bitset2);
    bitset1.And(((BitArray)bitset2.Clone()).Not());
    bitset1.Or(bitset2);
    bitset1.Xor(bitset2);
    //count 1 bits in bistset
    int countTrue = bitset1.Cast<bool>().Count(b => b);
    //copy bitset
    bitset1 = (BitArray)bitset2.Clone();
    //whether bitset equal
    bool equals = bitset1.Equals(bitset2);
    //set a bit to 0, to 1 or flip
    bitset1.Set(3, false);
    bitset1.Set(3, true);
    bitset1.Set(3, !bitset1[3]);
    //set a range of bits to 0, to 1 or flip
    for (int i = 3; i < 19; i++) bitset1.Set(i, false);
    for (int i = 3; i < 19; i++) bitset1.Set(i, true);
    for (int i = 3; i < 19; i++) bitset1.Set(i, !bitset1[i]);
    //set all bits to 0, to 1 or flip
    bitset1.SetAll(false);
    bitset1.SetAll(true);
    bitset1.Not();
    //get bit value
    bool value = bitset1[3];
    //get a sub bitset
    BitArray subset = new BitArray(bitset1.Cast<bool>().Skip(10).Take(16).ToArray());
    //whether bitset all 0
    bool empty = bitset1.Cast<bool>().All(b => !b);
    //whether bitset any 1
    bool any = bitset1.Cast<bool>().Any(b => b);
    //whether bitset all 1
    bool all = bitset1.Cast<bool>().All(b => b);
    //right shift
    bitset1.RightShift(7);
    //left shift
    bitset1.LeftShift(7);
  }
}