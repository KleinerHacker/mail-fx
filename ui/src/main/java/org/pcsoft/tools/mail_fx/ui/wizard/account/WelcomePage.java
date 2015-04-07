package org.pcsoft.tools.mail_fx.ui.wizard.account;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.controlsfx.control.decoration.Decorator;
import org.controlsfx.dialog.Wizard;
import org.pcsoft.tools.mail_fx.common_ui.controlsfx.decoration.ValidationDecoration;
import org.pcsoft.tools.mail_fx.core.impl.utils.ValidationUtils;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Christoph on 08.11.2014.
 */
class WelcomePage extends AbstractWizardPage {

    @FXML
    private TextField txtMailAddress;
    @FXML
    private TextField txtUsername;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private TextField txtAccountTitle;

    public WelcomePage(AccountWizard.Result result) {
        super(
                "Welcome to Account Creation Wizard!",
                Thread.currentThread().getContextClassLoader().getResource("fxml/wizard.page.account.welcome.fxml"),
                result
        );
        loadUI();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        txtAccountTitle.setText(result.getAccountName());//Input older value
        txtUsername.setText(result.getUsername());
        txtPassword.setText(result.getPassword());
        txtMailAddress.setText(result.getMailAddress());

        if (txtMailAddress.getText() == null || txtMailAddress.getText().trim().isEmpty()) {
            Decorator.addDecoration(txtMailAddress, new ValidationDecoration());
        }
        txtMailAddress.textProperty().addListener((v, o, n) -> {
            if (n == null || n.trim().isEmpty() || !ValidationUtils.validateMailAddress(n)) {
                Decorator.addDecoration(txtMailAddress, new ValidationDecoration());
            } else {
                Decorator.removeAllDecorations(txtMailAddress);
            }
        });

        if (txtAccountTitle.getText() == null || txtAccountTitle.getText().trim().isEmpty()) {
            Decorator.addDecoration(txtAccountTitle, new ValidationDecoration());
        }
        txtAccountTitle.textProperty().addListener((v, o, n) -> {
            if (n == null || n.trim().isEmpty()) {
                Decorator.addDecoration(txtAccountTitle, new ValidationDecoration());
            } else {
                Decorator.removeAllDecorations(txtAccountTitle);
            }
        });

        if (txtUsername.getText() == null || txtUsername.getText().trim().isEmpty()) {
            Decorator.addDecoration(txtUsername, new ValidationDecoration());
        }
        txtUsername.textProperty().addListener((v, o, n) -> {
            if (n == null || n.trim().isEmpty()) {
                Decorator.addDecoration(txtUsername, new ValidationDecoration());
            } else {
                Decorator.removeAllDecorations(txtUsername);
            }
        });

        if (txtPassword.getText() == null || txtPassword.getText().trim().isEmpty()) {
            Decorator.addDecoration(txtPassword, new ValidationDecoration());
        }
        txtPassword.textProperty().addListener((v, o, n) -> {
            if (n == null || n.trim().isEmpty()) {
                Decorator.addDecoration(txtPassword, new ValidationDecoration());
            } else {
                Decorator.removeAllDecorations(txtPassword);
            }
        });
    }

    @Override
    protected Wizard.WizardPane nextPage() {
        if (txtAccountTitle.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Please enter a valid account title first!", ButtonType.OK).showAndWait();
            return this;
        }
        result.setAccountName(txtAccountTitle.getText());

        if (txtMailAddress.getText() == null || txtMailAddress.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Please enter your mail address", ButtonType.OK).showAndWait();
            return this;
        }
        if (!ValidationUtils.validateMailAddress(txtMailAddress.getText())) {
            new Alert(Alert.AlertType.ERROR, "Please enter a valid mail address", ButtonType.OK).showAndWait();
            return this;
        }
        result.setMailAddress(txtMailAddress.getText());

        if (txtUsername.getText() == null || txtUsername.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Please enter your username", ButtonType.OK).showAndWait();
            return this;
        }
        result.setUsername(txtUsername.getText());

        if (txtPassword.getText() == null || txtPassword.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Please enter your password", ButtonType.OK).showAndWait();
            return this;
        }
        result.setPassword(txtPassword.getText());

        return new ConfigurationTypePage(result);
    }
}
