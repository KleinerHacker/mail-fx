package org.pcsoft.tools.mail_fx.plugin.mail_protocol.core;

import org.pcsoft.tools.mail_fx.plugin.common.Plugin;
import org.pcsoft.tools.mail_fx.plugin.mail_protocol.api.MailProtocol;

import java.util.Objects;

/**
 * Created by Christoph on 29.10.2014.
 */
public final class MailProtocolPlugin implements Plugin<MailProtocol> {
    private final String name, description;
    private final String id;
    private final String protocolName;
    private final MailProtocol instance;

    MailProtocolPlugin(String name, String description, String id, String protocolName, MailProtocol instance) {
        this.name = name;
        this.description = description;
        this.id = id;
        this.protocolName = protocolName;
        this.instance = instance;
    }

    @Override
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String getId() {
        return id;
    }

    public String getProtocolName() {
        return protocolName;
    }

    @Override
    public MailProtocol getInstance() {
        return instance;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final MailProtocolPlugin other = (MailProtocolPlugin) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "MailProtocolPlugin{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", id='" + id + '\'' +
                ", protocolName='" + protocolName + '\'' +
                '}';
    }
}
