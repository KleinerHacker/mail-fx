package org.pcsoft.tools.mail_fx.plugin.mail_file.impl.mail_fx;

import org.pcsoft.tools.mail_fx.plugin.mail_file.api.AbstractMailFileIOService;
import org.pcsoft.tools.mail_fx.plugin.mail_file.api.MailFileReader;
import org.pcsoft.tools.mail_fx.plugin.mail_file.api.MailFileWriter;
import org.pcsoft.tools.mail_fx.plugin.mail_file.api.annotations.MailFileDescriptor;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by Christoph on 09.11.2014.
 */
@MailFileDescriptor(id = "mail-fx", name = "Mail-FX File", description = "Proprietary file system for Mail-FX", fileExtension = "mfx")
public final class MailFxFileIOService extends AbstractMailFileIOService {

    @Override
    public void createMailFile(File file) {

    }

    @Override
    public void deleteMailFile(File file) {

    }

    @Override
    public MailFileReader createMailFileReader(InputStream inputStream) {
        return new MailFxFileReader(inputStream);
    }

    @Override
    public MailFileWriter createMailFileWriter(OutputStream outputStream) {
        return new MailFxFileWriter(outputStream);
    }
}
