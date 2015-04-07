package org.pcsoft.tools.mal_fx.plugin.affix_preview.common.exceptions;

import org.pcsoft.tools.mail_fx.plugin.common.exceptions.MailFxPluginIOException;

/**
 * Created by Christoph on 19.10.2014.
 */
public class MailFxAffixPreviewIOException extends MailFxPluginIOException {

    public MailFxAffixPreviewIOException() {
    }

    public MailFxAffixPreviewIOException(String message) {
        super(message);
    }

    public MailFxAffixPreviewIOException(String message, Throwable cause) {
        super(message, cause);
    }

    public MailFxAffixPreviewIOException(Throwable cause) {
        super(cause);
    }
}
