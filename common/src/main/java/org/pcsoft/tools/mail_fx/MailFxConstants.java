package org.pcsoft.tools.mail_fx;

import org.apache.commons.lang.SystemUtils;

import java.io.File;

/**
 * Created by Christoph on 31.10.2014.
 */
public final class MailFxConstants {

    public static final File CONFIGURATION_PATH;

    static {
        CONFIGURATION_PATH = new File(SystemUtils.USER_HOME, ".mail-fx");
        if (!CONFIGURATION_PATH.exists()) {
            CONFIGURATION_PATH.mkdirs();
        }
    }

    private MailFxConstants() {
    }
}
