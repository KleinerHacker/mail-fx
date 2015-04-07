package org.pcsoft.tools.mail_fx.plugin.mail_protocol.impl.pop3;

import org.pcsoft.tools.mail_fx.plugin.mail_protocol.api.MailProtocol;
import org.pcsoft.tools.mail_fx.plugin.mail_protocol.api.MailProtocolSettings;
import org.pcsoft.tools.mail_fx.plugin.mail_protocol.api.annotations.MailProtocolDescription;
import org.pcsoft.tools.mail_fx.plugin.mail_protocol.impl.pop3.types.Pop3MailProtocolData;

import java.util.Properties;

/**
 * Created by Christoph on 29.10.2014.
 */
@MailProtocolDescription(name = "POP3", id = "pop-3", protocolName = "pop3", description = "Mail Protocol POP3")
public final class Pop3MailProtocol implements MailProtocol<Pop3MailProtocolData> {

    @Override
    public MailProtocolSettings<Pop3MailProtocolData> getSettings() {
        return new Pop3MailProtocolSettings();
    }

    @Override
    public Pop3MailProtocolData createMailProtocolData() {
        return new Pop3MailProtocolData();
    }

    @Override
    public Pop3MailProtocolData createMailProtocolData(String host, int port) {
        return new Pop3MailProtocolData(host, port);
    }

    @Override
    public Pop3MailProtocolData loadMailProtocolData(Properties properties) {
        final Pop3MailProtocolData mailProtocolData = new Pop3MailProtocolData();
        mailProtocolData.load(properties);

        return mailProtocolData;
    }
}
