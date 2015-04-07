package org.pcsoft.tools.mail_fx.plugin.mail_file.api.types;

import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.scene.image.Image;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Christoph on 09.11.2014.
 */
public final class RootMailFolder extends MailFolder {

    public static List<RootMailFolder> createDefaultRootMailFolderList() {
        return Arrays.asList(
                new RootMailFolder("Incomming", new Image(Thread.currentThread().getContextClassLoader().getResourceAsStream("icons/ic_folder_in16.png"))),
                new RootMailFolder("Outgoing", new Image(Thread.currentThread().getContextClassLoader().getResourceAsStream("icons/ic_folder_out16.png"))),
                new RootMailFolder("Templates", new Image(Thread.currentThread().getContextClassLoader().getResourceAsStream("icons/ic_folder_template16.png"))),
                new RootMailFolder("Trash", new Image(Thread.currentThread().getContextClassLoader().getResourceAsStream("icons/ic_folder_trash16.png")))
        );
    }

    private final ReadOnlyObjectWrapper<Image> image = new ReadOnlyObjectWrapper<>();

    private RootMailFolder(String name, Image image) {
        super(name);
        this.image.set(image);
    }

    public Image getImage() {
        return image.get();
    }

    public ReadOnlyObjectProperty<Image> imageProperty() {
        return image.getReadOnlyProperty();
    }
}
