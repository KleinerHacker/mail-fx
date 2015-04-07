package org.pcsoft.tools.mail_fx.plugin.mail_protocol.common.exceptions;

import org.pcsoft.tools.mail_fx.plugin.common.exceptions.MailFxPluginExecutionException;

/**
 * Created by Christoph on 29.10.2014.
 */
public class MailProtocolPluginExecutionException extends MailFxPluginExecutionException {

    public MailProtocolPluginExecutionException() {
    }

    public MailProtocolPluginExecutionException(String message) {
        super(message);
    }

    public MailProtocolPluginExecutionException(String message, Throwable cause) {
        super(message, cause);
    }

    public MailProtocolPluginExecutionException(Throwable cause) {
        super(cause);
    }
}
