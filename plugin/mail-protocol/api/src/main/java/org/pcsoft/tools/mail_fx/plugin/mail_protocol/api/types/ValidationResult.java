package org.pcsoft.tools.mail_fx.plugin.mail_protocol.api.types;

import java.util.Objects;

/**
 * Created by Christoph on 12.11.2014.
 */
public final class ValidationResult {
    public static ValidationResult success() {
        return new ValidationResult(true, "");
    }

    public static ValidationResult failure(String message) {
        return new ValidationResult(false, message);
    }

    private final boolean success;
    private final String errorMessage;

    private ValidationResult(boolean success, String errorMessage) {
        this.success = success;
        this.errorMessage = errorMessage;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    @Override
    public int hashCode() {
        return Objects.hash(success, errorMessage);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final ValidationResult other = (ValidationResult) obj;
        return Objects.equals(this.success, other.success) && Objects.equals(this.errorMessage, other.errorMessage);
    }

    @Override
    public String toString() {
        return "ValidationResult{" +
                "success=" + success +
                ", errorMessage='" + errorMessage + '\'' +
                '}';
    }
}
