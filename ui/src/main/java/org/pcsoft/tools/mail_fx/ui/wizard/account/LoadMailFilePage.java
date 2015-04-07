package org.pcsoft.tools.mail_fx.ui.wizard.account;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.FileChooser;
import org.controlsfx.control.decoration.Decorator;
import org.controlsfx.dialog.Wizard;
import org.pcsoft.tools.mail_fx.common_ui.controlsfx.decoration.ValidationDecoration;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Christoph on 12.11.2014.
 */
class LoadMailFilePage extends AbstractWizardPage {

    @FXML
    private TextField txtSelectedFile;
    @FXML
    private RadioButton rbCopy;
    @FXML
    private RadioButton rbUse;
    @FXML
    private ToggleGroup grpFileHandling;

    public LoadMailFilePage(AccountWizard.Result result) {
        super(
                "Load existing mail file",
                Thread.currentThread().getContextClassLoader().getResource("fxml/wizard.page.account.config.file.load.fxml"),
                result
        );
        loadUI();
    }

    @Override
    protected Wizard.WizardPane nextPage() {
        if (txtSelectedFile.getText() == null || txtSelectedFile.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Please select a file!", ButtonType.OK).showAndWait();
            return this;
        }
        if (!new File(txtSelectedFile.getText()).exists()) {
            new Alert(Alert.AlertType.ERROR, "Please select an existing file!", ButtonType.OK).showAndWait();
            return this;
        }
        result.setMailFileName(txtSelectedFile.getText());
        result.setCopyMailFile(rbCopy.isSelected());

        return new SummaryPage(result);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        txtSelectedFile.setText(result.getMailFileName());

        if (txtSelectedFile.getText() == null || txtSelectedFile.getText().trim().isEmpty()) {
            Decorator.addDecoration(txtSelectedFile, new ValidationDecoration());
        }
        txtSelectedFile.textProperty().addListener((v, o, n) -> {
            if (n == null || n.trim().isEmpty()) {
                Decorator.addDecoration(txtSelectedFile, new ValidationDecoration());
            } else {
                Decorator.removeAllDecorations(txtSelectedFile);
            }
        });
    }

    @FXML
    private void onActionLoadFile(ActionEvent actionEvent) {
        final FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter(
                result.getMailFilePlugin().getName(),
                result.getMailFilePlugin().getFileExtension()
        ));

        final File file = fileChooser.showOpenDialog(null);
        if (file != null) {
            txtSelectedFile.setText(file.getAbsolutePath());
        }
    }
}
