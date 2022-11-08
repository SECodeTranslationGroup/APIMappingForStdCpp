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
    bool b1 = queue.SequenceEqual(queue1);
    //get first element
    string element = queue.First();
    //get last element
    element = queue.Last();
  }
  
  public static bool TestAll() {
    bool ret = true;
    Queue<int> c, c1, c2, c3, c4;
    c1 = new Queue<int>();
    c = new Queue<int>(new List<int> {2, 4, 3, 1, 5});
    c2 = new Queue<int>(c);
    c.Enqueue(6);
    c3 = new Queue<int>(c);
    c.Dequeue();
    c4 = new Queue<int>(c);
    ret = c1.Count == 0
          && c4.Count == 5
          && c.First() == 4
          && c.Last() == 6
          && c2.SequenceEqual(
              new Queue<int>(new List<int> { 2, 4, 3, 1, 5 }))
          && c3.SequenceEqual(
              new Queue<int>(new List<int> { 2, 4, 3, 1, 5, 6 }))
          && c4.SequenceEqual(
              new Queue<int>(new List<int> { 4, 3, 1, 5, 6 }));
    if (!ret)
      Console.WriteLine("Queue Test Failed!");
    return ret;
  }
}