package org.pcsoft.tools.mail_fx.core.impl.utils;

import org.pcsoft.tools.mail_fx.core.api.exceptions.MailFxCommunicationException;
import org.pcsoft.tools.mail_fx.core.api.exceptions.MailFxIOException;
import org.pcsoft.tools.mail_fx.core.api.types.account.MailAccount;
import org.pcsoft.tools.mail_fx.core.api.types.mail.Mail;

import javax.mail.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

/**
 * Created by Christoph on 29.10.2014.
 */
public final class MailUtils {

    public static List<Mail> receiveMails(final MailAccount mailAccount, final String password) {
        try {
            final Properties properties = mailAccount.getMailProtocolData().buildSessionProperties();
            final Session session = Session.getDefaultInstance(properties);
            final Store store = session.getStore(mailAccount.getMailProtocolPluginId());
            store.connect(mailAccount.getUsername(), password);

            final Folder folder = store.getFolder("INBOX");
            folder.open(Folder.READ_ONLY);

            final Message[] messages = folder.getMessages();
            final List<Mail> mailList = new ArrayList<>();
            for (final Message message : messages) {
                final Mail mail = new Mail(message.getSubject(), message.getContent().toString());
                mail.getSenderAddressList().setAll(
                        Arrays.asList(message.getFrom()).stream().map(Address::toString).collect(Collectors.toList())
                );
                mail.getReceiverAddressList().setAll(
                        Arrays.asList(message.getRecipients(Message.RecipientType.TO)).stream()
                                .map(Address::toString).collect(Collectors.toList())
                );
                mail.getAdditionalReceiverList().setAll(
                        Arrays.asList(message.getRecipients(Message.RecipientType.CC)).stream()
                                .map(Address::toString).collect(Collectors.toList())
                );
                mail.getHiddenReceiverAddressList().setAll(
                        Arrays.asList(message.getRecipients(Message.RecipientType.BCC)).stream()
                                .map(Address::toString).collect(Collectors.toList())
                );

                mailList.add(mail);
            }

            folder.close(false);
            store.close();

            return mailList;
        } catch (MessagingException e) {
            throw new MailFxCommunicationException(e);
        } catch (IOException e) {
            throw new MailFxIOException(e);
        }
    }

    private MailUtils() {
    }
}
