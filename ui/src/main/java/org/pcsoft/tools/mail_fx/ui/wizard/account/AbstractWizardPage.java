package org.pcsoft.tools.mail_fx.ui.wizard.account;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import org.controlsfx.dialog.Wizard;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;

/**
 * Created by Christoph on 08.11.2014.
 */
abstract class AbstractWizardPage extends Wizard.WizardPane implements Initializable, Wizard.Flow {

    private final URL fxmlUrl;
    protected final AccountWizard.Result result;

    protected AbstractWizardPage(String headerText, URL fxmlUrl, AccountWizard.Result result) {
        this.result = result;
        this.fxmlUrl = fxmlUrl;

        setGraphic(new ImageView(new Image(
                Thread.currentThread().getContextClassLoader().getResourceAsStream("icons/ic_account_add48.png")
        )));
        final Label label = new Label(headerText);
        label.setPadding(new Insets(15));
        label.setFont(Font.font(label.getFont().getFamily(), FontWeight.BOLD, 24));
        label.setBackground(new Background(new BackgroundFill(
                new LinearGradient(0, 0, 0, 1, true, CycleMethod.NO_CYCLE, new Stop(1, new Color(.97, .97, .97, 1)), new Stop(0, new Color(.9, .9, .9, 1))),
                null, null
        )));
        setHeader(label);
    }

    protected final void loadUI() {
        try {
            final FXMLLoader loader = new FXMLLoader();
            loader.setControllerFactory(cl -> this);
            loader.setLocation(fxmlUrl);
            final Pane pane = loader.load();

            setContent(pane);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public final Optional<Wizard.WizardPane> advance(Wizard.WizardPane wizardPane) {
        return Optional.ofNullable(nextPage());
    }

    @Override
    public final boolean canAdvance(Wizard.WizardPane wizardPane) {
        return hasNextPage();
    }

    protected abstract Wizard.WizardPane nextPage();

    protected boolean hasNextPage() {
        return true;
    }
}
