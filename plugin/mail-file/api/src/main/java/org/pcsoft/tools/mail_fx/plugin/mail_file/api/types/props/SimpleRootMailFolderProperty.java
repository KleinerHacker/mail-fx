package org.pcsoft.tools.mail_fx.plugin.mail_file.api.types.props;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import org.pcsoft.tools.mail_fx.plugin.mail_file.api.types.RootMailFolder;

/**
 * Created by Christoph on 09.11.2014.
 */
public class SimpleRootMailFolderProperty extends SimpleObjectProperty<RootMailFolder> {

    private final class Handler implements ChangeListener {
        @Override
        public void changed(ObservableValue observable, Object oldValue, Object newValue) {
            SimpleRootMailFolderProperty.this.fireValueChangedEvent();
        }
    }

    private final Handler handler = new Handler();

    public SimpleRootMailFolderProperty() {
    }

    public SimpleRootMailFolderProperty(RootMailFolder initialValue) {
        super(initialValue);
        register();
    }

    @Override
    public void set(RootMailFolder newValue) {
        unregister();
        super.set(newValue);
        register();
    }

    @Override
    public void setValue(RootMailFolder v) {
        unregister();
        super.setValue(v);
        register();
    }

    protected final void register() {
        if (get() == null)
            return;

        get().nameProperty().addListener(handler);
        get().imageProperty().addListener(handler);
    }

    protected final void unregister() {
        if (get() == null)
            return;

        get().nameProperty().removeListener(handler);
        get().imageProperty().removeListener(handler);
    }
}
