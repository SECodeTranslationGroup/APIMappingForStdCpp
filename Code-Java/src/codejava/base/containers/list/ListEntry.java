package codejava.base.containers.list;

import java.util.ArrayList;
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
    while (list.remove("ff"))
      ;
    //remove all elements satisfy condition
    list.removeIf(e -> e.compareTo("dd") > 0);
  }

  public static boolean testAll() {
    boolean ret = true;
    LinkedList<Integer> c, c1, c2, c3, c4, c5, c6, c7, c8, c9, c10;
    LinkedList<Integer> c11, c12, c13, c14, c15, c16, c17;
    List<Integer> vec = Arrays.asList(2, 4, 3, 1, 5);
    c = new LinkedList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
    c2 = new LinkedList<>(c);
    if (c.size() >= 10)
      c.subList(10, c.size()).clear();
    else
      c.addAll(Collections.nCopies(10 - c.size(), 0));
    c3 = new LinkedList<>(c);
    c.clear();
    c1 = new LinkedList<>(c);
    c.addAll(vec);
    c4 = new LinkedList<>(c);
    c.addAll(1, vec);
    c5 = new LinkedList<>(c);
    c.addFirst(-1);
    c6 = new LinkedList<>(c);
    c.addLast(10);
    c7 = new LinkedList<>(c);
    c.removeFirst();
    c8 = new LinkedList<>(c);
    c.removeLast();
    c9 = new LinkedList<>(c);
    c.remove(3);
    c10 = new LinkedList<>(c);
    c.subList(3, c.size() - 3).clear();
    c11 = new LinkedList<>(c);
    c.sort(null);
    c12 = new LinkedList<>(c);
    Collections.reverse(c);
    c13 = new LinkedList<>(c);
    c.add(1, 2);
    c14 = new LinkedList<>(c);
    c.remove(Integer.valueOf(2));
    c15 = new LinkedList<>(c);
    while (c.remove(Integer.valueOf(2)))
      ;
    c16 = new LinkedList<>(c);
    c.removeIf(e -> e > 3);
    c17 = new LinkedList<>(c);
    ret = c1.isEmpty()
        && c.contains(3)
        && c7.size() == 12
        && c.getFirst() == 3
        && c.getLast() == 1
        && c2.equals(Arrays.asList(1, 2, 3, 4, 5))
        && c3.equals(Arrays.asList(1, 2, 3, 4, 5, 0, 0, 0, 0, 0))
        && c4.equals(Arrays.asList(2, 4, 3, 1, 5))
        && c5.equals(Arrays.asList(2, 2, 4, 3, 1, 5, 4, 3, 1, 5))
        && c6.equals(Arrays.asList(-1, 2, 2, 4, 3, 1, 5, 4, 3, 1, 5))
        && c7.equals(Arrays.asList(-1, 2, 2, 4, 3, 1, 5, 4, 3, 1, 5, 10))
        && c8.equals(Arrays.asList(2, 2, 4, 3, 1, 5, 4, 3, 1, 5, 10))
        && c9.equals(Arrays.asList(2, 2, 4, 3, 1, 5, 4, 3, 1, 5))
        && c10.equals(Arrays.asList(2, 2, 4, 1, 5, 4, 3, 1, 5))
        && c11.equals(Arrays.asList(2, 2, 4, 3, 1, 5))
        && c12.equals(Arrays.asList(1, 2, 2, 3, 4, 5))
        && c13.equals(Arrays.asList(5, 4, 3, 2, 2, 1))
        && c14.equals(Arrays.asList(5, 2, 4, 3, 2, 2, 1))
        && c15.equals(Arrays.asList(5, 4, 3, 2, 2, 1))
        && c16.equals(Arrays.asList(5, 4, 3, 1))
        && c17.equals(Arrays.asList(3, 1));
    if (!ret)
      System.out.print("List Test Failed!");
    return ret;
  }
}
