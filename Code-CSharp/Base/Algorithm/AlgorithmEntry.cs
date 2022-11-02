namespace CodeCsharp.Base.Algorithm;

using System;

public class AlgorithmEntry {
  public static void AlgorithmProgram() {
    //initialize first list
    List<int> list = new List<int> { 1, 2, 1, 2, 3 };
    //whether all element satisfy condition
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
    int i6 = list.Find(i => !(i > 1));
    //find index of first element doesn't satisfy condition using optional
    int? res2 = list.Find(i => !(i > 1));
    //initialize another list
    List<int> toList = new List<int>();
    //copy a sublist to another list
    toList = list.Skip(1).Take(list.Count - (1 + 1)).ToList();
    //copy all element satisfy condition to another list
    toList = list.Where(i => i > 1).ToList();
    //copy a sublist to another list with length
    toList = list.Take(3).ToList();
    //fill a list with value
    list = Enumerable.Repeat(1, list.Count).ToList();
    //fill a list with length and value
    list = list.Select((s, index) => (index >= 1 && index < 1 + 3) ? 1 : s).ToList();
    //remove all element equal value
    list.RemoveAll(i => i == 1);
    //remove all element satisfy condition
    list.RemoveAll(i => i > 1);
    //copy a list removes all element equal value to another list
    toList = list.Where(i => !(i == 1)).ToList();
    //copy a list removes all element satisfy condition to another list
    toList = list.Where(i => !(i > 1)).ToList();
    //replace all element equal value to new value
    list = list.Select(i => i == 1 ? 2 : i).ToList();
    //replace all element satisfy condition to new value
    list = list.Select(i => i > 1 ? 2 : i).ToList();
    //copy a list replace all element equal value to new value to another list
    toList = list.Select(i => i == 1 ? 2 : i).ToList();
    //copy a list replace all element satisfy condition to new value to another list
    toList = list.Select(i => i > 1 ? 2 : i).ToList();
    //swap two element at two index values
    (list[1], list[2]) = (list[2], list[1]);
    //reverse all element
    list.Reverse();
    //copy a list reverse all element to another list
    toList = new List<int>(list);
    toList.Reverse();
    //rotate right with distance
    list = list.Skip(1).Concat(list.Take(1)).ToList();
    //copy a list rotate right with distance to another list
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
    list = Enumerable.Range(1, list.Count + 1).ToList();
    //fill list with range start with value
    toList = Enumerable.Range(-3, list.Count - 3).ToList();
    //initialize calculate lists
    List<int> cList = new List<int>(list), cList2 = new List<int>(list);
    //sum of the list
    int addSum = cList.Sum();
    //sum of the list using reduce function
    int multiplySum = cList.Aggregate(1, (a, b) => a * b);
    //inner product of two lists
    int innerProductSum = cList.Zip(cList2, (a, b) => a * b).Aggregate((a, b) => a + b);
    //inner product of two lists using reduce and transform function
    int productAddSum = cList.Zip(cList2, (a, b) => a + b).Aggregate(1,(a, b) => a * b);
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

  public bool Test1() {
    List<int> list1 = new List<int> { 1, 2, 1, 2, 3 };
    List<int> list2 = new List<int> { 1, 2, 1, 2, 3 };

    int sum = list1.Zip(list2, (a, b) => a + b).Aggregate((a, b) => a * b);

    int a = 1;
    list2 = list1.Select(i => a *= i).ToList();

    Dictionary<bool, List<int>> d = list1.GroupBy(i => i > 3)
        .ToDictionary(group => group.Key, group => group.ToList());
    List<int> list3 = d[true];
    List<int> list4 = d[false];

    return sum > 0;
  }
}