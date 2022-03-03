import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Random;

public class Range_Algorithms {

    public static void main(String[] args) throws IOException
    {
        //Declare the array of values simulating the amount values passed in a function as was presented in a presentation
        int[] testValuesInefficient = {1000, 2000, 4000, 8000, 16000, 32000, 64000};
        int[] testValuesEfficient = {1000, 2000, 4000, 8000, 16000, 32000, 64000, 128000, 256000, 512000, 1000000, 2000000, 4000000, 8000000, 16700000, 33000000, 65000000, 130000000, 260000000};

        Random rand = new Random();

        writeString("EFFICIENT RANGE VALUES");
        for (int num: testValuesEfficient){
            //Limiting the value to 100 to make the generation of random numbers more efficient, as numbers utilized in an exmaple
            //were not specified
            int[] workingArr = new Random().ints(num,1,1000).toArray();

            final long startTime3 = System.currentTimeMillis();
            efficientRange(workingArr);
            final long endTime3 = System.currentTimeMillis();
            writeString(""+(endTime3 - startTime3));
        }
        //Divider between efficient and inefficient values
        writeString("_____________________________");

        writeString("MILDLYINEFFICIENT RANGE VALUES");
        for (int num: testValuesInefficient){
            int[] workingArr = new Random().ints(num).toArray();
            //Utilize System.CurrentTimeMillis to access appropriate time changes from the moment a range ran
            //to the moment an output was produced
            final long startTime2 = System.currentTimeMillis();
            updatedInefficientRange(workingArr);
            final long endTime2 = System.currentTimeMillis();
            writeString(""+(endTime2 - startTime2));
        }
        writeString("_____________________________");

        writeString("INEFFICIENT RANGE VALUES");
        for (int num: testValuesInefficient) {
            int[] workingArr = new Random().ints(num).toArray();
            //Utilize System.CurrentTimeMillis to access appropriate time changes from the moment a range ran
            //to the moment an output was produced
            final long startTime = System.currentTimeMillis();
            inefficientRange(workingArr);
            final long endTime = System.currentTimeMillis();
            writeString(""+(endTime - startTime));
        }
    }

    static int inefficientRange(int[] numbers) {
        int maxDiff = 0;     // look at each pair of values
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                int diff = Math.abs(numbers[j] - numbers[i]);
                if (diff > maxDiff) {
                    maxDiff = diff;
                }
            }
        }
        return maxDiff;
    }
    public static int updatedInefficientRange(int[] numbers) {
        int maxDiff = 0;     // look at each pair of values
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                int diff = Math.abs(numbers[j] - numbers[i]);
                if (diff > maxDiff) {
                    maxDiff = diff;
                }
            }
        }
        return maxDiff;
    }

    public static int efficientRange(int[] numbers) {
        int max = numbers[0];     // find max/min values
        int min = max;
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < min) {
                min = numbers[i];
            }
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }
        return max - min;
    }
    public static void writeString(String value)
            throws IOException
    {
        // Writing into the file
        String filename= "Logs.txt";
        FileWriter fw = new FileWriter(filename,true); //the true will append the new data
        fw.write(value + "\n");//appends the string to the file
        fw.close();
    }

}
