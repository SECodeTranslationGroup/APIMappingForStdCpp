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
    int count = list.Count;
    if (count >= 20)
      for (int i = 0; i < count- 20; i++)
        list.RemoveLast();
    else
      for (int i = 0; i < 20 - count; i++)
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
    count = list.Count;
    for (int i = 1; i < count - 1; i++) {
      nextNode = node.Next;
      list.Remove(node);
      node = nextNode;
    }

    //sort list
    list = new LinkedList<string>(list.OrderBy(s => s));
    //reverse list
    list = new LinkedList<string>(list.Reverse());
    //remove first elements equal value
    list.Remove("ff");
    //remove all elements equal value
    while (list.Remove("ff")) ;
    //remove all elements satisfy condition
    for (node = list.First; node != null;) {
      nextNode = node.Next;
      if (string.CompareOrdinal(node.Value, "dd") > 0) list.Remove(node);
      node = nextNode;
    }
  }

  public static bool TestAll() {
    bool ret = true;
    LinkedList<int> c, c1, c2, c3, c4, c5, c6, c7, c8, c9, c10;
    LinkedList<int> c11, c12, c13, c14, c15, c16, c17;
    LinkedList<int> vec = new LinkedList<int>(new[] { 2, 4, 3, 1, 5 });
    c = new LinkedList<int>(new LinkedList<int>(new[] { 1, 2, 3, 4, 5 }));
    c2 = new LinkedList<int>(c);
    int count = c.Count;
    if (c.Count >= 10)
      for (int i = 0; i < count - 10; i++)
        c.RemoveLast();
    else
      for (int i = 0; i < 10 - count; i++)
        c.AddLast(0);
    c3 = new LinkedList<int>(c);
    c.Clear();
    c1 = new LinkedList<int>(c);
    foreach (var i in vec) c.AddLast(i);
    c4 = new LinkedList<int>(c);
    var node = c.First;
    for (int i = 0; i < 1; i++)
      node = node.Next;
    foreach (var i in vec) c.AddBefore(node, i);
    c5 = new LinkedList<int>(c);
    c.AddFirst(-1);
    c6 = new LinkedList<int>(c);
    c.AddLast(10);
    c7 = new LinkedList<int>(c);
    c.RemoveFirst();
    c8 = new LinkedList<int>(c);
    c.RemoveLast();
    c9 = new LinkedList<int>(c);
    node = c.First;
    for (int i = 0; i < 3; i++)
      node = node.Next;
    c.Remove(node);
    c10 = new LinkedList<int>(c);
    node = c.First;
    for (int i = 0; i < 3; i++)
      node = node.Next;
    var nextNode = node;
    count = c.Count;
    for (int i = 3; i < count - 3; i++) {
      nextNode = node.Next;
      c.Remove(node);
      node = nextNode;
    }
    c11 = new LinkedList<int>(c);
    c = new LinkedList<int>(c.OrderBy(s => s));
    c12 = new LinkedList<int>(c);
    c = new LinkedList<int>(c.Reverse());
    c13 = new LinkedList<int>(c);
    
    node = c.First;
    for (int i = 0; i < 1; i++)
      node = node.Next;
    c.AddBefore(node, 2);
    c14 = new LinkedList<int>(c);
    c.Remove(2);
    c15 = new LinkedList<int>(c);
    while (c.Remove(2)) ;
    c16 = new LinkedList<int>(c);
    for (node = c.First; node != null;) {
      nextNode = node.Next;
      if (node.Value > 3) c.Remove(node);
      node = nextNode;
    }
    c17 = new LinkedList<int>(c);
    ret = c1.Count == 0
          && c.Contains(3)
          && c7.Count == 12
          && c.First() == 3
          && c.Last() == 1
        && c2.SequenceEqual(new LinkedList<int>(new[] { 1, 2, 3, 4, 5 }))
        && c3.SequenceEqual(new LinkedList<int>(new[] { 1, 2, 3, 4, 5, 0, 0, 0, 0, 0 }))
        && c4.SequenceEqual(new LinkedList<int>(new[] { 2, 4, 3, 1, 5 }))
        && c5.SequenceEqual(new LinkedList<int>(new[] { 2, 2, 4, 3, 1, 5, 4, 3, 1, 5 }))
        && c6.SequenceEqual(new LinkedList<int>(new[] { -1, 2, 2, 4, 3, 1, 5, 4, 3, 1, 5 }))
        && c7.SequenceEqual(new LinkedList<int>(new[] { -1, 2, 2, 4, 3, 1, 5, 4, 3, 1, 5, 10 }))
        && c8.SequenceEqual(new LinkedList<int>(new[] { 2, 2, 4, 3, 1, 5, 4, 3, 1, 5, 10 }))
        && c9.SequenceEqual(new LinkedList<int>(new[] { 2, 2, 4, 3, 1, 5, 4, 3, 1, 5 }))
        && c10.SequenceEqual(new LinkedList<int>(new[] { 2, 2, 4, 1, 5, 4, 3, 1, 5 }))
        && c11.SequenceEqual(new LinkedList<int>(new[] { 2, 2, 4, 3, 1, 5 }))
        && c12.SequenceEqual(new LinkedList<int>(new[] { 1, 2, 2, 3, 4, 5 }))
        && c13.SequenceEqual(new LinkedList<int>(new[] { 5, 4, 3, 2, 2, 1 }))
        && c14.SequenceEqual(new LinkedList<int>(new[] { 5, 2, 4, 3, 2, 2, 1 }))
        && c15.SequenceEqual(new LinkedList<int>(new[] { 5, 4, 3, 2, 2, 1 }))
        && c16.SequenceEqual(new LinkedList<int>(new[] { 5, 4, 3, 1 }))
        && c17.SequenceEqual(new LinkedList<int>(new[] { 3, 1 }));
    if (!ret)
      Console.WriteLine("List Test Failed!");
    return ret;
  }
}