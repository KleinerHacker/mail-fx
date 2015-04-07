package org.pcsoft.tools.mail_fx.core.impl.config;

import org.ini4j.Profile;
import org.pcsoft.tools.mail_fx.MailFxConstants;
import org.pcsoft.tools.mail_fx.types.MailFxConfiguration;

import java.io.File;

/**
 * Created by Christoph on 14.11.2014.
 */
public class ApplicationConfiguration implements MailFxConfiguration {

    public static final String MASTER_KEY = "APPLICATION";

    private static final File DIRECTORY_DATA = new File(MailFxConstants.CONFIGURATION_PATH, "data");

    private static final String KEY_DIRECTORY_MAIL_FILE = "directory.mail_file";

    private File mailFileDirectory;

    public ApplicationConfiguration() {
        setMailFileDirectory(new File(DIRECTORY_DATA, "mail-files"));
    }

    public File getMailFileDirectory() {
        return mailFileDirectory;
    }

    public void setMailFileDirectory(File mailFileDirectory) {
        this.mailFileDirectory = mailFileDirectory;
        if (!this.mailFileDirectory.exists()) {
            this.mailFileDirectory.mkdirs();
        }
    }

    @Override
    public void save(Profile.Section section) {
        section.put(KEY_DIRECTORY_MAIL_FILE, mailFileDirectory.getAbsolutePath());
    }

    @Override
    public void load(Profile.Section section) {
        if (section == null)
            return;

        setMailFileDirectory(new File(section.get(KEY_DIRECTORY_MAIL_FILE)));
    }
}
