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
  
  public static bool TestAll() {
    bool ret = true;
    var strong = new ExampleObject();
    var weak = new WeakReference(strong);

    strong.Val = 10;
    ExampleObject exampleObject = weak.Target as ExampleObject;
    ret = exampleObject.Val == 10;

    (weak.Target as ExampleObject) .Val = 10;
    ret = ret && (strong.Val == 10);

    ret = ret && weak.IsAlive;
    weak.Target = null;
    ret = ret && !weak.IsAlive;

    weak = new WeakReference(strong);
    ret = ret && weak.IsAlive;
    strong = null;
    //ret = ret && !weak.IsAlive;
    
    if (!ret)
      Console.WriteLine("Weakptr Test Failed!");
    return ret;
  }
}