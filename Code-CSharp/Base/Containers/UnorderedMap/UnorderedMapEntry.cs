using System.Collections.Immutable;

namespace CodeCsharp.Base.Containers.UnorderedMap;

public class UnorderedMapEntry
{
    public static void MapProgram() {
        Dictionary<string, string> hashMap = new Dictionary<string, string>();
        Dictionary<string, string> hashMap1 = new Dictionary<string, string>{
            { "aa", "a" }, { "bb", "b" }, { "cc", "c" }, { "dd", "d" }
        };
        hashMap = new Dictionary<string, string>(hashMap1);

        bool isEmpty = hashMap.Count == 0;
        hashMap.Clear();
        hashMap.TryAdd("ee", "e");
        hashMap["ee"] = "e2";

        Dictionary<string, string> vec = new Dictionary<string, string> {
                { "aa", "a" }, { "bb", "b" }, { "cc", "c" }, { "dd", "d" }
        };
        foreach (var pair in vec) hashMap.TryAdd(pair.Key, pair.Value);
        foreach (var pair in vec) hashMap[pair.Key] = pair.Value;;

        int size = hashMap.Count;

        bool b1 = hashMap.ContainsKey("bb");
        ImmutableDictionary<string, string> constHashMapRef = hashMap.ToImmutableDictionary();
        bool b2 = Enumerable.SequenceEqual(hashMap,constHashMapRef);

        hashMap.Remove("cc");

        string defaultResult = hashMap.GetValueOrDefault("cc", "default");
        string? result = hashMap.GetValueOrDefault("cc", null);
    }
    
}