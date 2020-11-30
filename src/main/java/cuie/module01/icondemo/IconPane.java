package cuie.module01.icondemo;

import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;

/**
 * @author Dieter Holz
 */
public class IconPane extends StackPane {
	private static final String SAVE   = "\uf0c7";

	private Button button;

	public IconPane() {
        initializeSelf();
		initializeParts();
		layoutParts();
	}

    private void initializeSelf() {
        Font.loadFont(getClass().getResourceAsStream("/fonts/fontawesome-webfont.ttf"), 0);

        String stylesheet = getClass().getResource("style.css").toExternalForm();
        getStylesheets().add(stylesheet);

        getStyleClass().add("icon-pane");
    }

	private void initializeParts() {
		button = new Button(SAVE);
		button.getStyleClass().add("icon");
	}

	private void layoutParts() {
		getChildren().add(button);
	}
}
