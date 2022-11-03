using System.Collections.Immutable;
using System.Collections.ObjectModel;

namespace CodeCsharp.Base.Containers.List;

public class ListEntry {
  public static void ListProgram() {
    LinkedList<string> list = new LinkedList<string>();
    LinkedList<string> list1 = new LinkedList<string>(new[] { "aa", "bb", "cc", "dd" });
    list = new LinkedList<string>(list1);
    if (list.Count >= 20)
      for (int i = 0; i < list.Count - 20; i++)
        list.RemoveLast();
    else
      for (int i = 0; i < 20 - list.Count; i++)
        list.AddLast("");

    bool isEmpty = list.Count == 0;
    list.Clear();

    list.AddFirst("ee");
    list.AddLast("ee");
    var node = list.First;
    for (int i = 0; i < 1; i++)
      node = node.Next;
    list.AddBefore(node, "ff");

    List<string> vec = new List<string> { "aa", "bb", "cc", "dd" };
    foreach (var str in vec) list.AddLast(str);
    node = list.First;
    for (int i = 0; i < 1; i++)
      node = node.Next;
    foreach (var str in vec) list.AddBefore(node, str);

    int size = list.Count;

    bool b1 = list.Contains("bb");
    ImmutableList<string> constListRef = list.ToImmutableList();
    bool b2 = Enumerable.SequenceEqual(list, constListRef);
    string element = list.First();
    element = list.Last();

    list.RemoveFirst();
    list.RemoveLast();

    node = list.First;
    for (int i = 0; i < 3; i++)
      node = node.Next;
    list.Remove(node);

    node = list.First;
    for (int i = 0; i < 1; i++)
      node = node.Next;
    var nextNode = node;
    for (int i = 0; i < list.Count - 1 - 1; i++)
      nextNode = node.Next;
    list.Remove(node);
    node = nextNode;

    list = new LinkedList<string>(list.OrderBy(s => s));
    list.Reverse();
    list.Remove("ff");
    for (node = list.First; node != null;) {
      nextNode = node.Next;
      if ((e => e > "dd")(node.Value)) list.Remove(node);
      node = nextNode;
    }
  }
}