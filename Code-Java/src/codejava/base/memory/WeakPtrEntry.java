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

  public static boolean testAll() {
    boolean ret = true;
    var strong = new ExampleObject();
    var weak = new WeakReference<>(strong);

    strong.setVal(10);
    ExampleObject exampleObject = weak.get();
    ret = (exampleObject.getVal() == 10);

    weak.get().setVal(10);
    ret = ret && (strong.getVal() == 10);

    ret = ret && weak.get() != null;
    weak.clear();
    ret = ret && weak.get() == null;

    weak = new WeakReference<>(strong);
    ret = ret && weak.get() != null;
    strong = null;
    //ret = ret && weak.get() == null;

    if (!ret)
      System.out.println("Weakptr Test Failed!");
    return ret;
  }
}
