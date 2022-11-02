using System.Collections.Immutable;
using System.Collections.ObjectModel;

namespace CodeCsharp.Base.Containers.Vector;

public class VectorEntry {
  public static void VectorProgram() {
    List<string> vec = new List<string>();
    List<string> vec1 = new List<string> { "aa", "bb", "cc", "dd" };

    vec = new List<string>(Enumerable.Repeat("",10));
    if (vec.Count >= 20) {
      vec.RemoveRange(20,vec.Count);
    } else {
      vec.AddRange(Enumerable.Repeat("",20-vec.Count));
    }
    
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
    
    vec.RemoveAt(vec.Count - 1);
    vec.RemoveAt(3);
    vec.RemoveRange(1,3);
  }
}