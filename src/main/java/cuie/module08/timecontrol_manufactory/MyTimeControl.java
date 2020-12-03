package cuie.module08.timecontrol_manufactory;

import javafx.beans.property.*;
import javafx.css.PseudoClass;
import javafx.scene.control.Control;
import javafx.scene.control.Skin;
import javafx.scene.text.Font;
import javafx.util.converter.LocalTimeStringConverter;

import java.time.LocalTime;
import java.util.regex.Pattern;

public class MyTimeControl extends Control {

    private static final PseudoClass DELAYED_CLASS = PseudoClass.getPseudoClass("delayed");
    private static final PseudoClass CANCELLED_CLASS = PseudoClass.getPseudoClass("cancelled");
    private static final PseudoClass INVALID_CLASS = PseudoClass.getPseudoClass("invalid");

    private static final String CONVERTIBLE_REGEX = "now|(\\d{1,2}[:]{0,1}\\d{0,2})";
    private static final String TIME_FORMAT_REGEX = "\\d{2}:\\d{2}";

    private static final String FORMATTED_TIME_PATTERN = "HH:mm";

    private static final Pattern CONVERTIBLE_PATTERN = Pattern.compile(CONVERTIBLE_REGEX);
    private static final Pattern TIME_FORMAT_PATTERN = Pattern.compile(TIME_FORMAT_REGEX);

    private final SkinType skinType;

    //all properties
    private final ObjectProperty<LocalTime> timeValue = new SimpleObjectProperty<>();
    private final StringProperty timeAsString = new SimpleStringProperty();
    private final StringProperty caption = new SimpleStringProperty();
    private final BooleanProperty cancelled = new SimpleBooleanProperty();



    private final BooleanProperty delayed = new SimpleBooleanProperty(){
        @Override
        protected void invalidated() {
            pseudoClassStateChanged(DELAYED_CLASS, get());
        }
    };

    private final BooleanProperty invalid = new SimpleBooleanProperty(){
        @Override
        protected void invalidated() {
            pseudoClassStateChanged(INVALID_CLASS, get());
        }
    };

    private final BooleanProperty cancel = new SimpleBooleanProperty(){
        @Override
        protected void invalidated() {
            pseudoClassStateChanged(CANCELLED_CLASS, get());
        }
    };

    public MyTimeControl(SkinType skinType) {
        this.skinType = skinType;
        initializeSelf();
    }

    private void initializeSelf() {

        getStyleClass().add("my-time-control");

        timeAsStringProperty().bindBidirectional(timeValueProperty(),
                    new LocalTimeStringConverter(){
                        @Override
                        public LocalTime fromString(String value) {
                            try {
                                LocalTime time = super.fromString(value);
                                setInvalid(false);
                                return time;
                            }
                            catch (Exception e){
                                setInvalid(true);
                                return getTimeValue();
                            }
                        }
                    }
                );
    }

    @Override
    protected Skin<?> createDefaultSkin() {
        return skinType.getFactory().apply(this);
    }


    public void loadFonts(String... font){
        for(String f : font){
            Font.loadFont(getClass().getResourceAsStream(f), 0);
        }
    }

    public void addStylesheetFiles(String... stylesheetFile){
        for(String file : stylesheetFile){
            String stylesheet = getClass().getResource(file).toExternalForm();
            getStylesheets().add(stylesheet);
        }
    }

    public LocalTime getTimeValue() {
        return timeValue.get();
    }

    public ObjectProperty<LocalTime> timeValueProperty() {
        return timeValue;
    }

    public void setTimeValue(LocalTime timeValue) {
        this.timeValue.set(timeValue);
    }

    public String getCaption() {
        return caption.get();
    }

    public StringProperty captionProperty() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption.set(caption);
    }

    public boolean isMandatory() {
        return delayed.get();
    }

    public BooleanProperty mandatoryProperty() {
        return delayed;
    }

    public void setMandatory(boolean mandatory) {
        this.delayed.set(mandatory);
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

    public cuie.module08.timecontrol_manufactory.SkinType getSkinType() {
        return skinType;
    }

    public String getTimeAsString() {
        return timeAsString.get();
    }

    public StringProperty timeAsStringProperty() {
        return timeAsString;
    }

    public void setTimeAsString(String timeAsString) {
        this.timeAsString.set(timeAsString);
    }

    public boolean isCancelled() {
        return cancelled.get();
    }

    public boolean isDelayed() {
        return delayed.get();
    }

    public BooleanProperty delayedProperty() {
        return delayed;
    }

    public void setDelayed(boolean delayed) {
        this.delayed.set(delayed);
    }

    public boolean isCancel() {
        return cancel.get();
    }

    public BooleanProperty cancelProperty() {
        return cancel;
    }

    public void setCancel(boolean cancel) {
        this.cancel.set(cancel);
    }

    public boolean isInvalid() {
        return invalid.get();
    }

    public BooleanProperty invalidProperty() {
        return invalid;
    }

    public void setInvalid(boolean invalid) {
        this.invalid.set(invalid);
    }
}
