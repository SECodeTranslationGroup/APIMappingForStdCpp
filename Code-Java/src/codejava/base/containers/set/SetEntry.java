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
    TreeSet<String> set = new TreeSet<>();
    TreeSet<String> set1 = new TreeSet<>(Arrays.asList("aa", "bb", "cc", "dd"));
    set = new TreeSet<>(set1);

    boolean isEmpty = set.isEmpty();
    set.clear();
    set.add("ee");

    List<String> vec = Arrays.asList("aa", "bb", "cc", "dd");
    set.addAll(vec);

    int size = set.size();

    boolean b1 = set.contains("bb");
    Set<String> constSetRef = Collections.unmodifiableSet(set);
    boolean b2 = set.equals(constSetRef);

    set.remove("cc");

    TreeSet<String> resultSet = new TreeSet<>(set);
    resultSet.removeAll(set1);
    resultSet = new TreeSet<>(set);
    resultSet.addAll(set1);
    resultSet = new TreeSet<>(set);
    resultSet.retainAll(set1);
    resultSet = new TreeSet<>(set);
    resultSet.addAll(set1);
    TreeSet<String> tmpSet = new TreeSet<>(set);
    tmpSet.retainAll(set1);
    resultSet.removeAll(tmpSet);

    SortedSet<String> subset;
    subset = set.subSet("bb","dd");
    subset = set.tailSet("bb");
    subset = set.headSet("dd");

    Optional<String> result = Optional.ofNullable(set.floor("cc"));
    result = Optional.ofNullable(set.ceiling("cc"));
  }
}
