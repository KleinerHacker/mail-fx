package org.pcsoft.tools.mail_fx.core.api.types.mail;

import javafx.beans.binding.ObjectExpression;
import javafx.beans.binding.StringExpression;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.ReadOnlyStringWrapper;

/**
 * Created by Christoph on 29.10.2014.
 */
public final class MailAffix {

    private final StringExpression name;
    private final ObjectExpression<byte[]> content;

    public MailAffix(String name, byte[] content) {
        this.name = new ReadOnlyStringWrapper(name).getReadOnlyProperty();
        this.content = new ReadOnlyObjectWrapper<>(content).getReadOnlyProperty();
    }

    public String getTitle() {
        return name.get();
    }

    public StringExpression nameProperty() {
        return name;
    }

    public byte[] getContent() {
        return content.get();
    }

    public ObjectExpression<byte[]> contentProperty() {
        return content;
    }
}
