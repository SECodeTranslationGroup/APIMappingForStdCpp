package codejava.base.array;

import codejava.base.ExampleObject;

import java.util.Arrays;

public class Array {
    private static ExampleObject[] array_;

    private static ExampleObject obj;

    public static void ArrayProgram() {
        obj = new ExampleObject();
        array_ = new ExampleObject[5];
        Arrays.fill(array_,obj);
        ExampleObject obj1 = array_[1];
        ExampleObject obj2 = array_[0];
        ExampleObject obj3 = array_[array_.length-1];
        int size = array_.length;
        boolean isEmpty = (array_ == null || array_.length == 0);
    }

}
