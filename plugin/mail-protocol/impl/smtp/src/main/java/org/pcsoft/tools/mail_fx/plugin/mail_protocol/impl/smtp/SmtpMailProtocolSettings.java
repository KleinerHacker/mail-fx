package org.pcsoft.tools.mail_fx.plugin.mail_protocol.impl.smtp;

import javafx.scene.Node;
import javafx.scene.control.Label;
import org.pcsoft.tools.mail_fx.plugin.mail_protocol.api.MailProtocolSettings;
import org.pcsoft.tools.mail_fx.plugin.mail_protocol.impl.smtp.types.SmtpMailProtocolData;

/**
 * Created by Christoph on 08.11.2014.
 */
public class SmtpMailProtocolSettings implements MailProtocolSettings<SmtpMailProtocolData> {

    @Override
    public Node buildSettingsPage(SmtpMailProtocolData mailProtocolData) {
        return new Label("Settings SMTP");
    }
}
