package cuie.module08.timecontrol_manufactory.demo;

import javafx.beans.property.*;

import java.time.LocalTime;


public class PresentationModel {
    private final ObjectProperty<LocalTime> startTime = new SimpleObjectProperty<>(LocalTime.now());
    private final StringProperty            label     = new SimpleStringProperty("");
    private final BooleanProperty           cancelled = new SimpleBooleanProperty(false);
    private final BooleanProperty delayed = new SimpleBooleanProperty(false);


    public LocalTime getStartTime() {
        return startTime.get();
    }

    public ObjectProperty<LocalTime> startTimeProperty() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime.set(startTime);
    }

    public String getLabel() {
        return label.get();
    }

    public StringProperty labelProperty() {
        return label;
    }

    public void setLabel(String label) {
        this.label.set(label);
    }

    public boolean getCancelled() {
        return cancelled.get();
    }

    public BooleanProperty cancelledProperty() {
        return cancelled;
    }

    public void setCancelled(boolean cancelled) {
        this.cancelled.set(cancelled);
    }

    public boolean getDelayed() {
        return delayed.get();
    }

    public BooleanProperty delayedProperty() {
        return delayed;
    }

    public void setDelayed(boolean delayed) {
        this.delayed.set(delayed);
    }
}
