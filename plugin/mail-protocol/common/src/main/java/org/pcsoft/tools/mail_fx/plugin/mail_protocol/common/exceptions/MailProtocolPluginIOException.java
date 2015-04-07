package org.pcsoft.tools.mail_fx.plugin.mail_protocol.common.exceptions;

import org.pcsoft.tools.mail_fx.plugin.common.exceptions.MailFxPluginIOException;

/**
 * Created by Christoph on 29.10.2014.
 */
public class MailProtocolPluginIOException extends MailFxPluginIOException {

    public MailProtocolPluginIOException() {
    }

    public MailProtocolPluginIOException(String message) {
        super(message);
    }

    public MailProtocolPluginIOException(String message, Throwable cause) {
        super(message, cause);
    }

    public MailProtocolPluginIOException(Throwable cause) {
        super(cause);
    }
}
