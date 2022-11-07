package codejava.base.algorithm;

import codejava.base.containers.map.MapEntry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.OptionalInt;
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
    //initialize first list
    List<Integer> list = Arrays.asList(1, 2, 1, 2, 3);
    //whether all elements satisfy condition
    boolean b1 = list.stream().allMatch(i -> i > 3);
    //whether any element satisfy condition
    boolean b2 = list.stream().anyMatch(i -> i > 3);
    //whether no element satisfy condition
    boolean b3 = list.stream().noneMatch(i -> i > 3);
    //for each element do function
    list.forEach(i -> System.out.println(i));
    //transform each element with function
    list.replaceAll(i -> i * 2);
    //count how many elements equal value
    int i1 = Collections.frequency(list, 1);
    //count how many elements satisfy condition
    int i2 = (int) list.stream().filter(i -> i > 1).count();
    //find index of first element equals value, or else -1
    int i3 = list.indexOf(1);
    //find index of last element equals value, or else -1
    int i4 = list.lastIndexOf(1);
    //find index of first element satisfies condition, or else -1
    List<Integer> fList = new ArrayList<>(list);
    int i5 = IntStream.range(0, list.size()).filter(i -> fList.get(i) > 1).findFirst().orElse(-1);
    //find index of first element satisfies condition using optional
    OptionalInt res1 = IntStream.range(0, list.size()).filter(i -> fList.get(i) > 1).findFirst();
    //find index of first element doesn't satisfy condition, or else -1
    int i6 = IntStream.range(0, list.size()).filter(i -> !(fList.get(i) > 1)).findFirst()
        .orElse(-1);
    //find index of first element doesn't satisfy condition using optional
    OptionalInt res2 = IntStream.range(0, list.size()).filter(i -> !(fList.get(i) > 1)).findFirst();
    //initialize another list
    List<Integer> toList = new ArrayList<>();
    //copy a sublist to another list
    toList = list.stream().skip(1).limit(list.size() - (1 + 1)).collect(Collectors.toList());
    //copy all elements satisfy condition to another list
    toList = list.stream().filter(i -> i > 1).collect(Collectors.toList());
    //copy a sublist to another list with length
    toList = list.stream().limit(3).collect(Collectors.toList());
    //fill a list with value
    Collections.fill(list, 1);
    //fill a list with length and value
    Collections.fill(list.subList(1, 1 + 3), 1);
    //remove all elements equal value
    list.removeIf(i -> i == 1);
    //remove all elements satisfy condition
    list.removeIf(i -> i > 1);
    //copy a list removes all elements equal value to another list
    toList = list.stream().filter(i -> !(i == 1)).collect(Collectors.toList());
    //copy a list removes all elements satisfy condition to another list
    toList = list.stream().filter(i -> !(i > 1)).collect(Collectors.toList());
    //replace all elements equal value to new value
    list = list.stream().map(i -> i == 1 ? 2 : i).collect(Collectors.toList());
    //replace all elements satisfy condition to new value
    list = list.stream().map(i -> i > 1 ? 2 : i).collect(Collectors.toList());
    //copy a list replace all elements equal value to new value to another list
    toList = list.stream().map(i -> i == 1 ? 2 : i).collect(Collectors.toList());
    //copy a list replace all elements satisfy condition to new value to another list
    toList = list.stream().map(i -> i > 1 ? 2 : i).collect(Collectors.toList());
    //swap two element at two index values
    Collections.swap(list, 1, 2);
    //reverse list
    Collections.reverse(list);
    //copy a reversed list to another list
    Collections.reverse(toList = new ArrayList<>(list));
    //rotate left with distance
    Collections.rotate(list, -1);
    //copy a list rotate left with distance to another list
    Collections.rotate(toList = new ArrayList<>(list), -1);
    //initialize random generator
    Random rng = new Random();
    //random shuffle
    Collections.shuffle(list, rng);
    //random sample
    toList = list.stream().sorted(Comparator.comparingInt(a -> rng.nextInt())).limit(3)
        .collect(Collectors.toList());
    //initialize partition lists
    List<Integer> list1, list2;
    //partition to two lists with condition
    Map<Boolean, List<Integer>> groups = list.stream()
        .collect(Collectors.partitioningBy(i -> i > 1));
    list1 = groups.get(true);
    list2 = groups.get(false);
    //sort list
    list.sort(null);
    //sort list with compare function
    list.sort(Comparator.comparingInt(a -> a * a + 2 * a));
    //copy a list sorted to another list
    toList = list.stream().sorted(Comparator.comparingInt(a -> a * a + 2 * a))
        .collect(Collectors.toList());
    //binary search whether value exist
    boolean b4 = Collections.binarySearch(list, 1) >= 0;
    //max element of 2 values
    int max = Math.max(1, 2);
    //max element of a list with optional(in case list is empty)
    Optional<Integer> maxElement = list.stream().max(Integer::compare);
    //max element with compare function of a list with optional(in case list is empty)
    maxElement = list.stream().max(Comparator.comparingInt(a -> a * a + 2 * a));
    //min element of 2 values
    int min = Math.min(1, 2);
    //min element of a list with optional(in case list is empty)
    Optional<Integer> minElement = list.stream().min(Integer::compare);
    //min element with compare function of a list with optional(in case list is empty)
    minElement = list.stream().min(Comparator.comparingInt(a -> a * a + 2 * a));
    //clamp function
    int clamp = Math.max(0, Math.min(100, 5));
    //fill list with range start with 1
    list = IntStream.range(1, list.size() + 1).boxed().collect(Collectors.toList());
    //fill list with range start with value
    list = IntStream.range(-3, list.size() - 3).boxed().collect(Collectors.toList());
    //initialize calculate lists
    List<Integer> cList = new ArrayList<>(list), cList2 = new ArrayList<>(list);
    //sum of the list
    int addSum = cList.stream().mapToInt(Integer::intValue).sum();
    //sum of the list using reduce function
    int multiplySum = cList.stream().reduce(1, (a, b) -> a * b);
    //inner product of two lists
    int innerProductSum = IntStream.range(0, cList.size())
        .mapToObj(i -> cList.get(i) * cList2.get(i))
        .mapToInt(Integer::intValue).sum();
    //inner product of two lists using reduce and transform function
    int productAddSum = IntStream.range(0, cList.size())
        .mapToObj(i -> cList.get(i) + cList2.get(i))
        .reduce(1, (a, b) -> a * b);
    //copy adjacent difference of list to another list
    toList = IntStream.range(0, list.size())
        .mapToObj(i -> i == 0 ? cList.get(0) : cList.get(i) - cList.get(i - 1))
        .collect(Collectors.toList());
    //copy adjacent difference of list using difference function to another list
    toList = IntStream.range(0, list.size())
        .mapToObj(i -> i == 0 ? cList.get(0) : cList.get(i) * cList.get(i - 1))
        .collect(Collectors.toList());
    //copy partial sum of list to another list
    AtomicReference<Integer> s = new AtomicReference<>(0);
    toList = list.stream().map(i -> {
      s.set(s.get() + i);
      return s.get();
    }).collect(Collectors.toList());
    //copy partial sum of list using reduce function to another list
    s.set(1);
    toList = list.stream().map(i -> {
      s.set(s.get() * i);
      return s.get();
    }).collect(Collectors.toList());
  }

  public static boolean testAll() {
    boolean ret = true;
    List<Integer> l = Arrays.asList(1, 3, 5, 7, 9, 9, 7, 5, 3, 1);
    List<Integer> l1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    List<Integer> l2, l3, l4, l5, l6, l7, l8, l9, l10;
    List<Integer> l11, l12, l13, l14, l15, l16, l17, l18;
    List<Integer> l19, l20, l21, l22, l23, l24, l25, l26;
    List<Integer> l27, l28, l29, l30, l31, l32;
    l2 = new ArrayList<>();
    l.forEach(i -> l2.add(i * 2));
    l3 = new ArrayList<>(l2);
    l3.replaceAll(i -> i + 1);
    l4 = l2.stream().skip(1).limit(l2.size() - (1 + 1)).collect(Collectors.toList());
    l5 = l2.stream().filter(i -> i > 6).collect(Collectors.toList());
    l6 = l2.stream().limit(5).collect(Collectors.toList());
    l7 = new ArrayList<>(Collections.nCopies(10, 0));
    Collections.fill(l7, 1);
    l8 = new ArrayList<>(Collections.nCopies(10, 0));
    Collections.fill(l8.subList(0, 5), 1);
    l9 = new ArrayList<>(l2);
    l9.removeIf(i -> i == 6);
    l10 = new ArrayList<>(l2);
    l10.removeIf(i -> i > 6);
    l11 = l2.stream().filter(i -> !(i == 6)).collect(Collectors.toList());
    l12 = l2.stream().filter(i -> !(i > 6)).collect(Collectors.toList());
    l13 = l2.stream().map(i -> i == 2 ? 3 : i).collect(Collectors.toList());
    l14 = l2.stream().map(i -> i > 6 ? 3 : i).collect(Collectors.toList());
    l15 = l2.stream().map(i -> i == 2 ? 3 : i).collect(Collectors.toList());
    l16 = l2.stream().map(i -> i > 6 ? 3 : i).collect(Collectors.toList());
    l17 = new ArrayList<>(l2);
    Collections.swap(l17, 1, 2);
    l18 = new ArrayList<>(l17);
    Collections.reverse(l18);
    Collections.reverse(l19 = new ArrayList<>(l17));
    l20 = new ArrayList<>(l2);
    Collections.rotate(l20, 1);
    Collections.rotate(l21 = new ArrayList<>(l2), 1);
    Map<Boolean, List<Integer>> groups = l2.stream()
        .collect(Collectors.partitioningBy(i -> i > 6));
    l22 = groups.get(true);
    l23 = groups.get(false);
    l24 = new ArrayList<>(l2);
    l24.sort(null);
    l25 = new ArrayList<>(l2);
    l25.sort(Comparator.comparingInt(a -> Math.abs(a - 7)));
    l26 = l2.stream().sorted().collect(Collectors.toList());
    l27 = IntStream.range(1, 1 + 10).boxed().collect(Collectors.toList());
    l28 = IntStream.range(-3, -3 + 10).boxed().collect(Collectors.toList());
    l29 = IntStream.range(0, l2.size())
        .mapToObj(i -> i == 0 ? l2.get(0) : l2.get(i) - l2.get(i - 1))
        .collect(Collectors.toList());
    l30 = IntStream.range(0, l2.size())
        .mapToObj(i -> i == 0 ? l2.get(0) : l2.get(i) * l2.get(i - 1))
        .collect(Collectors.toList());
    AtomicReference<Integer> s = new AtomicReference<>(0);
    l31 = l2.stream().map(i -> {
      s.set(s.get() + i);
      return s.get();
    }).collect(Collectors.toList());
    s.set(1);
    l32 = l1.stream().map(i -> {
      s.set(s.get() * i);
      return s.get();
    }).collect(Collectors.toList());
    ret = l.stream().allMatch(i -> i > 0)
        && !l.stream().allMatch(i -> i > 5)
        && l.stream().anyMatch(i -> i > 5)
        && !l.stream().allMatch(i -> i > 10)
        && l.stream().noneMatch(i -> i > 10)
        && !l.stream().noneMatch(i -> i > 5)
        && Collections.binarySearch(l1, 5) >= 0
        && !(Collections.binarySearch(l1, 0) >= 0)
        && Collections.frequency(l, 1) == 2
        && l.stream().filter(i -> i > 5).count() == 4
        && l.indexOf(5) == 2
        && l.lastIndexOf(5) == 7
        && IntStream.range(0, l.size()).filter(i -> l.get(i) > 4).findFirst().orElse(-1) == 2
        && IntStream.range(0, l.size()).filter(i -> !(l.get(i) < 4)).findFirst().orElse(-1) == 2
        && Math.max(1, 2) == 2
        && l.stream().max(Integer::compare).orElse(-1) == 9
        && l.stream().max(Comparator.comparingInt(a -> Math.abs(a - 4))).orElse(-1) == 9
        && Math.min(1, 2) == 1
        && l.stream().min(Integer::compare).orElse(-1) == 1
        && l.stream().min(Comparator.comparingInt(a -> Math.abs(a - 5))).orElse(-1) == 5
        && Math.max(0, Math.min(100, 5)) == 5
        && Math.max(0, Math.min(3, 5)) == 3
        && Math.max(6, Math.min(100, 5)) == 6
        &&  l.stream().mapToInt(Integer::intValue).sum() == 50
        && l.stream().reduce(1, (a, b) -> a * b) ==893025
        && IntStream.range(0, l.size())
        .mapToObj(i -> l.get(i) * l.get(i))
        .mapToInt(Integer::intValue).sum() == 330
        && IntStream.range(0, l.size())
        .mapToObj(i -> l.get(i) + l.get(i))
        .reduce(1, (a, b) -> a * b) ==914457600
        && l2.equals(Arrays.asList(2, 6, 10, 14, 18, 18, 14, 10, 6, 2))
        && l3.equals(Arrays.asList(3, 7, 11, 15, 19, 19, 15, 11, 7, 3))
        && l4.equals(Arrays.asList(6, 10, 14, 18, 18, 14, 10, 6))
        && l5.equals(Arrays.asList(10, 14, 18, 18, 14, 10))
        && l6.equals(Arrays.asList(2, 6, 10, 14, 18))
        && l7.equals(Arrays.asList(1, 1, 1, 1, 1, 1, 1, 1, 1, 1))
        && l8.equals(Arrays.asList(1, 1, 1, 1, 1, 0, 0, 0, 0, 0))
        && l9.equals(Arrays.asList(2, 10, 14, 18, 18, 14, 10, 2))
        && l10.equals(Arrays.asList(2, 6, 6, 2))
        && l11.equals(Arrays.asList(2, 10, 14, 18, 18, 14, 10, 2))
        && l12.equals(Arrays.asList(2, 6, 6, 2))
        && l13.equals(Arrays.asList(3, 6, 10, 14, 18, 18, 14, 10, 6, 3))
        && l14.equals(Arrays.asList(2, 6, 3, 3, 3, 3, 3, 3, 6, 2))
        && l15.equals(Arrays.asList(3, 6, 10, 14, 18, 18, 14, 10, 6, 3))
        && l16.equals(Arrays.asList(2, 6, 3, 3, 3, 3, 3, 3, 6, 2))
        && l17.equals(Arrays.asList(2, 10, 6, 14, 18, 18, 14, 10, 6, 2))
        && l18.equals(Arrays.asList(2, 6, 10, 14, 18, 18, 14, 6, 10, 2))
        && l19.equals(Arrays.asList(2, 6, 10, 14, 18, 18, 14, 6, 10, 2))
        && l20.equals(Arrays.asList(2, 2, 6, 10, 14, 18, 18, 14, 10, 6))
        && l21.equals(Arrays.asList(2, 2, 6, 10, 14, 18, 18, 14, 10, 6))
        && l22.equals(Arrays.asList(10, 14, 18, 18, 14, 10))
        && l23.equals(Arrays.asList(2, 6, 6, 2))
        && l24.equals(Arrays.asList(2, 2, 6, 6, 10, 10, 14, 14, 18, 18))
        && l25.equals(Arrays.asList(6, 6, 10, 10, 2, 2, 14, 14, 18, 18))
        && l26.equals(Arrays.asList(2, 2, 6, 6, 10, 10, 14, 14, 18, 18))
        && l27.equals(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))
        && l28.equals(Arrays.asList(-3, -2, -1, 0, 1, 2, 3, 4, 5, 6))
        && l29.equals(Arrays.asList(2, 4, 4, 4, 4, 0, -4, -4, -4, -4))
        && l30.equals(Arrays.asList(2, 12, 60, 140, 252, 324, 252, 140, 60, 12))
        && l31.equals(Arrays.asList(2, 8, 18, 32, 50, 68, 82, 92, 98, 100))
        && l32.equals(Arrays.asList(1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800));
    if (!ret)
      System.out.println("Algorithm Test Failed!");
    return ret;
  }
}
