package codejava.base.containers.set;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class SetEntry {
  public static void SetProgram() {
    //initialize a set
    TreeSet<String> set = new TreeSet<>();
    //initialize a set with value
    TreeSet<String> set1 = new TreeSet<>(Arrays.asList("aa", "bb", "cc", "dd"));
    //copy set
    set = new TreeSet<>(set1);
    //whether set is empty
    boolean isEmpty = set.isEmpty();
    //clear set
    set.clear();
    //insert element
    set.add("ee");
    //initialize a vector contains values
    List<String> vec = Arrays.asList("aa", "bb", "cc", "dd");
    //insert a range of elements
    set.addAll(vec);
    //get size of set
    int size = set.size();
    //whether set contains element
    boolean b1 = set.contains("bb");
    //create immutable reference of set
    Set<String> constSetRef = Collections.unmodifiableSet(set);
    //whether two sets equal
    boolean b2 = set.equals(constSetRef);
    //remove element equal value
    set.remove("cc");
    //initialize result set for calculation
    TreeSet<String> resultSet = new TreeSet<>(set);
    //set difference
    resultSet.removeAll(set1);
    //set union
    resultSet = new TreeSet<>(set);
    resultSet.addAll(set1);
    //set intersection
    resultSet = new TreeSet<>(set);
    resultSet.retainAll(set1);
    //set symmetric difference
    resultSet = new TreeSet<>(set);
    resultSet.addAll(set1);
    TreeSet<String> tmpSet = new TreeSet<>(set);
    tmpSet.retainAll(set1);
    resultSet.removeAll(tmpSet);
    //initialize set for subset
    SortedSet<String> subset;
    //create a subset from given range
    subset = set.subSet("bb", "dd");
    //create a subset greater than given value
    subset = set.tailSet("bb");
    //create a subset less than given value
    subset = set.headSet("dd");
    //get optional of first value lower or equal given value
    Optional<String> result = Optional.ofNullable(set.floor("cc"));
    //get optional of first value greater or equal given value
    result = Optional.ofNullable(set.ceiling("cc"));
  }

  public static boolean testAll() {
    boolean ret = true;
    TreeSet<Integer> c, c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11;
    List<Integer> vec = Arrays.asList(1, 3, 5, 7, 9);
    c = new TreeSet<>(Arrays.asList(1, 2, 3, 4, 5));
    c2 = new TreeSet<>(c);
    c.clear();
    c1 = new TreeSet<>(c);
    c.addAll(vec);
    c3 = new TreeSet<>(c);
    c.remove(3);
    c4 = new TreeSet<>(c);
    c5 = new TreeSet<>(c);
    c5.removeAll(c2);
    c6 = new TreeSet<>(c);
    c6.addAll(c2);
    c7 = new TreeSet<>(c);
    c7.retainAll(c2);
    c8 = new TreeSet<>(c);
    c8.addAll(c2);
    c8.removeAll(c7);
    c9 = (TreeSet<Integer>) c.subSet(5, 9);
    c10 = (TreeSet<Integer>) c.tailSet(5);
    c11 = (TreeSet<Integer>) c.headSet(9);

    ret = c1.isEmpty()
        && c.contains(7)
        && c6.size() == 7
        && c.floor(6) == 5
        && c.ceiling(6) == 7
        && c2.equals(new TreeSet<>(Arrays.asList(1, 2, 3, 4, 5)))
        && c3.equals(new TreeSet<>(Arrays.asList(1, 3, 5, 7, 9)))
        && c4.equals(new TreeSet<>(Arrays.asList(1, 5, 7, 9)))
        && c5.equals(new TreeSet<>(Arrays.asList(7, 9)))
        && c6.equals(new TreeSet<>(Arrays.asList(1, 2, 3, 4, 5, 7, 9)))
        && c7.equals(new TreeSet<>(Arrays.asList(1, 5)))
        && c8.equals(new TreeSet<>(Arrays.asList(2, 3, 4, 7, 9)))
        && c9.equals(new TreeSet<>(Arrays.asList(5, 7)))
        && c10.equals(new TreeSet<>(Arrays.asList(5, 7, 9)))
        && c11.equals(new TreeSet<>(Arrays.asList(1, 5, 7)));
    if (!ret)
      System.out.print("Set Test Failed!");
    return ret;
  }
}
