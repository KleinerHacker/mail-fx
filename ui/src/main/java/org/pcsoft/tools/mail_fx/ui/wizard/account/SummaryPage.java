package org.pcsoft.tools.mail_fx.ui.wizard.account;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.controlsfx.dialog.Wizard;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Christoph on 12.11.2014.
 */
class SummaryPage extends AbstractWizardPage {

    @FXML
    private Label lblAccountTitle;
    @FXML
    private Label lblProtocol;
    @FXML
    private Label lblMailFileType;
    @FXML
    private Label lblProtocolHost;
    @FXML
    private Label lblProtocolPort;
    @FXML
    private Label lblMailFileState;
    @FXML
    private Label lblMailFileName;

    public SummaryPage(AccountWizard.Result result) {
        super(
                "Summary of data",
                Thread.currentThread().getContextClassLoader().getResource("fxml/wizard.page.account.summary.fxml"),
                result
        );
        loadUI();
    }

    @Override
    protected Wizard.WizardPane nextPage() {
        return null;
    }

    @Override
    protected boolean hasNextPage() {
        return false;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lblAccountTitle.setText(result.getAccountName());
        lblProtocol.setText(result.getMailProtocolPlugin().getName());
        lblMailFileType.setText(result.getMailFilePlugin().getName());
        lblProtocolHost.setText(result.getMailProtocolData().getHost());
        lblProtocolPort.setText(result.getMailProtocolData().getPort() + "");
        if (result.isLoadMailFile()) {
            final StringBuilder sb = new StringBuilder("Load from existing file ");
            if (result.isCopyMailFile()) {
                sb.append("(Copy file)");
            } else {
                sb.append("(Use this file)");
            }
            lblMailFileState.setText(sb.toString());
        } else {
            lblMailFileState.setText("Create new file");
        }
        lblMailFileName.setText(result.getMailFileName());
    }
}
