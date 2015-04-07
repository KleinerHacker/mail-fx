package org.pcsoft.tools.mail_fx.plugin.mail_protocol.core;

import org.pcsoft.tools.mail_fx.plugin.common.AbstractPluginManager;
import org.pcsoft.tools.mail_fx.plugin.common.exceptions.MailFxPluginLoadingException;
import org.pcsoft.tools.mail_fx.plugin.mail_protocol.api.MailProtocol;
import org.pcsoft.tools.mail_fx.plugin.mail_protocol.api.annotations.MailProtocolDescription;
import org.pcsoft.tools.mail_fx.plugin.mail_protocol.common.exceptions.MailProtocolPluginLoadingException;

import java.io.File;
import java.util.Map;

/**
 * Created by Christoph on 29.10.2014.
 */
public final class MailProtocolPluginManager extends AbstractPluginManager<MailProtocol, MailProtocolPlugin, MailProtocolDescription> {

    public MailProtocolPluginManager(File pluginPath) {
        super(pluginPath, MailProtocol.class, MailProtocolDescription.class);
    }

    @Override
    protected MailFxPluginLoadingException buildLoadingException(String message) {
        return new MailProtocolPluginLoadingException(message);
    }

    @Override
    protected void putPlugin(Map<String, MailProtocolPlugin> pluginMap, MailProtocolDescription annotation, MailProtocol instance) {
        pluginMap.put(annotation.id(), new MailProtocolPlugin(
                annotation.name(), annotation.description(), annotation.id(), annotation.protocolName(), instance
        ));
    }
}
