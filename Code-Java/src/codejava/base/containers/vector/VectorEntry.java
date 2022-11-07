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

  public static boolean testAll() {
    boolean ret = true;
    ArrayList<Integer> c, c1, c2, c3, c4, c5, c6, c7, c8, c9, c10;
    List<Integer> vec = Arrays.asList(2, 4, 3, 1, 5);
    c = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
    c2 = new ArrayList<>(c);
    if (c.size() >= 10) {
      c.subList(10, c.size()).clear();
    } else {
      c.addAll(Collections.nCopies(10 - c.size(), 0));
    }
    c3 = new ArrayList<>(c);
    c.clear();
    c1 = new ArrayList<>(c);
    c.addAll(vec);
    c4 = new ArrayList<>(c);
    c.addAll(1,vec);
    c5 = new ArrayList<>(c);
    c.add(1, -1);
    c6 = new ArrayList<>(c);
    c.add(10);
    c7 = new ArrayList<>(c);
    c.remove( 3);
    c8 = new ArrayList<>(c);
    c.remove(c.size()-1);
    c9 = new ArrayList<>(c);
    c.subList(1,3).clear();
    c10 = new ArrayList<>(c);
    ret = c1.isEmpty()
        && c.contains(3)
        && c7.size() == 12
       && c.get(2) == 1
        && c2.equals(Arrays.asList(1, 2, 3, 4, 5))
      && c3 .equals(Arrays.asList(1, 2, 3, 4, 5, 0, 0, 0, 0, 0))
      && c4 .equals(Arrays.asList(2, 4, 3, 1, 5))
      && c5 .equals(Arrays.asList(2, 2, 4, 3, 1, 5, 4, 3, 1, 5))
      && c6 .equals(Arrays.asList(2, -1, 2, 4, 3, 1, 5, 4, 3, 1, 5))
      && c7 .equals(Arrays.asList(2, -1, 2, 4, 3, 1, 5, 4, 3, 1, 5, 10))
      && c8 .equals(Arrays.asList(2, -1, 2, 3, 1, 5, 4, 3, 1, 5, 10))
      && c9 .equals(Arrays.asList(2, -1, 2, 3, 1, 5, 4, 3, 1, 5))
      && c10 .equals(Arrays.asList(2, 3, 1, 5, 4, 3, 1, 5));
    if (!ret)
      System.out.println("Vector Test Failed!");
    return ret;
  }
}
