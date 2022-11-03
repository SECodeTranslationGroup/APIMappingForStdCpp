namespace CodeCsharp.Base.Containers.Queue;

public class QueueEntry {
  public static void QueueProgram() {
    Queue<string> queue = new Queue<string>();
    Queue<string> queue1 = new Queue<string>(new[] { "aa", "bb", "cc", "dd" });
    queue = new Queue<string>(queue1);
    
    bool isEmpty = queue.Count == 0;
    queue.Clear();
    
    queue.Enqueue("ee");
    queue.Dequeue();
    
    int size = queue.Count;
    
    bool b1 = queue.Equals(queue1);
    
    string element = queue.First();
    element = queue.Last();
  }
}