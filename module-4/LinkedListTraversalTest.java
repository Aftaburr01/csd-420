import java.util.LinkedList;
import java.util.Iterator;

public class LinkedListTraversalTest {

    // Method to test traversal using iterator
    public static long testIterator(LinkedList<Integer> list) {
        long startTime = System.nanoTime();

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            iterator.next();
        }

        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    // Method to test traversal using get(index)
    public static long testGetMethod(LinkedList<Integer> list) {
        long startTime = System.nanoTime();
        
         for (int i = 0; i < list.size(); i++) {
            list.get(i);
        }

        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    // Method to run test for given size
    public static void runTest(int size) {
        LinkedList<Integer> list = new LinkedList<>();

        // Fill list
        for (int i = 0; i < size; i++) {
            list.add(i);
        }

        System.out.println("\nTesting with " + size + " elements:");

        long iteratorTime = testIterator(list);
        long getTime = testGetMethod(list);

        System.out.println("Iterator time: " + iteratorTime + " ns");
        System.out.println("get(index) time: " + getTime + " ns");
    }

    public static void main(String[] args) {

        // Test with 50,000
        runTest(50000);

        // Test with 500,000
        runTest(500000);
    }
}