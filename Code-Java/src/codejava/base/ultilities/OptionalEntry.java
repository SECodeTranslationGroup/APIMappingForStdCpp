package codejava.base.ultilities;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.TreeMap;

public class OptionalEntry {
  public static void OptionalProgram() {
    Integer nonRef = 1;
    Optional<Integer> opt = Optional.ofNullable(nonRef);
    boolean b1 = opt.isPresent();
    opt = Optional.empty();
    Integer value = opt.orElse(-1);

    Object any = null;
    boolean b2 = Objects.isNull(any);
    String str = "my string";
    var any2 = (Object) str;
    Map<Integer, Object> anyMap = new TreeMap<>();
    anyMap.put(1, "string1");
    anyMap.put(2, 3.14);
    anyMap.put(3, 500);
    boolean b3 = anyMap.get(2) instanceof Double;
    Optional<Double> anyValue = b3 ?
        Optional.of((Double) anyMap.get(2)) : Optional.empty();
  }
}
