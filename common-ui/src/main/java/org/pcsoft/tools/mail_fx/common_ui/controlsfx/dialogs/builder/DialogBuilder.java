package org.pcsoft.tools.mail_fx.common_ui.controlsfx.dialogs.builder;

import javafx.scene.Node;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.stage.Window;

import java.util.Optional;

/**
 * Created by Christoph on 13.11.2014.
 */
interface DialogBuilder<T extends DialogBuilder<T>> {

    T title(String title);
    T headerText(String headerText);
    T graphic(Node graphic);
    T graphic(Image image);
    T owner(Window window);

    Optional<ButtonType> show();

}
