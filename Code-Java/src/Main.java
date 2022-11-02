import codejava.base.GlobalEntry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    GlobalEntry.helloWorldEntry();
//    WeakPtrEntry.WeakPtrProgram();
//    CtypeEntry.CTypeProgram();
    List<Integer> l = Arrays.asList(1, 2, 3, 4, 5);
    Collections.fill(l.subList(1,3),0);
    System.out.println(l);
  }
}