package org.pcsoft.tools.mail_fx.plugin.mail_file.api.types;

import com.sun.javafx.collections.ObservableListWrapper;
import javafx.beans.Observable;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by Christoph on 09.11.2014.
 */
public abstract class MailFolder {

    private final StringProperty name = new SimpleStringProperty();
    private final ObservableList<ReadOnlyObjectProperty<CustomMailFolder>> mailFolderList =
            new ObservableListWrapper<>(new ArrayList<>(), o -> new Observable[] {o});

    protected MailFolder(String name) {
        this.name.set(name);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public ObservableList<ReadOnlyObjectProperty<CustomMailFolder>> getMailFolderList() {
        return mailFolderList;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name.get());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final MailFolder other = (MailFolder) obj;
        return Objects.equals(this.name.get(), other.name.get());
    }

    @Override
    public String toString() {
        return "MailFolder{" +
                "name=" + name.get() +
                '}';
    }
}
