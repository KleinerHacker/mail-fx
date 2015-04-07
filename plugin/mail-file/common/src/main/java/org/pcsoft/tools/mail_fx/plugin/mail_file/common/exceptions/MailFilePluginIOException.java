package org.pcsoft.tools.mail_fx.plugin.mail_file.common.exceptions;

import org.pcsoft.tools.mail_fx.plugin.common.exceptions.MailFxPluginIOException;

/**
 * Created by Christoph on 09.11.2014.
 */
public class MailFilePluginIOException extends MailFxPluginIOException {

    public MailFilePluginIOException() {
    }

    public MailFilePluginIOException(String message) {
        super(message);
    }

    public MailFilePluginIOException(String message, Throwable cause) {
        super(message, cause);
    }

    public MailFilePluginIOException(Throwable cause) {
        super(cause);
    }
}
