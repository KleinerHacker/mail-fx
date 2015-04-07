package org.pcsoft.tools.mail_fx.plugin.mail_file.impl.mail_fx;

import org.pcsoft.tools.mail_fx.plugin.mail_file.api.MailFileReader;
import org.pcsoft.tools.mail_fx.plugin.mail_file.api.types.MailFolder;
import org.pcsoft.tools.mail_fx.plugin.mail_file.common.exceptions.MailFilePluginIOException;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Christoph on 09.11.2014.
 */
public final class MailFxFileReader implements MailFileReader {

    private final InputStream inputStream;

    public MailFxFileReader(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    @Override
    public MailFolder readMailFolder() throws MailFilePluginIOException {
        return null;
    }

    @Override
    public void close() throws IOException {
        inputStream.close();
    }
}
