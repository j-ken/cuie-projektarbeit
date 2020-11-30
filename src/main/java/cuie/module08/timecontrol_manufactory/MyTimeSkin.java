package cuie.module08.timecontrol_manufactory;

import javafx.scene.control.Label;
import javafx.scene.control.SkinBase;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

class MyTimeSkin extends SkinBase<MyTimeControl> {
    // wird spaeter gebraucht
    private static final int ICON_SIZE  = 12;
    private static final int IMG_OFFSET = 4;

    private static ImageView invalidIcon = new ImageView(new Image(MyTimeSkin.class.getResource("icons/invalid.png").toExternalForm(),
                                                                   ICON_SIZE, ICON_SIZE,
                                                                   true, false));

    private static ImageView validIcon = new ImageView(new Image(MyTimeSkin.class.getResource("icons/valid.png").toExternalForm(),
                                                                   ICON_SIZE, ICON_SIZE,
                                                                   true, false));


    private TextField editableTimeField;
    private Text captionLabel;
    //Hier muss umgestellt werden für spezifisches Controll Flugi ;)
    private Label cancelledFieldBeforeTime;
    private Label cancelledFieldAfterTime;
    private Label cancelledField;

    MyTimeSkin(MyTimeControl control) {
        super(control);
        initializeSelf();
        initializeParts();
        layoutParts();
        setupValueChangeListeners();
        setupBindings();
    }

    private void initializeSelf() {
        // getSkinnable().loadFonts("/fonts/Lato/Lato-Reg.ttf", "/fonts/Lato/Lato-Lig.ttf");
        getSkinnable().addStylesheetFiles("style.css");
    }

    private void initializeParts() {

        cancelledFieldBeforeTime = new Label("Departing at: ");
        cancelledFieldBeforeTime.setVisible(false);

        cancelledFieldAfterTime = new Label ("is cancelled");
        cancelledFieldAfterTime.setVisible(false);

        editableTimeField = new TextField();
        editableTimeField.getStyleClass().add("editable-time-field");
        editableTimeField.setVisible(getSkinnable().getCancelled());

        captionLabel = new Text();
        captionLabel.getStyleClass().add("caption-label");

        cancelledField = new Label();
        cancelledField.setVisible(!getSkinnable().getCancelled());
        cancelledField.getStyleClass().add("read-only-field");
    }

    private void layoutParts() {
        getChildren().addAll(new VBox(  captionLabel,
                                        editableTimeField, cancelledFieldBeforeTime,
                cancelledField, cancelledFieldAfterTime));
    }

    private void setupValueChangeListeners() {
        getSkinnable().cancelledProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue){
                editableTimeField.setVisible(true);
                cancelledField.setVisible(false);
                cancelledFieldBeforeTime.setVisible(false);
                cancelledFieldAfterTime.setVisible(false);
            }
            else{
                editableTimeField.setVisible(false);
                cancelledField.setVisible(true);
                cancelledFieldBeforeTime.setVisible(true);
                cancelledFieldAfterTime.setVisible(true);
            }
        });
    }

    private void setupBindings() {
        editableTimeField.textProperty().bindBidirectional(getSkinnable().timeAsStringProperty());
        captionLabel.textProperty().bind(getSkinnable().captionProperty());
        cancelledField.textProperty().bind(getSkinnable().timeValueProperty().asString());
    }
}
