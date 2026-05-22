package com.miempresa.extension.stringutils.internal;

import org.mule.runtime.api.connection.ConnectionException;
import org.mule.runtime.api.connection.ConnectionProvider;
import org.mule.runtime.api.connection.ConnectionValidationResult;
import org.mule.runtime.extension.api.annotation.param.Parameter;
import org.mule.runtime.extension.api.annotation.param.display.DisplayName;
import org.mule.runtime.extension.api.annotation.param.display.Password;
import org.mule.runtime.extension.api.annotation.param.display.Summary;

public class StringConnectionProvider implements ConnectionProvider<StringConnection> {

    // 🛠️ Este parámetro aparecerá en la ventana flotante de Configuración Global en Studio
    @Parameter
    @Password
    @DisplayName("API Key de Conexión")
    @Summary("Clave de acceso global requerida para habilitar el uso de las operaciones.")
    private String apiKey;

    @Override
    public StringConnection connect() throws ConnectionException {
        // Simulamos una validación de credenciales
        if ("clave-invalida".equals(apiKey)) {
            throw new ConnectionException("Error de Autenticación: La API Key proporcionada es incorrecta.");
        }
        
        System.out.println("Nueva conexión creada con éxito usando la API Key.");
        return new StringConnection(apiKey);
    }

    @Override
    public void disconnect(StringConnection connection) {
        connection.invalidate();
    }

    @Override
    public ConnectionValidationResult validate(StringConnection connection) {
        return connection.isValid() 
                ? ConnectionValidationResult.success() 
                : ConnectionValidationResult.failure("La sesión ya no es válida", new Exception());
    }
}