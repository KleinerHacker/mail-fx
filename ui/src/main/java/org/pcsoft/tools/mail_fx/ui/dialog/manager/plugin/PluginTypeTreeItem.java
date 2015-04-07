package org.pcsoft.tools.mail_fx.ui.dialog.manager.plugin;

import javafx.scene.control.TreeItem;

/**
 * Created by Christoph on 13.11.2014.
 */
final class PluginTypeTreeItem extends TreeItem<Object> {

    public PluginTypeTreeItem(String title) {
        super(title);
    }

    public String getTitle() {
        return (String) getValue();
    }
}
