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
    bool b2 = Enumerable.SequenceEqual(hashMap, constHashMapRef);
    //remove element equal key
    hashMap.Remove("cc");
    //get value of key or else default
    string defaultResult = hashMap.GetValueOrDefault("cc", "default");
    //get optional value of key
    string? result = hashMap.GetValueOrDefault("cc", null);
  }
  
  public static bool TestAll() {
    bool ret = true;
    if (!ret)
      Console.WriteLine("Unordered Map Test Failed!");
    return ret;
  }
}