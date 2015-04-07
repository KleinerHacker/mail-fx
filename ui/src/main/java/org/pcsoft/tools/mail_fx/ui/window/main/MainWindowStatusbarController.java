package org.pcsoft.tools.mail_fx.ui.window.main;

import javafx.fxml.FXML;
import javafx.stage.Stage;
import org.controlsfx.control.StatusBar;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Christoph on 19.10.2014.
 */
class MainWindowStatusbarController extends AbstractMainWindowController {

    @FXML
    private StatusBar statusbar;

    public MainWindowStatusbarController(Stage parent) {
        super(parent);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
