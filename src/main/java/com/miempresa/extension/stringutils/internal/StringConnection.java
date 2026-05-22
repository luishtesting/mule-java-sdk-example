package com.miempresa.extension.stringutils.internal;

import org.mule.runtime.extension.api.annotation.param.display.DisplayName;
import java.util.UUID;

public class StringConnection {

    private final String id;
    private final String apiKey;

    public StringConnection(String apiKey) {
        this.id = UUID.randomUUID().toString();
        this.apiKey = apiKey;
    }

    public String getId() {
        return id;
    }

    public String getApiKey() {
        return apiKey;
    }

    // Método que Mule llamará por detrás para verificar si la conexión sigue siendo válida
    public boolean isValid() {
        return this.apiKey != null && !this.apiKey.trim().isEmpty();
    }

    // Método para liberar recursos cuando Mule cierre la conexión
    public void invalidate() {
        // Aquí se cerraría un cliente HTTP o una sesión de Base de Datos
        System.out.println("Conexión " + id + " destruida limpiamente.");
    }
}