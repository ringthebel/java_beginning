import java.util.stream.IntStream;

public class LambdaFunction {
    private static boolean isPrime(int number) {
        return number > 1
                && IntStream.range(2, number).noneMatch(
                index -> number % index == 0);
    }
    public static void main(String[] args){
        Boolean a = isPrime(5);
    }
}
