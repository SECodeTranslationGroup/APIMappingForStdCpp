package codejava.base.containers.unorderedset;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class UnorderedSetEntry {
  public static void UnorderedSetProgram() {
    //initialize a hash set
    HashSet<String> hashSet = new HashSet<>();
    //initialize a hash set with value
    HashSet<String> hashSet1 = new HashSet<>(Arrays.asList("aa", "bb", "cc", "dd"));
    //copy hash set
    hashSet = new HashSet<>(hashSet1);
    //whether hash set is empty
    boolean isEmpty = hashSet.isEmpty();
    //clear hash set
    hashSet.clear();
    //insert element
    hashSet.add("ee");
    //initialize a vector contains values
    List<String> vec = Arrays.asList("aa", "bb", "cc", "dd");
    //insert a range of elements
    hashSet.addAll(vec);
    //get size of hash set
    int size = hashSet.size();
    //whether hash set contains element
    boolean b1 = hashSet.contains("bb");
    //create immutable reference of hash set
    Set<String> constSetRef = Collections.unmodifiableSet(hashSet);
    //whether two hash sets equal
    boolean b2 = hashSet.equals(constSetRef);
    //remove element equal value
    hashSet.remove("cc");
  }

  public static boolean testAll() {
    boolean ret = true;
    HashSet<Integer> c, c1, c2, c3, c4;
    List<Integer> vec = Arrays.asList(1, 3, 5, 7, 9);
    c = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
    c2 = new HashSet<>(c);
    c.clear();
    c1 = new HashSet<>(c);
    c.addAll(vec);
    c3 = new HashSet<>(c);
    c.remove(3);
    c4 = new HashSet<>(c);
    ret = c1.isEmpty()
        && c.contains(7)
        && c4.size() == 4
        && c2.equals(new HashSet<>(Arrays.asList(1, 2, 3, 4, 5)))
        && c3.equals(new HashSet<>(Arrays.asList(1, 3, 5, 7, 9)))
        && c4.equals(new HashSet<>(Arrays.asList(1, 5, 7, 9)));
    if (!ret)
      System.out.println("Unordered Set Test Failed!");
    return ret;
  }
}
