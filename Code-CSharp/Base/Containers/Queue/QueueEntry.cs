namespace CodeCsharp.Base.Containers.Queue;

public class QueueEntry {
  public static void QueueProgram() {
    //initialize a queue
    Queue<string> queue = new Queue<string>();
    //initialize a queue with value
    Queue<string> queue1 = new Queue<string>(new[] { "aa", "bb", "cc", "dd" });
    //copy queue
    queue = new Queue<string>(queue1);
    //whether queue is empty
    bool isEmpty = queue.Count == 0;
    //clear queue
    queue.Clear();
    //insert element at last
    queue.Enqueue("ee");
    //remove first element
    queue.Dequeue();
    //get size of queue
    int size = queue.Count;
    //whether two queues equal
    bool b1 = queue.Equals(queue1);
    //get first element
    string element = queue.First();
    //get last element
    element = queue.Last();
  }
}