namespace CodeCsharp.Base.Memory;

public class WeakPtrEntry {

  public static void WeakPtrProgram() {
    //initialize strong ref
    ExampleObject strong = new ExampleObject();
    //initialize weak ref
    WeakReference weak = new WeakReference(strong);
    //get value from weak ref
    ExampleObject? obj = weak.Target as ExampleObject;
    //call method from weak ref
    int objValue = (weak.Target as ExampleObject).Val;
    //reset weak ref
    weak.Target = null;
    //whether weak ref contains value
    bool expired = !weak.IsAlive;
  }
}