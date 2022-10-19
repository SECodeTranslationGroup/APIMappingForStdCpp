namespace CodeCsharp.Base.Algorithm;

public class AlgorithmEntry {
  
  public static void AlgorithmProgram() {
    List<int> list = new List<int> { 1, 2, 1, 2, 3 };
    Func<int, bool> pred = (int i) => i > 3;
    Predicate<int> pred2 = i => i > 3;
    Action<int> con = (int i) => { };
    Func<int, int> op = (int i) => i * 2;
    bool b1 = list.All(pred);
    bool b2 = list.Any(pred);
    bool b3 = !list.Any(pred);
    list.ForEach(con);
    list = list.Select(op).ToList();
    int i1 = list.Count(i => i == 1);
    int i2 = list.Count(pred);
    
    int i3 = list.IndexOf(1);
    
    int i4 = list.FindIndex(pred2);
    int? res1 = list.Find(pred2);
    
    int i5 = list.Find(i => !pred2(i));
    int? res2 = list.Find(i => !pred2(i));
    
    List<int> toList = new List<int>();
    toList = list.Skip(1).Take(list.Count - 2).ToList();
    toList = list.Where(pred).ToList();
    toList = list.Take(3).ToList();


  }
}