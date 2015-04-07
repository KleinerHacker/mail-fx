package org.pcsoft.tools.mail_fx.plugin.mail_file.common.exceptions;

import org.pcsoft.tools.mail_fx.plugin.common.exceptions.MailFxPluginExecutionException;

/**
 * Created by Christoph on 09.11.2014.
 */
public class MailFilePluginExecutionException extends MailFxPluginExecutionException {

    public MailFilePluginExecutionException() {
    }

    public MailFilePluginExecutionException(String message) {
        super(message);
    }

    public MailFilePluginExecutionException(String message, Throwable cause) {
        super(message, cause);
    }

    public MailFilePluginExecutionException(Throwable cause) {
        super(cause);
    }
}
