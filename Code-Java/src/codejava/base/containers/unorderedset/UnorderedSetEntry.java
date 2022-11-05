package codejava.base.containers.unorderedset;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
}
