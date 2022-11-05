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
    boolean b1 = stack.equals(stack1);
    //get first element
    String element = stack.peek();
  }
}
