import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.Random;

/*
 * Name: Aftabur Rahman
 * Course: CSD420
 * Module: Multithreading Assignment
 */

public class Aftabur_ThreeThreads extends Application {

    private static final int COUNT = 10000;

    @Override
    public void start(Stage stage) {

        TextArea textArea = new TextArea();
        textArea.setWrapText(true);

        BorderPane root = new BorderPane(textArea);
        Scene scene = new Scene(root, 600, 400);

        stage.setTitle("Three Threads Output");
        stage.setScene(scene);
        stage.show();

        // Start threads
        Thread lettersThread = new Thread(() -> generateLetters(textArea));
        Thread numbersThread = new Thread(() -> generateNumbers(textArea));
        Thread symbolsThread = new Thread(() -> generateSymbols(textArea));

        lettersThread.start();
        numbersThread.start();
        symbolsThread.start();

        // Optional: Test completion
        new Thread(() -> {
            try {
                lettersThread.join();
                numbersThread.join();
                symbolsThread.join();

                Platform.runLater(() ->
                        textArea.appendText("\n\n--- All threads completed successfully ---\n"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    // ?? Letters thread
    private void generateLetters(TextArea textArea) {
        Random rand = new Random();

        for (int i = 0; i < COUNT; i++) {
            char c = (char) ('a' + rand.nextInt(26));

            Platform.runLater(() -> textArea.appendText(String.valueOf(c)));

            sleep();
        }
    }

    // ?? Numbers thread
    private void generateNumbers(TextArea textArea) {
        Random rand = new Random();

        for (int i = 0; i < COUNT; i++) {
            char c = (char) ('0' + rand.nextInt(10));

            Platform.runLater(() -> textArea.appendText(String.valueOf(c)));

            sleep();
        }
    }

    // ?? Symbols thread
    private void generateSymbols(TextArea textArea) {
        Random rand = new Random();
        char[] symbols = {'!', '@', '#', '$', '%', '^', '&', '*'};

        for (int i = 0; i < COUNT; i++) {
            char c = symbols[rand.nextInt(symbols.length)];

            Platform.runLater(() -> textArea.appendText(String.valueOf(c)));

            sleep();
        }
    }

    // Small delay for visible interleaving (important for assignment)
    private void sleep() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException ignored) {}
    }

    public static void main(String[] args) {
        launch(args);
    }
}