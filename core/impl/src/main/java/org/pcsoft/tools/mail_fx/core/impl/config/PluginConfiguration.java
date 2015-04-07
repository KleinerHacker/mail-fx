package org.pcsoft.tools.mail_fx.core.impl.config;

import org.ini4j.Profile;
import org.pcsoft.tools.mail_fx.MailFxConstants;
import org.pcsoft.tools.mail_fx.types.MailFxConfiguration;

import java.io.File;

/**
 * Created by Christoph on 29.10.2014.
 */
public final class PluginConfiguration implements MailFxConfiguration {

    public static final String MASTER_KEY = "PLUGINS";

    private static final File PLUGIN_PATH = new File(MailFxConstants.CONFIGURATION_PATH, "plugins");

    private static final String KEY_PLUGIN_AFFIX_PREVIEW = "plugin.directory.affix-preview";
    private static final String KEY_PLUGIN_MAIL_PROTOCOL = "plugin.directory.mail-protocol";
    private static final String KEY_PLUGIN_MAIL_CONTENT = "plugin.directory.mail-content";
    private static final String KEY_PLUGIN_MAIL_FILE = "plugin.directory.mail-file";

    private File affixPreviewPluginPath, mailProtocolPluginPath, mailContentPluginPath, mailFilePluginPath;

    public PluginConfiguration() {
        setAffixPreviewPluginPath(new File(PLUGIN_PATH, "affix-preview"));
        setMailProtocolPluginPath(new File(PLUGIN_PATH, "mail-protocol"));
        setMailContentPluginPath(new File(PLUGIN_PATH, "mail-content"));
        setMailFilePluginPath(new File(PLUGIN_PATH, "mail-file"));
    }

    public File getAffixPreviewPluginPath() {
        return affixPreviewPluginPath;
    }

    public void setAffixPreviewPluginPath(File affixPreviewPluginPath) {
        this.affixPreviewPluginPath = affixPreviewPluginPath;
        if (!affixPreviewPluginPath.exists()) {
            affixPreviewPluginPath.mkdirs();
        }
    }

    public File getMailProtocolPluginPath() {
        return mailProtocolPluginPath;
    }

    public void setMailProtocolPluginPath(File mailProtocolPluginPath) {
        this.mailProtocolPluginPath = mailProtocolPluginPath;
        if (!mailProtocolPluginPath.exists()) {
            mailProtocolPluginPath.mkdirs();
        }
    }

    public File getMailContentPluginPath() {
        return mailContentPluginPath;
    }

    public void setMailContentPluginPath(File mailContentPluginPath) {
        this.mailContentPluginPath = mailContentPluginPath;
        if (!mailContentPluginPath.exists()) {
            mailContentPluginPath.mkdirs();
        }
    }

    public File getMailFilePluginPath() {
        return mailFilePluginPath;
    }

    public void setMailFilePluginPath(File mailFilePluginPath) {
        this.mailFilePluginPath = mailFilePluginPath;
        if (!mailFilePluginPath.exists()) {
            mailFilePluginPath.mkdirs();
        }
    }

    @Override
    public void save(Profile.Section section) {
        section.put(KEY_PLUGIN_AFFIX_PREVIEW, affixPreviewPluginPath.getAbsolutePath());
        section.put(KEY_PLUGIN_MAIL_CONTENT, mailContentPluginPath.getAbsolutePath());
        section.put(KEY_PLUGIN_MAIL_PROTOCOL, mailProtocolPluginPath.getAbsolutePath());
        section.put(KEY_PLUGIN_MAIL_FILE, mailFilePluginPath.getAbsolutePath());
    }

    @Override
    public void load(Profile.Section section) {
        if (section == null)
            return;

        setAffixPreviewPluginPath(new File(section.get(KEY_PLUGIN_AFFIX_PREVIEW)));
        setMailContentPluginPath(new File(section.get(KEY_PLUGIN_MAIL_CONTENT)));
        setMailProtocolPluginPath(new File(section.get(KEY_PLUGIN_MAIL_PROTOCOL)));
        setMailFilePluginPath(new File(section.get(KEY_PLUGIN_MAIL_FILE)));
    }
}
