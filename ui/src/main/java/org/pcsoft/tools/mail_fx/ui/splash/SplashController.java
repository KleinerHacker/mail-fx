package org.pcsoft.tools.mail_fx.ui.splash;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.apache.commons.io.IOUtils;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Christoph on 19.10.2014.
 */
class SplashController implements Initializable {

    @FXML
    private Label lblVersion;
    @FXML
    private ProgressIndicator pbProgress;

    private final boolean standalone;
    private final Stage parent;

    SplashController(boolean standalone, Stage parent) {
        this.standalone = standalone;
        this.parent = parent;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        pbProgress.setVisible(!standalone);
        try {
            lblVersion.setText("Version: " + IOUtils.toString(Thread.currentThread().getContextClassLoader().getResourceAsStream("version.txt")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private void onActionBackgroundLink(ActionEvent actionEvent) {
        if (Desktop.isDesktopSupported()) {
            try {
                Desktop.getDesktop().browse(new URI("http://www.freepik.com/free-photos-vectors/background"));
            } catch (IOException | URISyntaxException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @FXML
    private void onActionLicenceLink(ActionEvent actionEvent) {

    }

    @FXML
    private void onMouseClickBackground(MouseEvent e) {
        if (standalone) {
            parent.close();
        }
    }
}
