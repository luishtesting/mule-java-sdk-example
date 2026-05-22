package com.miempresa.extension.stringutils.internal;

import org.mule.runtime.extension.api.annotation.param.MediaType;
import org.mule.runtime.extension.api.annotation.param.Optional;
import org.mule.runtime.extension.api.annotation.param.display.DisplayName;
import org.mule.runtime.extension.api.annotation.param.display.Summary;
import org.mule.runtime.extension.api.annotation.param.display.Placement;
import org.mule.runtime.extension.api.annotation.param.display.Password;
import org.mule.runtime.extension.api.annotation.error.Throws; // 🛠️ Nueva importación
import org.mule.runtime.extension.api.exception.ModuleException; // 🛠️ Nueva importación

public class BasicOperations {

    @MediaType(value = MediaType.ANY, strict = false)
    @DisplayName("Reverse String")
    @Summary("Voltea una cadena de texto y opcionalmente la convierte a mayúsculas.")
    @Throws(StringUtilsErrorProvider.class) // 🛠️ Le avisamos a Mule qué catálogo de errores usamos
    public String reverseString(
            
            @DisplayName("Texto a Voltear")
            String texto,
            
            @Optional(defaultValue = "false")
            @DisplayName("Convertir a Mayúsculas")
            @Placement(tab = "Advanced")
            boolean toUpperCase,

            @Optional
            @Password
            @DisplayName("Clave Secreta de Prefijo")
            @Placement(tab = "Advanced")
            String claveSecreta
    ) {
        
        // 🛠️ VALIDACIÓN: Si el texto viene nulo o vacío, disparamos el error custom
        if (texto == null || texto.trim().isEmpty()) {
            throw new ModuleException(
                StringUtilsError.TEXT_EMPTY, 
                new IllegalArgumentException("El parámetro 'Texto a Voltear' no puede estar vacío.")
            );
        }

        String resultado = new StringBuilder(texto).reverse().toString();

        if (toUpperCase) {
            resultado = resultado.toUpperCase();
        }

        if (claveSecreta != null && !claveSecreta.trim().isEmpty()) {
            resultado = "[" + claveSecreta + "] " + resultado;
        }

        return resultado;
    }
}