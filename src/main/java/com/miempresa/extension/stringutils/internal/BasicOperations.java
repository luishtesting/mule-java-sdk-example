package com.miempresa.extension.stringutils.internal;

import org.mule.runtime.extension.api.annotation.param.MediaType;
import org.mule.runtime.extension.api.annotation.param.Optional;
import org.mule.runtime.extension.api.annotation.param.display.DisplayName;
import org.mule.runtime.extension.api.annotation.param.display.Summary;
import org.mule.runtime.extension.api.annotation.param.display.Placement;
import org.mule.runtime.extension.api.annotation.param.display.Password;
import org.mule.runtime.extension.api.annotation.error.Throws; // 🛠️ Nueva importación
import org.mule.runtime.extension.api.exception.ModuleException; // 🛠️ Nueva importación
import org.mule.runtime.extension.api.annotation.param.Connection; // 🛠️ Nueva Importación

public class BasicOperations {

    @MediaType(value = MediaType.ANY, strict = false)
    @DisplayName("Reverse String")
    @Throws(StringUtilsErrorProvider.class)
    public String reverseString(
            
            // 🛠️ MULE INYECTA ESTO AUTOMÁTICAMENTE DESDE EL POOL GLOBAL
            @Connection StringConnection conexion, 
            
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
        
        if (texto == null || texto.trim().isEmpty()) {
            throw new ModuleException(StringUtilsError.TEXT_EMPTY, new IllegalArgumentException("Texto vacío."));
        }

        // 🛠️ Usamos datos de la conexión activa dentro de nuestra lógica de negocio
        System.out.println("Operación ejecutada bajo la Conexión ID: " + conexion.getId());

        String resultado = new StringBuilder(texto).reverse().toString();

        if (toUpperCase) {
            resultado = resultado.toUpperCase();
        }

        // Simulamos que añadimos la API Key de la conexión como parte del rastro
        if (claveSecreta != null && !claveSecreta.trim().isEmpty()) {
            resultado = "[" + claveSecreta + "] " + resultado;
        }

        return resultado;
    }
}