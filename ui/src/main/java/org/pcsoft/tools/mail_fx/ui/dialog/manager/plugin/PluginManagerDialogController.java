package org.pcsoft.tools.mail_fx.ui.dialog.manager.plugin;

import javafx.beans.property.ReadOnlyBooleanWrapper;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.CheckBoxTreeTableCell;
import org.pcsoft.tools.mail_fx.core.impl.PluginService;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

/**
 * Created by Christoph on 13.11.2014.
 */
class PluginManagerDialogController implements Initializable {

    @FXML
    private TreeTableView<Object> tblPlugin;
    @FXML
    private TreeTableColumn<Object, String> tbcPluginType;
    @FXML
    private TreeTableColumn<Object, Boolean> tbcPluginActive;
    @FXML
    private TreeTableColumn<Object, String> tbcPluginId;
    @FXML
    private TreeTableColumn<Object, String> tbcPluginName;
    @FXML
    private TreeTableColumn<Object, String> tbcPluginDescription;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        prepareTable();
        updateTable();
    }

    private void updateTable() {
        final TreeItem<Object> rootTreeItem = new TreeItem<>();

        final PluginTypeTreeItem mailFileTreeItem = new PluginTypeTreeItem("Mail File Plugins");
        mailFileTreeItem.getChildren().setAll(PluginService.getMailFilePluginList().stream()
                .map(PluginTreeItem::new)
                .collect(Collectors.toList()));
        rootTreeItem.getChildren().add(mailFileTreeItem);

        final PluginTypeTreeItem mailProtocolTreeItem = new PluginTypeTreeItem("Mail Protocols");
        mailProtocolTreeItem.getChildren().setAll(PluginService.getMailProtocolPluginList().stream()
                .map(PluginTreeItem::new)
                .collect(Collectors.toList()));
        rootTreeItem.getChildren().add(mailProtocolTreeItem);

        tblPlugin.setRoot(rootTreeItem);
    }

    private void prepareTable() {
        tbcPluginType.setCellValueFactory(data -> {
            if (!(data.getValue() instanceof PluginTypeTreeItem))
                return new ReadOnlyStringWrapper("").getReadOnlyProperty();

            return new ReadOnlyStringWrapper(((PluginTypeTreeItem)data.getValue()).getTitle()).getReadOnlyProperty();
        });
        tbcPluginActive.setCellValueFactory(data -> {
            if (!(data.getValue() instanceof PluginTreeItem))
                return new ReadOnlyBooleanWrapper(false).getReadOnlyProperty();

            return new SimpleBooleanProperty(true);
        });
        tbcPluginActive.setCellFactory(param -> new CheckBoxTreeTableCell<Object, Boolean>() {
            @Override
            public void updateItem(Boolean item, boolean empty) {
                super.updateItem(item, empty);

                if (!(getTreeTableRow().getTreeItem() instanceof PluginTreeItem)) {
                    setText(null);
                    setGraphic(null);
                }
            }
        });
        tbcPluginId.setCellValueFactory(data -> {
            if (!(data.getValue() instanceof PluginTreeItem))
                return new ReadOnlyStringWrapper("").getReadOnlyProperty();

            return new ReadOnlyStringWrapper(((PluginTreeItem)data.getValue()).getPlugin().getId()).getReadOnlyProperty();
        });
        tbcPluginName.setCellValueFactory(data -> {
            if (!(data.getValue() instanceof PluginTreeItem))
                return new ReadOnlyStringWrapper("").getReadOnlyProperty();

            return new ReadOnlyStringWrapper(((PluginTreeItem)data.getValue()).getPlugin().getName()).getReadOnlyProperty();
        });
        tbcPluginDescription.setCellValueFactory(data -> {
            if (!(data.getValue() instanceof PluginTreeItem))
                return new ReadOnlyStringWrapper("").getReadOnlyProperty();

            return new ReadOnlyStringWrapper(((PluginTreeItem)data.getValue()).getPlugin().getDescription()).getReadOnlyProperty();
        });
    }
}
