package org.pcsoft.tools.mail_fx.core.api.types.account.props;

import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.ReadOnlyObjectPropertyBase;
import org.pcsoft.tools.mail_fx.core.api.types.account.MailAccount;
import org.pcsoft.tools.mail_fx.plugin.mail_protocol.api.types.MailProtocolData;

/**
 * Created by Christoph on 31.10.2014.
 */
public class ReadOnlyMailAccountWrapper extends SimpleMailAccountProperty {

    private final class ReadOnlyObjectPropertyImpl extends ReadOnlyObjectPropertyBase<MailAccount> {
        public ReadOnlyObjectPropertyImpl() {
            ReadOnlyMailAccountWrapper.this.addListener(o -> this.fireValueChangedEvent());
        }

        @Override
        public MailAccount get() {
            return ReadOnlyMailAccountWrapper.this.get();
        }

        @Override
        public Object getBean() {
            return ReadOnlyMailAccountWrapper.this.getBean();
        }

        @Override
        public String getName() {
            return ReadOnlyMailAccountWrapper.this.getName();
        }
    }

    public ReadOnlyMailAccountWrapper(MailAccount obj) {
        super(obj);
    }

    public ReadOnlyMailAccountWrapper(String name, String mailAddress, ReadOnlyObjectProperty<? extends MailProtocolData> mailProtocolData, String mailFileName, String mailProtocolPluginId, String mailFilePluginId, String username) {
        super(name, mailAddress, mailProtocolData, mailFileName, mailProtocolPluginId, mailFilePluginId, username);
    }

    public ReadOnlyMailAccountWrapper() {
    }

    public ReadOnlyObjectProperty<MailAccount> getReadOnlyProperty() {
        return new ReadOnlyObjectPropertyImpl();
    }
}
