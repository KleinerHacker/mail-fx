package org.pcsoft.tools.mail_fx.plugin.common;

/**
 * Created by Christoph on 29.10.2014.
 */
public interface Plugin<I> {
    String getId();
    String getName();
    String getDescription();

    I getInstance();
}
