import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Map.Entry;

import javax.annotation.processing.FilerException;

public class App {
    public static void main(String[] args) throws Exception {
        String fileName = "words.txt";

        String line;
        Map<String,Integer> counts = new TreeMap<>();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))){
            while((line = bufferedReader.readLine())!=null){
                line = line.toLowerCase();
                if(counts.containsKey(line))
                {
                    counts.put(line,counts.get(line)+1);
                }
                else
                {
                    counts.put(line,1);
                }
            }
        }

        String outFileName = "count.txt";
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outFileName)))
        {
            for(Entry<String, Integer> entry: counts.entrySet())
            {
                bufferedWriter.write(entry.getKey()+" "+entry.getValue()+"\n");
            }
        }
    }
}
