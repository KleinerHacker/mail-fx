package org.pcsoft.tools.mail_fx.ui.window.main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import org.pcsoft.tools.mail_fx.ui.dialog.manager.account.AccountManagerDialog;
import org.pcsoft.tools.mail_fx.ui.dialog.manager.plugin.PluginManagerDialog;
import org.pcsoft.tools.mail_fx.ui.splash.Splash;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Christoph on 19.10.2014.
 */
class MainWindowMenuController extends AbstractMainWindowController {

    public MainWindowMenuController(Stage parent) {
        super(parent);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private void onActionExit(ActionEvent actionEvent) {
        parent.close();
    }

    @FXML
    private void onActionAbout(ActionEvent actionEvent) {
        Splash.show(true);
    }

    @FXML
    private void onActionAccountManager(ActionEvent actionEvent) {
        AccountManagerDialog.show();
    }

    @FXML
    private void onActionPluginManager(ActionEvent actionEvent) {
        PluginManagerDialog.show();
    }
}
