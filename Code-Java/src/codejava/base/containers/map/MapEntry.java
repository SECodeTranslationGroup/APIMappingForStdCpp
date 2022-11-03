package codejava.base.containers.map;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Optional;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class MapEntry {
  public static void MapProgram() {
    TreeMap<String, String> map = new TreeMap<>();
    TreeMap<String, String> map1 = new TreeMap<>(Map.of("aa", "a",
        "bb", "b", "cc", "c", "dd", "d"));
    map = new TreeMap<>(map1);

    boolean isEmpty = map.isEmpty();
    map.clear();
    map.putIfAbsent("ee", "e");
    map.put("ee", "e2");

    Map<String, String> vec = Map.of("aa", "a",
        "bb", "b", "cc", "c", "dd", "d");
    for (var ent : vec.entrySet())
      map.putIfAbsent(ent.getKey(), ent.getValue());
    map.putAll(vec);

    int size = map.size();

    boolean b1 = map.containsKey("bb");
    Map<String, String> constMapRef = Collections.unmodifiableMap(map);
    boolean b2 = map.equals(constMapRef);

    map.remove("cc");

    String defaultResult = map.getOrDefault("cc", "default");
    Optional<String> result = Optional.ofNullable(map.get("cc"));
    result = Optional.ofNullable(map.floorEntry("cc").getValue());
    result = Optional.ofNullable(map.ceilingEntry("cc").getValue());
  }
}
