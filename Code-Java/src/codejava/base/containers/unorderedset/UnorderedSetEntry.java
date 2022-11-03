package codejava.base.containers.unorderedset;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UnorderedSetEntry {
  public static void UnorderedSetProgram() {
    HashSet<String> hashSet = new HashSet<>();
    HashSet<String> hashSet1 = new HashSet<>(Arrays.asList("aa", "bb", "cc", "dd"));
    hashSet = new HashSet<>(hashSet1);

    boolean isEmpty = hashSet.isEmpty();
    hashSet.clear();

    hashSet.add("ee");

    List<String> vec = Arrays.asList("aa", "bb", "cc", "dd");
    hashSet.addAll(vec);

    int size = hashSet.size();

    boolean b1 = hashSet.contains("bb");
    Set<String> constSetRef = Collections.unmodifiableSet(hashSet);
    boolean b2 = hashSet.equals(constSetRef);

    hashSet.remove("cc");
  }
}
