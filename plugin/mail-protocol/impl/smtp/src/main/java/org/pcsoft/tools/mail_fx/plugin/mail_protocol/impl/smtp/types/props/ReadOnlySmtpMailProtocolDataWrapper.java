package org.pcsoft.tools.mail_fx.plugin.mail_protocol.impl.smtp.types.props;

import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.ReadOnlyObjectPropertyBase;
import org.pcsoft.tools.mail_fx.plugin.mail_protocol.impl.smtp.types.SmtpMailProtocolData;

/**
 * Created by Christoph on 08.11.2014.
 */
public class ReadOnlySmtpMailProtocolDataWrapper extends SimpleSmtpMailProtocolDataProperty {

    private final class ReadOnlyObjectPropertyImpl extends ReadOnlyObjectPropertyBase<SmtpMailProtocolData> {
        public ReadOnlyObjectPropertyImpl() {
            ReadOnlySmtpMailProtocolDataWrapper.this.addListener(o -> this.fireValueChangedEvent());
        }

        @Override
        public SmtpMailProtocolData get() {
            return ReadOnlySmtpMailProtocolDataWrapper.this.get();
        }

        @Override
        public Object getBean() {
            return ReadOnlySmtpMailProtocolDataWrapper.this.getBean();
        }

        @Override
        public String getName() {
            return ReadOnlySmtpMailProtocolDataWrapper.this.getName();
        }
    }

    public ReadOnlySmtpMailProtocolDataWrapper() {
    }

    public ReadOnlySmtpMailProtocolDataWrapper(String host, int port) {
        super(host, port);
    }

    public ReadOnlySmtpMailProtocolDataWrapper(SmtpMailProtocolData initialValue) {
        super(initialValue);
    }
    
    public ReadOnlyObjectProperty<SmtpMailProtocolData> getReadOnlyProperty() {
        return new ReadOnlyObjectPropertyImpl();
    }
}
