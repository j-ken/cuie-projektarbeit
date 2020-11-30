package cuie.module03.led_on_presentationmodel.demo;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

// PM = Presentation Model
public class DemoPM {
    private final BooleanProperty dangerous = new SimpleBooleanProperty(false);

    public boolean isDangerous() {
        return dangerous.get();
    }

    public BooleanProperty dangerousProperty() {
        return dangerous;
    }

    public void setDangerous(boolean dangerous) {
        this.dangerous.set(dangerous);
    }
}
