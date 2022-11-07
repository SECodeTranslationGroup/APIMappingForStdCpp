package codejava.base.containers.queue;

import java.util.ArrayDeque;
import java.util.Arrays;

public class QueueEntry {
  public static void QueueProgram() {
    //initialize a queue
    ArrayDeque<String> queue = new ArrayDeque<>();
    //initialize a queue with value
    ArrayDeque<String> queue1 = new ArrayDeque<>(Arrays.asList("aa", "bb", "cc", "dd"));
    //copy queue
    queue = new ArrayDeque<>(queue1);
    //whether queue is empty
    boolean isEmpty = queue.isEmpty();
    //clear queue
    queue.clear();
    //insert element at last
    queue.add("ee");
    //remove first element
    queue.remove();
    //get size of queue
    int size = queue.size();
    //whether two queues equal
    boolean b1 = Arrays.equals(queue.toArray(), queue1.toArray());
    //get first element
    String element = queue.peekFirst();
    //get last element
    element = queue.peekLast();
  }

  public static boolean testAll() {
    boolean ret = true;
    ArrayDeque<Integer> c, c1, c2, c3, c4;
    c1 = new ArrayDeque<>();
    c = new ArrayDeque<Integer>(Arrays.asList(2, 4, 3, 1, 5));
    c2 = new ArrayDeque<>(c);
    c.add(6);
    c3 = new ArrayDeque<>(c);
    c.remove();
    c4 = new ArrayDeque<>(c);
    ret = c1.isEmpty()
        && c4.size() == 5
        && c.peekFirst() == 4
        && c.peekLast() == 6
        && Arrays.equals(c2.toArray(),
        new ArrayDeque<Integer>(Arrays.asList(2, 4, 3, 1, 5)).toArray())
        && Arrays.equals(c3.toArray(),
        new ArrayDeque<Integer>(Arrays.asList(2, 4, 3, 1, 5,6)).toArray())
        && Arrays.equals(c4.toArray(),
        new ArrayDeque<Integer>(Arrays.asList(4, 3, 1, 5, 6)).toArray());
    if (!ret)
      System.out.println("Queue Test Failed!");
    return ret;
  }
}
