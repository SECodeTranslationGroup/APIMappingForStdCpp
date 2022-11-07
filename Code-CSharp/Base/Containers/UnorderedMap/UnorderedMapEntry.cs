using System.Collections.Immutable;

namespace CodeCsharp.Base.Containers.UnorderedMap;

public class UnorderedMapEntry {
  public static void MapProgram() {
    //initialize a hash map
    Dictionary<string, string> hashMap = new Dictionary<string, string>();
    //initialize a hash map with value
    Dictionary<string, string> hashMap1 = new Dictionary<string, string> {
        { "aa", "a" }, { "bb", "b" }, { "cc", "c" }, { "dd", "d" }
    };
    //copy hash map
    hashMap = new Dictionary<string, string>(hashMap1);
    //whether hash map is empty
    bool isEmpty = hashMap.Count == 0;
    //clear hash map
    hashMap.Clear();
    //insert element if not exist
    hashMap.TryAdd("ee", "e");
    //insert or update element
    hashMap["ee"] = "e2";
    //initialize a hash map contains values
    Dictionary<string, string> vec = new Dictionary<string, string> {
        { "aa", "a" }, { "bb", "b" }, { "cc", "c" }, { "dd", "d" }
    };
    //insert a range of elements if not exist
    foreach (var pair in vec) hashMap.TryAdd(pair.Key, pair.Value);
    //insert or update a range of elements
    foreach (var pair in vec) hashMap[pair.Key] = pair.Value;
    //get size of hash map
    int size = hashMap.Count;
    //whether hash map contains element
    bool b1 = hashMap.ContainsKey("bb");
    //create immutable reference of hash map
    ImmutableDictionary<string, string> constHashMapRef = hashMap.ToImmutableDictionary();
    //whether two hash maps equal
    bool b2 = Enumerable.SequenceEqual(hashMap.OrderBy(kv => kv.Key),
        constHashMapRef.OrderBy(kv => kv.Key));
    //remove element equal key
    hashMap.Remove("cc");
    //get value of key or else default
    string defaultResult = hashMap.GetValueOrDefault("cc", "default");
    //get optional value of key
    string? result = hashMap.GetValueOrDefault("cc", null);
  }

  public static bool TestAll() {
    bool ret = true;
    Dictionary<int, int> c, c1, c2, c3, c4, c5, c6, c7, c8;
    Dictionary<int, int> m = new Dictionary<int, int> { { 1, 10 }, { 2, 8 }, { 3, 13 }, { 4, 9 } };
    c = new Dictionary<int, int> { { 1, 10 }, { 2, 8 }, { 3, 13 }, { 4, 9 } };
    c.Clear();
    c1 = new Dictionary<int, int>(c);
    c = new Dictionary<int, int>(m);
    c2 = new Dictionary<int, int>(c);
    c.TryAdd(2, 10);
    c3 = new Dictionary<int, int>(c);
    c.TryAdd(5, 10);
    c4 = new Dictionary<int, int>(c);
    c[2] = 10;
    c5 = new Dictionary<int, int>(c);
    m = new Dictionary<int, int> { { 0, 3 }, { 1, 8 }, { 2, 7 }, { 10, 3 } };
    foreach (var pair in m) c.TryAdd(pair.Key, pair.Value);
    c6 = new Dictionary<int, int>(c);
    foreach (var pair in m) c[pair.Key] = pair.Value;
    c7 = new Dictionary<int, int>(c);
    c.Remove(2);
    c8 = new Dictionary<int, int>(c);
    ret = c1.Count == 0
          && c.ContainsKey(3)
          && c.GetValueOrDefault(3) == 13
          && c2.OrderBy(kv => kv.Key).SequenceEqual(
              new Dictionary<int, int> { { 1, 10 }, { 2, 8 }, { 3, 13 }, { 4, 9 } }
                      .OrderBy(kv => kv.Key))
          && c3.OrderBy(kv => kv.Key).SequenceEqual(
              new Dictionary<int, int> { { 1, 10 }, { 2, 8 }, { 3, 13 }, { 4, 9 } }
                  .OrderBy(kv => kv.Key))
          && c4.OrderBy(kv => kv.Key).SequenceEqual(new Dictionary<int, int> {
              { 1, 10 }, { 2, 8 }, { 3, 13 }, { 4, 9 }, { 5, 10 }
          }.OrderBy(kv => kv.Key))
          && c5.OrderBy(kv => kv.Key).SequenceEqual(new Dictionary<int, int> {
              { 1, 10 }, { 2, 10 }, { 3, 13 }, { 4, 9 }, { 5, 10 }
          }.OrderBy(kv => kv.Key))
          && c6.OrderBy(kv => kv.Key).SequenceEqual(new Dictionary<int, int> {
              { 0, 3 }, { 1, 10 }, { 2, 10 }, { 3, 13 }, { 4, 9 }, { 5, 10 }, { 10, 3 }
          }.OrderBy(kv => kv.Key))
          && c7.OrderBy(kv => kv.Key).SequenceEqual(new Dictionary<int, int> {
              { 0, 3 }, { 1, 8 }, { 2, 7 }, { 3, 13 }, { 4, 9 }, { 5, 10 }, { 10, 3 }
          }.OrderBy(kv => kv.Key))
          && c8.OrderBy(kv => kv.Key).SequenceEqual(new Dictionary<int, int> {
              { 0, 3 }, { 1, 8 }, { 3, 13 }, { 4, 9 }, { 5, 10 }, { 10, 3 }
          }.OrderBy(kv => kv.Key));
    if (!ret)
      Console.WriteLine("Unordered Map Test Failed!");
    return ret;
  }
}