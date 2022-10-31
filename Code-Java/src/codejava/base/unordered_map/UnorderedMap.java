package codejava.base.unordered_map;

import codejava.base.ExampleObject;

import java.util.HashMap;

public class Unordered_map {
    private static HashMap<Integer, ExampleObject> hashmap_;
    private static ExampleObject obj;

    public static void UnorderedMapProgram()
    {
        hashmap_ = new HashMap<Integer, ExampleObject>();
        obj = new ExampleObject();
        boolean isEmpty = hashmap_.isEmpty();
        int size = hashmap_.size();
        hashmap_.clear();
        hashmap_.put(1,obj);
        boolean isContained = hashmap_.containsKey(1);
        ExampleObject findObj = hashmap_.get(1);
        hashmap_.remove(1);
    }
}
