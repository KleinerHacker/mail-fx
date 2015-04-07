package org.pcsoft.tools.mail_fx.core.impl;

import org.ini4j.Ini;
import org.pcsoft.tools.mail_fx.MailFxConstants;
import org.pcsoft.tools.mail_fx.core.impl.config.ApplicationConfiguration;
import org.pcsoft.tools.mail_fx.core.impl.config.PluginConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

/**
 * Created by Christoph on 29.10.2014.
 */
public final class ConfigurationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConfigurationService.class);

    private static final File CONFIG_FILE = new File(MailFxConstants.CONFIGURATION_PATH, "config.ini");

    public static final PluginConfiguration PLUGIN_CONFIGURATION = new PluginConfiguration();
    public static final ApplicationConfiguration APPLICATION_CONFIGURATION = new ApplicationConfiguration();

    static {
        try {
            final Ini ini = new Ini(CONFIG_FILE);

            PLUGIN_CONFIGURATION.load(ini.get(PluginConfiguration.MASTER_KEY));
            APPLICATION_CONFIGURATION.load(ini.get(ApplicationConfiguration.MASTER_KEY));
        } catch (IOException e) {
            LOGGER.warn("Cannot load configuration! Use default values instead...", e);
        }
    }

    public static void store() {
        try {
            final Ini ini = new Ini();

            PLUGIN_CONFIGURATION.save(ini.add(PluginConfiguration.MASTER_KEY));
            APPLICATION_CONFIGURATION.save(ini.add(ApplicationConfiguration.MASTER_KEY));

            ini.store(CONFIG_FILE);
        } catch (IOException e) {
            LOGGER.warn("Cannot save configuration!", e);
        }
    }

    private ConfigurationService() {
    }
}
