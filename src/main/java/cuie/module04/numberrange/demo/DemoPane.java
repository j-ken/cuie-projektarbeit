package cuie.module04.numberrange.demo;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import cuie.module04.numberrange.NumberRange;

public class DemoPane extends BorderPane {

    private final DemoPM rootPM;

    // declare the custom control
    private NumberRange range;

    // all controls
    private Label  valueLabel;
    private Slider slider;

    public DemoPane(DemoPM rootPM) {
        this.rootPM = rootPM;

        initializeControls();
        layoutControls();
        setupBindings();
    }

    private void initializeControls() {
        setPadding(new Insets(10));

        range = new NumberRange();

        valueLabel = new Label();
        slider = new Slider();
        slider.setShowTickLabels(true);
    }

    private void layoutControls() {
        VBox controlPane = new VBox(new Label("Range Properties"), new Label("Value"), valueLabel, slider);
        controlPane.setPadding(new Insets(0, 50, 0, 50));
        controlPane.setSpacing(10);

        setCenter(range);
        setRight(controlPane);
    }

    private void setupBindings() {
        // auf keinen Fall die beiden UI-Elemente direkt miteinander koppeln:
        // Das hier wäre FALSCH: valueLabel.textProperty().bind(slider.valueProperty().asString());

        // so isses richtig: UI-Elemente immer mit Properties aus dem PresentationModel verbinden
        valueLabel.textProperty().bind(rootPM.temperatureProperty().asString("%.1f"));
        slider.valueProperty().bindBidirectional(rootPM.temperatureProperty());

        range.valueProperty().bindBidirectional(rootPM.temperatureProperty());
    }

}
