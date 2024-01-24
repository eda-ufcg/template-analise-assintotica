import java.io.*;
import java.util.Arrays;
public class AnaliseAssintotica {

    public static void main(String[] args) {

        // lendo da entrada padrão
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String line = "";
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(" ");
                int[] v = Arrays.stream(tokens).mapToInt(Integer::parseInt).toArray();
                
                long start = System.nanoTime();
                Sorting.insertionSort(v);
                long end = System.nanoTime();
                long time = end - start;
                System.out.println("insertion " + (time) + " " + tokens.length);


                start = System.nanoTime();
                Sorting.mergeSort(v, 0, v.length - 1);
                end = System.nanoTime();
                time = end - start;
                System.out.println("merge " + (time) + " " + tokens.length);

            }
        } catch (IOException ioe) {}

    }

    



}
