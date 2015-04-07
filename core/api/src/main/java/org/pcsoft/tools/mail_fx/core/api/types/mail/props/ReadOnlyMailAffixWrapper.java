package org.pcsoft.tools.mail_fx.core.api.types.mail.props;

import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.ReadOnlyObjectPropertyBase;
import org.pcsoft.tools.mail_fx.core.api.types.mail.MailAffix;

/**
 * Created by Christoph on 29.10.2014.
 */
public class ReadOnlyMailAffixWrapper extends SimpleMailAffixProperty {

    private final class ReadOnlyObjectPropertyImpl extends ReadOnlyObjectPropertyBase<MailAffix> {
        public ReadOnlyObjectPropertyImpl() {
            ReadOnlyMailAffixWrapper.this.addListener(o -> this.fireValueChangedEvent());
        }

        @Override
        public MailAffix get() {
            return ReadOnlyMailAffixWrapper.this.get();
        }

        @Override
        public Object getBean() {
            return ReadOnlyMailAffixWrapper.this.getBean();
        }

        @Override
        public String getName() {
            return ReadOnlyMailAffixWrapper.this.getName();
        }
    }

    public ReadOnlyMailAffixWrapper(MailAffix obj) {
        super(obj);
    }

    public ReadOnlyMailAffixWrapper(String name, byte[] content) {
        super(new MailAffix(name, content));
    }

    public ReadOnlyMailAffixWrapper() {
    }

    public ReadOnlyObjectProperty<MailAffix> getReadOnlyProperty() {
        return new ReadOnlyObjectPropertyImpl();
    }
}
