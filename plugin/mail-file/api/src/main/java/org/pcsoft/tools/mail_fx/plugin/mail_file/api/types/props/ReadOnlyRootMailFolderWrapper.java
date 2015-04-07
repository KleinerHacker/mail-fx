package org.pcsoft.tools.mail_fx.plugin.mail_file.api.types.props;

import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.ReadOnlyObjectPropertyBase;
import org.pcsoft.tools.mail_fx.plugin.mail_file.api.types.RootMailFolder;

/**
 * Created by Christoph on 09.11.2014.
 */
public class ReadOnlyRootMailFolderWrapper extends SimpleRootMailFolderProperty {

    private final class ReadOnlyObjectPropertyImpl extends ReadOnlyObjectPropertyBase<RootMailFolder> {
        public ReadOnlyObjectPropertyImpl() {
            ReadOnlyRootMailFolderWrapper.this.addListener(o -> this.fireValueChangedEvent());
        }

        @Override
        public RootMailFolder get() {
            return ReadOnlyRootMailFolderWrapper.this.get();
        }

        @Override
        public Object getBean() {
            return ReadOnlyRootMailFolderWrapper.this.getBean();
        }

        @Override
        public String getName() {
            return ReadOnlyRootMailFolderWrapper.this.getName();
        }
    }

    public ReadOnlyRootMailFolderWrapper() {
    }

    public ReadOnlyRootMailFolderWrapper(RootMailFolder initialValue) {
        super(initialValue);
    }

    public ReadOnlyObjectProperty<RootMailFolder> getReadOnlyProperty() {
        return new ReadOnlyObjectPropertyImpl();
    }
}
