package org.pcsoft.tools.mail_fx.ui.dialog.manager.account;

import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.pcsoft.tools.mail_fx.common_ui.controlsfx.dialogs.builder.DialogBuilderFactory;
import org.pcsoft.tools.mail_fx.converters.SimpleStringConverter;
import org.pcsoft.tools.mail_fx.core.api.types.account.MailAccount;
import org.pcsoft.tools.mail_fx.core.api.types.account.props.ReadOnlyMailAccountWrapper;
import org.pcsoft.tools.mail_fx.core.impl.ConfigurationService;
import org.pcsoft.tools.mail_fx.core.impl.MailAccountService;
import org.pcsoft.tools.mail_fx.core.impl.PluginService;
import org.pcsoft.tools.mail_fx.plugin.mail_file.core.MailFilePlugin;
import org.pcsoft.tools.mail_fx.plugin.mail_protocol.core.MailProtocolPlugin;
import org.pcsoft.tools.mail_fx.ui.fragment.WaiterFragmentController;
import org.pcsoft.tools.mail_fx.ui.wizard.account.AccountWizard;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

/**
 * Created by Christoph on 08.11.2014.
 */
class AccountManagerDialogController implements Initializable {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountManagerDialogController.class);

    @FXML
    private Button btnAddAccount;
    @FXML
    private Button btnEditAccount;
    @FXML
    private Button btnRemoveAccount;
    @FXML
    private TableView<ReadOnlyObjectProperty<MailAccount>> tblAccount;
    @FXML
    private TableColumn<ReadOnlyObjectProperty<MailAccount>, Image> tbcState;
    @FXML
    private TableColumn<ReadOnlyObjectProperty<MailAccount>, String> tbcTitle;
    @FXML
    private TableColumn<ReadOnlyObjectProperty<MailAccount>, String> tbcMailAddress;
    @FXML
    private TableColumn<ReadOnlyObjectProperty<MailAccount>, String> tbcProvider;
    @FXML
    private TableColumn<ReadOnlyObjectProperty<MailAccount>, String> tbcMailProtocol;
    @FXML
    private TableColumn<ReadOnlyObjectProperty<MailAccount>, String> tbcMailFile;
    @FXML
    private TableColumn<ReadOnlyObjectProperty<MailAccount>, String> tbcMailFileType;

    @FXML
    private WaiterFragmentController waiterController;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        prepareTable();

        btnEditAccount.disableProperty().bind(tblAccount.getSelectionModel().selectedItemProperty().isNull());
        btnRemoveAccount.disableProperty().bind(tblAccount.getSelectionModel().selectedItemProperty().isNull());

        tblAccount.setItems(MailAccountService.getMailAccountList());
    }

    private void prepareTable() {
        tbcState.setCellValueFactory(data -> new ReadOnlyObjectWrapper<Image>().getReadOnlyProperty());
        tbcState.setCellFactory(param -> new TableCell<ReadOnlyObjectProperty<MailAccount>, Image>() {
            @Override
            protected void updateItem(Image item, boolean empty) {
                super.updateItem(item, empty);

                setText(null);
                if (item == null || empty) {
                    setGraphic(null);
                } else {
                    setGraphic(new ImageView(item));
                }
            }
        });
        tbcTitle.setCellValueFactory(data -> data.getValue().get().titleProperty());
        tbcTitle.setCellFactory(param -> new TextFieldTableCell<>(new SimpleStringConverter()));
        tbcMailAddress.setCellValueFactory(data -> data.getValue().get().mailAddressProperty());
        tbcMailAddress.setCellFactory(param -> new TextFieldTableCell<>(new SimpleStringConverter()));
        tbcMailFile.setCellValueFactory(data -> data.getValue().get().mailFileNameProperty());
        tbcMailFileType.setCellValueFactory(data -> {
            final String mailFilePluginId = data.getValue().get().getMailFilePluginId();
            final MailFilePlugin mailFilePlugin = PluginService.getMailFilePluginMap().get(mailFilePluginId);

            return new ReadOnlyStringWrapper(mailFilePlugin.getName()).getReadOnlyProperty();
        });
        tbcMailProtocol.setCellValueFactory(data -> {
            final String mailProtocolPluginId = data.getValue().get().getMailProtocolPluginId();
            final MailProtocolPlugin mailProtocolPlugin = PluginService.getMailProtocolPluginMap().get(mailProtocolPluginId);

            return new ReadOnlyStringWrapper(mailProtocolPlugin.getName()).getReadOnlyProperty();
        });
        tbcProvider.setCellValueFactory(data -> data.getValue().get().getMailProtocolData().hostProperty());
    }

    @FXML
    private void onActionAddAccount(ActionEvent actionEvent) {
        final AccountWizard.Result result = AccountWizard.show();
        if (result != null) {
            try {
                //Create or load (and copy)
                String mailFileName = result.getMailFileName();
                if (result.isLoadMailFile()) {
                    if (result.isCopyMailFile()) {
                        FileUtils.copyFile(
                                new File(result.getMailFileName()),
                                new File(
                                        ConfigurationService.APPLICATION_CONFIGURATION.getMailFileDirectory(),
                                        FilenameUtils.getName(result.getMailFileName())
                                )
                        );
                        mailFileName = FilenameUtils.getName(result.getMailFileName());
                    }
                } else {
                    result.getMailFilePlugin().getInstance().createMailFile(
                            new File(ConfigurationService.APPLICATION_CONFIGURATION.getMailFileDirectory(), result.getMailFileName())
                    );
                }

                final MailAccount mailAccount = new MailAccount(
                        result.getAccountName(),
                        result.getMailAddress(),
                        result.getMailProtocolData().toReadOnlyProperty(),
                        mailFileName,
                        result.getMailProtocolPlugin().getId(),
                        result.getMailFilePlugin().getId(),
                        result.getUsername()
                );
                MailAccountService.getMailAccountList().add(new ReadOnlyMailAccountWrapper(mailAccount).getReadOnlyProperty());
            } catch (IOException e) {
                LOGGER.error("Error while creating account", e);
                DialogBuilderFactory.createExceptionDialogBuilder(e)
                        .headerText("Error while creating account")
                        .message("Cannot create account: " + e.getMessage())
                        .show();
            }
        }
    }

    @FXML
    private void onActionEditAccount(ActionEvent actionEvent) {

    }

    @FXML
    private void onActionRemoveAccount(ActionEvent actionEvent) {
        Optional<ButtonType> result = new Alert(Alert.AlertType.WARNING, "You are sure to remove selected account?",
                ButtonType.YES, ButtonType.NO).showAndWait();

        if (result.isPresent() && result.get() == ButtonType.YES) {
            MailAccountService.getMailAccountList().remove(tblAccount.getSelectionModel().getSelectedItem());
        }
    }
}
