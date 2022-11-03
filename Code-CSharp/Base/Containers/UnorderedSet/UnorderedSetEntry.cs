using System.Collections.Immutable;

namespace CodeCsharp.Base.Containers.UnorderedSet;

public class UnorderedSetEntry {
  public static void UnorderedSetProgram() {
    HashSet<string> hashSet = new HashSet<string>();
    HashSet<string> hashSet1 = new HashSet<string>{ "aa", "bb", "cc", "dd" };
    hashSet = new HashSet<string>(hashSet1);

    bool isEmpty = hashSet.Count==0;
    hashSet.Clear();

    hashSet.Add("ee");

    List<string> vec = new List<string> { "aa", "bb", "cc", "dd" };
    hashSet.UnionWith(vec);

    int size = hashSet.Count;

    bool b1 = hashSet.Contains("bb");
    ImmutableHashSet<string> constSetRef = hashSet.ToImmutableHashSet();
    bool b2 = Enumerable.SequenceEqual(hashSet,constSetRef);

    hashSet.Remove("cc");
  }
}