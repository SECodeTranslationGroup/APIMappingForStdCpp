package codejava.base.memory;

import codejava.base.misc.ExampleObject;
import java.lang.ref.WeakReference;

public class WeakPtrEntry {
  public static void WeakPtrProgram() {
    //initialize strong ref
    ExampleObject strong = new ExampleObject();
    //initialize weak ref
    WeakReference<ExampleObject> weak = new WeakReference<>(strong);
    //get value from weak ref
    ExampleObject obj = weak.get();
    //call method from weak ref
    int objValue = weak.get().getVal();
    //reset weak ref
    weak.clear();
    //whether weak ref contains value
    boolean expired = weak.get() == null;
  }
}
