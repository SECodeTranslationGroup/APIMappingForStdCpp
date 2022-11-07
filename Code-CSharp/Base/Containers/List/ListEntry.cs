using System.Collections.Immutable;
using System.Collections.ObjectModel;

namespace CodeCsharp.Base.Containers.List;

public class ListEntry {
  public static void ListProgram() {
    //initialize a list
    LinkedList<string> list = new LinkedList<string>();
    //initialize a list with value
    LinkedList<string> list1 = new LinkedList<string>(new[] { "aa", "bb", "cc", "dd" });
    //copy list
    list = new LinkedList<string>(list1);
    //resize list, trunc additional size or fill with default value
    if (list.Count >= 20)
      for (int i = 0; i < list.Count - 20; i++)
        list.RemoveLast();
    else
      for (int i = 0; i < 20 - list.Count; i++)
        list.AddLast("");
    //whether list is empty
    bool isEmpty = list.Count == 0;
    //clear list
    list.Clear();
    //insert element at begin
    list.AddFirst("ee");
    //insert element at end
    list.AddLast("ee");
    //insert element at given position
    var node = list.First;
    for (int i = 0; i < 1; i++)
      node = node.Next;
    list.AddBefore(node, "ff");
    //initialize a vector contains values
    List<string> vec = new List<string> { "aa", "bb", "cc", "dd" };
    //insert a range of elements at end
    foreach (var str in vec) list.AddLast(str);
    //insert a range of elements at given position
    node = list.First;
    for (int i = 0; i < 1; i++)
      node = node.Next;
    foreach (var str in vec) list.AddBefore(node, str);
    //get size of list
    int size = list.Count;
    //whether list contains element
    bool b1 = list.Contains("bb");
    //create immutable reference of list
    ImmutableList<string> constListRef = list.ToImmutableList();
    //whether two lists equal
    bool b2 = Enumerable.SequenceEqual(list, constListRef);
    //get first element
    string element = list.First();
    //get last element
    element = list.Last();
    //remove first element
    list.RemoveFirst();
    //remove last element
    list.RemoveLast();
    //remove element at given position
    node = list.First;
    for (int i = 0; i < 3; i++)
      node = node.Next;
    list.Remove(node);
    //remove a range of elements at given position
    node = list.First;
    for (int i = 0; i < 1; i++)
      node = node.Next;
    var nextNode = node;
    for (int i = 1; i < list.Count - 1; i++)
      nextNode = node.Next;
    list.Remove(node);
    node = nextNode;
    //sort list
    list = new LinkedList<string>(list.OrderBy(s => s));
    //reverse list
    list.Reverse();
    //remove first elements equal value
    list.Remove("ff");
    //remove all elements equal value
    while(list.Remove("ff"));
    //remove all elements satisfy condition
    for (node = list.First; node != null;) {
      nextNode = node.Next;
      if (string.CompareOrdinal(node.Value,"dd")>0) list.Remove(node);
      node = nextNode;
    }
  }
  public static bool TestAll() {
    bool ret = true;
    if (!ret)
      Console.WriteLine("List Test Failed!");
    return ret;
  }
}