package org.pcsoft.tools.mail_fx.plugin.mail_file.api.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Christoph on 09.11.2014.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface MailFileDescriptor {

    /**
     * Unique identifier
     *
     * @return
     */
    String id();

    /**
     * Name of mail file system
     *
     * @return
     */
    String name();

    /**
     * Description of mail file system
     *
     * @return
     */
    String description();

    /**
     * Extension of mail file
     *
     * @return
     */
    String fileExtension();

}
