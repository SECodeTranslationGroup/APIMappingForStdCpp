namespace CodeCsharp.Base.Memory;

public class WeakPtrEntry {
  private static WeakReference _weak;
  private static string _strong;

  public static void WeakPtrProgram() {
    _strong = new string("Example");
    _weak = new WeakReference(_strong);
    Console.WriteLine((_weak.Target == null) ? "null" : (_weak.Target as string));
    Console.WriteLine(!_weak.IsAlive ? "expired" : "not expired");
    _weak.Target = null;
    Console.WriteLine((_weak.Target == null) ? "null" : (_weak.Target as string));
    Console.WriteLine(!_weak.IsAlive ? "expired" : "not expired");
  }
}