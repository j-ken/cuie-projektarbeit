package cuie.module03.led_and_slider.demo;
import cuie.module03.led_and_slider.LED;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

/**
 * @author Dieter Holz
 */
public class DemoUI extends BorderPane {
    private final DemoPM pm;

    private       LED    led;
    private       Button onButton;
    private       Button offButton;
    private       Slider slider;

    public DemoUI(DemoPM pm) {
        this.pm = pm;
        initializeParts();
        layoutParts();
        setupEventHandler();
        setupBindings();
    }

    private void initializeParts() {
        led       = new LED();
        slider    = new Slider();
    }

    private void layoutParts() {
        setCenter(led);

        slider.setMin(0);
        slider.setMax(100);
        slider.setValue(0);
        slider.setMajorTickUnit(10);
        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);

//        VBox buttonBox = new VBox(10, slider);
        HBox buttonBoxxH = new HBox(10, slider);
        buttonBoxxH.setPadding(new Insets(10));

//        setRight(buttonBox);
        setBottom(buttonBoxxH);
    }

    private void setupEventHandler() {

    }

    private void setupBindings(){
        led.onProperty().bindBidirectional(pm.inDangerZoneProperty());

        slider.valueProperty().bindBidirectional(pm.valueProperty());
    }

}
