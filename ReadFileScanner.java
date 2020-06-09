import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.IOException;

public class ReadFileScanner {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("/home/ngocmai/vnpt/code/ActivePercent/test/data/bike-data/201508_station_data.csv"));
        String answer;
        while ((answer = input.nextLine()) != null) {
            System.out.println(answer);
        }
    }
}