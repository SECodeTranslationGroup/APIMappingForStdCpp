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
    vec = new List<string>(Enumerable.Repeat("", 10));
    //resize vector, trunc additional size or fill with default value
    if (vec.Count >= 20) {
      vec.RemoveRange(20, vec.Count);
    } else {
      vec.AddRange(Enumerable.Repeat("", 20 - vec.Count));
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
    bool b2 = Enumerable.SequenceEqual(vec, constVecRef);
    //get element at given position
    string element = vec[3];
    //update element
    vec[3] = "hh";
    //remove last element
    vec.RemoveAt(vec.Count - 1);
    //remove element at given position
    vec.RemoveAt(3);
    //remove a range of elements at given position
    vec.RemoveRange(1, 3);
  }

  public static bool TestAll() {
    bool ret = true;
    List<int> c, c1, c2, c3, c4, c5, c6, c7, c8, c9, c10;
    List<int> vec = new List<int> { 2, 4, 3, 1, 5 };
    c = new List<int>(new List<int> { 1, 2, 3, 4, 5 });
    c2 = new List<int>(c);
    if (c.Count >= 10) {
      c.RemoveRange(10, vec.Count);
    } else {
      c.AddRange(Enumerable.Repeat(0, 10 - vec.Count));
    }

    c3 = new List<int>(c);
    c.Clear();
    c1 = new List<int>(c);
    c.AddRange(vec);
    c4 = new List<int>(c);
    c.InsertRange(1, vec);
    c5 = new List<int>(c);
    c.Insert(1, -1);
    c6 = new List<int>(c);
    c.Add(10);
    c7 = new List<int>(c);
    c.RemoveAt(3);
    c8 = new List<int>(c);
    c.RemoveAt(c.Count - 1);
    c9 = new List<int>(c);
    c.RemoveRange(1, 3 - 1);
    c10 = new List<int>(c);
    ret = c1.Count == 0
          && c.Contains(3)
          && c7.Count == 12
          && c[2] == 1
          && c2.SequenceEqual(new List<int> { 1, 2, 3, 4, 5 })
          && c3.SequenceEqual(new List<int> { 1, 2, 3, 4, 5, 0, 0, 0, 0, 0 })
          && c4.SequenceEqual(new List<int> { 2, 4, 3, 1, 5 })
          && c5.SequenceEqual(new List<int> { 2, 2, 4, 3, 1, 5, 4, 3, 1, 5 })
          && c6.SequenceEqual(new List<int> { 2, -1, 2, 4, 3, 1, 5, 4, 3, 1, 5 })
          && c7.SequenceEqual(new List<int> { 2, -1, 2, 4, 3, 1, 5, 4, 3, 1, 5, 10 })
          && c8.SequenceEqual(new List<int> { 2, -1, 2, 3, 1, 5, 4, 3, 1, 5, 10 })
          && c9.SequenceEqual(new List<int> { 2, -1, 2, 3, 1, 5, 4, 3, 1, 5 })
          && c10.SequenceEqual(new List<int> { 2, 3, 1, 5, 4, 3, 1, 5 });
    if (!ret)
      Console.WriteLine("Vector Test Failed!");
    return ret;
  }
}