package cuie.module03.led_on_presentationmodel.demo;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import cuie.module03.led_on_presentationmodel.LED;

/**
 * @author Dieter Holz
 */
public class DemoUI extends BorderPane {
    private LED    led;
    private Button onButton;
    private Button offButton;

    private final DemoPM pm;

    public DemoUI(DemoPM pm) {
        this.pm = pm;

        initializeParts();
        layoutParts();
        setupEventHandler();
        setupBindings();
    }

    private void initializeParts() {
        led       = new LED();
        onButton  = new Button("On");
        offButton = new Button("Off");
    }

    private void layoutParts() {
        setCenter(led);

        VBox buttonBox = new VBox(10, onButton, offButton);
        buttonBox.setPadding(new Insets(10));

        setRight(buttonBox);
    }

    private void setupEventHandler() {
        // bei Bedarf ergaenzen
        onButton.setOnAction(event -> {
            // zustand in PM muss sich ändern
            pm.setDangerous(true);
        });
        offButton.setOnAction(event -> {
            pm.setDangerous(false);
        });
    }

    private void setupBindings() {
        // kann man auch mit changeListener machen,
        // aber bindings sinnvoller
        led.onProperty().bindBidirectional(pm.dangerousProperty());
        onButton.disableProperty().bind(pm.dangerousProperty());
        offButton.disableProperty().bind(pm.dangerousProperty().not());
    }

}
