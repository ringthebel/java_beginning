import org.apache.spark.sql.sources.In;
import sun.security.util.ArrayUtil;

import java.nio.Buffer;

import static java.util.Collections.reverse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import java.util.Arrays;
import java.util.*;
// khi tai file jar thi nen tai dang binary, vao projectstructure -> module -> dependence.
import org.apache.commons.lang3.ArrayUtils;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
public class Streamming {
    public static void main(String[] args){
//        mapExamples();
//        invertExample();
//        filterExample();
//        aggregatingOperationExample();
        moreFunnyExample();
    }
    public static void mapExamples(){
//        map la anh xa
        String s = "1 2 3 4 5 6 7 8 9";
        System.out.println("1. Mapping with a one-argument function:");
        String[] arr = s.split("\\s+");
//        moi phan tu trong arr type la String
//        System.out.println(arr);
//        for (String w : arr){
//            System.out.println(w);
//        }
//        chuyen moi phan tu trong arr thanh kieu Int
//        Arrays.stream(mot mang) or motmang.stream()
        List<Integer> ints = Arrays.stream(arr).map(Integer::parseInt).collect(Collectors.toList());
        for (Integer w : ints){
            System.out.println(w);
        }
        System.out.println("2. Mapping with a simple lambda expression:");
        List<Double> pow2 = ints.stream().map(x ->Math.pow(2.0, x)).collect(Collectors.toList());
        System.out.println(pow2);
//        java convert char to int: int('_') = 95
        List<String> doubled = ints.stream().map(x -> x + "_" + x).collect(Collectors.toList());
        System.out.println(doubled);
        System.out.println("3. Mapping with complex function:");
        List<Integer> pows = pow2.stream().map(
                d->{
                    String str = Double.toString(d);
                    return str.length();
                }).collect(Collectors.toList());
        System.out.println(pows);
    }
    private static void filterExample(){
//        filter la loc phan tu: cac ham bat buoc dung trong filter la >, < ==, eequals
        List<String> words = Arrays.asList("tst", "one", "two", "three", "four", "five", "rotator", "deified");
        System.out.println("1. Simple filtering");
//        lay phan tu dai hon 3
        List<String> longwords = words.stream().filter(i->i.length()>3).collect(Collectors.toList());
        System.out.println(longwords);
        System.out.println("2. A little more complex filtering");
//        lay nhung tu ma tu dao nguoc cua no giong no, ham dao nguoc la, hinh nhu .collect(Collectors.toList()) khong tra ve List<Boolean>
        List<String> arr_check = words.stream().filter(i-> i.equals(new StringBuilder(i).reverse().toString())).collect(Collectors.toList());
        System.out.println(arr_check);
    }
    private static void aggregatingOperationExample(){
//        kiem tra trong tat ca phan tu
        List<String> words = Arrays.stream("hom nay thoi tiet sos dep tuyet".split("\\s+")).collect(Collectors.toList());
        System.out.println("1. Check if all items satisfy a criterion:");
//        boolean khong co toList
        boolean booleanWord1 = words.stream().allMatch(i->i.length()>4);
//        booleanWord1 tra ve false: ko phai tat ca phan tu deu dai hon 4
        System.out.println(booleanWord1);
//        trong tat ca cac phan tu, ko co phan tu length < 2
        boolean booleanWord2 = words.stream().noneMatch(i->i.length()<2);
        System.out.println(booleanWord2);
        boolean anyCheck = words.stream().anyMatch(i->i.length()==5);
        boolean anyCheck1 = words.stream().anyMatch(i->i.equals(new StringBuilder(i).reverse()));
//        anyCheck1 tra ve false
        boolean anyCheck2 = words.stream().anyMatch(i->i.equals(new StringBuilder(i).reverse().toString()));
//        anyCheck2 tra ve true
        System.out.println(anyCheck +","+ anyCheck1);

//        tim phan tu, vi tri phan tu trong mang
        String[] fruits = { "Orange", "Apple", "Blueberry", "Guava"
                , "Apple", "Peach", "Orange", "Strawberry" };
        boolean findWord = ArrayUtils.contains(fruits, "sos");
        int indexOfOrange = ArrayUtils.indexOf(fruits, "Orange");
        BitSet indexOfOranges = ArrayUtils.indexesOf(fruits, "Orange");
//        BitSet la lop co ham add
        int[] intArray = bits2Ints(indexOfOranges);
        int lastIndexOfOrange = ArrayUtils.lastIndexOf(fruits, "Orange");
        for (int i:intArray){
            System.out.println(i);
        }
//        System.out.println(intArray);
//        find in stream
        List<String> listWords = Arrays.asList("hom", "nay", "thoi", "tiet", "dep", "lam", "nay");
        Optional<String> result = listWords.stream().findAny();
        assertTrue(result.isPresent());
//        assertThat(result.get(), is("A"));

        List<String> resultNay = listWords.stream().filter(w->w.equals("nay")).collect(Collectors.toList());
        System.out.println("============"+"\n");
        Integer i = 2;
//        lenh dung thi khong tra ve gi, sai thi bao loi
        try {
            assertFalse(i==3);
        }catch (Exception e){
            System.out.println(e);
        }
    }
    static int[] bits2Ints(BitSet bs) {
        int[] temp = new int[bs.size() / 32];

        for (int i = 0; i < temp.length; i++)
            for (int j = 0; j < 32; j++)
                if (bs.get(i * 32 + j))
                    temp[i] |= 1 << j;

        return temp;
    }
    static String toBinary(int num) {
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < 32; i++) {
            sb.append(((num & 1) == 1) ? '1' : '0');
            num >>= 1;
        }

