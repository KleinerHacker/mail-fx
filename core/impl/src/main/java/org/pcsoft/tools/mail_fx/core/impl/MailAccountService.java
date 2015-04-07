package org.pcsoft.tools.mail_fx.core.impl;

import com.sun.javafx.collections.ObservableListWrapper;
import javafx.beans.Observable;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import org.ini4j.Ini;
import org.ini4j.Profile;
import org.pcsoft.tools.mail_fx.MailFxConstants;
import org.pcsoft.tools.mail_fx.core.api.types.account.MailAccount;
import org.pcsoft.tools.mail_fx.core.api.types.account.props.ReadOnlyMailAccountWrapper;
import org.pcsoft.tools.mail_fx.plugin.mail_protocol.api.types.MailProtocolData;
import org.pcsoft.tools.mail_fx.plugin.mail_protocol.core.MailProtocolPlugin;
import org.pcsoft.tools.mail_fx.utils.PropertiesUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

/**
 * Created by Christoph on 14.11.2014.
 */
public final class MailAccountService {

    private static final File ACCOUNT_FILE = new File(MailFxConstants.CONFIGURATION_PATH, "accounts.ini");

    private static final String MASTER_KEY = "ACCOUNT.";
    private static final String KEY_TITLE = "title";
    private static final String KEY_USER = "user";
    private static final String KEY_MAIL_ADDRESS = "mail_address";
    private static final String BASE_KEY_MAIL_PROTOCOL = "mail_protocol.";
    private static final String KEY_MAIL_PROTOCOL_ID = BASE_KEY_MAIL_PROTOCOL + "id";
    private static final String KEY_MAIL_PROTOCOL_DATA = BASE_KEY_MAIL_PROTOCOL + "data";
    private static final String BASE_KEY_MAIL_FILE = "mail_file.";
    private static final String KEY_MAIL_FILE_ID = BASE_KEY_MAIL_FILE + "id";
    private static final String KEY_MAIL_FILE_NAME = BASE_KEY_MAIL_FILE + "name";

    private static final ObservableList<ReadOnlyObjectProperty<MailAccount>> mailAccountList =
            new ObservableListWrapper<>(new ArrayList<>(), o -> new Observable[]{o});

    static {
        load();
        mailAccountList.addListener((ListChangeListener<ReadOnlyObjectProperty<MailAccount>>) c -> store());
    }

    /**
     * Returns the list.
     * <b>If add or remove is called the inserted data will be stored or deleted</b>
     *
     * @return
     */
    public static ObservableList<ReadOnlyObjectProperty<MailAccount>> getMailAccountList() {
        return mailAccountList;
    }

    private static void load() {
        if (!ACCOUNT_FILE.exists())
            return;

        try {
            final List<MailAccount> mailAccounts = new ArrayList<>();
            final Ini ini = new Ini(ACCOUNT_FILE);
            for (final String sectionKey : ini.keySet()) {
                final MailAccount mailAccount = load(ini.get(sectionKey));
                mailAccounts.add(mailAccount);
            }

            mailAccountList.setAll(
                    mailAccounts.stream()
                            .map(item -> new ReadOnlyMailAccountWrapper(item).getReadOnlyProperty())
                            .collect(Collectors.toList())
            );
        } catch (IOException e) {
            e.printStackTrace();//TODO
        }
    }

    private static MailAccount load(Profile.Section section) {
        final String title = section.get(KEY_TITLE);
        final String username = section.get(KEY_USER);
        final String mailAddress = section.get(KEY_MAIL_ADDRESS);

        final String mailProtocolId = section.get(KEY_MAIL_PROTOCOL_ID);
        final MailProtocolPlugin mailProtocolPlugin = PluginService.getMailProtocolPluginMap().get(mailProtocolId);
        final Properties mailProtocolProps = PropertiesUtils.parseProperties(section.get(KEY_MAIL_PROTOCOL_DATA));
        final MailProtocolData mailProtocolData = mailProtocolPlugin.getInstance().loadMailProtocolData(mailProtocolProps);

        final String mailFileId = section.get(KEY_MAIL_FILE_ID);
        final String mailFileName = section.get(KEY_MAIL_FILE_NAME);

        return new MailAccount(title, mailAddress, mailProtocolData.toReadOnlyProperty(), mailFileName, mailProtocolId, mailFileId, username);
    }

    private static void store() {
        try {
            final Ini ini = new Ini();

            for (final ReadOnlyObjectProperty<MailAccount> mailAccount : mailAccountList) {
                store(ini.add(MASTER_KEY + mailAccount.get().getTitle().toUpperCase()), mailAccount.get());
            }

            ini.store(ACCOUNT_FILE);
        } catch (IOException e) {
            e.printStackTrace();//TODO
        }
    }

    private static void store(Profile.Section section, MailAccount mailAccount) {
        section.put(KEY_TITLE, mailAccount.getTitle());
        section.put(KEY_USER, mailAccount.getUsername());
        section.put(KEY_MAIL_ADDRESS, mailAccount.getMailAddress());

        section.put(KEY_MAIL_PROTOCOL_ID, mailAccount.getMailProtocolPluginId());
        final Properties mailProtocolProps = mailAccount.getMailProtocolData().save();
        section.put(KEY_MAIL_PROTOCOL_DATA, PropertiesUtils.toString(mailProtocolProps));

        section.put(KEY_MAIL_FILE_ID, mailAccount.getMailFilePluginId());
        section.put(KEY_MAIL_FILE_NAME, mailAccount.getMailFileName());
    }

    private MailAccountService() {
    }
}
