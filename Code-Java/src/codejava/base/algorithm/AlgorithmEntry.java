package codejava.base.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AlgorithmEntry {
  public static void AlgorithmProgram() {
    List<Integer> list = Arrays.asList(1, 2, 1, 2, 3);
    Predicate<Integer> pred = (Integer i) -> i > 3;
    Consumer<Integer> con = (Integer i) -> {};
    UnaryOperator<Integer> op = (Integer i) -> i = i * 2;

    IntPredicate pred2 = i -> i > 3;
    boolean b1 = list.stream().allMatch(pred);
    boolean b2 = list.stream().allMatch(pred);
    boolean b3 = list.stream().noneMatch(pred);
    list.forEach(con);
    list.replaceAll(op);
    int i1 = Collections.frequency(list,1);
    int i2 = (int) list.stream().filter(pred).count();

    int i3 = list.indexOf(1);

    int i4 = IntStream.range(0, list.size()).filter(pred2).findFirst().orElse(-1);
    Optional<Integer> res1 = list.stream().filter(pred).findFirst();

    int i5 = IntStream.range(0, list.size()).filter((IntPredicate) pred.negate()).findFirst().orElse(-1);
    Optional<Integer> res2 = list.stream().filter(pred.negate()).findFirst();

    List<Integer> toList = new ArrayList<>();
    toList = list.stream().skip(1).limit(list.size()-2).collect(Collectors.toList());
    toList = list.stream().filter(pred).collect(Collectors.toList());
    toList = list.stream().limit(3).collect(Collectors.toList());

  }
}
