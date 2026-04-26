import java.util.Comparator;

/*
 * Name: Aftabur Rahman
 * Course: CSD420
 * Module: 6
 * Assignment: Generic Bubble Sort (Comparable & Comparator)
 */

public class Rahman_Mod6_CSD420 {

    // ?? Bubble sort using Comparable
    public static <E extends Comparable<E>> void bubbleSort(E[] list) {
        boolean swapped;

        for (int i = 0; i < list.length - 1; i++) {
            swapped = false;

            for (int j = 0; j < list.length - 1 - i; j++) {
                if (list[j].compareTo(list[j + 1]) > 0) {
                    // Swap
                    E temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                    swapped = true;
                }
            }

            // Optimization: stop if already sorted
            if (!swapped) break;
        }
    }

    // ?? Bubble sort using Comparator
    public static <E> void bubbleSort(E[] list, Comparator<E> comparator) {
        boolean swapped;

        for (int i = 0; i < list.length - 1; i++) {
            swapped = false;

            for (int j = 0; j < list.length - 1 - i; j++) {
                if (comparator.compare(list[j], list[j + 1]) > 0) {
                    // Swap
                    E temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) break;
        }
    }

    // ?? Utility method to print array
    public static <E> void printArray(E[] list) {
        for (E element : list) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    // ?? TEST CODE
    public static void main(String[] args) {

        // Test Comparable (Integers)
        Integer[] numbers = {5, 2, 9, 1, 3};

        System.out.println("Before sorting (Comparable):");
        printArray(numbers);

        bubbleSort(numbers);

        System.out.println("After sorting (Comparable):");
        printArray(numbers);

        // Test Comparator (Strings - reverse order)
        String[] names = {"Alice", "Bob", "Charlie", "David"};

        System.out.println("\nBefore sorting (Comparator):");
        printArray(names);

        bubbleSort(names, (a, b) -> b.compareTo(a)); // reverse order

        System.out.println("After sorting (Comparator - reverse):");
        printArray(names);
    }
}