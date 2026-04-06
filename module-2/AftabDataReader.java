import java.io.*;

public class AftabDataReader {
    public static void main(String[] args) {

        try {
            File file = new File("aftab_datafile.dat");

            if (!file.exists()) {
                System.out.println("File does not exist.");
                return;
            }

            BufferedReader reader = new BufferedReader(new FileReader(file));

            String line;
            System.out.println("Reading file content:\n");

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            reader.close();

        } catch (IOException e) {
            System.out.println("Error reading file.");
            e.printStackTrace();
        }
    }
}