package org.pcsoft.tools.mail_fx.core.api.types.account.props;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import org.pcsoft.tools.mail_fx.core.api.types.account.MailAccount;
import org.pcsoft.tools.mail_fx.plugin.mail_protocol.api.types.MailProtocolData;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Created by Christoph on 31.10.2014.
 */
public class SimpleMailAccountProperty extends SimpleObjectProperty<MailAccount> {

    private final class Handler implements ChangeListener, InvalidationListener {
        @Override
        public void stateChanged(ChangeEvent e) {
            SimpleMailAccountProperty.this.fireValueChangedEvent();
        }

        @Override
        public void invalidated(Observable observable) {
            SimpleMailAccountProperty.this.fireValueChangedEvent();
        }
    }

    private final Handler handler = new Handler();

    public SimpleMailAccountProperty(MailAccount obj) {
        super(obj);
        register();
    }

    public SimpleMailAccountProperty(String name, String mailAddress, ReadOnlyObjectProperty<? extends MailProtocolData> mailProtocolData, String mailFileName, String mailProtocolPluginId, String mailFilePluginId, String username) {
        super(new MailAccount(name, mailAddress, mailProtocolData, mailFileName, mailProtocolPluginId, mailFilePluginId, username));
        register();
    }

    public SimpleMailAccountProperty() {
    }

    @Override
    public void set(MailAccount newValue) {
        unregister();
        super.set(newValue);
        register();
    }

    @Override
    public void setValue(MailAccount v) {
        unregister();
        super.setValue(v);
        register();
    }

    protected final void register() {
        if (get() == null)
            return;

        get().titleProperty().addListener(handler);
        get().usernameProperty().addListener(handler);
        get().mailProtocolDataProperty().addListener(handler);
        get().mailProtocolDataProperty().addListener(handler);
    }

    protected final void unregister() {
        if (get() == null)
            return;

        get().titleProperty().removeListener(handler);
        get().usernameProperty().removeListener(handler);
        get().mailProtocolDataProperty().removeListener(handler);
        get().mailProtocolDataProperty().removeListener(handler);
    }
}
