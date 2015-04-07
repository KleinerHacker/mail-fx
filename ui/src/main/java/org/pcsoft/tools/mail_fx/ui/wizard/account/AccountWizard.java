package org.pcsoft.tools.mail_fx.ui.wizard.account;

import javafx.scene.control.ButtonType;
import org.controlsfx.dialog.Wizard;
import org.pcsoft.tools.mail_fx.plugin.mail_file.core.MailFilePlugin;
import org.pcsoft.tools.mail_fx.plugin.mail_protocol.api.types.MailProtocolData;
import org.pcsoft.tools.mail_fx.plugin.mail_protocol.core.MailProtocolPlugin;

import java.util.Optional;

/**
 * Created by Christoph on 08.11.2014.
 */
public final class AccountWizard {

    /**
     * Result object of wizard.<br/>
     * This object will be enrich while running of wizard
     */
    public static final class Result {
        private String accountName;
        private String username, password = "12345";//TODO: Remove default password
        private String mailAddress;
        private MailProtocolPlugin mailProtocolPlugin;
        private MailProtocolData mailProtocolData;
        private MailFilePlugin mailFilePlugin;
        private String mailFileName;
        private boolean loadMailFile;
        private boolean copyMailFile;

        private Result() {
        }

        public String getAccountName() {
            return accountName;
        }

        public String getMailAddress() {
            return mailAddress;
        }

        public MailProtocolPlugin getMailProtocolPlugin() {
            return mailProtocolPlugin;
        }

        public MailFilePlugin getMailFilePlugin() {
            return mailFilePlugin;
        }

        public MailProtocolData getMailProtocolData() {
            return mailProtocolData;
        }

        public String getMailFileName() {
            return mailFileName;
        }

        public boolean isLoadMailFile() {
            return loadMailFile;
        }

        /**
         * Only for loaded mail file
         * @return
         */
        public boolean isCopyMailFile() {
            return copyMailFile;
        }

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }

        void setAccountName(String accountName) {
            this.accountName = accountName;
        }

        void setMailProtocolPlugin(MailProtocolPlugin mailProtocolPlugin) {
            this.mailProtocolPlugin = mailProtocolPlugin;
        }

        void setMailFilePlugin(MailFilePlugin mailFilePlugin) {
            this.mailFilePlugin = mailFilePlugin;
        }

        void setMailProtocolData(MailProtocolData mailProtocolData) {
            this.mailProtocolData = mailProtocolData;
        }

        void setMailFileName(String mailFile) {
            this.mailFileName = mailFile;
        }

        void setLoadMailFile(boolean loadMailFile) {
            this.loadMailFile = loadMailFile;
        }

        void setCopyMailFile(boolean copyMailFile) {
            this.copyMailFile = copyMailFile;
        }

        void setUsername(String username) {
            this.username = username;
        }

        void setPassword(String password) {
            this.password = password;
        }

        void setMailAddress(String mailAddress) {
            this.mailAddress = mailAddress;
        }

        @Override
        public String toString() {
            return "Result{" +
                    "accountName='" + accountName + '\'' +
                    ", mailAddress='" + mailAddress + '\'' +
                    ", username='" + username + '\'' +
                    ", password='" + password + '\'' +
                    ", mailProtocolPlugin=" + mailProtocolPlugin +
                    ", mailProtocolData=" + mailProtocolData +
                    ", mailFilePlugin=" + mailFilePlugin +
                    ", mailFileName='" + mailFileName + '\'' +
                    ", loadMailFile=" + loadMailFile +
                    ", copyMailFile=" + copyMailFile +
                    '}';
        }
    }

    public static Result show() {
        final Result result = new Result();

        final Wizard wizard = new Wizard(null, "Create new mail account");
        wizard.setFlow(new AccountFlow(result));

        final Optional<ButtonType> wizardResult = wizard.showAndWait();
        if (wizardResult.isPresent() && wizardResult.get() == ButtonType.FINISH) {
            return result;
        }

        return null;
    }

    private AccountWizard() {
    }
}
