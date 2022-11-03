package codejava.base.containers.priorityqueue;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class PriorityQueueEntry {
  public static void PriorityQueueProgram() {
    PriorityQueue<String> heap = new PriorityQueue<>();
    List<String> tmpVec = Arrays.asList("aa", "bb", "cc", "dd");
    PriorityQueue<String> heap1 = new PriorityQueue<>(String::compareTo);
    heap1.addAll(tmpVec);
    heap = new PriorityQueue<>(heap1);

    boolean isEmpty = heap.isEmpty();
    heap.clear();

    heap.add("ee");
    heap.remove();

    int size = heap.size();

    String element = heap.peek();
  }
}
