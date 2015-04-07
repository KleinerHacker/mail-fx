package org.pcsoft.tools.mail_fx.ui.window.main;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by Christoph on 19.10.2014.
 */
public final class MainWindow {

    public static void show(Stage rootStage, Stage splashStage) {
        rootStage.setResizable(false);
        rootStage.setTitle("Mail FX");
        rootStage.getIcons().add(new Image(Thread.currentThread().getContextClassLoader().getResourceAsStream("icon.png")));

        try {
            final FXMLLoader loader = new FXMLLoader();
            loader.setControllerFactory(aClass -> {
                try {
                    return aClass.getConstructor(Stage.class).newInstance(rootStage);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });
            loader.setLocation(Thread.currentThread().getContextClassLoader().getResource("fxml/window.main.fxml"));
            final Pane pane = loader.load();

            rootStage.setScene(new Scene(pane));
            rootStage.show();

            splashStage.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private MainWindow() {
    }
}
