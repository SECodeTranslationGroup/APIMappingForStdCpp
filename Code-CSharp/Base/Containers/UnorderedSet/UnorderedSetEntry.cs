using System.Collections.Immutable;

namespace CodeCsharp.Base.Containers.UnorderedSet;

public class UnorderedSetEntry {
  public static void UnorderedSetProgram() {
    //initialize a hash set
    HashSet<string> hashSet = new HashSet<string>();
    //initialize a hash set with value
    HashSet<string> hashSet1 = new HashSet<string>{ "aa", "bb", "cc", "dd" };
    //copy hash set
    hashSet = new HashSet<string>(hashSet1);
    //whether hash set is empty
    bool isEmpty = hashSet.Count==0;
    //clear hash set
    hashSet.Clear();
    //insert element
    hashSet.Add("ee");
    //initialize a vector contains values
    List<string> vec = new List<string> { "aa", "bb", "cc", "dd" };
    //insert a range of elements
    hashSet.UnionWith(vec);
    //get size of hash set
    int size = hashSet.Count;
    //whether hash set contains element
    bool b1 = hashSet.Contains("bb");
    //create immutable reference of hash set
    ImmutableHashSet<string> constSetRef = hashSet.ToImmutableHashSet();
    //whether two hash sets equal
    bool b2 = hashSet.OrderBy(k=>k).SequenceEqual(constSetRef.OrderBy(k=>k));
    //remove element equal value
    hashSet.Remove("cc");
  }
  
  public static bool TestAll() {
    bool ret = true;
    HashSet<int> c, c1, c2, c3, c4;
    List<int> vec = new List<int> { 1, 3, 5, 7, 9 };
    c = new HashSet<int>(new List<int> { 1, 2, 3, 4, 5 });
    c2 = new HashSet<int>(c);
    c.Clear();
    c1 = new HashSet<int>(c);
    c.UnionWith(vec);
    c3 = new HashSet<int>(c);
    c.Remove(3);
    c4 = new HashSet<int>(c);
    ret = c1.Count == 0
          && c.Contains(7)
          && c4.Count == 4
          && c2.OrderBy(k=>k).SequenceEqual(
              new HashSet<int>(new List<int> { 1, 2, 3, 4, 5 }.OrderBy(k=>k)))
          && c3.OrderBy(k=>k).SequenceEqual(
              new HashSet<int>(new List<int> { 1, 3, 5, 7, 9 }.OrderBy(k=>k)))
          && c4.OrderBy(k=>k).SequenceEqual(
              new HashSet<int>(new List<int> { 1, 5, 7, 9 }.OrderBy(k=>k)));
    if (!ret)
      Console.WriteLine("Unordered Set Test Failed!");
    return ret;
  }
}