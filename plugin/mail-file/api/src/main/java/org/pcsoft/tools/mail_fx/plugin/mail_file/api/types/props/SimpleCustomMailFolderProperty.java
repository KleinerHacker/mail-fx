package org.pcsoft.tools.mail_fx.plugin.mail_file.api.types.props;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import org.pcsoft.tools.mail_fx.plugin.mail_file.api.types.CustomMailFolder;

/**
 * Created by Christoph on 09.11.2014.
 */
public class SimpleCustomMailFolderProperty extends SimpleObjectProperty<CustomMailFolder> {

    private final class Handler implements ChangeListener {
        @Override
        public void changed(ObservableValue observable, Object oldValue, Object newValue) {
            SimpleCustomMailFolderProperty.this.fireValueChangedEvent();
        }
    }

    private final Handler handler = new Handler();

    public SimpleCustomMailFolderProperty() {
    }

    public SimpleCustomMailFolderProperty(String name) {
        super(new CustomMailFolder(name));
        register();
    }

    public SimpleCustomMailFolderProperty(CustomMailFolder initialValue) {
        super(initialValue);
        register();
    }

    @Override
    public void set(CustomMailFolder newValue) {
        unregister();
        super.set(newValue);
        register();
    }

    @Override
    public void setValue(CustomMailFolder v) {
        unregister();
        super.setValue(v);
        register();
    }

    protected final void register() {
        if (get() == null)
            return;

        get().nameProperty().addListener(handler);
    }

    protected final void unregister() {
        if (get() == null)
            return;

        get().nameProperty().removeListener(handler);
    }
}
