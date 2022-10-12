namespace CodeCsharp.Base.Memory;

public class WeakPtrEntry {
  private static WeakReference _weak;
  private static ExampleObject _strong;

  public static void WeakPtrProgram() {
    _strong = new ExampleObject();
    _weak = new WeakReference(_strong);
    ExampleObject obj = _weak.Target as ExampleObject;
    int objValue = (_weak.Target as ExampleObject).Val;
    _weak.Target = null;
    bool expired = !_weak.IsAlive;
  }
}