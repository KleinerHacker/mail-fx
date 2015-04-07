package org.pcsoft.tools.mail_fx.plugin.mail_protocol.api.types;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.Objects;

/**
 * Created by Christoph on 08.11.2014.
 */
public abstract class AbstractMailProtocolData implements MailProtocolData {

    private final StringProperty host = new SimpleStringProperty();
    private final IntegerProperty port = new SimpleIntegerProperty();

    public AbstractMailProtocolData(String host, int port) {
        this.host.set(host);
        this.port.set(port);
    }

    public AbstractMailProtocolData() {
    }

    @Override
    public final String getHost() {
        return this.host.get();
    }

    @Override
    public final void setHost(String host) {
        this.host.set(host);
    }

    @Override
    public final StringProperty hostProperty() {
        return this.host;
    }

    @Override
    public final int getPort() {
        return this.port.get();
    }

    @Override
    public final void setPort(int port) {
        this.port.set(port);
    }

    @Override
    public final IntegerProperty portProperty() {
        return this.port;
    }

    @Override
    public final ValidationResult validate() {
        if (host.get() == null || host.get().trim().isEmpty())
            return ValidationResult.failure("The host is null or empty");
        if (port.get() <= 0)
            return ValidationResult.failure("The port must be greater than 0");

        return _validate();
    }

    protected ValidationResult _validate() {
        return ValidationResult.success();
    }

    @Override
    public int hashCode() {
        return Objects.hash(host.get(), port.get());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final AbstractMailProtocolData other = (AbstractMailProtocolData) obj;
        return Objects.equals(this.host.get(), other.host.get()) && Objects.equals(this.port.get(), other.port.get());
    }

    @Override
    public String toString() {
        return "AbstractMailProtocolData{" +
                "host=" + host.get() +
                ", port=" + port.get() +
                '}';
    }
}
