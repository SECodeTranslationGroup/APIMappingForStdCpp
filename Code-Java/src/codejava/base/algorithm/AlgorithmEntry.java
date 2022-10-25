package codejava.base.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AlgorithmEntry {
  public static void AlgorithmProgram() {
    List<Integer> list = Arrays.asList(1, 2, 1, 2, 3);
    Predicate<Integer> pred = i -> i > 3;
    Consumer<Integer> con = i -> {
    };
    UnaryOperator<Integer> op = i -> i = i * 2;

    IntPredicate pred2 = i -> i > 3;
    boolean b1 = list.stream().allMatch(pred);
    boolean b2 = list.stream().allMatch(pred);
    boolean b3 = list.stream().noneMatch(pred);
    list.forEach(con);
    list.replaceAll(op);
    int i1 = Collections.frequency(list, 1);
    int i2 = (int) list.stream().filter(pred).count();

    int i3 = list.indexOf(1);

    int i4 = IntStream.range(0, list.size()).filter(pred2).findFirst().orElse(-1);
    Optional<Integer> res1 = list.stream().filter(pred).findFirst();

    int i5 = IntStream.range(0, list.size()).filter((IntPredicate) pred.negate()).findFirst()
        .orElse(-1);
    Optional<Integer> res2 = list.stream().filter(pred.negate()).findFirst();

    List<Integer> toList = new ArrayList<>();
    toList = list.stream().skip(1).limit(list.size() - 2).collect(Collectors.toList());
    toList = list.stream().filter(pred).collect(Collectors.toList());
    toList = list.stream().limit(3).collect(Collectors.toList());

    Collections.fill(list, 1);
    List<Integer> finalList = list;
    list = IntStream.range(0, list.size()).mapToObj(i -> i < 3 ? 1 : finalList.get(i))
        .collect(Collectors.toList());

    list.removeIf(i -> i == 1);
    list.removeIf(pred);

    toList = list.stream().filter(i -> i != 1).collect(Collectors.toList());
    toList = list.stream().filter(pred.negate()).collect(Collectors.toList());

    list = list.stream().map(i -> i == 1 ? 2 : i).collect(Collectors.toList());
    list = list.stream().map(i -> pred.test(i) ? 2 : i).collect(Collectors.toList());

    toList = list.stream().map(i -> i == 1 ? 2 : i).collect(Collectors.toList());
    toList = list.stream().map(i -> pred.test(i) ? 2 : i).collect(Collectors.toList());

    Collections.swap(list, 1, 2);

    Collections.reverse(list);

    Collections.reverse(toList = new ArrayList<>(list));

    Collections.rotate(list, 1);

    Collections.rotate(toList = new ArrayList<>(list), 1);

    Random rng = new Random();
    Collections.shuffle(list, rng);

    toList = list.stream().sorted(Comparator.comparingInt(a -> rng.nextInt())).limit(3)
        .collect(Collectors.toList());

    Map<Boolean, List<Integer>> groups = list.stream().collect(Collectors.partitioningBy(pred));
    List<Integer> list1 = groups.get(true);
    List<Integer> list2 = groups.get(false);

    list.sort((a, b) -> a * a + 2 * a - b * b - 2 * b);
    Collections.sort(list);
    toList = list.stream().sorted(Comparator.comparingInt(a -> a * a + 2 * a))
        .collect(Collectors.toList());

    boolean b4 = Collections.binarySearch(list, 1) >= 0;

    int max = Math.max(1, 2);
    Optional<Integer> maxElement = list.stream().max(Integer::compare);
    maxElement = list.stream().max(Comparator.comparingInt(a -> a * a + 2 * a));

    int min = Math.min(1, 2);
    Optional<Integer> minElement = list.stream().min(Integer::compare);
    minElement = list.stream().min(Comparator.comparingInt(a -> a * a + 2 * a));

    int clamp = Math.max(0, Math.min(100, 5));

    list = IntStream.range(1, list.size() + 1).boxed().collect(Collectors.toList());
    int addSum = list.stream().mapToInt(Integer::intValue).sum();
    int multiplySum = list.stream().reduce(1, Math::multiplyExact);
    toList = IntStream.range(-3, list.size() - 3).boxed().collect(Collectors.toList());

    List<Integer> finalList1 = list;
    List<Integer> finalToList = toList;
    int innerProductSum = IntStream.range(0, list.size())
        .mapToObj(i -> finalList1.get(i) * finalToList.get(i))
        .reduce(0, Integer::sum);
    toList = IntStream.range(0, list.size())
        .mapToObj(i -> i == 0 ? i : finalList1.get(i) - finalList1.get(i - 1))
        .collect(Collectors.toList());

    Integer[] arr = list.toArray(Integer[]::new);
    Arrays.parallelPrefix(arr, Integer::sum);
    toList = Arrays.asList(arr);

    AtomicReference<Integer> a = new AtomicReference<>(0);
    toList = list.stream().map(i -> a.getAndSet(a.get() + i)).collect(Collectors.toList());
  }

  public boolean Test1() {
    List<Integer> list1 = Arrays.asList(1, 2, 1, 2, 3);
    List<Integer> list2 = Arrays.asList(1, 2, 1, 2, 3);

    List<Integer> finalList = list2;
    int sum = IntStream.range(0, list1.size())
        .mapToObj(i -> list1.get(i) + finalList.get(i))
        .reduce(1, (a, b) -> a * b);

    AtomicReference<Integer> a = new AtomicReference<>(1);
    list2 = list1.stream().map(i -> a.getAndSet(a.get() * i)).collect(Collectors.toList());

    return sum > 0;
  }
}
