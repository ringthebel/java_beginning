@FunctionalInterface
interface Hello{
    public String sayHello();
}
@FunctionalInterface
interface HelloOneArg{
    public String sayHello(String name);
}
@FunctionalInterface
interface HelloManyArgs{
    public String sayHello(String name, int count);
}

public class Lambda {
    public static void main(String[] args){
        Hello s = () -> {
            return "hello world";
        };
//        don't need declare
        System.out.println(s.sayHello());

        HelloOneArg s1 = name -> {
            return "hello, " + name;
        };
        System.out.println(s1.sayHello("anh Tuân"));

        HelloManyArgs s2 = (name, count) -> {
            return "anh "+name +" năm nay "+count +" tuổi";
        };
        System.out.println(s2.sayHello("Tuân", 29));


    }
}
