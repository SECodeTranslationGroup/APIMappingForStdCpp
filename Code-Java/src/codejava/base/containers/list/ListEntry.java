package codejava.base.containers.list;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ListEntry {
  public static void ListProgram() {
    //initialize a list
    LinkedList<String> list = new LinkedList<>();
    //initialize a list with value
    LinkedList<String> list1 = new LinkedList<>(Arrays.asList("aa", "bb", "cc", "dd"));
    //copy list
    list = new LinkedList<>(list1);
    //resize list, trunc additional size or fill with default value
    if (list.size() >= 20)
      list.subList(20, list.size()).clear();
    else
      list.addAll(Collections.nCopies(20 - list.size(), ""));
    //whether list is empty
    boolean isEmpty = list.isEmpty();
    //clear list
    list.clear();
    //insert element at begin
    list.addFirst("ee");
    //insert element at end
    list.addLast("ee");
    //insert element at given position
    list.add(1, "ff");
    //initialize a vector contains values
    List<String> vec = Arrays.asList("aa", "bb", "cc", "dd");
    //insert a range of elements at end
    list.addAll(vec);
    //insert a range of elements at given position
    list.addAll(1, vec);
    //get size of list
    int size = list.size();
    //whether list contains element
    boolean b1 = list.contains("bb");
    //create immutable reference of list
    List<String> constListRef = Collections.unmodifiableList(list);
    //whether two lists equal
    boolean b2 = list.equals(constListRef);
    //get first element
    String element = list.getFirst();
    //get last element
    element = list.getLast();
    //remove first element
    list.removeFirst();
    //remove last element
    list.removeLast();
    //remove element at given position
    list.remove(3);
    //remove a range of elements at given position
    list.subList(1, list.size() - 1).clear();
    //sort list
    list.sort(null);
    //reverse list
    Collections.reverse(list);
    //remove first elements equal value
    list.remove("ff");
    //remove all elements equal value
    while (list.remove("ff"));
    //remove all elements satisfy condition
    list.removeIf(e -> e.compareTo("dd") > 0);
  }
}
