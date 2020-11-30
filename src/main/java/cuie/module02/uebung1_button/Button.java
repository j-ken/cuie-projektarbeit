package cuie.module02.uebung1_button;

import javafx.geometry.Insets;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Button extends Region {

    private static final double ARTBOARD_SIZE = 400;

    private static final double PREFERRED_SIZE = ARTBOARD_SIZE;
    private static final double MINIMUM_SIZE   = 14;
    private static final double MAXIMUM_SIZE   = 800;

    private static final Color BUTTON_COLOR = Color.rgb(0, 255, 0);

    private Circle background;
    private Circle innerCircle;
    private Circle glow;

    private Pane drawingPane;

    private static double sizeFactor() {
        return PREFERRED_SIZE / ARTBOARD_SIZE;
    }

    public Button() {
        initializeSelf();
        initializeParts();
        layoutParts();
    }

    private void initializeSelf() {
        String stylesheet = getClass().getResource("style.css").toExternalForm();
        getStylesheets().add(stylesheet);

        Insets padding           = getPadding();
        double verticalPadding   = padding.getTop() + padding.getBottom();
        double horizontalPadding = padding.getLeft() + padding.getRight();

        setMinSize(MINIMUM_SIZE + horizontalPadding, MINIMUM_SIZE + verticalPadding);
        setPrefSize(PREFERRED_SIZE + horizontalPadding, PREFERRED_SIZE + verticalPadding);
        setMaxSize(MAXIMUM_SIZE + horizontalPadding, MAXIMUM_SIZE + verticalPadding);
    }

    private void initializeParts() {
        double center = 200;

        background = new Circle(center, center, 200 * sizeFactor());
        background.getStyleClass().addAll("background");

        innerCircle = new Circle(center, center, 169 * sizeFactor());
        innerCircle.getStyleClass().addAll("inner-circle");

        glow = new Circle(center, center, 157 * sizeFactor());
        glow.getStyleClass().addAll("glow");

//        mainOn = new Circle(center, center, 144 * sizeFactor());
//        mainOn.getStyleClass().addAll("main-on");
//        mainOn.setEffect(GLOW);
//
//        mainOff = new Circle(center, center, 144 * sizeFactor());
//        mainOff.getStyleClass().addAll("main-off");
//        mainOff.setEffect(INNER_SHADOW);
//
//        frame = new Circle(center, center, 200 * sizeFactor());
//        frame.getStyleClass().addAll("frame");

        drawingPane = new Pane();
        drawingPane.setMaxSize(PREFERRED_SIZE, PREFERRED_SIZE);
        drawingPane.setMinSize(PREFERRED_SIZE, PREFERRED_SIZE);
        drawingPane.setPrefSize(PREFERRED_SIZE, PREFERRED_SIZE);
        drawingPane.getStyleClass().add("led");
    }

    private void layoutParts() {
        drawingPane.getChildren().addAll(background, innerCircle, glow);
        getChildren().add(drawingPane);
    }

    @Override
    protected void layoutChildren() {
        super.layoutChildren();
        resize();
    }

    private void resize() {
        Insets padding         = getPadding();
        double availableWidth  = getWidth() - padding.getLeft() - padding.getRight();
        double availableHeight = getHeight() - padding.getTop() - padding.getBottom();
        double size            = Math.max(Math.min(Math.min(availableWidth, availableHeight), MAXIMUM_SIZE), MINIMUM_SIZE);

        double scalingFactor = size / PREFERRED_SIZE;

        if (availableWidth > 0 && availableHeight > 0) {
            drawingPane.relocate((getWidth() - PREFERRED_SIZE) * 0.5, (getHeight() - PREFERRED_SIZE) * 0.5);
            drawingPane.setScaleX(scalingFactor);
            drawingPane.setScaleY(scalingFactor);
        }
    }
}
