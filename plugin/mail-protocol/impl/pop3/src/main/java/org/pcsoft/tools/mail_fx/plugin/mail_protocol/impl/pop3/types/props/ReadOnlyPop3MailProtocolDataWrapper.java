package org.pcsoft.tools.mail_fx.plugin.mail_protocol.impl.pop3.types.props;

import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.ReadOnlyObjectPropertyBase;
import org.pcsoft.tools.mail_fx.plugin.mail_protocol.impl.pop3.types.Pop3MailProtocolData;

/**
 * Created by Christoph on 08.11.2014.
 */
public class ReadOnlyPop3MailProtocolDataWrapper extends SimplePop3MailProtocolDataProperty {

    private final class ReadOnlyObjectPropertyImpl extends ReadOnlyObjectPropertyBase<Pop3MailProtocolData> {
        public ReadOnlyObjectPropertyImpl() {
            ReadOnlyPop3MailProtocolDataWrapper.this.addListener(o -> this.fireValueChangedEvent());
        }

        @Override
        public Pop3MailProtocolData get() {
            return ReadOnlyPop3MailProtocolDataWrapper.this.get();
        }

        @Override
        public Object getBean() {
            return ReadOnlyPop3MailProtocolDataWrapper.this.getBean();
        }

        @Override
        public String getName() {
            return ReadOnlyPop3MailProtocolDataWrapper.this.getName();
        }
    }

    public ReadOnlyPop3MailProtocolDataWrapper() {
    }

    public ReadOnlyPop3MailProtocolDataWrapper(String host, int port, boolean enableTsl) {
        super(host, port, enableTsl);
    }

    public ReadOnlyPop3MailProtocolDataWrapper(Pop3MailProtocolData initialValue) {
        super(initialValue);
    }

    public ReadOnlyObjectProperty<Pop3MailProtocolData> getReadOnlyProperty() {
        return new ReadOnlyObjectPropertyImpl();
    }
}
