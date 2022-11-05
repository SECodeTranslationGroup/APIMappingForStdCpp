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
    //removes element equal key
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
}
