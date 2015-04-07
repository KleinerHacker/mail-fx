package org.pcsoft.tools.mail_fx.plugin.mail_file.api;

import org.pcsoft.tools.mail_fx.plugin.mail_file.api.types.MailFolder;
import org.pcsoft.tools.mail_fx.plugin.mail_file.common.exceptions.MailFilePluginIOException;

import java.io.Closeable;

/**
 * Created by Christoph on 09.11.2014.
 */
public interface MailFileReader extends Closeable {

    /**
     * Read the next mail folder.
     *
     * @return The read mail folder or <code>null</code> if no more mail folders are found
     */
    MailFolder readMailFolder() throws MailFilePluginIOException;

}
