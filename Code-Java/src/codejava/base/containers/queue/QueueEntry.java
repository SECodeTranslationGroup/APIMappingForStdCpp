package codejava.base.containers.queue;

import java.util.ArrayDeque;
import java.util.Arrays;

class QueueEntry {
  public static void QueueProgram() {
    ArrayDeque<String> queue = new ArrayDeque<>();
    ArrayDeque<String> queue1 = new ArrayDeque<>(Arrays.asList("aa", "bb", "cc", "dd"));
    queue = new ArrayDeque<>(queue1);

    boolean isEmpty = queue.isEmpty();
    queue.clear();

    queue.add("ee");
    queue.remove();

    int size = queue.size();

    boolean b1 = queue.equals(queue1);

    String element = queue.peekFirst();
    element = queue.peekLast();
  }
}
