using System.Diagnostics;

namespace CodeCsharp.Base.Algorithm;

using System;

public class AlgorithmEntry {
  public static void AlgorithmProgram() {
    //initialize first list
    List<int> list = new List<int> { 1, 2, 1, 2, 3 };
    //whether all elements satisfy condition
    bool b1 = list.All(i => i > 1);
    //whether any element satisfy condition
    bool b2 = list.Any(i => i > 1);
    //whether no element satisfy condition
    bool b3 = !list.Any(i => i > 1);
    //for each element do function
    list.ForEach(i => Console.WriteLine(i));
    //transform each element with function
    list = list.Select(i => i * 2).ToList();
    //count how many elements equal value
    int i1 = list.Count(i => i == 1);
    //count how many elements satisfy condition
    int i2 = list.Count(i => i > 1);
    //find index of first element equals value, or else -1
    int i3 = list.IndexOf(1);
    //find index of last element equals value, or else -1
    int i4 = list.LastIndexOf(1);
    //find index of first element satisfies condition, or else -1
    int i5 = list.FindIndex(i => i > 1);
    //find index of first element satisfies condition using optional
    int? res1 = list.Find(i => i > 1);
    //find index of first element doesn't satisfy condition, or else -1
    int i6 = list.FindIndex(i => !(i > 1));
    //find index of first element doesn't satisfy condition using optional
    int? res2 = list.Find(i => !(i > 1));
    //initialize another list
    List<int> toList = new List<int>();
    //copy a sublist to another list
    toList = list.Skip(1).Take(list.Count - (1 + 1)).ToList();
    //copy all elements satisfy condition to another list
    toList = list.Where(i => i > 1).ToList();
    //copy a sublist to another list with length
    toList = list.Take(3).ToList();
    //fill a list with value
    list = Enumerable.Repeat(1, list.Count).ToList();
    //fill a list with length and value
    list = list.Select((s, index) => (index >= 1 && index < 1 + 3) ? 1 : s).ToList();
    //remove all elements equal value
    list.RemoveAll(i => i == 1);
    //remove all elements satisfy condition
    list.RemoveAll(i => i > 1);
    //copy a list removes all elements equal value to another list
    toList = list.Where(i => !(i == 1)).ToList();
    //copy a list removes all elements satisfy condition to another list
    toList = list.Where(i => !(i > 1)).ToList();
    //replace all elements equal value to new value
    list = list.Select(i => i == 1 ? 2 : i).ToList();
    //replace all elements satisfy condition to new value
    list = list.Select(i => i > 1 ? 2 : i).ToList();
    //copy a list replace all elements equal value to new value to another list
    toList = list.Select(i => i == 1 ? 2 : i).ToList();
    //copy a list replace all elements satisfy condition to new value to another list
    toList = list.Select(i => i > 1 ? 2 : i).ToList();
    //swap two element at two index values
    (list[1], list[2]) = (list[2], list[1]);
    //reverse list
    list.Reverse();
    //copy a reversed list to another list
    (toList = new List<int>(list)).Reverse();
    //rotate left with distance
    list = list.Skip(1).Concat(list.Take(1)).ToList();
    //copy a list rotate left with distance to another list
    toList = list.Skip(1).Concat(list.Take(1)).ToList();
    //initialize random generator
    Random rng = new Random();
    //random shuffle
    list = list.OrderBy(i => rng.Next()).ToList();
    //random sample
    toList = list.OrderBy(i => rng.Next()).Take(3).ToList();
    //initialize partition lists
    List<int> list1, list2;
    //partition to two lists with condition
    Dictionary<bool, List<int>> d = list.GroupBy(i => i > 1)
        .ToDictionary(group => group.Key, group => group.ToList());
    list1 = d[true];
    list2 = d[false];
    //sort list
    list.Sort();
    //sort list with compare function
    list.Sort((a, b) => (a * a + 2 * a) - (b * b + 2 * b));
    //copy a list sorted to another list
    toList = list.OrderBy(a => a * a + 2 * a).ToList();
    //binary search whether value exist
    bool b4 = list.BinarySearch(1) >= 0;
    //max element of 2 values
    int max = Math.Max(1, 2);
    //max element of a list with optional(in case list is empty)
    int? maxElement = list.Max();
    //max element with compare function of a list with optional(in case list is empty)
    maxElement = list.MaxBy(a => a * a + 2 * a);
    //min element of 2 values
    int min = Math.Min(1, 2);
    //min element of a list with optional(in case list is empty)
    int? minElement = list.Min();
    //min element with compare function of a list with optional(in case list is empty)
    minElement = list.MinBy(a => a * a + 2 * a);
    //clamp function
    int clamp = Math.Clamp(5, 0, 100);
    //fill list with range start with 1
    list = Enumerable.Range(1, list.Count).ToList();
    //fill list with range start with value
    list = Enumerable.Range(-3, list.Count).ToList();
    //initialize calculate lists
    List<int> cList = new List<int>(list), cList2 = new List<int>(list);
    //sum of the list
    int addSum = cList.Sum();
    //sum of the list using reduce function
    int multiplySum = cList.Aggregate(1, (a, b) => a * b);
    //inner product of two lists
    int innerProductSum = cList.Zip(cList2, (a, b) => a * b).Aggregate((a, b) => a + b);
    //inner product of two lists using reduce and transform function
    int productAddSum = cList.Zip(cList2, (a, b) => a + b).Aggregate(1, (a, b) => a * b);
    //copy adjacent difference of list to another list
    toList = list.Select((s, index) => index == 0 ? s : s - list[index - 1]).ToList();
    //copy adjacent difference of list using difference function to another list
    toList = list.Select((s, index) => index == 0 ? s : s * list[index - 1]).ToList();
    //copy partial sum of list to another list
    int s = 0;
    toList = list.Select(a => s += a).ToList();
    //copy partial sum of list using reduce function to another list
    s = 1;
    toList = list.Select(a => s *= a).ToList();
  }

