namespace CodeCsharp.Base; 

public class ExampleObject {
  private int _val;
  
  public ExampleObject() {
    _val = 0;
  }
  
  public virtual int Val {
    get => _val;
    set => _val = value;
  }
}