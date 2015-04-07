package org.pcsoft.tools.mail_fx.ui.wizard.account;

import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import org.controlsfx.dialog.Wizard;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Christoph on 08.11.2014.
 */
class ConfigurationTypePage extends AbstractWizardPage {

    @FXML
    private RadioButton rbAutomaticConfiguration;
    @FXML
    private RadioButton rbManuelConfiguration;
    @FXML
    private ToggleGroup grpConfigurationType;

    public ConfigurationTypePage(AccountWizard.Result result) {
        super(
                "Choice Configuration Type",
                Thread.currentThread().getContextClassLoader().getResource("fxml/wizard.page.account.config.type.fxml"),
                result
        );
        loadUI();
    }

    @Override
    protected Wizard.WizardPane nextPage() {
        if (rbAutomaticConfiguration.isSelected()) {
            //TODO: Auto detection
        }

        return new ConfigProtocolChoicePage(result);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
