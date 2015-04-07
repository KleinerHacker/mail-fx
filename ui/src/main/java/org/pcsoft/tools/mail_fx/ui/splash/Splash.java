package org.pcsoft.tools.mail_fx.ui.splash;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

/**
 * Created by Christoph on 19.10.2014.
 */
public final class Splash {

    public static Stage show(final boolean standalone) {
        final Stage stage = new Stage(StageStyle.UNDECORATED);
        stage.setResizable(false);
        stage.setTitle("Mail FX - Splash");
        stage.setAlwaysOnTop(true);

        try {
            final FXMLLoader loader = new FXMLLoader();
            loader.setControllerFactory(aClass -> new SplashController(standalone, stage));
            loader.setLocation(Thread.currentThread().getContextClassLoader().getResource("fxml/splash.fxml"));
            final Pane pane = loader.load();

            stage.setScene(new Scene(pane));
            if (standalone) {
                stage.showAndWait();
            } else {
                stage.show();
            }

            return stage;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Splash() {
    }
}
