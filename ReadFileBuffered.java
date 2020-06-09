import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileBuffered {
    public static void main(String[] args) throws FileNotFoundException {
        BufferedReader csvReader = new BufferedReader(new FileReader("/home/ngocmai/vnpt/code/ActivePercent/test/data/bike-data/201508_station_data.csv"));
        String answer;
        try{
//            answer = csvReader.readLine();
            while ((answer = csvReader.readLine()) != null) {
//                System.out.println(answer);
                for (String w : answer.split(",")) {
                    System.out.println(w);
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
