using CodeCsharp.Base.Algorithm;
using CodeCsharp.Base.CCType;
using CodeCsharp.Base.Chrono;
using CodeCsharp.Base.Cmath;
using CodeCsharp.Base.Containers.List;
using CodeCsharp.Base.Containers.Map;
using CodeCsharp.Base.Containers.PriorityQueue;
using CodeCsharp.Base.Containers.Queue;
using CodeCsharp.Base.Containers.Set;
using CodeCsharp.Base.Containers.Stack;
using CodeCsharp.Base.Containers.UnorderedMap;
using CodeCsharp.Base.Containers.UnorderedSet;
using CodeCsharp.Base.Containers.Vector;
using CodeCsharp.Base.Fstream;
using CodeCsharp.Base.Memory;
using CodeCsharp.Base.Random;
using CodeCsharp.Base.Regex;
using CodeCsharp.Base.String;
using CodeCsharp.Base.Utilities;

namespace CodeCsharp.Base;

public class GlobalEntry {
  public static void HelloWorldEntry() {
    Console.WriteLine("Hello, World!");
  }
  public static void TestAllEntry(){
    bool test = true;
    test = test && AlgorithmEntry.TestAll();
    test = test && CctypeEntry.TestAll();
    test = test && ChronoEntry.TestAll();
    test = test && CmathEntry.TestAll();
    test = test && ListEntry.TestAll();
    test = test && MapEntry.TestAll();
    test = test && PriorityQueueEntry.TestAll();
    test = test && QueueEntry.TestAll();
    test = test && SetEntry.TestAll();
    test = test && StackEntry.TestAll();
    test = test && UnorderedMapEntry.TestAll();
    test = test && UnorderedSetEntry.TestAll();
    test = test && VectorEntry.TestAll();
    test = test && FstreamEntry.TestAll();
    test = test && WeakPtrEntry.TestAll();
    test = test && RandomEntry.TestAll();
    test = test && RegexEntry.TestAll();
    test = test && StringEntry.TestAll();
    test = test && StringViewEntry.TestAll();
    test = test && BitsetEntry.TestAll();
    test = test && OptionalEntry.TestAll();
    if(test)
      Console.WriteLine("Pass!");
    else
      Console.WriteLine("Failed!");
  }

}