  public static bool TestAll() {
    bool ret = true;
    List<int> l = new List<int> { 1, 3, 5, 7, 9, 9, 7, 5, 3, 1 };
    List<int> l1 = new List<int> { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
    List<int> l2, l3, l4, l5, l6, l7, l8, l9, l10;
    List<int> l11, l12, l13, l14, l15, l16, l17, l18;
    List<int> l19, l20, l21, l22, l23, l24, l25, l26;
    List<int> l27, l28, l29, l30, l31, l32;
    l2 = new List<int>();
    l.ForEach(i => l2.Add(i * 2));
    l3 = l2.Select(i => i + 1).ToList();
    l4 = l2.Skip(1).Take(l2.Count - (1 + 1)).ToList();
    l5 = l2.Where(i => i > 6).ToList();
    l6 = l2.Take(5).ToList();
    l7 = Enumerable.Repeat(1, 10).ToList();
    l8 = Enumerable.Repeat(0, 10).ToList();
    l8 = l8.Select((s, index) => index < 5 ? 1 : s).ToList();
    l9 = new List<int>(l2);
    l9.RemoveAll(i => i == 6);
    l10 = new List<int>(l2);
    l10.RemoveAll(i => i > 6);
    l11 = l2.Where(i => !(i == 6)).ToList();
    l12 = l2.Where(i => !(i > 6)).ToList();
    l13 = l2.Select(i => i == 2 ? 3 : i).ToList();
    l14 = l2.Select(i => i > 6 ? 3 : i).ToList();
    l15 = l2.Select(i => i == 2 ? 3 : i).ToList();
    l16 = l2.Select(i => i > 6 ? 3 : i).ToList();
    l17 = new List<int>(l2);
    (l17[1], l17[2]) = (l17[2], l17[1]);
    l18 = new List<int>(l17);
    l18.Reverse();
    (l19 = new List<int>(l17)).Reverse();
    l20 = new List<int>(l2);
    l20 = l20.Skip(9).Concat(l20.Take(9)).ToList();
    l21 = l2.Skip(9).Concat(l2.Take(9)).ToList();
    Dictionary<bool, List<int>> d = l2.GroupBy(i => i > 6)
        .ToDictionary(group => group.Key, group => group.ToList());
    l22 = d[true];
    l23 = d[false];
    l24 = new List<int>(l2);
    l24.Sort();
    l25 = new List<int>(l2);
    l25.Sort((a, b) => Math.Abs(a - 7) - Math.Abs(b - 7));
    l26 = l2.OrderBy(a => a).ToList();
    l27 = Enumerable.Range(1, 10).ToList();
    l28 = Enumerable.Range(-3, 10).ToList();
    l29 = l2.Select((s, index) => index == 0 ? s : s - l2[index - 1]).ToList();
    l30 = l2.Select((s, index) => index == 0 ? s : s * l2[index - 1]).ToList();
    int s = 0;
    l31 = l2.Select(a => s += a).ToList();
    s = 1;
    l32 = l1.Select(a => s *= a).ToList();
    ret = l.All(i => i > 0)
          && !l.All(i => i > 5)
          && l.Any(i => i > 5)
          && !l.Any(i => i > 10)
          && !l.Any(i => i > 10)
          && l.Any(i => i > 5)
          && l1.BinarySearch(5) >= 0
          && !(l1.BinarySearch(0) >= 0)
          && l.Count(i => i == 1) == 2
          && l.Count(i => i > 5) == 4
          && l.IndexOf(5) == 2
          && l.LastIndexOf(5) == 7
          && l.FindIndex(i => i > 4) == 2
          && l.FindIndex(i => !(i < 4)) == 2
          && Math.Max(1, 2) == 2
          && l.Max() == 9
          && l.MaxBy(a => Math.Abs(a - 4)) == 9
          && Math.Min(1, 2) == 1
          && l.Min() == 1
          && l.MinBy(a => Math.Abs(a - 5)) == 5
          && Math.Clamp(5, 0, 100) == 5
          && Math.Clamp(5, 0, 3) == 3
          && Math.Clamp(5, 6, 100) == 6
          && l.Sum() == 50
          && l.Aggregate(1, (a, b) => a * b) == 893025
          && l.Zip(l, (a, b) => a * b)
              .Aggregate((a, b) => a + b) == 330
          && l.Zip(l, (a, b) => a + b)
              .Aggregate(1, (a, b) => a * b) == 914457600
          && l2.SequenceEqual(new List<int> { 2, 6, 10, 14, 18, 18, 14, 10, 6, 2 })
          && l3.SequenceEqual(new List<int> { 3, 7, 11, 15, 19, 19, 15, 11, 7, 3 })
          && l4.SequenceEqual(new List<int> { 6, 10, 14, 18, 18, 14, 10, 6 })
          && l5.SequenceEqual(new List<int> { 10, 14, 18, 18, 14, 10 })
          && l6.SequenceEqual(new List<int> { 2, 6, 10, 14, 18 })
          && l7.SequenceEqual(new List<int> { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 })
          && l8.SequenceEqual(new List<int> { 1, 1, 1, 1, 1, 0, 0, 0, 0, 0 })
          && l9.SequenceEqual(new List<int> { 2, 10, 14, 18, 18, 14, 10, 2 })
          && l10.SequenceEqual(new List<int> { 2, 6, 6, 2 })
          && l11.SequenceEqual(new List<int> { 2, 10, 14, 18, 18, 14, 10, 2 })
          && l12.SequenceEqual(new List<int> { 2, 6, 6, 2 })
          && l13.SequenceEqual(new List<int> { 3, 6, 10, 14, 18, 18, 14, 10, 6, 3 })
          && l14.SequenceEqual(new List<int> { 2, 6, 3, 3, 3, 3, 3, 3, 6, 2 })
          && l15.SequenceEqual(new List<int> { 3, 6, 10, 14, 18, 18, 14, 10, 6, 3 })
          && l16.SequenceEqual(new List<int> { 2, 6, 3, 3, 3, 3, 3, 3, 6, 2 })
          && l17.SequenceEqual(new List<int> { 2, 10, 6, 14, 18, 18, 14, 10, 6, 2 })
          && l18.SequenceEqual(new List<int> { 2, 6, 10, 14, 18, 18, 14, 6, 10, 2 })
          && l19.SequenceEqual(new List<int> { 2, 6, 10, 14, 18, 18, 14, 6, 10, 2 })
          && l20.SequenceEqual(new List<int> { 2, 2, 6, 10, 14, 18, 18, 14, 10, 6 })
          && l21.SequenceEqual(new List<int> { 2, 2, 6, 10, 14, 18, 18, 14, 10, 6 })
          && l22.SequenceEqual(new List<int> { 10, 14, 18, 18, 14, 10 })
          && l23.SequenceEqual(new List<int> { 2, 6, 6, 2 })
          && l24.SequenceEqual(new List<int> { 2, 2, 6, 6, 10, 10, 14, 14, 18, 18 })
          && l25.SequenceEqual(new List<int> { 6, 6, 10, 10, 2, 2, 14, 14, 18, 18 })
          && l26.SequenceEqual(new List<int> { 2, 2, 6, 6, 10, 10, 14, 14, 18, 18 })
          && l27.SequenceEqual(new List<int> { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 })
          && l28.SequenceEqual(new List<int> { -3, -2, -1, 0, 1, 2, 3, 4, 5, 6 })
          && l29.SequenceEqual(new List<int> { 2, 4, 4, 4, 4, 0, -4, -4, -4, -4 })
          && l30.SequenceEqual(new List<int> { 2, 12, 60, 140, 252, 324, 252, 140, 60, 12 })
          && l31.SequenceEqual(new List<int> { 2, 8, 18, 32, 50, 68, 82, 92, 98, 100 })
          && l32.SequenceEqual(
              new List<int> { 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800 });
    if (!ret)
      Console.WriteLine("Algorithm Test Failed!");
    return ret;
  }
}