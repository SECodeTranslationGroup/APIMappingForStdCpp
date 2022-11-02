package codejava.base.containers.vector;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class VectorEntry {
  public static void VectorProgram() {
    List<String> vec = new ArrayList<>();
    List<String> vec1 = Arrays.asList("aa", "bb", "cc", "dd");

    vec = new ArrayList<>(Collections.nCopies(10, ""));
    if (vec.size() >= 20) {
      vec.subList(20, vec.size()).clear();
    } else {
      vec.addAll(Collections.nCopies(20 - vec.size(), ""));
    }

    boolean isEmpty = vec.isEmpty();
    vec.clear();

    vec.add("ee");
    vec.add(1, "ff");
    vec.addAll(vec1);
    vec.addAll(1, vec1);

    int size = vec.size();

    boolean b1 = vec.contains("gg");
    List<String> constVecRef = Collections.unmodifiableList(vec);
    boolean b3 = vec.equals(constVecRef);
    String element = vec.get(3);
    vec.set(3, "hh");

    vec.remove(vec.size() - 1);
    vec.remove(3);
    vec.subList(1, 3).clear();
  }
}
