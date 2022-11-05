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
    //removes element equal value
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
    subset = set.subSet("bb","dd");
    //create a subset greater than given value
    subset = set.tailSet("bb");
    //create a subset less than given value
    subset = set.headSet("dd");
    //get optional of first value lower or equal given value
    Optional<String> result = Optional.ofNullable(set.floor("cc"));
    //get optional of first value greater or equal given value
    result = Optional.ofNullable(set.ceiling("cc"));
  }
}
