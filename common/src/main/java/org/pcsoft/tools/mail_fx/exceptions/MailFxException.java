package org.pcsoft.tools.mail_fx.exceptions;

/**
 * Created by Christoph on 19.10.2014.
 */
public abstract class MailFxException extends RuntimeException {

    protected MailFxException() {
    }

    protected MailFxException(String message) {
        super(message);
    }

    protected MailFxException(String message, Throwable cause) {
        super(message, cause);
    }

    protected MailFxException(Throwable cause) {
        super(cause);
    }
}
