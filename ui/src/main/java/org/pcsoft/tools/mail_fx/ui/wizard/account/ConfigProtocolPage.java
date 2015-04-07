package org.pcsoft.tools.mail_fx.ui.wizard.account;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import org.apache.commons.lang.math.NumberUtils;
import org.controlsfx.control.decoration.Decorator;
import org.controlsfx.dialog.Wizard;
import org.pcsoft.tools.mail_fx.plugin.mail_protocol.api.types.ValidationResult;
import org.pcsoft.tools.mail_fx.common_ui.controlsfx.decoration.ValidationDecoration;
import org.pcsoft.tools.mail_fx.ui.utils.EventHandlerUtils;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Christoph on 08.11.2014.
 */
class ConfigProtocolPage extends AbstractWizardPage {

    @FXML
    private TextField txtHost;
    @FXML
    private TextField txtPort;
    @FXML
    private BorderPane pnlProtocolData;

    public ConfigProtocolPage(final AccountWizard.Result result) {
        super(
                "Configure Mail Protocol",
                Thread.currentThread().getContextClassLoader().getResource("fxml/wizard.page.account.config.protocol.fxml"),
                result
        );

        loadUI();
    }

    @Override
    protected Wizard.WizardPane nextPage() {
        if (txtPort.getText() == null || txtPort.getText().trim().isEmpty() || !NumberUtils.isNumber(txtPort.getText())) {
            new Alert(Alert.AlertType.ERROR, "Please enter a valid port.", ButtonType.OK).showAndWait();
            return this;
        }
        result.getMailProtocolData().setPort(Integer.parseInt(txtPort.getText()));
        if (txtHost.getText() == null || txtHost.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Please enter a valid host name or ip address.", ButtonType.OK).showAndWait();
            return this;
        }
        result.getMailProtocolData().setHost(txtHost.getText());

        final ValidationResult validationResult = result.getMailProtocolData().validate();
        if (!validationResult.isSuccess()) {
            new Alert(Alert.AlertType.ERROR, validationResult.getErrorMessage(), ButtonType.OK).showAndWait();
            return this;
        }

        return new MailFileChoicePage(result);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        txtPort.addEventHandler(
                KeyEvent.KEY_TYPED,
                EventHandlerUtils.TextFieldHandlers.createNumericIntegerInputRestrictionHandler(5)
        );

        txtHost.setText(result.getMailProtocolData().getHost());
        txtPort.setText(result.getMailProtocolData().getPort() + "");

        if (txtHost.getText() == null || txtHost.getText().trim().isEmpty()) {
            Decorator.addDecoration(txtHost, new ValidationDecoration());
        }
        txtHost.textProperty().addListener((v, o, n) -> {
            if (n == null || n.trim().isEmpty()) {
                Decorator.addDecoration(txtHost, new ValidationDecoration());
            } else {
                Decorator.removeAllDecorations(txtHost);
            }
        });

        if (txtPort.getText() == null || txtPort.getText().trim().isEmpty() ||
                !NumberUtils.isNumber(txtPort.getText()) || Integer.parseInt(txtPort.getText()) <= 0) {
            Decorator.addDecoration(txtPort, new ValidationDecoration());
        }
        txtPort.textProperty().addListener((v, o, n) -> {
            if (n == null || n.trim().isEmpty() || !NumberUtils.isNumber(n) || Integer.parseInt(n) <= 0) {
                Decorator.addDecoration(txtPort, new ValidationDecoration());
            } else {
                Decorator.removeAllDecorations(txtPort);
            }
        });

        pnlProtocolData.setCenter(result.getMailProtocolPlugin().getInstance().getSettings().buildSettingsPage(result.getMailProtocolData()));
    }
}
