using System.Collections.Immutable;
using System.Collections.ObjectModel;

namespace CodeCsharp.Base.Vector;

public class VectorEntry {
  public static void VectorProgram() {
    List<string> vec = new List<string>();
    List<string> vec1 = new List<string> { "aa", "bb", "cc", "dd" };

    vec = new List<string>(Enumerable.Repeat("",10));
    bool isEmpty = vec.Any();
    vec.Clear();

    vec.Add("ee");
    vec.Insert(1, "ff");
    vec.AddRange(vec1);
    vec.InsertRange(1, vec1);
    
    int size = vec.Count;
    bool b1 = vec.Contains("gg");
    IList<string> constVecRef = vec.AsReadOnly();
    bool b3 = vec.Equals(constVecRef);
    string element = vec[3];
    vec[3] = "hh";
    
    int index = vec.IndexOf("bb");
    int lastIndex = vec.LastIndexOf("bb");
    
    vec.RemoveAt(vec.Count - 1);
    vec.RemoveAt(3);
    vec.Remove("cc");
    vec.RemoveAll(e=>e.Equals("cc"));
    vec = vec.Select(e => e + "1").ToList();
    
    vec.Sort();
    vec.Sort((s1, s2)=>-string.CompareOrdinal(s1,s2));
    
    List<string> sublist = vec.Skip(1).Take(2-1).ToList();
  }
}