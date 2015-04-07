package org.pcsoft.tools.mail_fx.plugin.mail_protocol.impl.pop3.types;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import org.pcsoft.tools.mail_fx.plugin.mail_protocol.api.types.AbstractMailProtocolData;
import org.pcsoft.tools.mail_fx.plugin.mail_protocol.api.types.MailProtocolData;
import org.pcsoft.tools.mail_fx.plugin.mail_protocol.api.types.props.SimpleMailProtocolDataProperty;
import org.pcsoft.tools.mail_fx.plugin.mail_protocol.impl.pop3.types.props.ReadOnlyPop3MailProtocolDataWrapper;
import org.pcsoft.tools.mail_fx.plugin.mail_protocol.impl.pop3.types.props.SimplePop3MailProtocolDataProperty;

import java.util.Properties;

/**
 * Created by Christoph on 29.10.2014.
 */
public final class Pop3MailProtocolData extends AbstractMailProtocolData {

    private static final String KEY_HOST = "pop3.host";
    private static final String KEY_PORT = "pop3.port";
    private static final String KEY_TLS = "pop3.tls";

    private static final String PROP_HOST = "mail.pop3.host";
    private static final String PROP_PORT = "mail.pop3.port";
    private static final String PROP_TLS = "mail.pop3.starttls.enable";

    private final BooleanProperty enableTls = new SimpleBooleanProperty();

    public Pop3MailProtocolData(String host, int port, boolean enableTsl) {
        super(host, port);
        this.enableTls.set(enableTsl);
    }

    public Pop3MailProtocolData(String host, int port) {
        super(host, port);
    }

    public Pop3MailProtocolData() {
    }

    public boolean getEnableTls() {
        return enableTls.get();
    }

    public BooleanProperty enableTlsProperty() {
        return enableTls;
    }

    public void setEnableTls(boolean enableTls) {
        this.enableTls.set(enableTls);
    }

    @Override
    public Properties save() {
        final Properties properties = new Properties();
        properties.put(KEY_HOST, getHost());
        properties.put(KEY_PORT, Integer.toString(getPort()));
        properties.put(KEY_TLS, Boolean.toString(enableTls.get()));

        return properties;
    }

    @Override
    public void load(Properties properties) {
        setHost(properties.getProperty(KEY_HOST));
        setPort(Integer.parseInt(properties.getProperty(KEY_PORT)));
        enableTls.set(Boolean.parseBoolean(properties.getProperty(KEY_TLS)));
    }

    @Override
    public Properties buildSessionProperties() {
        final Properties properties = new Properties();
        properties.put(PROP_HOST, getHost());
        properties.put(PROP_PORT, Integer.toString(getPort()));
        properties.put(PROP_TLS, enableTls.get());

        return properties;
    }

    @Override
    public SimpleMailProtocolDataProperty toSimpleProperty() {
        return new SimplePop3MailProtocolDataProperty(this);
    }

    @Override
    public ReadOnlyObjectProperty<? extends MailProtocolData> toReadOnlyProperty() {
        return new ReadOnlyPop3MailProtocolDataWrapper(this).getReadOnlyProperty();
    }

    @Override
    public String toString() {
        return "Pop3MailProtocolData{" +
                "enableTls=" + enableTls +
                "} " + super.toString();
    }
}
