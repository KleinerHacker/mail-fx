package org.pcsoft.tools.mail_fx.core.api.types.mail.props;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import org.pcsoft.tools.mail_fx.core.api.types.mail.MailAffix;

/**
 * Created by Christoph on 29.10.2014.
 */
public class SimpleMailAffixProperty extends SimpleObjectProperty<MailAffix> {

    private final class Handler implements ChangeListener {
        @Override
        public void changed(ObservableValue observable, Object oldValue, Object newValue) {
            SimpleMailAffixProperty.this.fireValueChangedEvent();
        }
    }

    private final Handler handler = new Handler();

    public SimpleMailAffixProperty(MailAffix obj) {
        super(obj);
        register();
    }

    public SimpleMailAffixProperty(String name, byte[] content) {
        super(new MailAffix(name, content));
        register();
    }

    public SimpleMailAffixProperty() {
    }

    @Override
    public void set(MailAffix newValue) {
        unregister();
        super.set(newValue);
        register();
    }

    @Override
    public void setValue(MailAffix v) {
        unregister();
        super.setValue(v);
        register();
    }

    protected final void register() {
        if (get() == null)
            return;

        get().nameProperty().addListener(handler);
        get().contentProperty().addListener(handler);
    }

    protected final void unregister() {
        if (get() == null)
            return;

        get().nameProperty().removeListener(handler);
        get().contentProperty().removeListener(handler);
    }
}
