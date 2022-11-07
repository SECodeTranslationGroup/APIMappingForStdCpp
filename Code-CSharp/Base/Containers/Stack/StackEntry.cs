namespace CodeCsharp.Base.Containers.Stack;

public class StackEntry {
  public static void StackProgram() {
    //initialize a stack
    Stack<string> stack = new Stack<string>();
    //initialize a stack with value
    Stack<string> stack1 = new Stack<string>(new[] { "aa", "bb", "cc", "dd" });
    //copy stack
    stack = new Stack<string>(stack1);
    //whether stack is empty
    bool isEmpty = stack.Count == 0;
    //clear stack
    stack.Clear();
    //insert element at first
    stack.Push("ee");
    //remove first element
    stack.Pop();
    //get size of stack
    int size = stack.Count;
    //whether two stacks equal
    bool b1 = stack.Equals(stack1);
    //get first element
    string element = stack.Peek();
  }
  
  public static bool TestAll() {
    bool ret = true;
    if (!ret)
      Console.WriteLine("Stack Test Failed!");
    return ret;
  }
}