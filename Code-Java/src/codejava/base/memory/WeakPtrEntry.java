package codejava.base.memory;

import java.lang.ref.WeakReference;

public class WeakPtrEntry {
  private static WeakReference<String> weak;
  private static String strong;

  public static void WeakPtrProgram() {
    strong = new String("Example");
    weak = new WeakReference<>(strong);
    System.out.println((weak.get() == null) ? "null" : weak.get());
    System.out.println((weak.get() == null) ? "expired" : "not expired");
    weak.clear();
    System.out.println((weak.get() == null) ? "null" : weak.get());
    System.out.println((weak.get() == null) ? "expired" : "not expired");
  }
}
