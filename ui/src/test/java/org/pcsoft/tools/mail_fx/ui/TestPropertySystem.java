package org.pcsoft.tools.mail_fx.ui;

import com.sun.javafx.collections.ObservableListWrapper;
import javafx.beans.Observable;
import javafx.beans.binding.ObjectExpression;
import javafx.beans.binding.StringExpression;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by Christoph on 03.11.2014.
 */
public class TestPropertySystem {

    public static final class TestObject {
        private final String title;
        private boolean selected = false;

        public TestObject(String title) {
            this.title = title;
        }

        public String getTitle() {
            return title;
        }

        public boolean isSelected() {
            return selected;
        }

        public void setSelected(boolean selected) {
            this.selected = selected;
        }

        @Override
        public int hashCode() {
            return Objects.hash(title);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            final TestObject other = (TestObject) obj;
            return Objects.equals(this.title, other.title);
        }

        @Override
        public String toString() {
            return "TestObject{" +
                    "name='" + title + '\'' +
                    ", selected=" + selected +
                    '}';
        }
    }

    public static final class TestObjectWrapper {
        private final TestObject value;
        private final StringExpression title;
        private final BooleanProperty selected;

        public TestObjectWrapper(TestObject value) {
            this.value = value;
            this.title = new SimpleStringProperty(this.value, "title");
            this.selected = new SimpleBooleanProperty(this.value, "selected");
        }

        public TestObjectWrapper(String name) {
            this(new TestObject(name));
        }

        public String getTitle() {
            return title.get();
        }

        public StringExpression titleProperty() {
            return title;
        }

        public boolean getSelected() {
            return selected.get();
        }

        public BooleanProperty selectedProperty() {
            return selected;
        }

        public void setSelected(boolean selected) {
            this.selected.set(selected);
        }

        @Override
        public int hashCode() {
            return Objects.hash(title.get());
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            final TestObjectWrapper other = (TestObjectWrapper) obj;
            return Objects.equals(this.title.get(), other.title.get());
        }

        @Override
        public String toString() {
            return "TestObjectWrapper{" +
                    " title=" + title.get() +
                    ", selected=" + selected.get() +
                    '}';
        }
    }

    public static final class TestProperty extends ReadOnlyObjectWrapper<TestObjectWrapper> {
        public TestProperty(String name) {
            super(new TestObjectWrapper(name));
            init();
        }

        public TestProperty(TestObject initialValue) {
            super(new TestObjectWrapper(initialValue));
            init();
        }

        @Override
        public void set(TestObjectWrapper newValue) {
            super.set(newValue);
            init();
        }

        @Override
        public void setValue(TestObjectWrapper v) {
            super.setValue(v);
            init();
        }

        private void init() {
            if (get() == null)
                return;

            get().titleProperty().addListener((v, o, n) -> fireValueChangedEvent());
            get().selectedProperty().addListener((v, o, n) -> fireValueChangedEvent());
        }
    }

    @Test
    public void testSimple() throws NoSuchMethodException {
        final ObjectExpression<TestObjectWrapper> testProperty = new TestProperty("Hello");
        testProperty.addListener(observable -> System.out.println("New state: " + observable));

        testProperty.get().setSelected(true);
        testProperty.get().setSelected(false);
    }

    @Test
    public void testList() throws NoSuchMethodException {
        final ObservableList<ObjectExpression<TestObjectWrapper>> list = new ObservableListWrapper<>(new ArrayList<>());
        list.addAll(new TestProperty("Hello"), new TestProperty("World"));
        list.addListener((Observable observable) -> System.out.println("New state: " + observable));

        list.get(0).get().setSelected(true);
    }

}
