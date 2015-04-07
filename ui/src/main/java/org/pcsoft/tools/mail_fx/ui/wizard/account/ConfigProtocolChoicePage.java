package org.pcsoft.tools.mail_fx.ui.wizard.account;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import org.controlsfx.control.decoration.Decorator;
import org.controlsfx.dialog.Wizard;
import org.pcsoft.tools.mail_fx.core.impl.PluginService;
import org.pcsoft.tools.mail_fx.plugin.mail_protocol.core.MailProtocolPlugin;
import org.pcsoft.tools.mail_fx.common_ui.controlsfx.decoration.ValidationDecoration;
import org.pcsoft.tools.mail_fx.ui.item.list.DetailListItem;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Christoph on 08.11.2014.
 */
class ConfigProtocolChoicePage extends AbstractWizardPage {

    @FXML
    private ListView<MailProtocolPlugin> lstProtocol;

    public ConfigProtocolChoicePage(AccountWizard.Result result) {
        super(
                "Choice your Mail Protocol",
                Thread.currentThread().getContextClassLoader().getResource("fxml/wizard.page.account.config.protocol.choice.fxml"),
                result
        );
        loadUI();
    }

    @Override
    protected Wizard.WizardPane nextPage() {
        if (lstProtocol.getSelectionModel().getSelectedItem() == null) {
            new Alert(Alert.AlertType.INFORMATION, "Please select a protocol first.", ButtonType.OK).showAndWait();
            return this;
        }
        result.setMailProtocolPlugin(lstProtocol.getSelectionModel().getSelectedItem());
        result.setMailProtocolData(result.getMailProtocolPlugin().getInstance().createMailProtocolData());

        return new ConfigProtocolPage(result);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        prepareList();

        lstProtocol.getItems().setAll(PluginService.getMailProtocolPluginList());
        lstProtocol.getSelectionModel().select(result.getMailProtocolPlugin());//Select older value

        if (lstProtocol.getSelectionModel().getSelectedItem() == null) {
            Decorator.addDecoration(lstProtocol, new ValidationDecoration());
        }
        lstProtocol.getSelectionModel().selectedItemProperty().addListener((v, o, n) -> {
            if (n == null) {
                Decorator.addDecoration(lstProtocol, new ValidationDecoration());
            } else {
                Decorator.removeAllDecorations(lstProtocol);
            }
        });
    }

    private void prepareList() {
        lstProtocol.setCellFactory(param -> new ListCell<MailProtocolPlugin>() {
            @Override
            protected void updateItem(MailProtocolPlugin item, boolean empty) {
                super.updateItem(item, empty);

                setText(null);
                if (item == null || empty) {
                    setGraphic(null);
                } else {
                    setGraphic(new DetailListItem(item.getName(), item.getDescription()));
                }
            }
        });
    }
}
