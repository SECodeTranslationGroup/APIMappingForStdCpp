package codejava.base.containers.unorderedmap;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

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
    //removes element equal key
    hashMap.remove("cc");
    //get value of key or else default
    String defaultResult = hashMap.getOrDefault("cc", "default");
    //get optional value of key
    Optional<String> result = Optional.ofNullable(hashMap.get("cc"));
  }
}
