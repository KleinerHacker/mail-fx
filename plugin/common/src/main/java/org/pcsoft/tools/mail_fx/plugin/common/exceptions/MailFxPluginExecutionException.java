package org.pcsoft.tools.mail_fx.plugin.common.exceptions;

/**
 * Created by Christoph on 19.10.2014.
 */
public abstract class MailFxPluginExecutionException extends MailFxPluginException {

    public MailFxPluginExecutionException() {
    }

    public MailFxPluginExecutionException(String message) {
        super(message);
    }

    public MailFxPluginExecutionException(String message, Throwable cause) {
        super(message, cause);
    }

    public MailFxPluginExecutionException(Throwable cause) {
        super(cause);
    }
}
