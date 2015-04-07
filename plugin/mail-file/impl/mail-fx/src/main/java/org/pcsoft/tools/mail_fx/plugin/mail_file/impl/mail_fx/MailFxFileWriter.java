package org.pcsoft.tools.mail_fx.plugin.mail_file.impl.mail_fx;

import org.pcsoft.tools.mail_fx.plugin.mail_file.api.MailFileWriter;
import org.pcsoft.tools.mail_fx.plugin.mail_file.api.types.MailFolder;
import org.pcsoft.tools.mail_fx.plugin.mail_file.common.exceptions.MailFilePluginIOException;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by Christoph on 09.11.2014.
 */
public final class MailFxFileWriter implements MailFileWriter {

    private final OutputStream outputStream;

    public MailFxFileWriter(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    @Override
    public void writeMailFolder(MailFolder mailFolder) throws MailFilePluginIOException {

    }

    @Override
    public void close() throws IOException {
        outputStream.close();
    }
}
