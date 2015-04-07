package org.pcsoft.tools.mail_fx.plugin.mail_protocol.impl.smtp.types;

import javafx.beans.property.ReadOnlyObjectProperty;
import org.pcsoft.tools.mail_fx.plugin.mail_protocol.api.types.AbstractMailProtocolData;
import org.pcsoft.tools.mail_fx.plugin.mail_protocol.api.types.MailProtocolData;
import org.pcsoft.tools.mail_fx.plugin.mail_protocol.api.types.props.SimpleMailProtocolDataProperty;
import org.pcsoft.tools.mail_fx.plugin.mail_protocol.impl.smtp.types.props.ReadOnlySmtpMailProtocolDataWrapper;
import org.pcsoft.tools.mail_fx.plugin.mail_protocol.impl.smtp.types.props.SimpleSmtpMailProtocolDataProperty;

import java.util.Properties;

/**
 * Created by Christoph on 08.11.2014.
 */
public final class SmtpMailProtocolData extends AbstractMailProtocolData {

    public SmtpMailProtocolData(String host, int port) {
        super(host, port);
    }

    public SmtpMailProtocolData() {
    }

    @Override
    public Properties save() {
        return null;
    }

    @Override
    public void load(Properties properties) {

    }

    @Override
    public Properties buildSessionProperties() {
        return null;
    }

    @Override
    public SimpleMailProtocolDataProperty toSimpleProperty() {
        return new SimpleSmtpMailProtocolDataProperty(this);
    }

    @Override
    public ReadOnlyObjectProperty<? extends MailProtocolData> toReadOnlyProperty() {
        return new ReadOnlySmtpMailProtocolDataWrapper(this).getReadOnlyProperty();
    }
}
