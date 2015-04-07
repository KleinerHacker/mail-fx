package org.pcsoft.tools.mail_fx.common_ui.controlsfx.decoration;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import org.controlsfx.control.decoration.GraphicDecoration;

/**
 * Created by Christoph on 08.11.2014.
 */
public class ValidationDecoration extends GraphicDecoration {

    public ValidationDecoration() {
        super(
                new ImageView(new Image(Thread.currentThread().getContextClassLoader().getResourceAsStream("icons/ic_warn16.png"))),
                Pos.BOTTOM_LEFT
        );
    }

    @Override
    public Node applyDecoration(Node targetNode) {
        targetNode.setEffect(new DropShadow(5, Color.RED));
        return super.applyDecoration(targetNode);
    }

    @Override
    public void removeDecoration(Node targetNode) {
        targetNode.setEffect(null);
        super.removeDecoration(targetNode);
    }
}
