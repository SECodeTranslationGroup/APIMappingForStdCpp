namespace CodeCsharp.Base.Utilities;

public class OptionalEntry {
  public static void OptionalProgram() {
    int nonRef = 1;
    int? opt = nonRef;
    bool b1 = opt.HasValue;
    opt = null;
    int value = opt.GetValueOrDefault(-1);

    object? any = null;
    bool b2 = any == null;
    string str = "my string";
    var any2 = (object)str;
    Dictionary<int, object> anyMap = new Dictionary<int, object>();
    anyMap.Add(1,"string1");
    anyMap.Add(2, 3.14);
    anyMap.Add(3, 500);
    bool b3 = anyMap[2] is double;
    double? anyValue = b3 ? (double)anyMap[2] : null;
  }
}