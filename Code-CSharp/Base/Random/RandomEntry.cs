namespace CodeCsharp.Base.Random;

using System;

public class RandomEntry {
  public static void RandomProgram() {
    Random eng = new Random();

    int randomInt = eng.Next(3, 12);
    int randomInt2 = eng.Next(1, 10);

    double randomDouble = 3 + eng.NextDouble() * (12 - 3);
    double randomDouble2 = 1 + eng.NextDouble() * (10 - 1);

    List<int> list;
    list = Enumerable.Repeat(0, 10).Select(i => eng.Next(0, 10)).ToList();

    List<Double> list2;
    list2 = Enumerable.Repeat(0, 10).Select(i => eng.NextDouble() * 10).ToList();
  }
}