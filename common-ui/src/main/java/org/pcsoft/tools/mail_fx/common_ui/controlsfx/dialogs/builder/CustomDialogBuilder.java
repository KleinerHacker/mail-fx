package org.pcsoft.tools.mail_fx.common_ui.controlsfx.dialogs.builder;

import javafx.scene.Node;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;

import java.util.Arrays;
import java.util.Optional;

/**
 * Created by Christoph on 13.11.2014.
 */
public final class CustomDialogBuilder extends AbstractDialogBuilder<CustomDialogBuilder, Dialog<ButtonType>> {

    static CustomDialogBuilder create() {
        return new CustomDialogBuilder();
    }

    private CustomDialogBuilder() {
        super(new Dialog<>());
    }

    public CustomDialogBuilder contentText(String contentText) {
        dialog.getDialogPane().setContentText(contentText);
        return this;
    }

    public CustomDialogBuilder content(Node content) {
        dialog.getDialogPane().setContent(content);
        return this;
    }

    public CustomDialogBuilder buttons(ButtonType... buttonTypes) {
        return buttons(0, buttonTypes);
    }

    public CustomDialogBuilder buttons(int defButtonIndex, ButtonType... buttonTypes) {
        dialog.getDialogPane().getButtonTypes().setAll(Arrays.asList(buttonTypes));
        dialog.getDialogPane().lookupButton(buttonTypes[defButtonIndex]);

        return this;
    }

    @Override
    public Optional<ButtonType> show() {
        return dialog.showAndWait();
    }
}
