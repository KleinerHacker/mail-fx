package org.pcsoft.tools.mail_fx.ui.window.main;

import javafx.fxml.Initializable;
import javafx.stage.Stage;

/**
 * Created by Christoph on 19.10.2014.
 */
abstract class AbstractMainWindowController implements Initializable {

    protected final Stage parent;

    protected AbstractMainWindowController(Stage parent) {
        this.parent = parent;
    }
}
