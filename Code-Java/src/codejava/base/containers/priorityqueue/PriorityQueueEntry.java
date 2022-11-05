package codejava.base.containers.priorityqueue;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class PriorityQueueEntry {
  public static void PriorityQueueProgram() {
    //initialize a priority queue
    PriorityQueue<String> heap = new PriorityQueue<>();
    //initialize a priority queue with value
    List<String> tmpVec = Arrays.asList("aa", "bb", "cc", "dd");
    PriorityQueue<String> heap1 = new PriorityQueue<>(String::compareTo);
    heap1.addAll(tmpVec);
    //copy priority queue
    heap = new PriorityQueue<>(heap1);
    //whether priority queue is empty
    boolean isEmpty = heap.isEmpty();
    //clear priority queue
    heap.clear();
    //insert element
    heap.add("ee");
    //remove smallest element
    heap.remove();
    //get size of priority queue
    int size = heap.size();
    //get smallest element
    String element = heap.peek();
  }
}
