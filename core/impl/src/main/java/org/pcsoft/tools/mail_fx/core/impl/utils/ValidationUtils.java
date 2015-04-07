package org.pcsoft.tools.mail_fx.core.impl.utils;

import java.util.regex.Pattern;

/**
 * Validation Utils
 */
public final class ValidationUtils {

    private static final Pattern PATTERN_VAL_MAIL = Pattern.compile("^[a-zA-Z0-9\\.\\-_]+@[a-zA-Z0-9\\-_]+\\.[a-zA-Z0-9\\.\\-_]+$");

    /**
     * Validate a mail address
     * @param mailAddress Mail Address to validate
     * @return <code>true</code> if validation was successfully, otherwise <code>false</code>
     */
    public static boolean validateMailAddress(String mailAddress) {
        return PATTERN_VAL_MAIL.matcher(mailAddress).find();
    }

    private ValidationUtils() {
    }
}
