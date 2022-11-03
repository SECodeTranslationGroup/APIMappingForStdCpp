package codejava.base.containers.unorderedmap;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class UnorderedMapEntry {
    public static void MapProgram() {
        HashMap<String, String> hashMap = new HashMap<>();
        HashMap<String, String> hashMap1 = new HashMap<>(Map.of("aa", "a",
            "bb", "b", "cc", "c", "dd", "d"));
        hashMap = new HashMap<>(hashMap1);

        boolean isEmpty = hashMap.isEmpty();
        hashMap.clear();
        hashMap.putIfAbsent("ee", "e");
        hashMap.put("ee", "e2");

        Map<String, String> vec = Map.of("aa", "a",
            "bb", "b", "cc", "c", "dd", "d");
        for (var ent : vec.entrySet())
            hashMap.putIfAbsent(ent.getKey(), ent.getValue());
        hashMap.putAll(vec);

        int size = hashMap.size();

        boolean b1 = hashMap.containsKey("bb");
        Map<String,String> constHashMapRef = Collections.unmodifiableMap(hashMap);
        boolean b2 = hashMap.equals(constHashMapRef);

        hashMap.remove("cc");

        String defaultResult = hashMap.getOrDefault("cc","default");
        Optional<String> result = Optional.ofNullable(hashMap.get("cc"));
    }
}
