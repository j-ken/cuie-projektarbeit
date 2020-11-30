package cuie.module01.simplecontrols;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import fr.brouillard.oss.cssfx.CSSFX;

public class SimpleControlsStarter extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent rootPanel = new SimpleControlsPane();

		Scene scene = new Scene(rootPanel);

		primaryStage.setTitle("Simple Controls");
		primaryStage.setScene(scene);

		primaryStage.centerOnScreen();
		primaryStage.show();
        CSSFX.start();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
