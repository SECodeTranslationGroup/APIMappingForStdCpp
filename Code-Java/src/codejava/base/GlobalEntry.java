package codejava.base;

import codejava.base.algorithm.AlgorithmEntry;

public class GlobalEntry {
  public static void helloWorldEntry() {
    System.out.println("Hello, World!");
  }
  public static void testAllEntry(){
    boolean test = true;
    test = test && AlgorithmEntry.testAll();
    if(test)
      System.out.println("Pass!");
    else
      System.out.println("Failed!");
  }
}
