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
    bool b2 = Enumerable.SequenceEqual(hashSet,constSetRef);
    //remove element equal value
    hashSet.Remove("cc");
  }
}