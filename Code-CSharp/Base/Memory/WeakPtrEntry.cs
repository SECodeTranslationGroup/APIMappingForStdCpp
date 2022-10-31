namespace CodeCsharp.Base.Memory;

public class WeakPtrEntry {

  public static void WeakPtrProgram() {
    ExampleObject strong = new ExampleObject();
    WeakReference weak = new WeakReference(strong);
    ExampleObject obj = weak.Target as ExampleObject;
    int objValue = (weak.Target as ExampleObject).Val;
    weak.Target = null;
    bool expired = !weak.IsAlive;
  }
}