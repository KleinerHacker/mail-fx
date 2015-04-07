package org.pcsoft.tools.mail_fx.core.impl;

import org.pcsoft.tools.mail_fx.plugin.mail_file.core.MailFilePlugin;
import org.pcsoft.tools.mail_fx.plugin.mail_file.core.MailFilePluginManager;
import org.pcsoft.tools.mail_fx.plugin.mail_protocol.core.MailProtocolPlugin;
import org.pcsoft.tools.mail_fx.plugin.mail_protocol.core.MailProtocolPluginManager;

import java.util.List;
import java.util.Map;

/**
 * Created by Christoph on 29.10.2014.
 */
public final class PluginService {

    private static final MailProtocolPluginManager MAIL_PROTOCOL_PLUGIN_MANAGER;
    private static final MailFilePluginManager MAIL_FILE_PLUGIN_MANAGER;

    static {
        MAIL_PROTOCOL_PLUGIN_MANAGER = new MailProtocolPluginManager(
                ConfigurationService.PLUGIN_CONFIGURATION.getMailProtocolPluginPath()
        );
        MAIL_FILE_PLUGIN_MANAGER = new MailFilePluginManager(
                ConfigurationService.PLUGIN_CONFIGURATION.getMailFilePluginPath()
        );
    }

    public static Map<String, MailProtocolPlugin> getMailProtocolPluginMap() {
        return MAIL_PROTOCOL_PLUGIN_MANAGER.getPluginMap();
    }

    public static List<MailProtocolPlugin> getMailProtocolPluginList() {
        return MAIL_PROTOCOL_PLUGIN_MANAGER.getPluginList();
    }

    public static Map<String, MailFilePlugin> getMailFilePluginMap() {
        return MAIL_FILE_PLUGIN_MANAGER.getPluginMap();
    }

    public static List<MailFilePlugin> getMailFilePluginList() {
        return MAIL_FILE_PLUGIN_MANAGER.getPluginList();
    }

    private PluginService() {
    }
}
