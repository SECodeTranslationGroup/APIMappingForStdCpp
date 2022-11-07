using System.Collections.Immutable;

namespace CodeCsharp.Base.Containers.Map;

public class MapEntry {
  public static void MapProgram() {
    //initialize a map
    SortedDictionary<string, string> map = new SortedDictionary<string, string>();
    //initialize a map with value
    SortedDictionary<string, string> map1 = new SortedDictionary<string, string> {
        { "aa", "a" }, { "bb", "b" }, { "cc", "c" }, { "dd", "d" }
    };
    //copy map
    map = new SortedDictionary<string, string>(map1);
    //whether map is empty
    bool isEmpty = map.Count == 0;
    //clear map
    map.Clear();
    //insert element if not exist
    map.TryAdd("ee", "e");
    //insert or update element
    map["ee"] = "e2";
    //initialize a map contains values
    SortedDictionary<string, string> vec = new SortedDictionary<string, string> {
        { "aa", "a" }, { "bb", "b" }, { "cc", "c" }, { "dd", "d" }
    };
    //insert a range of elements if not exist
    foreach (var pair in vec) map.TryAdd(pair.Key, pair.Value);
    //insert or update a range of elements
    foreach (var pair in vec) map[pair.Key] = pair.Value;
    //get size of map
    int size = map.Count;
    //whether map contains element
    bool b1 = map.ContainsKey("bb");
    //create immutable reference of map
    ImmutableSortedDictionary<string, string> constMapRef = map.ToImmutableSortedDictionary();
    //whether two maps equal
    bool b2 = Enumerable.SequenceEqual(map,constMapRef);
    //remove element equal key
    map.Remove("cc");
    //get value of key or else default
    string defaultResult = map.GetValueOrDefault("cc", "default");
    //get optional value of key
    string? result = map.GetValueOrDefault("cc", null);
    //get optional value of first key lower or equal given key
    result = map.FirstOrDefault(e => string.CompareOrdinal(e.Key, "cc") <= 0,new KeyValuePair<string, string>(string.Empty,null)).Value;
    //get optional value of first key greater or equal given key
    result = map.FirstOrDefault(e => string.CompareOrdinal(e.Key, "cc") >= 0,new KeyValuePair<string, string>(string.Empty,null)).Value;
  }
  public static bool TestAll() {
    bool ret = true;
    if (!ret)
      Console.WriteLine("Map Test Failed!");
    return ret;
  }
}