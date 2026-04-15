import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class WordSetTest {

    public static void main(String[] args) {

        // File reference (must be in same folder)
        File file = new File("collection_of_words.txt");

        // TreeSet automatically sorts and removes duplicates
        Set<String> words = new TreeSet<>();

        try {
            Scanner input = new Scanner(file);

            // Read words from file
            while (input.hasNext()) {
                String word = input.next().toLowerCase();

                // Remove punctuation (optional but good practice)
                word = word.replaceAll("[^a-zA-Z]", "");

                if (!word.isEmpty()) {
                    words.add(word);
                }
            }

            input.close();

            // Display ascending order
            System.out.println("Words in Ascending Order:");
            for (String word : words) {
                System.out.println(word);
            }

            // Display descending order
            System.out.println("\nWords in Descending Order:");
            List<String> descendingList = new ArrayList<>(words);
            Collections.reverse(descendingList);

            for (String word : descendingList) {
                System.out.println(word);
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }
}