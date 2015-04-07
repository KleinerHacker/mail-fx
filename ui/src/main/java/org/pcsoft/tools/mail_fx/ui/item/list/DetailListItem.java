package org.pcsoft.tools.mail_fx.ui.item.list;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Christoph on 10.11.2014.
 */
public class DetailListItem extends BorderPane implements Initializable {

    @FXML
    private ImageView imgImage;
    @FXML
    private Label lblTitle;
    @FXML
    private Label lblDescription;

    private final String name;
    private final String description;
    private final Image image;

    public DetailListItem(String name, String description) {
        this(name, description, null);
    }

    public DetailListItem(String name, String description, Image image) {
        this.name = name;
        this.description = description;
        this.image = image;

        try {
            final FXMLLoader loader = new FXMLLoader();
            loader.setControllerFactory(cl -> this);
            loader.setLocation(Thread.currentThread().getContextClassLoader().getResource("fxml/item.list.detail.fxml"));
            final Pane pane = loader.load();

            setCenter(pane);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lblTitle.setText(name);
        lblDescription.setText(description);
        imgImage.setImage(image);
    }
}
