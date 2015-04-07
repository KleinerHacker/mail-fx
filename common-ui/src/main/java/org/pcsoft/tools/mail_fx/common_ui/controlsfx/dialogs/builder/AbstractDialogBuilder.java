package org.pcsoft.tools.mail_fx.common_ui.controlsfx.dialogs.builder;

import javafx.scene.Node;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Window;

import java.util.Optional;

/**
 * Created by Christoph on 13.11.2014.
 */
abstract class AbstractDialogBuilder<T extends AbstractDialogBuilder<T,D>, D extends Dialog<ButtonType>> implements DialogBuilder<T> {

    protected final D dialog;

    public AbstractDialogBuilder(D dialog) {
        this.dialog = dialog;
        this.dialog.setResizable(false);
    }

    @Override
    public T owner(Window window) {
        dialog.initOwner(window);
        return (T) this;
    }

    @Override
    public T title(String title) {
        dialog.setTitle(title);
        return (T) this;
    }

    @Override
    public T headerText(String headerText) {
        dialog.setHeaderText(headerText);
        return (T) this;
    }

    @Override
    public T graphic(Node graphic) {
        dialog.setGraphic(graphic);
        return (T) this;
    }

    @Override
    public T graphic(Image image) {
        dialog.setGraphic(new ImageView(image));
        return (T) this;
    }

    @Override
    public Optional<ButtonType> show() {
        return dialog.showAndWait();
    }
}
