package cuie.module02.resizing_a;

import javafx.geometry.Insets;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

/**
 * @author Dieter Holz
 */
public class ResizingTemplatePane extends Region {
	private static final double ARTBOARD_SIZE = 300;
	private static final double MINIMUM_SIZE  = 75;
	private static final double MAXIMUM_SIZE  = 800;

	private static final Color  COLOR          = Color.rgb(2, 138, 204);
	private static final double BORDER_WIDTH   = 2.0;
	private static final double LINE_WIDTH     = 1.0;
	private static final double CENTER_RADIUS  = 5.0;

	private Rectangle border;
	private Line      line1;
	private Line      line2;
	private Circle    center;
	private Rectangle innerRect;

	private Pane drawingPane;

	public ResizingTemplatePane() {
		initializeSizes();
        initializeSelf();
		initializeControls();
		layoutControls();
	}

    private void initializeSizes() {
		Insets padding           = getPadding();
		double verticalPadding   = padding.getTop() + padding.getBottom();
		double horizontalPadding = padding.getLeft() + padding.getRight();
		setMinSize(MINIMUM_SIZE + horizontalPadding, MINIMUM_SIZE + verticalPadding);
		setPrefSize(ARTBOARD_SIZE + horizontalPadding, ARTBOARD_SIZE + verticalPadding);
		setMaxSize(MAXIMUM_SIZE + horizontalPadding, MAXIMUM_SIZE + verticalPadding);
	}

    private void initializeSelf() {
        String stylesheet = getClass().getResource("style.css").toExternalForm();
        getStylesheets().add(stylesheet);

        getStyleClass().add("resizing-template-pane");
    }


	private void initializeControls() {
		border = new Rectangle();
		border.setFill(COLOR.deriveColor(0, 0.3, 1.5, 1));
		border.setStroke(COLOR);

		line1 = new Line();
		line1.setStroke(COLOR);

		line2 = new Line();
		line2.setStroke(COLOR);

		center = new Circle();
		center.setFill(Color.TRANSPARENT);
		center.setStroke(COLOR);

		innerRect = new Rectangle();
		innerRect.setStroke(COLOR);
		innerRect.setFill(Color.TRANSPARENT);

		drawingPane = new Pane();
	}

	private void layoutControls() {
		drawingPane.getChildren().addAll(border, line1, line2, center, innerRect);
		getChildren().add(drawingPane);
	}

	@Override
	protected void layoutChildren() {
		super.layoutChildren();
		resize();
	}

	private void resize() {
		double width  = getWidth() - getInsets().getLeft() - getInsets().getRight();
		double height = getHeight() - getInsets().getTop() - getInsets().getBottom();
		double size = Math.max(Math.min(Math.min(width, height), MAXIMUM_SIZE), MINIMUM_SIZE);

		double scalingFactor = size / ARTBOARD_SIZE;

		if(width > 0 && height > 0){
			drawingPane.setMaxSize(size, size);
			drawingPane.setMinSize(size, size);
			drawingPane.relocate((getWidth() - size) * 0.5, (getHeight() - size) * 0.5);

			border.setX(0.0);
			border.setY(0.0);
			border.setWidth(size);
			border.setHeight(size);
			border.setStrokeWidth(BORDER_WIDTH * scalingFactor);

			line1.setStartX(0.0);
			line1.setStartY(0.0);
			line1.setEndX(size);
			line1.setEndY(size);
			line1.setStrokeWidth(LINE_WIDTH * scalingFactor);

			line2.setStartX(0.0);
			line2.setStartY(size);
			line2.setEndX(size);
			line2.setEndY(0.0);
			line2.setStrokeWidth(LINE_WIDTH * scalingFactor);

			center.setCenterX(size * 0.5);
			center.setCenterY(size * 0.5);
			center.setRadius(CENTER_RADIUS * scalingFactor);
			center.setStrokeWidth(LINE_WIDTH * scalingFactor);

			innerRect.relocate(size * 0.25, size * 0.25);
			innerRect.setWidth(size * 0.5);
			innerRect.setHeight(size * 0.5);
			innerRect.setStrokeWidth(LINE_WIDTH * scalingFactor);
		}
	}
}
