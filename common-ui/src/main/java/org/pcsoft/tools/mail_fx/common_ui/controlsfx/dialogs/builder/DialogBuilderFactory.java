package org.pcsoft.tools.mail_fx.common_ui.controlsfx.dialogs.builder;

import javafx.scene.control.Alert;
import org.controlsfx.dialog.CommandLinksDialog;

/**
 * Created by Christoph on 13.11.2014.
 */
public final class DialogBuilderFactory {

    public static CustomDialogBuilder createCustomDialog() {
        return CustomDialogBuilder.create();
    }

    public static AlertDialogBuilder createAlertDialog(Alert.AlertType alertType) {
        return AlertDialogBuilder.create(alertType);
    }

    public static CommandLinkDialogBuilder createCommandLinkDialogBuilder(CommandLinksDialog.CommandLinksButtonType... buttonTypes) {
        return CommandLinkDialogBuilder.create(buttonTypes);
    }

    public static ExceptionDialogBuilder createExceptionDialogBuilder(Throwable e) {
        return ExceptionDialogBuilder.create(e);
    }

    private DialogBuilderFactory() {
    }
}
