package org.pcsoft.tools.mail_fx.ui.window.main;

import javafx.fxml.FXML;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Christoph on 19.10.2014.
 */
class MainWindowController extends AbstractMainWindowController {

    @FXML
    private MainWindowMenuController menuController;
    @FXML
    private MainWindowContentController contentController;
    @FXML
    private MainWindowStatusbarController statusbarController;

    public MainWindowController(Stage parent) {
        super(parent);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
