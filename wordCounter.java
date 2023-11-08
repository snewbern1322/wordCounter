import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;



public class wordCounter {
    public static void main(String[]args) {
        //txt input & output files
        String nameInputFile = "input.txt";
        String nameOutputFile = "output.txt";

        //store words with hashmap
        Map<String, Integer> wordCountMap = new HashMap<>();

        try {//reader content in input.txt
            BufferedReader reader = new BufferedReader(new FileReader(nameInputFile));

            String line;
            while ((line = reader.readLine()) != null) {
                //check for null line
                if (line.isEmpty()) {
                    continue;
                }

                //normalize to lowercase
                String word = line.toLowerCase().trim();

                //word count in hashmap
                wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);

            }
            //close reader
            reader.close();

            //write to output file
            FileWriter writer = new FileWriter(nameOutputFile);

            for(Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
                writer.write(entry.getKey() + entry.getValue() + "\n"); //get word create new line
            }

            //close writer
            writer.close();

            //message in terminal
            System.out.println("Word count put in " + nameOutputFile);

        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
