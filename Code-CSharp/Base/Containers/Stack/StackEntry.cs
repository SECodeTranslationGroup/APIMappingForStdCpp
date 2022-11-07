namespace CodeCsharp.Base.Containers.Stack;

public class StackEntry {
  public static void StackProgram() {
    //initialize a stack
    Stack<string> stack = new Stack<string>();
    //initialize a stack with value
    Stack<string> stack1 = new Stack<string>(new[] { "aa", "bb", "cc", "dd" });
    //copy stack
    stack = new Stack<string>(stack1.Reverse());
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
    Stack<int> c, c1, c2, c3, c4;
    c1 = new Stack<int>();
    c = new Stack<int>(new List<int> {2, 4, 3, 1, 5});
    c2 = new Stack<int>(c.Reverse());
    c.Push(6);
    c3 = new Stack<int>(c.Reverse());
    c.Pop();
    c4 = new Stack<int>(c.Reverse());
    ret = c1.Count == 0
          && c4.Count == 5
          && c.Peek() == 5
          && c2.SequenceEqual(
              new Stack<int>(new List<int> { 2, 4, 3, 1, 5 }))
          && c3.SequenceEqual(
              new Stack<int>(new List<int> {2, 4, 3, 1, 5, 6 }))
          && c4.SequenceEqual(
              new Stack<int>(new List<int>  {2, 4, 3, 1, 5 }));
    if (!ret)
      Console.WriteLine("Stack Test Failed!");
    return ret;
  }
}