        return sb.reverse().toString();
    }
    private static void moreFunnyExample(){
        List<String> words = Arrays.stream("These examples cover only a small part of Java 8 Streams.".split("\\s+")).collect(Collectors.toList());
//        giong ham join trong python, khong dung delimiter la  ' ' duoc ma phai la " "
        String noSpace = words.stream().collect(Collectors.joining(" "));
        System.out.println(noSpace);
        //count tong so phan tu cua List c1: dung for, c2 dung stream => bi loi vi bien dung trong stream chi duoc dung 1 lan, khong goi duoc tu ben ngoai
//        A final variable means that it can be instantiated only one time. in Java you can't use non-final variables in lambda as well as in anonymous inner classes.

        List<Integer> count = words.stream().map(i->{
            int sum = 0;
            sum += i.length();
            System.out.println(i + "  " + i.length() + "  " + sum);
            return sum;
        }).collect(Collectors.toList());
//        System.out.println(count);
        System.out.println("2. Concat two streams:");
//        concat tra ve composedClose cua 2 List
        List<String> concat = Stream.concat(words.stream(),
                words.stream().map(s -> new StringBuilder(s).reverse().toString()))
                .collect(Collectors.toList());
//        System.out.println(words + "\n" + concat);

//        Map object
        System.out.println("3. in ra moi tu dai bao nhieu");
//        :: dung trong map
        //toMap takes two arguments: the first is the function to get keys (we pass identity there -- it is a function
        //that returns exactly its argument, like `x -> x`, and the second one to get values.
        Map<String, Integer> map = words.stream().collect(Collectors.toMap(Function.identity(), String::length));
        System.out.println(map);

        System.out.println("4. Distinct items of a stream:");
        //Here's also a way to create a stream directly from values
        List<Integer> intUnique = Stream.of(5, 1, 2, 3, 4, 5, 4, 3, 2, 1).collect(Collectors.toList());
        Set<Integer> unique = Stream.of(5, 1, 2, 3, 4, 5, 4, 3, 2, 1).collect(Collectors.toSet());
        System.out.println(unique);
//khac python, set la {1,2,3} thi java set van giong list la [1,2,3]
        System.out.println("5. Sorted stream");
        List<String> sorted = Stream.of("a", "z", "b", "c").sorted().collect(Collectors.toList());
//        khong co thu vien ho tro sap xep giam dan, chi co the sap xep tang dan roi dao chieu
//        Set<String> sortedSet = Stream.of("a", "z", "b", "c").sorted(Collections.reverseOrder()).collect(Collectors.toSet());
    }
    private static void invertExample(){
        String s = "tst";
        StringBuilder s1 =new StringBuilder(s).reverse();
//        neu khong chuyen s1.toString() thi s1 o kieu Builder => khong so sanh duoc
        boolean s2 = s.equals(s1.toString());
        System.out.println(s2);
    }
}
