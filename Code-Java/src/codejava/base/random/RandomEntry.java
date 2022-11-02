package codejava.base.random;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class RandomEntry {
  public static void RandomProgram() {
    //initialize random generator
    Random eng = new Random();
    //generator random int
    int randomInt = 3 + eng.nextInt(12 - 3);
    int randomInt2 = 1 + eng.nextInt(10 - 1);
    //generator random float
    double randomDouble = 3 + eng.nextDouble(12 - 3);
    double randomDouble2 = 1 + eng.nextDouble(9 - 1);
    //generator random int list
    List<Integer> list;
    list = eng.ints(10, 0, 10).
        boxed().collect(Collectors.toList());
    //generator random double list
    List<Double> list2;
    list2 = eng.doubles(10, 0, 10).
        boxed().collect(Collectors.toList());
  }
}
