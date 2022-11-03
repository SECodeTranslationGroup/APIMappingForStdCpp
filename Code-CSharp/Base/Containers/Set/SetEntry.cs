using System.Collections.Immutable;

namespace CodeCsharp.Base.Containers.Set;

public class SetEntry {
  public static void SetProgram() {
    SortedSet<string> set = new SortedSet<string>();
    SortedSet<string> set1 = new SortedSet<string> { "aa", "bb", "cc", "dd" };
    set = new SortedSet<string>(set1);

    bool isEmpty = set.Count == 0;
    set.Clear();
    set.Add("ee");

    List<string> vec = new List<string> { "aa", "bb", "cc", "dd" };
    set.UnionWith(vec);

    int size = set.Count;

    bool b1 = set.Contains("bb");
    ImmutableSortedSet<string> constSetRef = set.ToImmutableSortedSet();
    bool b2 = Enumerable.SequenceEqual(set, constSetRef);

    set.Remove("cc");

    SortedSet<string> resultSet = new SortedSet<string>(set);
    resultSet.ExceptWith(set1);
    resultSet = new SortedSet<string>(set);
    resultSet.IntersectWith(set1);
    resultSet = new SortedSet<string>(set);
    resultSet.UnionWith(set1);
    resultSet = new SortedSet<string>(set);
    resultSet.SymmetricExceptWith(set1);

    SortedSet<string> subset;
    subset = new SortedSet<string>(set.GetViewBetween("bb", "dd"));
    subset = new SortedSet<string>(set.GetViewBetween("bb", set.Max));
    subset = new SortedSet<string>(set.GetViewBetween(set.Min, "dd"));

    string? result = set.GetViewBetween(set.Min, "cc").Max;
    result = set.GetViewBetween("cc", set.Max).Min;
  }
}