package codejava.base;

import codejava.base.algorithm.AlgorithmEntry;
import codejava.base.cctype.CctypeEntry;
import codejava.base.chrono.ChronoEntry;
import codejava.base.cmath.CmathEntry;
import codejava.base.containers.list.ListEntry;
import codejava.base.containers.map.MapEntry;
import codejava.base.containers.priorityqueue.PriorityQueueEntry;
import codejava.base.containers.queue.QueueEntry;
import codejava.base.containers.set.SetEntry;
import codejava.base.containers.stack.StackEntry;
import codejava.base.containers.unorderedmap.UnorderedMapEntry;
import codejava.base.containers.unorderedset.UnorderedSetEntry;
import codejava.base.containers.vector.VectorEntry;
import codejava.base.fstream.FstreamEntry;
import codejava.base.memory.WeakPtrEntry;
import codejava.base.random.RandomEntry;
import codejava.base.regex.RegexEntry;
import codejava.base.string.StringEntry;
import codejava.base.string.StringViewEntry;
import codejava.base.ultilities.BitsetEntry;
import codejava.base.ultilities.OptionalEntry;

public class GlobalEntry {
  public static void helloWorldEntry() {
    System.out.println("Hello, World!");
  }
  public static void testAllEntry(){
    boolean test = true;
    test = test && AlgorithmEntry.testAll();
    test = test && CctypeEntry.testAll();
    test = test && ChronoEntry.testAll();
    test = test && CmathEntry.testAll();
    test = test && ListEntry.testAll();
    test = test && MapEntry.testAll();
    test = test && PriorityQueueEntry.testAll();
    test = test && QueueEntry.testAll();
    test = test && SetEntry.testAll();
    test = test && StackEntry.testAll();
    test = test && UnorderedMapEntry.testAll();
    test = test && UnorderedSetEntry.testAll();
    test = test && VectorEntry.testAll();
    test = test && FstreamEntry.testAll();
    test = test && WeakPtrEntry.testAll();
    test = test && RandomEntry.testAll();
    test = test && RegexEntry.testAll();
    test = test && StringEntry.testAll();
    test = test && StringViewEntry.testAll();
    test = test && BitsetEntry.testAll();
    test = test && OptionalEntry.testAll();
    if(test)
      System.out.println("Pass!");
    else
      System.out.println("Failed!");
  }
}
