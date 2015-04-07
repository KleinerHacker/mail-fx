package org.pcsoft.tools.mail_fx.plugin.mail_protocol.impl.pop3.page.settings;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import org.pcsoft.tools.mail_fx.plugin.mail_protocol.impl.pop3.types.Pop3MailProtocolData;

import java.io.IOException;

/**
 * Created by Christoph on 08.11.2014.
 */
public final class SettingsPage {

    public static Node build(Pop3MailProtocolData mailProtocolData) {
        try {
            final FXMLLoader loader = new FXMLLoader();
            loader.setControllerFactory(cl -> new SettingsPageController(mailProtocolData));
            loader.setLocation(SettingsPage.class.getClassLoader().getResource("fxml/page.settings.pop3.fxml"));
            loader.setClassLoader(SettingsPage.class.getClassLoader());
            return loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private SettingsPage() {
    }
}
