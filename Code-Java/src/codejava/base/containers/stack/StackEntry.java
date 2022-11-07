package codejava.base.containers.stack;

import java.util.ArrayDeque;
import java.util.Arrays;

public class StackEntry {
  public static void StackProgram() {
    //initialize a stack
    ArrayDeque<String> stack = new ArrayDeque<>();
    //initialize a stack with value
    ArrayDeque<String> stack1 = new ArrayDeque<>(Arrays.asList("aa", "bb", "cc", "dd"));
    //copy stack
    stack = new ArrayDeque<>(stack1);
    //whether stack is empty
    boolean isEmpty = stack.isEmpty();
    //clear stack
    stack.clear();
    //insert element at first
    stack.push("ee");
    //remove first element
    stack.pop();
    //get size of stack
    int size = stack.size();
    //whether two stacks equal
    boolean b1 = Arrays.equals(stack.toArray(), stack1.toArray());
    //get first element
    String element = stack.peek();
  }

  public static boolean testAll() {
    boolean ret = true;
    ArrayDeque<Integer> c, c1, c2, c3, c4;
    c1 = new ArrayDeque<>();
    c = new ArrayDeque<Integer>(Arrays.asList(5, 1, 3, 4, 2));
    c2 = new ArrayDeque<>(c);
    c.push(6);
    c3 = new ArrayDeque<>(c);
    c.pop();
    c4 = new ArrayDeque<>(c);
    ret = c1.isEmpty()
        && c4.size() == 5
        && c.peek() == 5
        && Arrays.equals(c2.toArray(),
        new ArrayDeque<Integer>(Arrays.asList(5, 1, 3, 4, 2)).toArray())
        && Arrays.equals(c3.toArray(),
        new ArrayDeque<Integer>(Arrays.asList(6, 5, 1, 3, 4, 2)).toArray())
        && Arrays.equals(c4.toArray(),
        new ArrayDeque<Integer>(Arrays.asList(5, 1, 3, 4, 2)).toArray());
    if (!ret)
      System.out.println("Stack Test Failed!");
    return ret;
  }
}
