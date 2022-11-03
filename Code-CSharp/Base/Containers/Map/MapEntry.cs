using System.Collections.Immutable;

namespace CodeCsharp.Base.Containers.Map;

public class MapEntry {
  public static void MapProgram() {
    SortedDictionary<string, string> map = new SortedDictionary<string, string>();
    SortedDictionary<string, string> map1 = new SortedDictionary<string, string> {
        { "aa", "a" }, { "bb", "b" }, { "cc", "c" }, { "dd", "d" }
    };
    map = new SortedDictionary<string, string>(map1);

    bool isEmpty = map.Count == 0;
    map.Clear();
    map.TryAdd("ee", "e");
    map["ee"] = "e2";

    SortedDictionary<string, string> vec = new SortedDictionary<string, string> {
        { "aa", "a" }, { "bb", "b" }, { "cc", "c" }, { "dd", "d" }
    };
    foreach (var pair in vec) map.TryAdd(pair.Key, pair.Value);
    foreach (var pair in vec) map[pair.Key] = pair.Value;

    int size = map.Count;

    bool b1 = map.ContainsKey("bb");
    ImmutableSortedDictionary<string, string> constMapRef = map.ToImmutableSortedDictionary();
    bool b2 = Enumerable.SequenceEqual(map,constMapRef);

    map.Remove("cc");
    
    string defaultResult = map.GetValueOrDefault("cc", "default");
    string? result = map.GetValueOrDefault("cc", null);
    result = map.FirstOrDefault(e => string.CompareOrdinal(e.Key, "cc") <= 0,new KeyValuePair<string, string>(string.Empty,null)).Value;
    result = map.FirstOrDefault(e => string.CompareOrdinal(e.Key, "cc") >= 0,new KeyValuePair<string, string>(string.Empty,null)).Value;
  }
}