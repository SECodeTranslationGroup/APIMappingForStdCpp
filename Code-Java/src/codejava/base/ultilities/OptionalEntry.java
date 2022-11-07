package codejava.base.ultilities;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.TreeMap;

public class OptionalEntry {
  public static void OptionalProgram() {
    //initialize variable
    Integer i = 1;
    //make optional from variable
    Optional<Integer> opt = Optional.ofNullable(i);
    //whether optional has value
    boolean b1 = opt.isPresent();
    //reset optional
    opt = Optional.empty();
    //get optional value, or else -1
    Integer value = opt.orElse(-1);
    //initialize any type
    Object any = null;
    //whether any has value
    boolean b2 = Objects.isNull(any);
    //initialize any type variable
    String str = "my string";
    //make any from any variable
    var any2 = (Object) str;
    //build a container to contain any value
    Map<Integer, Object> anyMap = new TreeMap<>();
    //insert values
    anyMap.put(1, "string1");
    anyMap.put(2, 3.14);
    anyMap.put(3, 500);
    //whether any cast successful
    boolean b3 = anyMap.get(2) instanceof Double;
    //any cast to optional
    Optional<Double> anyValue = b3 ?
        Optional.of((Double) anyMap.get(2)) : Optional.empty();
  }

  public static boolean testAll() {
    boolean ret = true;
    int i = 1;
    Optional<Integer> opt = Optional.ofNullable(i);
    ret = opt.isPresent()
        && opt.orElse(-1) == 1;
    opt = Optional.empty();
    ret = ret
        && !opt.isPresent()
        && opt.orElse(-1) == -1;
    String str = "example";
    Object any = null;
    ret = ret && any == null;
    any = str;
    ret = ret
        && any!=null
        && !(any instanceof Integer)
        && any instanceof String
        && ((String)any).equals("example");
    if (!ret)
      System.out.print("Optional Test Failed!");
    return ret;
  }
}
