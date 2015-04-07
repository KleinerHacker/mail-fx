package org.pcsoft.tools.mail_fx.core.api.types.mail.props;

import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.ReadOnlyObjectPropertyBase;
import org.pcsoft.tools.mail_fx.core.api.types.mail.Mail;

/**
 * Created by Christoph on 29.10.2014.
 */
public class ReadOnlyMailWrapper extends SimpleMailProperty {

    private final class ReadOnlyObjectPropertyImpl extends ReadOnlyObjectPropertyBase<Mail> {
        public ReadOnlyObjectPropertyImpl() {
            ReadOnlyMailWrapper.this.addListener(o -> this.fireValueChangedEvent());
        }

        @Override
        public Mail get() {
            return ReadOnlyMailWrapper.this.get();
        }

        @Override
        public Object getBean() {
            return ReadOnlyMailWrapper.this.getBean();
        }

        @Override
        public String getName() {
            return ReadOnlyMailWrapper.this.getName();
        }
    }

    public ReadOnlyMailWrapper(Mail obj) {
        super(obj);
    }

    public ReadOnlyMailWrapper(String subject, String content) {
        super(subject, content);
    }

    public ReadOnlyMailWrapper() {
    }

    public ReadOnlyObjectProperty<Mail> getReadOnlyProperty() {
        return new ReadOnlyObjectPropertyImpl();
    }
}
