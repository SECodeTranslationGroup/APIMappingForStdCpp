using System.Text;
using CodeCsharp.Base;
using CodeCsharp.Base.CCType;
using CodeCsharp.Base.Memory;

GlobalEntry.HelloWorldEntry();
// WeakPtrEntry.WeakPtrProgram();
// CTypeEntry.CTypeProgram();

List<string> l = new List<string>{"1","2","3","4","5"};
var o = l.GetRange(1, 3);
l[1] += "2";
foreach (var i in l) {
  Console.Write(i);
}
foreach (var i in o) {
  Console.Write(i);
}