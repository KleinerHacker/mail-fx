package org.pcsoft.tools.mail_fx.converters;

import javafx.util.StringConverter;

/**
 * Created by Christoph on 15.11.2014.
 */
public final class SimpleStringConverter extends StringConverter<String> {

    @Override
    public String toString(String object) {
        return object;
    }

    @Override
    public String fromString(String string) {
        return string;
    }
}
