namespace CodeCsharp.Base.Containers.PriorityQueue;

public class PriorityQueueEntry {
  public static void PriorityQueueProgram() {
    //initialize a priority queue
    PriorityQueue<string,string> heap = new PriorityQueue<string,string>();
    //initialize a priority queue with value
    List<string> tmpVec = new List<string> { "aa", "bb", "cc", "dd" };
    PriorityQueue<string,string> heap1 = new PriorityQueue<string,string>(
        tmpVec.Select(i => ValueTuple.Create(i, i)),
        StringComparer.Ordinal);
    //copy priority queue
    heap = new PriorityQueue<string,string>(heap1.UnorderedItems);
    //whether priority queue is empty
    bool isEmpty = heap.Count == 0;
    //clear priority queue
    heap.Clear();;
    //insert element
    heap.Enqueue("ee","ee");
    //remove smallest element
    heap.Dequeue();
    //get size of priority queue
    int size = heap.Count;
    //get smallest element
    string element = heap.Peek();
  }
}