package org.pcsoft.tools.mail_fx.plugin.mail_protocol.api;

import org.pcsoft.tools.mail_fx.plugin.mail_protocol.api.types.MailProtocolData;

import java.util.Properties;

/**
 * Represent the interface for a mail protocol. Must be annotated with {@link org.pcsoft.tools.mail_fx.plugin.mail_protocol.api.annotations.MailProtocolDescription}
 */
public interface MailProtocol<D extends MailProtocolData> {

    MailProtocolSettings<D> getSettings();

    D createMailProtocolData();
    D createMailProtocolData(String host, int port);
    D loadMailProtocolData(Properties properties);

}
