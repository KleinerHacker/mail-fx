package org.pcsoft.tools.mail_fx.plugin.mail_protocol.impl.pop3.page.settings;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import org.pcsoft.tools.mail_fx.plugin.mail_protocol.impl.pop3.types.Pop3MailProtocolData;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Christoph on 08.11.2014.
 */
class SettingsPageController implements Initializable {

    @FXML
    private CheckBox ckbEnableTls;

    private final Pop3MailProtocolData mailProtocolData;

    public SettingsPageController(Pop3MailProtocolData mailProtocolData) {
        this.mailProtocolData = mailProtocolData;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ckbEnableTls.selectedProperty().bindBidirectional(mailProtocolData.enableTlsProperty());
    }
}
