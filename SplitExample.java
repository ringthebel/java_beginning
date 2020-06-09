public class SplitExample {
    public static void main(String args[]) {
        String s1 = "station_id,name,lat,long,dockcount,landmark,installation";
        System.out.println(s1.split(","));
        for (String w : s1.split(",")) {
            System.out.println(w);
        }
//        for (String w : s1.split("\\s", 2)) {
//            System.out.println(w);
//        }
//        System.out.println("returning words:");
//        for (String w : s1.split("\\s", 1)) {
//            System.out.println(w);
//        }
//        System.out.println("returning words:");
//        for (String w : s1.split("\\s", 2)) {
//            System.out.println(w);
//        }
    }
}
