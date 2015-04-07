package org.pcsoft.tools.mail_fx.plugin.mail_protocol.api.annotations;

import java.lang.annotation.*;

/**
 * Annotation for {@link org.pcsoft.tools.mail_fx.plugin.mail_protocol.api.MailProtocol}
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface MailProtocolDescription {
    /**
     * Name (for UI) for the mail protocol
     *
     * @return
     */
    String name();

    /**
     * Unique id for the mail protocol
     *
     * @return
     */
    String id();

    /**
     * Name of protocol to use in code as e. g. store type
     *
     * @return
     */
    String protocolName();

    /**
     * Description to show in wizard or other pages
     * @return
     */
    String description();
}
