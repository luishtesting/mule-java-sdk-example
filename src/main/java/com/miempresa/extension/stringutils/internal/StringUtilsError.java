package com.miempresa.extension.stringutils.internal;

import org.mule.runtime.extension.api.error.ErrorTypeDefinition;
import java.util.Optional;

public enum StringUtilsError implements ErrorTypeDefinition<StringUtilsError> {

    // Nuestro error personalizado para textos vacíos o nulos
    TEXT_EMPTY;

    @Override
    public Optional<ErrorTypeDefinition<? extends Enum<?>>> getParent() {
        // 🛠️ Corrección: Quitamos el <?> para cumplir estrictamente con la firma del SDK 1.7.0
        return Optional.empty();
    }
}