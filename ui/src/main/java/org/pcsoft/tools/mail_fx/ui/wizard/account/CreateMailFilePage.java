package org.pcsoft.tools.mail_fx.ui.wizard.account;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import org.controlsfx.control.decoration.Decorator;
import org.controlsfx.dialog.Wizard;
import org.pcsoft.tools.mail_fx.common_ui.controlsfx.decoration.ValidationDecoration;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Christoph on 12.11.2014.
 */
class CreateMailFilePage extends AbstractWizardPage {

    @FXML
    private TextField txtFileName;

    public CreateMailFilePage(AccountWizard.Result result) {
        super(
                "Create new mail file",
                Thread.currentThread().getContextClassLoader().getResource("fxml/wizard.page.account.config.file.create.fxml"),
                result
        );
        loadUI();
    }

    @Override
    protected Wizard.WizardPane nextPage() {
        if (txtFileName.getText() == null || txtFileName.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Please enter a valid file name!", ButtonType.OK).showAndWait();
            return this;
        }
        result.setMailFileName(txtFileName.getText());

        return new SummaryPage(result);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        txtFileName.setText(result.getMailFileName());

        if (txtFileName.getText() == null || txtFileName.getText().trim().isEmpty()) {
            Decorator.addDecoration(txtFileName, new ValidationDecoration());
        }
        txtFileName.textProperty().addListener((v, o, n) -> {
            if (n == null || n.trim().isEmpty()) {
                Decorator.addDecoration(txtFileName, new ValidationDecoration());
            } else {
                Decorator.removeAllDecorations(txtFileName);
            }
        });
    }
}
