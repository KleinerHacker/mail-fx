package org.pcsoft.tools.mail_fx.plugin.mail_file.api;

import org.pcsoft.tools.mail_fx.plugin.mail_file.common.exceptions.MailFilePluginIOException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Christoph on 09.11.2014.
 */
public abstract class AbstractMailFileIOService implements MailFileIOService {

    @Override
    public final MailFileReader createMailFileReader(File file) {
        try (final FileInputStream inputStream = new FileInputStream(file)) {
            return createMailFileReader(inputStream);
        } catch (IOException e) {
            throw new MailFilePluginIOException("Cannot read file: " + file.getAbsolutePath(), e);
        }
    }

    @Override
    public final MailFileWriter createMailFileWriter(File file) {
        try (final FileOutputStream outputStream = new FileOutputStream(file)) {
            return createMailFileWriter(outputStream);
        } catch (IOException e) {
            throw new MailFilePluginIOException("Cannot write file: " + file.getAbsolutePath(), e);
        }
    }
}
