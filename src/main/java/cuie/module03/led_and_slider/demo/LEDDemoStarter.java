package cuie.module03.led_and_slider.demo;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LEDDemoStarter extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
        DemoPM pm        = new DemoPM();
        Parent rootPanel = new DemoUI(pm);

		Scene scene = new Scene(rootPanel);

        primaryStage.titleProperty().bind(pm.demoTitleProperty());

        primaryStage.setScene(scene);
		primaryStage.setWidth(300);
		primaryStage.setHeight(300);

		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}