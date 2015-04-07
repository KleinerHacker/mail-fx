package org.pcsoft.tools.mail_fx.plugin.mail_file.core;

import org.pcsoft.tools.mail_fx.plugin.common.Plugin;
import org.pcsoft.tools.mail_fx.plugin.mail_file.api.MailFileIOService;

import java.util.Objects;

/**
 * Created by Christoph on 09.11.2014.
 */
public final class MailFilePlugin implements Plugin<MailFileIOService> {
    private final String id;
    private final String name, description;
    private final String fileExtension;
    private final MailFileIOService ioService;

    MailFilePlugin(String id, String name, String description, String fileExtension, MailFileIOService ioService) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.fileExtension = fileExtension;
        this.ioService = ioService;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getFileExtension() {
        return fileExtension;
    }

    @Override
    public MailFileIOService getInstance() {
        return ioService;
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
        final MailFilePlugin other = (MailFilePlugin) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "MailFilePlugin{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", fileExtension='" + fileExtension + '\'' +
                '}';
    }
}
