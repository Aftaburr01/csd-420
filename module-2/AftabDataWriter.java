import java.io.*;
import java.util.Random;

public class AftabDataWriter {
    public static void main(String[] args) {

        Random rand = new Random();

        int[] intArray = new int[5];
        double[] doubleArray = new double[5];

        // Fill arrays with random values
        for (int i = 0; i < 5; i++) {
            intArray[i] = rand.nextInt(100);
            doubleArray[i] = rand.nextDouble() * 100;
        }

        try {
            File file = new File("aftab_datafile.dat");

            // true = append mode
            PrintWriter writer = new PrintWriter(new FileWriter(file, true));

            writer.println("Integers:");
            for (int num : intArray) {
                writer.print(num + " ");
            }

            writer.println("\nDoubles:");
            for (double num : doubleArray) {
                writer.printf("%.2f ", num);
            }

            writer.println("\n----------------------");

            writer.close();

            System.out.println("Data written successfully!");

        } catch (IOException e) {
            System.out.println("Error writing file.");
            e.printStackTrace();
        }
    }
}