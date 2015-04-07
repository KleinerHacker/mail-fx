package org.pcsoft.tools.mail_fx.plugin.mail_file.api;

import org.pcsoft.tools.mail_fx.plugin.mail_file.common.exceptions.MailFilePluginIOException;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by Christoph on 09.11.2014.
 */
public interface MailFileIOService {

    void createMailFile(File file);

    void deleteMailFile(File file);

    MailFileReader createMailFileReader(InputStream inputStream) throws MailFilePluginIOException;

    MailFileReader createMailFileReader(File file) throws MailFilePluginIOException;

    MailFileWriter createMailFileWriter(OutputStream outputStream) throws MailFilePluginIOException;

    MailFileWriter createMailFileWriter(File file) throws MailFilePluginIOException;

}
