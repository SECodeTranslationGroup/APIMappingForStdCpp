using System.Collections.Immutable;

namespace CodeCsharp.Base.Containers.Set;

public class SetEntry {
  public static void SetProgram() {
    //initialize a set
    SortedSet<string> set = new SortedSet<string>();
    //initialize a set with value
    SortedSet<string> set1 = new SortedSet<string> { "aa", "bb", "cc", "dd" };
    //copy set
    set = new SortedSet<string>(set1);
    //whether set is empty
    bool isEmpty = set.Count == 0;
    //clear set
    set.Clear();
    //insert element
    set.Add("ee");
    //initialize a vector contains values
    List<string> vec = new List<string> { "aa", "bb", "cc", "dd" };
    //insert a range of elements
    set.UnionWith(vec);
    //get size of set
    int size = set.Count;
    //whether set contains element
    bool b1 = set.Contains("bb");
    //create immutable reference of set
    ImmutableSortedSet<string> constSetRef = set.ToImmutableSortedSet();
    //whether two sets equal
    bool b2 = Enumerable.SequenceEqual(set, constSetRef);
    //remove element equal value
    set.Remove("cc");
    //initialize result set for calculation
    SortedSet<string> resultSet = new SortedSet<string>(set);
    //set difference
    resultSet.ExceptWith(set1);
    //set union
    resultSet = new SortedSet<string>(set);
    resultSet.UnionWith(set1);
    //set intersection
    resultSet = new SortedSet<string>(set);
    resultSet.IntersectWith(set1);
    //set symmetric difference
    resultSet = new SortedSet<string>(set);
    resultSet.SymmetricExceptWith(set1);
    //initialize set for subset
    SortedSet<string> subset;
    //create a subset from given range
    subset = new SortedSet<string>(set.GetViewBetween("bb", "dd"));
    //create a subset greater than given value
    subset = new SortedSet<string>(set.GetViewBetween("bb", set.Max));
    //create a subset less than given value
    subset = new SortedSet<string>(set.GetViewBetween(set.Min, "dd"));
    //get optional of first value lower or equal given value
    string? result = set.GetViewBetween(set.Min, "cc").Max;
    //get optional of first value greater or equal given value
    result = set.GetViewBetween("cc", set.Max).Min;
  }

  public static bool TestAll() {
    bool ret = true;
    SortedSet<int> c, c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11;
    List<int> vec = new List<int> { 1, 3, 5, 7, 9 };
    c = new SortedSet<int>(new List<int> { 1, 2, 3, 4, 5 });
    c2 = new SortedSet<int>(c);
    c.Clear();
    c1 = new SortedSet<int>(c);
    c.UnionWith(vec);
    c3 = new SortedSet<int>(c);
    c.Remove(3);
    c4 = new SortedSet<int>(c);
    c5 = new SortedSet<int>(c);
    c5.ExceptWith(c2);
    c6 = new SortedSet<int>(c);
    c6.UnionWith(c2);
    c7 = new SortedSet<int>(c);
    c7.IntersectWith(c2);
    c8 = new SortedSet<int>(c);
    c8.SymmetricExceptWith(c2);
    c9 = new SortedSet<int>(c.GetViewBetween(5, 7));
    c10 = new SortedSet<int>(c.GetViewBetween(5, c.Max));
    c11 = new SortedSet<int>(c.GetViewBetween(c.Min, 7));
    ret = c1.Count == 0
          && c.Contains(7)
          && c6.Count == 7
          && c.GetViewBetween(c.Min, 6).Max == 5
          && c.GetViewBetween(6, c.Max).Min == 7
          && c2.SequenceEqual(new SortedSet<int>(new List<int> { 1, 2, 3, 4, 5 }))
          && c3.SequenceEqual(new SortedSet<int>(new List<int> { 1, 3, 5, 7, 9 }))
          && c4.SequenceEqual(new SortedSet<int>(new List<int> { 1, 5, 7, 9 }))
          && c5.SequenceEqual(new SortedSet<int>(new List<int> { 7, 9 }))
          && c6.SequenceEqual(new SortedSet<int>(new List<int> { 1, 2, 3, 4, 5, 7, 9 }))
          && c7.SequenceEqual(new SortedSet<int>(new List<int> { 1, 5 }))
          && c8.SequenceEqual(new SortedSet<int>(new List<int> { 2, 3, 4, 7, 9 }))
          && c9.SequenceEqual(new SortedSet<int>(new List<int> { 5, 7 }))
          && c10.SequenceEqual(new SortedSet<int>(new List<int> { 5, 7, 9}))
          && c11.SequenceEqual(new SortedSet<int>(new List<int> { 1, 5, 7}));
    if (!ret)
      Console.WriteLine("Set Test Failed!");
    return ret;
  }
}