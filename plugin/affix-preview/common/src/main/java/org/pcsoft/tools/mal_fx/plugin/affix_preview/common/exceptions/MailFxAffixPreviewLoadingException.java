package org.pcsoft.tools.mal_fx.plugin.affix_preview.common.exceptions;

import org.pcsoft.tools.mail_fx.plugin.common.exceptions.MailFxPluginLoadingException;

/**
 * Created by Christoph on 19.10.2014.
 */
public class MailFxAffixPreviewLoadingException extends MailFxPluginLoadingException {

    public MailFxAffixPreviewLoadingException() {
    }

    public MailFxAffixPreviewLoadingException(String message) {
        super(message);
    }

    public MailFxAffixPreviewLoadingException(String message, Throwable cause) {
        super(message, cause);
    }

    public MailFxAffixPreviewLoadingException(Throwable cause) {
        super(cause);
    }
}
