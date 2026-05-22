package com.miempresa.extension.stringutils.internal;

import org.mule.runtime.extension.api.annotation.Extension;
import org.mule.runtime.extension.api.annotation.Operations;
import org.mule.runtime.extension.api.annotation.Configurations; // 🛠️ Nueva importación
import org.mule.runtime.extension.api.annotation.dsl.xml.Xml;
import org.mule.sdk.api.annotation.JavaVersionSupport;
import org.mule.sdk.api.meta.JavaVersion;

@Xml(prefix = "string-utils")
@Extension(name = "String Utils")
@Operations(BasicOperations.class) // Asegúrate de que apunte a tu clase de operaciones (BasicOperations o StringUtilsOperations según la renombraras)
// 🛠️ Le indicamos a Mule que use nuestro Connection Provider para generar la Configuración Global
@Configurations(BasicConfiguration.class) 
@JavaVersionSupport(JavaVersion.JAVA_17)
public class BasicExtension {
	//Comentario
}