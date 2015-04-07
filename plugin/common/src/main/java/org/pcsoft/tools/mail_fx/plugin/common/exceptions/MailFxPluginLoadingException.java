package org.pcsoft.tools.mail_fx.plugin.common.exceptions;

/**
 * Created by Christoph on 19.10.2014.
 */
public abstract class MailFxPluginLoadingException extends MailFxPluginException {

    protected MailFxPluginLoadingException() {
    }

    protected MailFxPluginLoadingException(String message) {
        super(message);
    }

    protected MailFxPluginLoadingException(String message, Throwable cause) {
        super(message, cause);
    }

    protected MailFxPluginLoadingException(Throwable cause) {
        super(cause);
    }
}
