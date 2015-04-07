package org.pcsoft.tools.mail_fx.plugin.mail_file.api.types.props;

import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.ReadOnlyObjectPropertyBase;
import org.pcsoft.tools.mail_fx.plugin.mail_file.api.types.CustomMailFolder;

/**
 * Created by Christoph on 09.11.2014.
 */
public class ReadOnlyCustomMailFolderWrapper extends SimpleCustomMailFolderProperty {

    private final class ReadOnlyObjectPropertyImpl extends ReadOnlyObjectPropertyBase<CustomMailFolder> {
        public ReadOnlyObjectPropertyImpl() {
            ReadOnlyCustomMailFolderWrapper.this.addListener(o -> this.fireValueChangedEvent());
        }

        @Override
        public CustomMailFolder get() {
            return ReadOnlyCustomMailFolderWrapper.this.get();
        }

        @Override
        public Object getBean() {
            return ReadOnlyCustomMailFolderWrapper.this.getBean();
        }

        @Override
        public String getName() {
            return ReadOnlyCustomMailFolderWrapper.this.getName();
        }
    }

    public ReadOnlyCustomMailFolderWrapper() {
    }

    public ReadOnlyCustomMailFolderWrapper(String name) {
        super(name);
    }

    public ReadOnlyCustomMailFolderWrapper(CustomMailFolder initialValue) {
        super(initialValue);
    }

    public ReadOnlyObjectProperty<CustomMailFolder> getReadOnlyProperty() {
        return new ReadOnlyObjectPropertyImpl();
    }
}
