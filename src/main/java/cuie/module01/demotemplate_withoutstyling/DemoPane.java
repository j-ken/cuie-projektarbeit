package cuie.module01.demotemplate_withoutstyling;

import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

/**
 * @author Dieter Holz
 */
public class DemoPane extends StackPane {
	private Button button;

	public DemoPane() {
		initializeParts();
		layoutParts();
	}

	private void initializeParts() {
		button = new Button("Hello World");
	}

	private void layoutParts() {
		getChildren().add(button);
	}
}
