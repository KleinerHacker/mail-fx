package org.pcsoft.tools.mail_fx.plugin.mail_protocol.api.types.props;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import org.pcsoft.tools.mail_fx.plugin.mail_protocol.api.types.MailProtocolData;

/**
 * Abstract class for a {@link org.pcsoft.tools.mail_fx.plugin.mail_protocol.api.types.MailProtocolData} property
 */
public abstract class SimpleMailProtocolDataProperty<T extends MailProtocolData> extends SimpleObjectProperty<T> {

    private final class Handler implements ChangeListener {
        @Override
        public void changed(ObservableValue observable, Object oldValue, Object newValue) {
            SimpleMailProtocolDataProperty.this.fireValueChangedEvent();
        }
    }

    private final Handler handler = new Handler();

    protected SimpleMailProtocolDataProperty() {
    }

    protected SimpleMailProtocolDataProperty(T initialValue) {
        super(initialValue);
        register();
    }

    @Override
    public final void set(T newValue) {
        unregister();
        super.set(newValue);
        register();
    }

    @Override
    public final void setValue(T v) {
        unregister();
        super.setValue(v);
        register();
    }

    private void register() {
        if (get() == null)
            return;

        get().hostProperty().addListener(handler);
        get().portProperty().addListener(handler);
        _register();
    }

    private void unregister() {
        if (get() == null)
            return;

        get().hostProperty().removeListener(handler);
        get().portProperty().removeListener(handler);
        _unregister();
    }

    protected abstract void _unregister();
    protected abstract void _register();
}
