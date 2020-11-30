package cuie.module02.uebung1_button;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ButtonStarter extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent rootPanel = new Button();

        Scene scene = new Scene(rootPanel);

        primaryStage.setTitle("Uebung Button");
        primaryStage.setScene(scene);
        primaryStage.setWidth(400);
        primaryStage.setHeight(400);

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
