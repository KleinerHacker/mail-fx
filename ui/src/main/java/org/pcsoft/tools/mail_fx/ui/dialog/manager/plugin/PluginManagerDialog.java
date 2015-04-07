package org.pcsoft.tools.mail_fx.ui.dialog.manager.plugin;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.Pane;
import org.pcsoft.tools.mail_fx.common_ui.controlsfx.dialogs.builder.DialogBuilderFactory;

import java.io.IOException;

/**
 * Created by Christoph on 13.11.2014.
 */
public final class PluginManagerDialog {

    public static void show() {
        try {
            final FXMLLoader loader = new FXMLLoader();
            loader.setControllerFactory(cl -> {
                if (PluginManagerDialogController.class.equals(cl))
                    return new PluginManagerDialogController();

                try {
                    return cl.newInstance();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });
            loader.setLocation(Thread.currentThread().getContextClassLoader().getResource("fxml/dialog.manager.plugin.fxml"));
            final Pane pane = loader.load();

            DialogBuilderFactory.createCustomDialog()
                    .title("Plugin Manager")
                    .headerText("Shows the installed plugins")
                    .buttons(ButtonType.CLOSE)
                    .content(pane)
                    .show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private PluginManagerDialog() {
    }
}
