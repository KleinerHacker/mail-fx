package org.pcsoft.tools.mail_fx.core.api.types.account;

import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.ReadOnlyStringProperty;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import org.pcsoft.tools.mail_fx.plugin.mail_protocol.api.types.MailProtocolData;

import java.util.Objects;

/**
 * Created by Christoph on 29.10.2014.
 */
public final class MailAccount {
    private final ReadOnlyObjectProperty<? extends MailProtocolData> mailProtocolData;
    private final StringProperty mailFileName;
    private final ReadOnlyStringProperty mailProtocolPluginId, mailFilePluginId;
    private final StringProperty title, username, mailAddress;

    public MailAccount(final String title, final String mailAddress, final ReadOnlyObjectProperty<? extends MailProtocolData> mailProtocolData, final String mailFileName, final String mailProtocolPluginId, final String mailFilePluginId, final String username) {
        this.title = new SimpleStringProperty(title);
        this.mailAddress = new SimpleStringProperty(mailAddress);
        this.mailProtocolData = mailProtocolData;
        this.mailFileName = new SimpleStringProperty(mailFileName);
        this.mailProtocolPluginId = new ReadOnlyStringWrapper(mailProtocolPluginId).getReadOnlyProperty();
        this.mailFilePluginId = new ReadOnlyStringWrapper(mailFilePluginId).getReadOnlyProperty();
        this.username = new SimpleStringProperty(username);
    }

    public MailProtocolData getMailProtocolData() {
        return mailProtocolData.get();
    }

    public ReadOnlyObjectProperty<? extends MailProtocolData> mailProtocolDataProperty() {
        return mailProtocolData;
    }

    public String getTitle() {
        return title.get();
    }

    public StringProperty titleProperty() {
        return title;
    }

    public void setTitle(String title) {
        this.title.set(title);
    }

    public String getUsername() {
        return username.get();
    }

    public StringProperty usernameProperty() {
        return username;
    }

    public void setUsername(String username) {
        this.username.set(username);
    }

    public String getMailProtocolPluginId() {
        return mailProtocolPluginId.get();
    }

    public ReadOnlyStringProperty mailProtocolPluginIdProperty() {
        return mailProtocolPluginId;
    }

    public String getMailFilePluginId() {
        return mailFilePluginId.get();
    }

    public ReadOnlyStringProperty mailFilePluginIdProperty() {
        return mailFilePluginId;
    }

    public String getMailFileName() {
        return mailFileName.get();
    }

    public StringProperty mailFileNameProperty() {
        return mailFileName;
    }

    public void setMailFileName(String mailFileName) {
        this.mailFileName.set(mailFileName);
    }

    public String getMailAddress() {
        return mailAddress.get();
    }

    public StringProperty mailAddressProperty() {
        return mailAddress;
    }

    public void setMailAddress(String mailAddress) {
        this.mailAddress.set(mailAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title.get());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final MailAccount other = (MailAccount) obj;
        return Objects.equals(this.title.get(), other.title.get());
    }

    @Override
    public String toString() {
        return "MailAccount{" +
                "title=" + title.get() +
                ", mailAddress=" + mailAddress.get() +
                ", username=" + username.get() +
                ", mailFileName=" + mailFileName.get() +
                ", mailFilePluginId=" + mailFilePluginId.get() +
                ", mailProtocolPluginId=" + mailProtocolPluginId.get() +
                ", mailProtocolData=" + mailProtocolData.get() +
                '}';
    }
}
