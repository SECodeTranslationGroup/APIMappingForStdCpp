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
    bool b2 = Enumerable.SequenceEqual(map, constMapRef);
    //remove element equal key
    map.Remove("cc");
    //get value of key or else default
    string defaultResult = map.GetValueOrDefault("cc", "default");
    //get optional value of key
    string? result = map.GetValueOrDefault("cc", null);
    //get optional value of first key lower or equal given key
    result = map.FirstOrDefault(e => string.CompareOrdinal(e.Key, "cc") <= 0,
        new KeyValuePair<string, string>(string.Empty, null)).Value;
    //get optional value of first key greater or equal given key
    result = map.LastOrDefault(e => string.CompareOrdinal(e.Key, "cc") >= 0,
        new KeyValuePair<string, string>(string.Empty, null)).Value;
  }

  public static bool TestAll() {
    bool ret = true;
    SortedDictionary<int, int> c, c1, c2, c3, c4, c5, c6, c7, c8;
    SortedDictionary<int, int> m = new SortedDictionary<int, int> {
        { 1, 10 }, { 2, 8 }, { 3, 13 }, { 4, 9 }
    };
    c = new SortedDictionary<int, int> { { 1, 10 }, { 2, 8 }, { 3, 13 }, { 4, 9 } };
    c.Clear();
    c1 = new SortedDictionary<int, int>(c);
    c = new SortedDictionary<int, int>(m);
    c2 = new SortedDictionary<int, int>(c);
    c.TryAdd(2, 10);
    c3 = new SortedDictionary<int, int>(c);
    c.TryAdd(5, 10);
    c4 = new SortedDictionary<int, int>(c);
    c[2] = 10;
    c5 = new SortedDictionary<int, int>(c);
    m = new SortedDictionary<int, int> { { 0, 3 }, { 1, 8 }, { 2, 7 }, { 10, 3 } };
    foreach (var pair in m) c.TryAdd(pair.Key, pair.Value);
    c6 = new SortedDictionary<int, int>(c);
    foreach (var pair in m) c[pair.Key] = pair.Value;
    c7 = new SortedDictionary<int, int>(c);
    c.Remove(2);
    c8 = new SortedDictionary<int, int>(c);
    ret = c1.Count == 0
          && c.ContainsKey(3)
          && c.GetValueOrDefault(3) == 13
          && c.First(e => e.Key >= 2).Value == 13
          && c.Last(e => e.Key <= 2).Value == 8
        && c2.SequenceEqual(
            new SortedDictionary<int, int> { { 1, 10 }, { 2, 8 }, { 3, 13 }, { 4, 9 } })
        && c3.SequenceEqual(
            new SortedDictionary<int, int> { { 1, 10 }, { 2, 8 }, { 3, 13 }, { 4, 9 } })
        && c4.SequenceEqual(new SortedDictionary<int, int> {
            { 1, 10 }, { 2, 8 }, { 3, 13 }, { 4, 9 }, { 5, 10 }
        })
        && c5.SequenceEqual(new SortedDictionary<int, int> {
            { 1, 10 }, { 2, 10 }, { 3, 13 }, { 4, 9 }, { 5, 10 }
        })
        && c6.SequenceEqual(new SortedDictionary<int, int> {
            { 0, 3 }, { 1, 10 }, { 2, 10 }, { 3, 13 }, { 4, 9 }, { 5, 10 }, { 10, 3 }
        })
        && c7.SequenceEqual(new SortedDictionary<int, int> {
            { 0, 3 }, { 1, 8 }, { 2, 7 }, { 3, 13 }, { 4, 9 }, { 5, 10 }, { 10, 3 }
        })
        && c8.SequenceEqual(new SortedDictionary<int, int> {
            { 0, 3 }, { 1, 8 }, { 3, 13 }, { 4, 9 }, { 5, 10 }, { 10, 3 }
        });
    if (!ret)
      Console.WriteLine("Map Test Failed!");
    return ret;
  }
}