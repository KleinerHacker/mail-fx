package org.pcsoft.tools.mail_fx.ui.dialog.manager.plugin;

import javafx.scene.control.TreeItem;
import org.pcsoft.tools.mail_fx.plugin.common.Plugin;

/**
 * Created by Christoph on 13.11.2014.
 */
final class PluginTreeItem extends TreeItem<Object> {

    public PluginTreeItem(Plugin value) {
        super(value);
    }

    public Plugin getPlugin() {
        return (Plugin) getValue();
    }
}
