namespace CodeCsharp.Base.Utilities;

public class OptionalEntry {
  public static void OptionalProgram() {
    //initialize variable
    int nonRef = 1;
    //make optional from variable
    int? opt = nonRef;
    //whether optional has value
    bool b1 = opt.HasValue;
    //reset optional
    opt = null;
    //get optional value, or else -1
    int value = opt ?? -1;
    //initialize any type
    object? any = null;
    //whether any has value
    bool b2 = any is null;
    //initialize any type variable
    string str = "my string";
    //make any from any variable
    var any2 = (object)str;
    //build a container to contain any value
    Dictionary<int, object> anyMap = new Dictionary<int, object>();
    //insert values
    anyMap.Add(1,"string1");
    anyMap.Add(2, 3.14);
    anyMap.Add(3, 500);
    //whether any cast successful
    bool b3 = anyMap[2] is double;
    //any cast to optional
    double? anyValue = b3 ? (double)anyMap[2] : null;

  }
}