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
    //initialize first list
    List<Integer> list = Arrays.asList(1, 2, 1, 2, 3);
    //whether all element satisfy condition
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
    //find index of first element equals value, orelse -1
    int i3 = list.indexOf(1);
    //find index of last element equals value, orelse -1
    int i4 = list.lastIndexOf(1);
    //find index of first element satisfies condition, orelse -1
    int i5 = IntStream.range(0, list.size()).filter(i -> i > 1).findFirst().orElse(-1);
    //find index of first element satisfies condition using optional
    Optional<Integer> res1 = list.stream().filter(i -> i > 1).findFirst();
    //find index of first element doesn't satisfy condition, orelse -1
    int i6 = IntStream.range(0, list.size()).filter(i -> !(i > 1)).findFirst()
        .orElse(-1);
    //find index of first element doesn't satisfy condition using optional
    Optional<Integer> res2 = list.stream().filter(i -> !(i > 1)).findFirst();
    //initialize another list
    List<Integer> toList = new ArrayList<>();
    //copy a sublist to another list
    toList = list.stream().skip(1).limit(list.size() - (1 + 1)).collect(Collectors.toList());
    //copy all element satisfy condition to another list
    toList = list.stream().filter(i -> i > 1).collect(Collectors.toList());
    //copy a sublist to another list with length
    toList = list.stream().limit(3).collect(Collectors.toList());
    //fill a list with value
    Collections.fill(list, 1);
    //fill a list with length and value
    Collections.fill(list.subList(1, 1 + 3), 1);
    //remove all element equal value
    list.removeIf(i -> i == 1);
    //remove all element satisfy condition
    list.removeIf(i -> i > 1);
    //copy a list removes all element equal value to another list
    toList = list.stream().filter(i -> !(i == 1)).collect(Collectors.toList());
    //copy a list removes all element satisfy condition to another list
    toList = list.stream().filter(i -> !(i > 1)).collect(Collectors.toList());
    //replace all element equal value to new value
    list = list.stream().map(i -> i == 1 ? 2 : i).collect(Collectors.toList());
    //replace all element satisfy condition to new value
    list = list.stream().map(i -> i > 1 ? 2 : i).collect(Collectors.toList());
    //copy a list replace all element equal value to new value to another list
    toList = list.stream().map(i -> i == 1 ? 2 : i).collect(Collectors.toList());
    //copy a list replace all element satisfy condition to new value to another list
    toList = list.stream().map(i -> i > 1 ? 2 : i).collect(Collectors.toList());
    //swap two element at two index values
    Collections.swap(list, 1, 2);
    //reverse all element
    Collections.reverse(list);
    //copy a list reverse all element to another list
    Collections.reverse(toList = new ArrayList<>(list));
    //rotate right with distance
    Collections.rotate(list, 1);
    //copy a list rotate right with distance to another list
    toList = new ArrayList<>(list);
    Collections.rotate(toList, 1);
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
    toList = IntStream.range(-3, list.size() - 3).boxed().collect(Collectors.toList());
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
        .mapToObj(i -> i == 0 ? i : cList.get(i) - cList.get(i - 1))
        .collect(Collectors.toList());
    //copy adjacent difference of list using difference function to another list
    toList = IntStream.range(0, list.size())
        .mapToObj(i -> i == 0 ? i : cList.get(i) * cList.get(i - 1))
        .collect(Collectors.toList());
    //copy partial sum of list to another list
    AtomicReference<Integer> s = new AtomicReference<>(0);
    toList = list.stream().map(i -> s.getAndSet(s.get() + i)).collect(Collectors.toList());
    //copy partial sum of list using reduce function to another list
    s.set(1);
    toList = list.stream().map(i -> s.getAndSet(s.get() * i)).collect(Collectors.toList());
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

    Map<Boolean, List<Integer>> groups = list1.stream().
        collect(Collectors.partitioningBy(i -> i > 3));
    List<Integer> list3 = groups.get(true);
    List<Integer> list4 = groups.get(false);

    return sum > 0;
  }
}
