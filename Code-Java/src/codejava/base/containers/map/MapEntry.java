package codejava.base.containers.map;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class MapEntry {
  public static void MapProgram() {
    //initialize a map
    TreeMap<String, String> map = new TreeMap<>();
    //initialize a map with value
    TreeMap<String, String> map1 = new TreeMap<>(Map.of("aa", "a",
        "bb", "b", "cc", "c", "dd", "d"));
    //copy map
    map = new TreeMap<>(map1);
    //whether map is empty
    boolean isEmpty = map.isEmpty();
    //clear map
    map.clear();
    //insert element if not exist
    map.putIfAbsent("ee", "e");
    //insert or update element
    map.put("ee", "e2");
    //initialize a map contains values
    Map<String, String> vec = Map.of("aa", "a",
        "bb", "b", "cc", "c", "dd", "d");
    //insert a range of elements if not exist
    for (var ent : vec.entrySet())
      map.putIfAbsent(ent.getKey(), ent.getValue());
    //insert or update a range of elements
    map.putAll(vec);
    //get size of map
    int size = map.size();
    //whether map contains element
    boolean b1 = map.containsKey("bb");
    //create immutable reference of map
    Map<String, String> constMapRef = Collections.unmodifiableMap(map);
    //whether two maps equal
    boolean b2 = map.equals(constMapRef);
    //remove element equal key
    map.remove("cc");
    //get value of key or else default
    String defaultResult = map.getOrDefault("cc", "default");
    //get optional value of key
    Optional<String> result = Optional.ofNullable(map.get("cc"));
    //get optional value of first key lower or equal given key
    result = Optional.ofNullable(map.floorEntry("cc").getValue());
    //get optional value of first key greater or equal given key
    result = Optional.ofNullable(map.ceilingEntry("cc").getValue());
  }

  public static boolean testAll() {
    boolean ret = true;
    TreeMap<Integer, Integer> c, c1, c2, c3, c4, c5, c6, c7, c8;
    TreeMap<Integer, Integer> m = new TreeMap<>(Map.of(
        1, 10, 2, 8, 3, 13, 4, 9));
    c = new TreeMap<>(Map.of(
        1, 10, 2, 8, 3, 13, 4, 9));
    c.clear();
    c1 = new TreeMap<>(c);
    c = new TreeMap<>(m);
    c2 = new TreeMap<>(c);
    c.putIfAbsent(2, 10);
    c3 = new TreeMap<>(c);
    c.putIfAbsent(5, 10);
    c4 = new TreeMap<>(c);
    c.put(2, 10);
    c5 = new TreeMap<>(c);
    m = new TreeMap<>(Map.of(
        0, 3, 1, 8, 2, 7, 10, 3));
    for (var ent : m.entrySet())
      c.putIfAbsent(ent.getKey(), ent.getValue());
    c6 = new TreeMap<>(c);
    c.putAll(m);
    c7 = new TreeMap<>(c);
    c.remove(2);
    c8 = new TreeMap<>(c);
    ret = c1.isEmpty()
        && c.containsKey(3)
        && c.get(3) == 13
        && c.ceilingEntry(2).getValue() == 13
        && c.floorEntry(2).getValue() == 8
        && c2.equals(Map.of(1, 10, 2, 8, 3, 13, 4, 9))
        && c3.equals(Map.of(1, 10, 2, 8, 3, 13, 4, 9))
        && c4.equals(Map.of(1, 10, 2, 8, 3, 13, 4, 9, 5, 10))
        && c5.equals(Map.of(1, 10, 2, 10, 3, 13, 4, 9, 5, 10))
        && c6.equals(Map.of(0, 3, 1, 10, 2, 10, 3, 13, 4, 9, 5, 10, 10, 3))
        && c7.equals(Map.of(0, 3, 1, 8, 2, 7, 3, 13, 4, 9, 5, 10, 10, 3))
        && c8.equals(Map.of(0, 3, 1, 8, 3, 13, 4, 9, 5, 10, 10, 3))    ;
    if (!ret)
      System.out.print("Map Test Failed!");
    return ret;
  }
}
