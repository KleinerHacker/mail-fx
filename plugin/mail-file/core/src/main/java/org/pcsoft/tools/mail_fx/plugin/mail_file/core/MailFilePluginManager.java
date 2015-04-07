package org.pcsoft.tools.mail_fx.plugin.mail_file.core;

import org.pcsoft.tools.mail_fx.plugin.common.AbstractPluginManager;
import org.pcsoft.tools.mail_fx.plugin.common.exceptions.MailFxPluginLoadingException;
import org.pcsoft.tools.mail_fx.plugin.mail_file.api.MailFileIOService;
import org.pcsoft.tools.mail_fx.plugin.mail_file.api.annotations.MailFileDescriptor;
import org.pcsoft.tools.mail_fx.plugin.mail_file.common.exceptions.MailFilePluginLoadingException;

import java.io.File;
import java.util.Map;

/**
 * Created by Christoph on 09.11.2014.
 */
public class MailFilePluginManager extends AbstractPluginManager<MailFileIOService, MailFilePlugin, MailFileDescriptor> {

    public MailFilePluginManager(File pluginPath) {
        super(pluginPath, MailFileIOService.class, MailFileDescriptor.class);
    }

    @Override
    protected MailFxPluginLoadingException buildLoadingException(String message) {
        return new MailFilePluginLoadingException(message);
    }

    @Override
    protected void putPlugin(Map<String, MailFilePlugin> pluginMap, MailFileDescriptor annotation, MailFileIOService instance) {
        pluginMap.put(annotation.id(), new MailFilePlugin(
                annotation.id(), annotation.name(), annotation.description(), annotation.fileExtension(), instance
        ));
    }
}
