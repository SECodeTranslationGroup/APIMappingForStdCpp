package codejava.base.containers.unorderedmap;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class UnorderedMapEntry {
  public static void MapProgram() {
    //initialize a hash map
    HashMap<String, String> hashMap = new HashMap<>();
    //initialize a hash map with value
    HashMap<String, String> hashMap1 = new HashMap<>(Map.of("aa", "a",
        "bb", "b", "cc", "c", "dd", "d"));
    //copy hash map
    hashMap = new HashMap<>(hashMap1);
    //whether hash map is empty
    boolean isEmpty = hashMap.isEmpty();
    //clear hash map
    hashMap.clear();
    //insert element if not exist
    hashMap.putIfAbsent("ee", "e");
    //insert or update element
    hashMap.put("ee", "e2");
    //initialize a hash map contains values
    Map<String, String> vec = Map.of("aa", "a",
        "bb", "b", "cc", "c", "dd", "d");
    //insert a range of elements if not exist
    for (var ent : vec.entrySet())
      hashMap.putIfAbsent(ent.getKey(), ent.getValue());
    //insert or update a range of elements
    hashMap.putAll(vec);
    //get size of hash map
    int size = hashMap.size();
    //whether hash map contains element
    boolean b1 = hashMap.containsKey("bb");
    //create immutable reference of hash map
    Map<String, String> constHashMapRef = Collections.unmodifiableMap(hashMap);
    //whether two hash maps equal
    boolean b2 = hashMap.equals(constHashMapRef);
    //remove element equal key
    hashMap.remove("cc");
    //get value of key or else default
    String defaultResult = hashMap.getOrDefault("cc", "default");
    //get optional value of key
    Optional<String> result = Optional.ofNullable(hashMap.get("cc"));
  }

  public static boolean testAll() {
    boolean ret = true;
    HashMap<Integer, Integer> c, c1, c2, c3, c4, c5, c6, c7, c8;
    HashMap<Integer, Integer> m = new HashMap<>(Map.of(
        1, 10, 2, 8, 3, 13, 4, 9));
    c = new HashMap<>(Map.of(
        1, 10, 2, 8, 3, 13, 4, 9));
    c.clear();
    c1 = new HashMap<>(c);
    c = new HashMap<>(m);
    c2 = new HashMap<>(c);
    c.putIfAbsent(2, 10);
    c3 = new HashMap<>(c);
    c.putIfAbsent(5, 10);
    c4 = new HashMap<>(c);
    c.put(2, 10);
    c5 = new HashMap<>(c);
    m = new HashMap<>(Map.of(
        0, 3, 1, 8, 2, 7, 10, 3));
    for (var ent : m.entrySet())
      c.putIfAbsent(ent.getKey(), ent.getValue());
    c6 = new HashMap<>(c);
    c.putAll(m);
    c7 = new HashMap<>(c);
    c.remove(2);
    c8 = new HashMap<>(c);
    ret = c1.isEmpty()
        && c.containsKey(3)
        && c.get(3) == 13
        && c2.equals(Map.of(1, 10, 2, 8, 3, 13, 4, 9))
        && c3.equals(Map.of(1, 10, 2, 8, 3, 13, 4, 9))
        && c4.equals(Map.of(1, 10, 2, 8, 3, 13, 4, 9, 5, 10))
        && c5.equals(Map.of(1, 10, 2, 10, 3, 13, 4, 9, 5, 10))
        && c6.equals(Map.of(0, 3, 1, 10, 2, 10, 3, 13, 4, 9, 5, 10, 10, 3))
        && c7.equals(Map.of(0, 3, 1, 8, 2, 7, 3, 13, 4, 9, 5, 10, 10, 3))
        && c8.equals(Map.of(0, 3, 1, 8, 3, 13, 4, 9, 5, 10, 10, 3))    ;
    if (!ret)
      System.out.print("Unordered Map Test Failed!");
    return ret;
  }
}
