package codejava.base.vector;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class VectorEntry {
  public static void VectorProgram() {
    List<String> vec = new ArrayList<>();
    List<String> vec1 = Arrays.asList("aa", "bb", "cc", "dd");

    vec = new ArrayList<>(Collections.nCopies(10,""));
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
    vec.set(3,"hh");

    int index = vec.indexOf("bb");
    int lastIndex = vec.lastIndexOf("bb");

    vec.remove(vec.size()-1);
    vec.remove(3);

    vec.remove("cc");

    vec.removeIf(e->e.equals("cc"));
    vec.replaceAll(e -> e + "1");

    vec.sort(null);
    vec.sort((s1,s2)->-s1.compareTo(s2));

    List<String> sublist = vec.subList(1,2);
  }
}
