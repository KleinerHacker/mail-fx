package org.pcsoft.tools.mail_fx.plugin.mail_protocol.impl.smtp;

import org.pcsoft.tools.mail_fx.plugin.mail_protocol.api.MailProtocol;
import org.pcsoft.tools.mail_fx.plugin.mail_protocol.api.MailProtocolSettings;
import org.pcsoft.tools.mail_fx.plugin.mail_protocol.api.annotations.MailProtocolDescription;
import org.pcsoft.tools.mail_fx.plugin.mail_protocol.impl.smtp.types.SmtpMailProtocolData;

import java.util.Properties;

/**
 * Created by Christoph on 08.11.2014.
 */
@MailProtocolDescription(id = "smtp", name = "SMTP", protocolName = "smtp", description = "Mail Protocol SMTP")
public class SmtpMailProtocol implements MailProtocol<SmtpMailProtocolData> {

    @Override
    public MailProtocolSettings<SmtpMailProtocolData> getSettings() {
        return new SmtpMailProtocolSettings();
    }

    @Override
    public SmtpMailProtocolData createMailProtocolData() {
        return new SmtpMailProtocolData();
    }

    @Override
    public SmtpMailProtocolData createMailProtocolData(String host, int port) {
        return new SmtpMailProtocolData(host, port);
    }

    @Override
    public SmtpMailProtocolData loadMailProtocolData(Properties properties) {
        final SmtpMailProtocolData mailProtocolData = new SmtpMailProtocolData();
        mailProtocolData.load(properties);

        return mailProtocolData;
    }
}
