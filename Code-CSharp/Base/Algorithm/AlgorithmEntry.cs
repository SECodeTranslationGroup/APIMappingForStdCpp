namespace CodeCsharp.Base.Algorithm;

public class AlgorithmEntry {
  public static void AlgorithmProgram() {
    List<int> list = new List<int> { 1, 2, 1, 2, 3 };
    Func<int, bool> pred = i => i > 3;
    Predicate<int> pred2 = i => i > 3;
    Action<int> con = i => { };
    Func<int, int> op = i => i * 2;
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

    list = Enumerable.Repeat(1, list.Count).ToList();
    list = list.Select((s, index) => index < 3 ? 1 : s).ToList();

    list.RemoveAll(i => i == 1);
    list.RemoveAll(pred2);

    toList = list.Where(i => i != 1).ToList();
    toList = list.Where(i => !pred(i)).ToList();

    list = list.Select(i => i == 1 ? 2 : i).ToList();
    list = list.Select(i => pred(1) ? 2 : i).ToList();

    toList = list.Select(i => i == 1 ? 2 : i).ToList();
    toList = list.Select(i => pred(1) ? 2 : i).ToList();

    (list[1], list[2]) = (list[2], list[1]);

    list.Reverse();

    (toList = new List<int>(list)).Reverse();

    list = list.Skip(1).Concat(list.Take(1)).ToList();

    toList = list.Skip(1).Concat(list.Take(1)).ToList();

    Random rng = new Random();
    list = list.OrderBy(i => rng.Next()).ToList();

    toList = list.OrderBy(i => rng.Next()).Take(3).ToList();

    Dictionary<bool, List<int>> d = list.GroupBy(pred).ToDictionary(
        group => group.Key, group => group.ToList());
    List<int> list1 = d[true];
    List<int> list2 = d[false];

    list.Sort((a, b) => a * a + 2 * a - b * b - 2 * b);
    toList = list.OrderBy(a => a * a + 2 * a).ToList();

    bool b4 = list.BinarySearch(1) >= 0;

    int max = Math.Max(1, 2);
    int? maxElement = list.Max();
    maxElement = list.MaxBy(a => a * a + 2 * a);

    int min = Math.Min(1, 2);
    int? minElement = list.Min();
    minElement = list.MinBy(a => a * a + 2 * a);

    int clamp = Math.Clamp(5, 0, 100);

    list = Enumerable.Range(1, list.Count + 1).ToList();
    int addSum = list.Sum();
    int multiplySum = list.Aggregate(1, (a, b) => a * b);
    toList = Enumerable.Range(-3, list.Count - 3).ToList();

    int innerProductSum = list.Zip(toList, (a, b) => a * b).Aggregate((a, b) => a + b);
    toList = list.Select((s, index) => index == 0 ? s : s - list[index - 1]).ToList();

    int sss = 0;
    toList = list.Select(a => sss += a).ToList();
  }
  
  public bool Test1(){
    List<int> list1 = new List<int> { 1, 2, 1, 2, 3 };
    List<int> list2 = new List<int> { 1, 2, 1, 2, 3 };

    int sum = list1.Zip(list2, (a, b) => a + b)
        .Aggregate((a, b) => a * b);
    
    int a = 1;
    list2 = list1.Select(i => a += i).ToList();
    
    return sum >0 ;
  }
}