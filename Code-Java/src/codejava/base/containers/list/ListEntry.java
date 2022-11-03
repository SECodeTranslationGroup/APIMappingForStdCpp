package codejava.base.containers.list;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ListEntry {
  public static void ListProgram() {
    LinkedList<String> list = new LinkedList<>();
    LinkedList<String> list1 = new LinkedList<>(Arrays.asList("aa", "bb", "cc", "dd"));
    list = new LinkedList<>(list1);
    if (list.size() >= 20)
      list.subList(20, list.size()).clear();
    else
      list.addAll(Collections.nCopies(20 - list.size(), ""));

    boolean isEmpty = list.isEmpty();
    list.clear();

    list.addFirst("ee");
    list.addLast("ee");
    list.add(1, "ff");

    List<String> vec = Arrays.asList("aa", "bb", "cc", "dd");
    list.addAll(vec);
    list.addAll(1, vec);

    int size = list.size();

    boolean b1 = list.contains("bb");
    List<String> constListRef = Collections.unmodifiableList(list);
    boolean b2 = list.equals(constListRef);
    String element = list.getFirst();
    element = list.getLast();

    list.removeFirst();
    list.removeLast();
    list.remove(3);
    list.subList(1, list.size() - 1).clear();

    list.sort(null);
    Collections.reverse(list);
    list.remove("ff");
    list.removeIf(e -> e.compareTo("dd") > 0);
  }
}
