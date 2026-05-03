import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/*
 * Name: Your Name
 * Course: CSD420
 * Module: 7
 * Assignment: JavaFX CSS Styling
 */

public class Rahman_Mod7_CSD420 extends Application {

    @Override
    public void start(Stage stage) {

        // Create circles
        Circle c1 = new Circle(50);
        Circle c2 = new Circle(50);
        Circle c3 = new Circle(50);
        Circle c4 = new Circle(50);

        // Apply style class
        c1.getStyleClass().add("white-circle");
        c2.getStyleClass().add("white-circle");
        c3.getStyleClass().add("white-circle");
        c4.getStyleClass().add("white-circle");

        // Apply IDs for color override
        c2.setId("red-circle");
        c3.setId("green-circle");

        // Layout
        HBox root = new HBox(20, c1, c2, c3, c4);
        root.setStyle("-fx-padding: 20; -fx-alignment: center;");

        // Scene
        Scene scene = new Scene(root, 400, 150);

        // Attach CSS file
        scene.getStylesheets().add("mystyle.css");

        // Stage
        stage.setTitle("Module 7 - CSS Styling");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}