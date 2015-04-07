package org.pcsoft.tools.mail_fx.types.props;

import javafx.beans.InvalidationListener;
import javafx.beans.binding.ObjectExpression;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;

/**
 * Created by Christoph on 29.10.2014.
 */
public abstract class AbstractExpression<T> extends ObjectExpression<T> {

    protected final class WrapperProperty extends SimpleObjectProperty<T> {
        public WrapperProperty() {
        }

        public final void fireChangeEvent() {
            super.fireValueChangedEvent();
        }
    }

    protected final WrapperProperty value = new WrapperProperty();

    protected AbstractExpression(T obj) {
        value.set(obj);
        init();
    }

    protected AbstractExpression() {
    }

    @Override
    public T get() {
        return value.get();
    }

    @Override
    public void addListener(ChangeListener<? super T> listener) {
        value.addListener(listener);
    }

    @Override
    public void removeListener(ChangeListener<? super T> listener) {
        value.removeListener(listener);
    }

    @Override
    public void addListener(InvalidationListener listener) {
        value.addListener(listener);
    }

    @Override
    public void removeListener(InvalidationListener listener) {
        value.removeListener(listener);
    }

    protected abstract void init();
}
