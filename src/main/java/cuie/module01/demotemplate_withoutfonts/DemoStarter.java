package cuie.module01.demotemplate_withoutfonts;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import fr.brouillard.oss.cssfx.CSSFX;

/**
 * @author Dieter Holz
 */
public class DemoStarter extends Application {

	@Override
	public void start(Stage primaryStage) {
		Parent rootPanel = new DemoPane();

		Scene scene = new Scene(rootPanel);

		primaryStage.setTitle("Custom Controls Demo");
		primaryStage.setScene(scene);

		primaryStage.show();
      //  CSSFX.start();
	}

	public static void main(String[] args) {
		launch(args);
	}
}