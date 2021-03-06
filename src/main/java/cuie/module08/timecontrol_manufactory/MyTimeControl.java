package cuie.module08.timecontrol_manufactory;

import javafx.beans.property.*;
import javafx.css.PseudoClass;
import javafx.scene.control.Control;
import javafx.scene.control.Skin;
import javafx.scene.text.Font;

import java.time.LocalTime;
import java.util.regex.Pattern;

public class MyTimeControl extends Control {

    private static final PseudoClass MANDATORY_CLASS = PseudoClass.getPseudoClass("mandatory");

    private static final String CONVERTIBLE_REGEX = "now|(\\d{1,2}[:]{0,1}\\d{0,2})";
    private static final String TIME_FORMAT_REGEX = "\\d{2}:\\d{2}";

    private static final String FORMATTED_TIME_PATTERN = "HH:mm";

    private static final Pattern CONVERTIBLE_PATTERN = Pattern.compile(CONVERTIBLE_REGEX);
    private static final Pattern TIME_FORMAT_PATTERN = Pattern.compile(TIME_FORMAT_REGEX);

    private final SkinType skinType;

    //all properties
    private final ObjectProperty<LocalTime> timeValue = new SimpleObjectProperty<>();
    private final StringProperty caption = new SimpleStringProperty();

    private final BooleanProperty mandatory = new SimpleBooleanProperty(){
        @Override
        protected void invalidated() {
            pseudoClassStateChanged(MANDATORY_CLASS, get());
        }
    };

    public MyTimeControl(SkinType skinType) {
        this.skinType = skinType;

        initializeSelf();
    }

    private void initializeSelf() {
        getStyleClass().add("my-time-control");
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
        return mandatory.get();
    }

    public BooleanProperty mandatoryProperty() {
        return mandatory;
    }

    public void setMandatory(boolean mandatory) {
        this.mandatory.set(mandatory);
    }
}
