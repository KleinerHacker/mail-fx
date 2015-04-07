package org.pcsoft.tools.mail_fx.common_ui.controlsfx.dialogs.builder;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Arrays;
import java.util.Optional;

/**
 * Created by Christoph on 13.11.2014.
 */
public final class AlertDialogBuilder extends AbstractDialogBuilder<AlertDialogBuilder, Alert> {

    static AlertDialogBuilder create(Alert.AlertType alertType) {
        return new AlertDialogBuilder(alertType);
    }

    private AlertDialogBuilder(Alert.AlertType alertType) {
        super(new Alert(alertType));
    }

    public AlertDialogBuilder message(String message) {
        dialog.setContentText(message);
        return this;
    }

    public AlertDialogBuilder buttons(ButtonType... buttonTypes) {
        dialog.getButtonTypes().setAll(Arrays.asList(buttonTypes));
        return this;
    }

    @Override
    public Optional<ButtonType> show() {
        return dialog.showAndWait();
    }
}
