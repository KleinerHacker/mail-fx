package org.pcsoft.tools.mail_fx.plugin.mail_protocol.api;

import javafx.scene.Node;
import org.pcsoft.tools.mail_fx.plugin.mail_protocol.api.types.MailProtocolData;

/**
 * Created by Christoph on 08.11.2014.
 */
public interface MailProtocolSettings<D extends MailProtocolData> {

    Node buildSettingsPage(D mailProtocolData);

}
