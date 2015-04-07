package org.pcsoft.tools.mail_fx.ui.wizard.account;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import org.controlsfx.control.decoration.Decorator;
import org.controlsfx.dialog.Wizard;
import org.pcsoft.tools.mail_fx.core.impl.PluginService;
import org.pcsoft.tools.mail_fx.plugin.mail_file.core.MailFilePlugin;
import org.pcsoft.tools.mail_fx.common_ui.controlsfx.decoration.ValidationDecoration;
import org.pcsoft.tools.mail_fx.ui.item.list.DetailListItem;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Christoph on 11.11.2014.
 */
class MailFileChoicePage extends AbstractWizardPage {

    @FXML
    private RadioButton rbCreateFile;
    @FXML
    private RadioButton rbLoadFile;
    @FXML
    private ToggleGroup grpFileState;
    @FXML
    private ListView<MailFilePlugin> lstFileType;

    public MailFileChoicePage(AccountWizard.Result result) {
        super(
                "Select a file type",
                Thread.currentThread().getContextClassLoader().getResource("fxml/wizard.page.account.config.file.choice.fxml"),
                result
        );
        loadUI();
    }

    @Override
    protected Wizard.WizardPane nextPage() {
        if (lstFileType.getSelectionModel().getSelectedItem() == null) {
            new Alert(Alert.AlertType.ERROR, "Please select a mail file type!", ButtonType.OK).showAndWait();
            return this;
        }
        result.setMailFilePlugin(lstFileType.getSelectionModel().getSelectedItem());

        if (rbCreateFile.isSelected()) {
            result.setLoadMailFile(false);
            return new CreateMailFilePage(result);
        } else if (rbLoadFile.isSelected()) {
            result.setLoadMailFile(true);
            return new LoadMailFilePage(result);
        }

        throw new IllegalStateException("Unknown selected option!");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        prepareList();

        lstFileType.getItems().setAll(PluginService.getMailFilePluginList());
        lstFileType.getSelectionModel().select(result.getMailFilePlugin());//Select old value

        if (lstFileType.getSelectionModel().getSelectedItem() == null) {
            Decorator.addDecoration(lstFileType, new ValidationDecoration());
        }
        lstFileType.getSelectionModel().selectedItemProperty().addListener((v, o, n) -> {
            if (n == null) {
                Decorator.addDecoration(lstFileType, new ValidationDecoration());
            } else {
                Decorator.removeAllDecorations(lstFileType);
            }
        });
    }

    private void prepareList() {
        lstFileType.setCellFactory(view -> new ListCell<MailFilePlugin>() {
            @Override
            protected void updateItem(MailFilePlugin item, boolean empty) {
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
