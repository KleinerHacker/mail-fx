package org.pcsoft.tools.mail_fx.plugin.mail_protocol.impl.pop3;

import javafx.scene.Node;
import org.pcsoft.tools.mail_fx.plugin.mail_protocol.api.MailProtocolSettings;
import org.pcsoft.tools.mail_fx.plugin.mail_protocol.impl.pop3.page.settings.SettingsPage;
import org.pcsoft.tools.mail_fx.plugin.mail_protocol.impl.pop3.types.Pop3MailProtocolData;

/**
 * Created by Christoph on 08.11.2014.
 */
public final class Pop3MailProtocolSettings implements MailProtocolSettings<Pop3MailProtocolData> {

    @Override
    public Node buildSettingsPage(Pop3MailProtocolData mailProtocolData) {
        return SettingsPage.build(mailProtocolData);
    }
}
