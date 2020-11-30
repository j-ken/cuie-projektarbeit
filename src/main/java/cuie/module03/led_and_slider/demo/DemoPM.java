package cuie.module03.led_and_slider.demo;

import javafx.beans.property.*;

/**
 * @author Dieter Holz
 */
public class DemoPM {
    private final StringProperty  demoTitle    = new SimpleStringProperty("LED using PresentationModel");
    private final IntegerProperty value        = new SimpleIntegerProperty();
    private final BooleanProperty inDangerZone = new SimpleBooleanProperty(true);

    public DemoPM() {
        inDangerZone.bind(value.greaterThan(70));

        inDangerZone.addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                setDemoTitle("Mehr als 70");
            } else {
                setDemoTitle("Weniger als 70");
            }
        });

    }

    // alle Getter und Setter

    public String getDemoTitle() {
        return demoTitle.get();
    }

    public StringProperty demoTitleProperty() {
        return demoTitle;
    }

    public void setDemoTitle(String demoTitle) {
        this.demoTitle.set(demoTitle);
    }

    public boolean isInDangerZone() {
        return inDangerZone.get();
    }

    public BooleanProperty inDangerZoneProperty() {
        return inDangerZone;
    }

    public void setInDangerZone(boolean inDangerZone) {
        this.inDangerZone.set(inDangerZone);
    }

    public int getValue() {
        return value.get();
    }

    public IntegerProperty valueProperty() {
        return value;
    }

    public void setValue(int value) {
        this.value.set(value);
    }
}
