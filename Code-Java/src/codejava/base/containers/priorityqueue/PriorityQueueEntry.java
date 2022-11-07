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

  public static boolean equalPQ(PriorityQueue<Integer> a,
      PriorityQueue<Integer> b){
    if (a.size() != b.size()) return false;
    for(int i = 0; i <a.size();i++) {
      if (a.peek() != b.peek()) return false;
      a.remove();b.remove();
    }
    return true;
  }

  public static boolean testAll() {
    boolean ret = true;
    PriorityQueue<Integer> c, c1, c2, c3, c4;
    List<Integer> vec = Arrays.asList(2, 4, 3, 1, 5);
    c1 = new PriorityQueue<>();
    c =  new PriorityQueue<>(vec);
    c2 = new PriorityQueue<>(c);
    c.remove();
    c3 = new PriorityQueue<>(c);
    c.add(0);
    c4 = new PriorityQueue<>(c);
    ret = c1.isEmpty()
        && c4.size() == 5
        && c.peek() == 0
        && equalPQ(c2,new PriorityQueue<Integer>(Arrays.asList(1, 2, 3, 4, 5)))
        && equalPQ(c3,new PriorityQueue<Integer>(Arrays.asList(2, 3, 4, 5)))
        && equalPQ(c4,new PriorityQueue<Integer>(Arrays.asList(0, 2, 3, 4, 5)));
    if (!ret)
      System.out.println("Prior Queue Test Failed!");
    return ret;
  }
}
