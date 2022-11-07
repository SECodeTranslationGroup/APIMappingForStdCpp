namespace CodeCsharp.Base.Containers.PriorityQueue;

public class PriorityQueueEntry {
  public static void PriorityQueueProgram() {
    //initialize a priority queue
    PriorityQueue<string, string> heap = new PriorityQueue<string, string>();
    //initialize a priority queue with value
    List<string> tmpVec = new List<string> { "aa", "bb", "cc", "dd" };
    PriorityQueue<string, string> heap1 = new PriorityQueue<string, string>(
        tmpVec.Select(i => ValueTuple.Create(i, i)),
        StringComparer.Ordinal);
    //copy priority queue
    heap = new PriorityQueue<string, string>(heap1.UnorderedItems);
    //whether priority queue is empty
    bool isEmpty = heap.Count == 0;
    //clear priority queue
    heap.Clear();
    //insert element
    heap.Enqueue("ee", "ee");
    //remove smallest element
    heap.Dequeue();
    //get size of priority queue
    int size = heap.Count;
    //get smallest element
    string element = heap.Peek();
  }

  public static bool EqualPQ(PriorityQueue<int, int> a,
      PriorityQueue<int, int> b) {
    if (a.Count != b.Count) return false;
    for (int i = 0; i < a.Count; i++) {
      if (a.Peek() != b.Peek()) return false;
      a.Dequeue();
      b.Dequeue();
    }

    return true;
  }

  public static bool TestAll() {
    bool ret = true;
    PriorityQueue<int, int> c, c1, c2, c3, c4;
    List<int> vec = new List<int> { 2, 4, 3, 1, 5 };
    c1 = new PriorityQueue<int, int>();
    c = new PriorityQueue<int, int>(vec.Select(i => ValueTuple.Create(i, i)));
    c2 = new PriorityQueue<int, int>(c.UnorderedItems);
    c.Dequeue();
    c3 = new PriorityQueue<int, int>(c.UnorderedItems);
    c.Enqueue(0, 0);
    c4 = new PriorityQueue<int, int>(c.UnorderedItems);
    ret = c1.Count == 0
          && c4.Count == 5
          && c.Peek() == 0
          && EqualPQ(c2, new PriorityQueue<int, int>(new List<int> { 1, 2, 3, 4, 5 }
              .Select(i => ValueTuple.Create(i, i))))
          && EqualPQ(c3, new PriorityQueue<int, int>(new List<int> { 2, 3, 4, 5 }
              .Select(i => ValueTuple.Create(i, i))))
          && EqualPQ(c4, new PriorityQueue<int, int>(new List<int> { 0, 2, 3, 4, 5 }
              .Select(i => ValueTuple.Create(i, i))));
    if (!ret)
      Console.WriteLine("Priority Queue Test Failed!");
    return ret;
  }
}