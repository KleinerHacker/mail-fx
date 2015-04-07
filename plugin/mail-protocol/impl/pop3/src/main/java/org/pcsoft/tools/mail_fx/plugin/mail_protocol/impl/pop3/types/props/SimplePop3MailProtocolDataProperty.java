package org.pcsoft.tools.mail_fx.plugin.mail_protocol.impl.pop3.types.props;

import org.pcsoft.tools.mail_fx.plugin.mail_protocol.api.types.props.SimpleMailProtocolDataProperty;
import org.pcsoft.tools.mail_fx.plugin.mail_protocol.impl.pop3.types.Pop3MailProtocolData;

/**
 * Created by Christoph on 08.11.2014.
 */
public class SimplePop3MailProtocolDataProperty extends SimpleMailProtocolDataProperty<Pop3MailProtocolData> {

    public SimplePop3MailProtocolDataProperty() {
    }

    public SimplePop3MailProtocolDataProperty(String host, int port, boolean enableTsl) {
        super(new Pop3MailProtocolData(host, port, enableTsl));
    }

    public SimplePop3MailProtocolDataProperty(Pop3MailProtocolData initialValue) {
        super(initialValue);
    }

    @Override
    protected void _unregister() {
        get().enableTlsProperty().removeListener((v, o, n) -> fireValueChangedEvent());
    }

    @Override
    protected void _register() {
        get().enableTlsProperty().addListener((v, o, n) -> fireValueChangedEvent());
    }
}
