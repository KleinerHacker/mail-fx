package org.pcsoft.tools.mail_fx.common_ui.controlsfx.dialogs.builder;

import org.controlsfx.dialog.CommandLinksDialog;

/**
 * Created by Christoph on 13.11.2014.
 */
public final class CommandLinkDialogBuilder extends AbstractDialogBuilder<CommandLinkDialogBuilder, CommandLinksDialog> {

    static CommandLinkDialogBuilder create(CommandLinksDialog.CommandLinksButtonType[] buttonTypes) {
        return new CommandLinkDialogBuilder(buttonTypes);
    }

    private CommandLinkDialogBuilder(CommandLinksDialog.CommandLinksButtonType[] buttonTypes) {
        super(new CommandLinksDialog(buttonTypes));
    }
}
