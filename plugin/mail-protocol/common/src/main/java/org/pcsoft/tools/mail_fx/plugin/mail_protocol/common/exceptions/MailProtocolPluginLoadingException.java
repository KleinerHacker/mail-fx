package org.pcsoft.tools.mail_fx.plugin.mail_protocol.common.exceptions;

import org.pcsoft.tools.mail_fx.plugin.common.exceptions.MailFxPluginLoadingException;

/**
 * Created by Christoph on 29.10.2014.
 */
public class MailProtocolPluginLoadingException extends MailFxPluginLoadingException {

    public MailProtocolPluginLoadingException() {
    }

    public MailProtocolPluginLoadingException(String message) {
        super(message);
    }

    public MailProtocolPluginLoadingException(String message, Throwable cause) {
        super(message, cause);
    }

    public MailProtocolPluginLoadingException(Throwable cause) {
        super(cause);
    }
}
