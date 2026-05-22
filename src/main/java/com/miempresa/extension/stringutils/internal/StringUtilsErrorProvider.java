package com.miempresa.extension.stringutils.internal;

import org.mule.runtime.extension.api.annotation.error.ErrorTypeProvider;
import org.mule.runtime.extension.api.error.ErrorTypeDefinition;
import java.util.HashSet;
import java.util.Set;

public class StringUtilsErrorProvider implements ErrorTypeProvider {

    @Override
    public Set<ErrorTypeDefinition> getErrorTypes() {
        Set<ErrorTypeDefinition> errors = new HashSet<>();
        // Registramos nuestro enum
        errors.add(StringUtilsError.TEXT_EMPTY);
        return errors;
    }
}