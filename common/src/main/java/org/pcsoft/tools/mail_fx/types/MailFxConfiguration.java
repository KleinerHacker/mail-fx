package org.pcsoft.tools.mail_fx.types;

import org.ini4j.Profile;

/**
 * Created by Christoph on 29.10.2014.
 */
public interface MailFxConfiguration {

    void save(Profile.Section section);
    void load(Profile.Section section);

}
