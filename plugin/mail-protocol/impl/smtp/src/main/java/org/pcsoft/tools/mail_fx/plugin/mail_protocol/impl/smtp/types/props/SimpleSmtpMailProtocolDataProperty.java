package org.pcsoft.tools.mail_fx.plugin.mail_protocol.impl.smtp.types.props;

import org.pcsoft.tools.mail_fx.plugin.mail_protocol.api.types.props.SimpleMailProtocolDataProperty;
import org.pcsoft.tools.mail_fx.plugin.mail_protocol.impl.smtp.types.SmtpMailProtocolData;

/**
 * Created by Christoph on 08.11.2014.
 */
public class SimpleSmtpMailProtocolDataProperty extends SimpleMailProtocolDataProperty<SmtpMailProtocolData> {

    public SimpleSmtpMailProtocolDataProperty() {
    }

    public SimpleSmtpMailProtocolDataProperty(String host, int port) {
        super(new SmtpMailProtocolData(host, port));
    }

    public SimpleSmtpMailProtocolDataProperty(SmtpMailProtocolData initialValue) {
        super(initialValue);
    }

    @Override
    protected void _unregister() {

    }

    @Override
    protected void _register() {

    }
}
