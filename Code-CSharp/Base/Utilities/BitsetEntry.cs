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
    bool equals = new BitArray(bitset1).Xor(bitset2).Cast<bool>().Count(b => b) == 0;
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
    //get a bit value
    bool value = bitset1[3];
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

  public static BitArray StringToBs(string s) {
    int len = s.Length;
    BitArray bs = new BitArray(len);
    for (int i = 0; i < len; i++) {
      if (s[i] == '0')
        bs.Set(len - 1 - i, false);
      else
        bs.Set(len - 1 - i, true);
    }

    return bs;
  }

  public static bool TestAll() {
    bool ret = true;
    BitArray bs = StringToBs("11001001");
    BitArray final_bs = StringToBs("11110000");
    BitArray bs1, bs2, bs3, bs4, bs5, bs6, bs7, bs8, bs9, bs10;
    BitArray bs11, bs12, bs13, bs14, bs15, tmpBs;
    bs1 = new BitArray(bs);
    bs1.And(final_bs);
    bs2 = new BitArray(bs);
    tmpBs = new BitArray(final_bs).Not();
    bs2.And(tmpBs);
    bs3 = new BitArray(bs);
    bs3.Or(final_bs);
    bs4 = new BitArray(bs);
    bs4.Xor(final_bs);
    bs5 = new BitArray(bs);
    bs5.Set(6, false);
    bs6 = new BitArray(bs);
    bs6.Set(5, true);
    bs7 = new BitArray(bs);
    bs7.Set(5, !bs7[5]);
    bs8 = new BitArray(bs);
    for (int i = 1; i < 5; i++) bs8.Set(i, false);
    bs9 = new BitArray(bs);
    for (int i = 1; i < 5; i++) bs9.Set(i, true);
    bs10 = new BitArray(bs);
    for (int i = 1; i < 5; i++) bs10.Set(i, !bs10[i]);
    bs11 = new BitArray(bs);
    bs11.SetAll(false);
    bs12 = new BitArray(bs);
    bs12.SetAll(true);
    bs13 = new BitArray(bs);
    bs13.Not();
    bs14 = new BitArray(bs);
    bs14.RightShift(2);
    bs15 = new BitArray(bs);
    bs15.LeftShift(2);

    ret = !bs[1]
          && !bs.Cast<bool>().All(b => !b)
          && bs11.Cast<bool>().All(b => !b)
          && bs.Cast<bool>().Count(b => b) > 0
          && bs11.Cast<bool>().Count(b => b) == 0
          && bs.Cast<bool>().Count(b => b) != bs.Count
          && bs12.Cast<bool>().Count(b => b) == bs12.Count
          && bs.Count == 8
          && bs.Cast<bool>().Count(b => b) == 4
          && new BitArray(bs1).Xor(StringToBs("11000000")).Cast<bool>().Count(b => b) == 0
          && new BitArray(bs2).Xor(StringToBs("00001001")).Cast<bool>().Count(b => b) == 0
          && new BitArray(bs3).Xor(StringToBs("11111001")).Cast<bool>().Count(b => b) == 0
          && new BitArray(bs4).Xor(StringToBs("00111001")).Cast<bool>().Count(b => b) == 0
          && new BitArray(bs5).Xor(StringToBs("10001001")).Cast<bool>().Count(b => b) == 0
          && new BitArray(bs6).Xor(StringToBs("11101001")).Cast<bool>().Count(b => b) == 0
          && new BitArray(bs7).Xor(StringToBs("11101001")).Cast<bool>().Count(b => b) == 0
          && new BitArray(bs8).Xor(StringToBs("11000001")).Cast<bool>().Count(b => b) == 0
          && new BitArray(bs9).Xor(StringToBs("11011111")).Cast<bool>().Count(b => b) == 0
          && new BitArray(bs10).Xor(StringToBs("11010111")).Cast<bool>().Count(b => b) == 0
          && new BitArray(bs11).Xor(StringToBs("00000000")).Cast<bool>().Count(b => b) == 0
          && new BitArray(bs12).Xor(StringToBs("11111111")).Cast<bool>().Count(b => b) == 0
          && new BitArray(bs13).Xor(StringToBs("00110110")).Cast<bool>().Count(b => b) == 0
          && new BitArray(bs14).Xor(StringToBs("00110010")).Cast<bool>().Count(b => b) == 0
          && new BitArray(bs15).Xor(StringToBs("00100100")).Cast<bool>().Count(b => b) == 0;
    if (!ret)
      Console.WriteLine("Bitset Test Failed!");
    return ret;
  }
}