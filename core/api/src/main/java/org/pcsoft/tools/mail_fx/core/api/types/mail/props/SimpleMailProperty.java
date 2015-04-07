package org.pcsoft.tools.mail_fx.core.api.types.mail.props;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import org.pcsoft.tools.mail_fx.core.api.types.mail.Mail;

/**
 * Created by Christoph on 29.10.2014.
 */
public class SimpleMailProperty extends SimpleObjectProperty<Mail> {

    private final class Handler implements ChangeListener, ListChangeListener {
        @Override
        public void changed(ObservableValue observable, Object oldValue, Object newValue) {
            SimpleMailProperty.this.fireValueChangedEvent();
        }

        @Override
        public void onChanged(Change c) {
            SimpleMailProperty.this.fireValueChangedEvent();
        }
    }

    private final Handler handler = new Handler();

    public SimpleMailProperty(Mail obj) {
        super(obj);
    }

    public SimpleMailProperty(String subject, String content) {
        super(subject, content);
    }

    public SimpleMailProperty() {
    }

    @Override
    public void set(Mail newValue) {
        super.set(newValue);
    }

    @Override
    public void setValue(Mail v) {
        super.setValue(v);
    }

    protected void register() {
        if (get() == null)
            return;

        get().subjectProperty().addListener(handler);
        get().contentProperty().addListener(handler);
        get().getAdditionalReceiverList().addListener(handler);
        get().getReceiverAddressList().addListener(handler);
        get().getHiddenReceiverAddressList().addListener(handler);
        get().getSenderAddressList().addListener(handler);
        get().getAffixList().addListener(handler);
    }
}
