namespace CodeCsharp.Base.Containers.Stack;

public class StackEntry {
  public static void StackProgram() {
    Stack<string> stack = new Stack<string>();
    Stack<string> stack1 = new Stack<string>(new[] { "aa", "bb", "cc", "dd" });
    stack = new Stack<string>(stack1);

    bool isEmpty = stack.Count == 0;
    stack.Clear();

    stack.Push("ee");
    stack.Pop();

    int size = stack.Count;

    bool b1 = stack.Equals(stack1);

    string element = stack.Peek();
  }
}