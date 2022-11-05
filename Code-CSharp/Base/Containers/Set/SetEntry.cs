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
}