package codejava.base.containers.queue;

import java.util.ArrayDeque;
import java.util.Arrays;

class QueueEntry {
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
    boolean b1 = queue.equals(queue1);
    //get first element
    String element = queue.peekFirst();
    //get last element
    element = queue.peekLast();
  }
}
