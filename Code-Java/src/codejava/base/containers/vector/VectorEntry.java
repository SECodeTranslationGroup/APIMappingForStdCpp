package codejava.base.containers.vector;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class VectorEntry {
  public static void VectorProgram() {
    //initialize a vector
    ArrayList<String> vec = new ArrayList<>();
    //initialize a vector with value
    ArrayList<String> vec1 = new ArrayList<>(Arrays.asList("aa", "bb", "cc", "dd"));
    //copy vector
    vec =  new ArrayList<>(vec1);
    //resize vector and fill with default value
    vec = new ArrayList<>(Collections.nCopies(10, ""));
    //resize vector, trunc additional size or fill with default value
    if (vec.size() >= 20) {
      vec.subList(20, vec.size()).clear();
    } else {
      vec.addAll(Collections.nCopies(20 - vec.size(), ""));
    }
    //whether vector is empty
    boolean isEmpty = vec.isEmpty();
    //clear vector
    vec.clear();
    //insert element at end
    vec.add("ee");
    //insert element at given position
    vec.add(1, "ff");
    //insert a range of elements at end
    vec.addAll(vec1);
    //insert a range of elements at given position
    vec.addAll(1, vec1);
    //get size of list
    int size = vec.size();
    //whether list contains element
    boolean b1 = vec.contains("gg");
    //create immutable reference of list
    List<String> constVecRef = Collections.unmodifiableList(vec);
    //whether two lists equal
    boolean b2 = vec.equals(constVecRef);
    //get element at given position
    String element = vec.get(3);
    //update element
    vec.set(3, "hh");
    //remove last element
    vec.remove(vec.size() - 1);
    //remove element at given position
    vec.remove(3);
    //remove a range of elements at given position
    vec.subList(1, 3).clear();
  }
}
