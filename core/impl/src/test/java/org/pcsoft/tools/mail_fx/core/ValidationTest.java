package org.pcsoft.tools.mail_fx.core;

import org.junit.Assert;
import org.junit.Test;
import org.pcsoft.tools.mail_fx.core.impl.utils.ValidationUtils;

/**
 * Created by Christoph on 08.11.2014.
 */
public class ValidationTest {

    @Test
    public void testMailAddressValidation() {
        Assert.assertTrue(ValidationUtils.validateMailAddress("a@a.a"));
        Assert.assertTrue(ValidationUtils.validateMailAddress("a.a@a.a"));
        Assert.assertTrue(ValidationUtils.validateMailAddress("abc_123-XYZ@abc_123-XYZ.uk.com"));
        Assert.assertFalse(ValidationUtils.validateMailAddress("abü@r.e"));
        Assert.assertFalse(ValidationUtils.validateMailAddress("a.a@a"));
        Assert.assertFalse(ValidationUtils.validateMailAddress("a@a.ü"));
    }

}
