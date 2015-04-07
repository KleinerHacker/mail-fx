package org.pcsoft.tools.mail_fx.plugin.mail_protocol.api.types;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.StringProperty;
import org.pcsoft.tools.mail_fx.plugin.mail_protocol.api.types.props.SimpleMailProtocolDataProperty;

import java.util.Properties;

/**
 * Protocol Data
 */
public interface MailProtocolData {
    String getHost();
    void setHost(String host);
    StringProperty hostProperty();

    int getPort();
    void setPort(int port);
    IntegerProperty portProperty();

    SimpleMailProtocolDataProperty toSimpleProperty();
    ReadOnlyObjectProperty<? extends MailProtocolData> toReadOnlyProperty();

    /**
     * Validate the protocol data
     * @return
     */
    ValidationResult validate();

    Properties save();
    void load(Properties properties);

    Properties buildSessionProperties();
}
