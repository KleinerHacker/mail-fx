package org.pcsoft.tools.mail_fx.plugin.common.exceptions;

/**
 * Created by Christoph on 19.10.2014.
 */
public abstract class MailFxPluginIOException extends MailFxPluginException {

    protected MailFxPluginIOException() {
    }

    protected MailFxPluginIOException(String message) {
        super(message);
    }

    protected MailFxPluginIOException(String message, Throwable cause) {
        super(message, cause);
    }

    protected MailFxPluginIOException(Throwable cause) {
        super(cause);
    }
}
