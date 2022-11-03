package codejava.base.containers.stack;

import java.util.ArrayDeque;
import java.util.Arrays;

public class StackEntry {
  public static void StackProgram() {
    ArrayDeque<String> stack = new ArrayDeque<>();
    ArrayDeque<String> stack1 = new ArrayDeque<>(Arrays.asList("aa", "bb", "cc", "dd"));
    stack = new ArrayDeque<>(stack1);

    boolean isEmpty = stack.isEmpty();
    stack.clear();

    stack.push("ee");
    stack.pop();

    int size = stack.size();

    boolean b1 = stack.equals(stack1);

    String element = stack.peek();
  }
}
