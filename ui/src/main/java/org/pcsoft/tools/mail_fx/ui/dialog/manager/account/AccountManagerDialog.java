package org.pcsoft.tools.mail_fx.ui.dialog.manager.account;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import org.pcsoft.tools.mail_fx.common_ui.controlsfx.dialogs.builder.DialogBuilderFactory;

import java.io.IOException;

/**
 * Created by Christoph on 08.11.2014.
 */
public final class AccountManagerDialog {

    public static void show() {
        try {
            final FXMLLoader loader = new FXMLLoader();
            loader.setControllerFactory(cl -> {
                if (AccountManagerDialogController.class.equals(cl))
                    return new AccountManagerDialogController();

                try {
                    return cl.newInstance();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });
            loader.setLocation(Thread.currentThread().getContextClassLoader().getResource("fxml/dialog.manager.account.fxml"));
            final Pane pane = loader.load();

            DialogBuilderFactory.createCustomDialog()
                    .title("Mail Account Manager")
                    .headerText("Manager for all known mail accounts")
                    .graphic(new Image(
                            Thread.currentThread().getContextClassLoader().getResourceAsStream("icons/ic_account48.png")
                    ))
                    .buttons(ButtonType.CLOSE)
                    .content(pane)
                    .show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private AccountManagerDialog() {
    }
}
