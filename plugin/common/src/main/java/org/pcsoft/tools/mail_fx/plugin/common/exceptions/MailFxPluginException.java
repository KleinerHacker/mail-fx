package org.pcsoft.tools.mail_fx.plugin.common.exceptions;

import org.pcsoft.tools.mail_fx.exceptions.MailFxException;

/**
 * Created by Christoph on 19.10.2014.
 */
public abstract class MailFxPluginException extends MailFxException {

    protected MailFxPluginException() {
    }

    protected MailFxPluginException(String message) {
        super(message);
    }

    protected MailFxPluginException(String message, Throwable cause) {
        super(message, cause);
    }

    protected MailFxPluginException(Throwable cause) {
        super(cause);
    }
}
