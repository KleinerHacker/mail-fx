package org.pcsoft.tools.mail_fx.core.api.types.mail;

import com.sun.javafx.collections.ObservableListWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import org.pcsoft.tools.mail_fx.types.props.AbstractExpression;

import java.util.ArrayList;

/**
 * Created by Christoph on 29.10.2014.
 */
public final class Mail {

    private final StringProperty subject = new SimpleStringProperty();
    private final StringProperty content = new SimpleStringProperty();
    private final ObservableList<AbstractExpression<MailAffix>> affixList = new ObservableListWrapper<>(new ArrayList<>());

    private final ObservableList<String> senderAddressList = new ObservableListWrapper<>(new ArrayList<>());
    private final ObservableList<String> receiverAddressList = new ObservableListWrapper<>(new ArrayList<>());
    private final ObservableList<String> additionalReceiverList = new ObservableListWrapper<>(new ArrayList<>());
    private final ObservableList<String> hiddenReceiverAddressList = new ObservableListWrapper<>(new ArrayList<>());

    public Mail(String subject, String content) {
        this.subject.set(subject);
        this.content.set(content);
    }

    public String getSubject() {
        return subject.get();
    }

    public StringProperty subjectProperty() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject.set(subject);
    }

    public String getContent() {
        return content.get();
    }

    public StringProperty contentProperty() {
        return content;
    }

    public void setContent(String content) {
        this.content.set(content);
    }

    public ObservableList<AbstractExpression<MailAffix>> getAffixList() {
        return affixList;
    }

    public ObservableList<String> getSenderAddressList() {
        return senderAddressList;
    }

    public ObservableList<String> getReceiverAddressList() {
        return receiverAddressList;
    }

    public ObservableList<String> getAdditionalReceiverList() {
        return additionalReceiverList;
    }

    public ObservableList<String> getHiddenReceiverAddressList() {
        return hiddenReceiverAddressList;
    }
}
