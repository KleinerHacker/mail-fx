package org.pcsoft.tools.mail_fx.ui.window.main;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Christoph on 19.10.2014.
 */
class MainWindowContentController extends AbstractMainWindowController {

    @FXML
    private TableView tblMail;
    @FXML
    private TableColumn tbcMailDate;
    @FXML
    private TableColumn tbcMailFrom;
    @FXML
    private TableColumn tbcMailSubject;
    @FXML
    private WebView webMail;

    public MainWindowContentController(Stage parent) {
        super(parent);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
