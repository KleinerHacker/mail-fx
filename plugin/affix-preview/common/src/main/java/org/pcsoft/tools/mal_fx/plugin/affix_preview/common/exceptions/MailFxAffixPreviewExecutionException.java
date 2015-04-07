package org.pcsoft.tools.mal_fx.plugin.affix_preview.common.exceptions;

import org.pcsoft.tools.mail_fx.plugin.common.exceptions.MailFxPluginExecutionException;

/**
 * Created by Christoph on 19.10.2014.
 */
public class MailFxAffixPreviewExecutionException extends MailFxPluginExecutionException {

    public MailFxAffixPreviewExecutionException() {
    }

    public MailFxAffixPreviewExecutionException(String message) {
        super(message);
    }

    public MailFxAffixPreviewExecutionException(String message, Throwable cause) {
        super(message, cause);
    }

    public MailFxAffixPreviewExecutionException(Throwable cause) {
        super(cause);
    }
}
