namespace CodeCsharp.Base.Containers.PriorityQueue;

public class PriorityQueueEntry {
  public static void PriorityQueueProgram() {
    PriorityQueue<string,string> heap = new PriorityQueue<string,string>();
    List<string> tmpVec = new List<string> { "aa", "bb", "cc", "dd" };
    PriorityQueue<string,string> heap1 = new PriorityQueue<string,string>(
        tmpVec.Select(i => ValueTuple.Create(i, i)),
        StringComparer.Ordinal);
    heap = new PriorityQueue<string,string>(heap1.UnorderedItems);
    
    bool isEmpty = heap.Count == 0;
    heap.Clear();;
    
    heap.Enqueue("ee","ee");
    heap.Dequeue();
    
    int size = heap.Count;
    
    string element = heap.Peek();
  }
}