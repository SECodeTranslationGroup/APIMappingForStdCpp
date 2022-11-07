namespace CodeCsharp.Base.Random;

using System;

public class RandomEntry {
  public static void RandomProgram() {
    //initialize random generator
    Random eng = new Random();
    //generator random int
    int randomInt = eng.Next(3, 12);
    int randomInt2 = eng.Next(1, 10);
    //generator random float
    double randomDouble = 3 + eng.NextDouble() * (12 - 3);
    double randomDouble2 = 1 + eng.NextDouble() * (10 - 1);
    //generator random int list
    List<int> list;
    list = Enumerable.Repeat(0, 10).Select(i => eng.Next(0, 10)).ToList();
    //generator random double list
    List<Double> list2;
    list2 = Enumerable.Repeat(0, 10).Select(i => eng.NextDouble() * 10).ToList();
  }
  public static bool TestAll() {
    bool ret = true;
    Random eng = new Random();
    int randomInt = eng.Next(3,12);
    ret = randomInt >= 3 && randomInt <= 12;
    double randomDouble = 17 + eng.NextDouble() * (22 - 17);
    ret = ret && randomDouble >= 17 && randomDouble <= 22;
    List<int> list;
    list = Enumerable.Repeat(0, 10).Select(i => eng.Next(0, 10)).ToList();
    ret = ret && list.All(i => i >= 0 && i <= 10);
    if (!ret)
      Console.WriteLine("Random Test Failed!");
    return ret;
  }
}