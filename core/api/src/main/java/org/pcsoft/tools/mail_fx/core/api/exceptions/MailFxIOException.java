package org.pcsoft.tools.mail_fx.core.api.exceptions;

import org.pcsoft.tools.mail_fx.exceptions.MailFxException;

/**
 * Created by Christoph on 29.10.2014.
 */
public class MailFxIOException extends MailFxException {

    public MailFxIOException() {
    }

    public MailFxIOException(String message) {
        super(message);
    }

    public MailFxIOException(String message, Throwable cause) {
        super(message, cause);
    }

    public MailFxIOException(Throwable cause) {
        super(cause);
    }
}
