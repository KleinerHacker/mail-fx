package org.pcsoft.tools.mail_fx.core.api.exceptions;

/**
 * Created by Christoph on 29.10.2014.
 */
public class MailFxCommunicationException extends MailFxIOException {

    public MailFxCommunicationException() {
    }

    public MailFxCommunicationException(String message) {
        super(message);
    }

    public MailFxCommunicationException(String message, Throwable cause) {
        super(message, cause);
    }

    public MailFxCommunicationException(Throwable cause) {
        super(cause);
    }
}
