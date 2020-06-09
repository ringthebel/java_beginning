import com.sun.corba.se.impl.resolver.SplitLocalResolverImpl;
import org.apache.spark.sql.sources.In;

import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Crunchify.com
 *
 */

public class ListBeginning {
    public static void InitializeasList(){
        List<Integer> numbers = Arrays.asList(1,2,3,4);
        numbers = new ArrayList<>(numbers);
        numbers.add(6);
//        List<Integer> other_numbers = new(Arr)
        System.out.println(numbers);
        String type = numbers.getClass().getName();
        System.out.println(type);
    }
    public static List<Integer> InitializearrrayList(){
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1,2,3,4));
        numbers.add(5);
        System.out.println(numbers);
        return numbers;
    }
    public static void InitializeCollection(List<Integer> list){
//        List<Integer> numbers = Collections.EMPTY_LIST;
        Collections.addAll(list, 6,7);
        System.out.println(list);
    }
    public static void CollectionUnmodifiable(){
//        thay cho Collections.EMPTY_LIST
        List<Integer> numbers = Collections.unmodifiableList(Arrays.asList(1,2,3,4));
        numbers = new ArrayList<>(numbers);
        numbers.add(4);
        String type = numbers.getClass().getName();
        System.out.println(numbers + type);
    }
    public static void InitializeStream(){
//        stream.of to list
        List<Integer> numbers = Stream.of(1,2,3).collect(Collectors.toList());
        numbers.add(4);
        System.out.println(numbers);
    }
    public static void Base() {
        String[] geeks = {"Rahul", "Utkarsh",
                "Shubham", "Neelam"};

        // Conversion of array to ArrayList
        // using Arrays.asList - return asList and can not add
        List al = Arrays.asList(geeks);
        System.out.println(al);
        List al_new = new ArrayList<String>(Arrays.asList(geeks));
        // Adding some more values to the List .
        al_new.add("Shashank");
        al_new.add("Nishant");
        System.out.println(al_new);
//        can not convert int arr as String arr
        int[] arr = {1,2,3,4};
//        ArrayList numbers = new ArrayList<Integer>(Arrays.asList(arr));
    }

    public static void main(String[] args) throws FileNotFoundException {
        InitializeasList();
        InitializearrrayList();
        List<Integer> numbers  = InitializearrrayList();
        InitializeCollection(numbers);
        CollectionUnmodifiable();
        InitializeStream();
        Base();
    }
}
