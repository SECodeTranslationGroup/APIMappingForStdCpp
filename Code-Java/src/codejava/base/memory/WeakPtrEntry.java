package codejava.base.memory;

import codejava.base.ExampleObject;
import java.lang.ref.WeakReference;

public class WeakPtrEntry {
  private static WeakReference<ExampleObject> weak;
  private static ExampleObject strong;

  public static void WeakPtrProgram() {
    strong = new ExampleObject();
    weak = new WeakReference<>(strong);
    ExampleObject obj = weak.get();
    int objValue = weak.get().getVal();
    weak.clear();
    boolean expired = weak.get() == null;
  }
}
