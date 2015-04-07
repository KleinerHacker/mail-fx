package org.pcsoft.tools.mail_fx.plugin.mail_file.common.exceptions;

import org.pcsoft.tools.mail_fx.plugin.common.exceptions.MailFxPluginLoadingException;

/**
 * Created by Christoph on 09.11.2014.
 */
public class MailFilePluginLoadingException extends MailFxPluginLoadingException {

    public MailFilePluginLoadingException() {
    }

    public MailFilePluginLoadingException(String message) {
        super(message);
    }

    public MailFilePluginLoadingException(String message, Throwable cause) {
        super(message, cause);
    }

    public MailFilePluginLoadingException(Throwable cause) {
        super(cause);
    }
}
