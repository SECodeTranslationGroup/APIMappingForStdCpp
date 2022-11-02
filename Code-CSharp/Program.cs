using System.Text;
using CodeCsharp.Base;
using CodeCsharp.Base.CCType;
using CodeCsharp.Base.Memory;

GlobalEntry.HelloWorldEntry();
// WeakPtrEntry.WeakPtrProgram();
// CTypeEntry.CTypeProgram();

int Foo(List<int> list, int value) {
  int i1 = list.IndexOf(value);
  int i2 = list.LastIndexOf(value);
  return i2 - i1;
}
List<int> list = new List<int> { 1, 2, 3, 2, 1 };
Console.WriteLine(Foo(list,1)); // 4