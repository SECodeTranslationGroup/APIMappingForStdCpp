using System.Collections.Immutable;
using System.Collections.ObjectModel;

namespace CodeCsharp.Base.Containers.Vector;

public class VectorEntry {
  public static void VectorProgram() {
    //initialize a vector
    List<string> vec = new List<string>();
    //initialize a vector with value
    List<string> vec1 = new List<string> { "aa", "bb", "cc", "dd" };
    //copy vector
    vec = new List<string>(vec1);
    //resize vector and fill with default value
    vec = new List<string>(Enumerable.Repeat("",10));
    //resize vector, trunc additional size or fill with default value
    if (vec.Count >= 20) {
      vec.RemoveRange(20,vec.Count);
    } else {
      vec.AddRange(Enumerable.Repeat("",20-vec.Count));
    }
    //whether vector is empty
    bool isEmpty = vec.Any();
    //clear vector
    vec.Clear();
    //insert element at end
    vec.Add("ee");
    //insert element at given position
    vec.Insert(1, "ff");
    //insert a range of elements at end
    vec.AddRange(vec1);
    //insert a range of elements at given position
    vec.InsertRange(1, vec1);
    //get size of list
    int size = vec.Count;
    //whether list contains element
    bool b1 = vec.Contains("gg");
    //create immutable reference of list
    ImmutableList<string> constVecRef = vec.ToImmutableList();
    //whether two lists equal
    bool b2 = Enumerable.SequenceEqual(vec,constVecRef);
    //get element at given position
    string element = vec[3];
    //update element
    vec[3] = "hh";
    //remove last element
    vec.RemoveAt(vec.Count - 1);
    //remove element at given position
    vec.RemoveAt(3);
    //remove a range of elements at given position
    vec.RemoveRange(1,3);
  }
  
  public static bool TestAll() {
    bool ret = true;
    if (!ret)
      Console.WriteLine("Vector Test Failed!");
    return ret;
  }
}