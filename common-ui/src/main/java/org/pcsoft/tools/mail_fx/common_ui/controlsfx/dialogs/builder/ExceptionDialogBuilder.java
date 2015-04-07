package org.pcsoft.tools.mail_fx.common_ui.controlsfx.dialogs.builder;

import org.controlsfx.dialog.ExceptionDialog;

/**
 * Created by Christoph on 14.11.2014.
 */
public final class ExceptionDialogBuilder extends AbstractDialogBuilder<ExceptionDialogBuilder, ExceptionDialog> {

    static ExceptionDialogBuilder create(Throwable e) {
        return new ExceptionDialogBuilder(e);
    }

    private ExceptionDialogBuilder(Throwable e) {
        super(new ExceptionDialog(e));
    }

    public ExceptionDialogBuilder message(String message) {
        dialog.setContentText(message);
        return this;
    }
}
