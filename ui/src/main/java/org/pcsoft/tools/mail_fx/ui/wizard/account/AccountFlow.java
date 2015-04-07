package org.pcsoft.tools.mail_fx.ui.wizard.account;

import org.controlsfx.dialog.Wizard;

import java.util.Optional;

/**
 * Created by Christoph on 08.11.2014.
 */
final class AccountFlow implements Wizard.Flow {

    private final AccountWizard.Result result;

    public AccountFlow(AccountWizard.Result result) {
        this.result = result;
    }

    @Override
    public Optional<Wizard.WizardPane> advance(Wizard.WizardPane wizardPane) {
        if (wizardPane == null)
            return Optional.of(new WelcomePage(result));
        else if (wizardPane instanceof AbstractWizardPage)
            return ((AbstractWizardPage) wizardPane).advance(wizardPane);

        throw new IllegalStateException("No handling implemented: " + wizardPane.getClass().getName());
    }

    @Override
    public boolean canAdvance(Wizard.WizardPane wizardPane) {
        if (wizardPane == null)
            return true;
        else if (wizardPane instanceof AbstractWizardPage)
            return ((AbstractWizardPage) wizardPane).canAdvance(wizardPane);

        throw new IllegalStateException("No handling implemented: " + wizardPane.getClass().getName());
    }

}
