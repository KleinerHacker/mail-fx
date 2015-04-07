package org.pcsoft.tools.mail_fx.plugin.mail_file.api;

import org.pcsoft.tools.mail_fx.plugin.mail_file.api.types.MailFolder;
import org.pcsoft.tools.mail_fx.plugin.mail_file.common.exceptions.MailFilePluginIOException;

import java.io.Closeable;

/**
 * Created by Christoph on 09.11.2014.
 */
public interface MailFileWriter extends Closeable {

    /**
     * Write the given mail folder
     *
     * @param mailFolder
     */
    void writeMailFolder(MailFolder mailFolder) throws MailFilePluginIOException;

}
