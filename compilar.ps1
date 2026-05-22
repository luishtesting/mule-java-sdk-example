$ErrorActionPreference = "Stop"
Clear-Host

Write-Host "=========================================================" -ForegroundColor Cyan
Write-Host "  Compilando Conector Mule Java SDK (Java 17)            " -ForegroundColor Cyan
Write-Host "=========================================================" -ForegroundColor Cyan

# 🛠️ PASO MAESTRO: Abrimos los módulos de Java para que el plugin de Mule pueda trabajar
$env:MAVEN_OPTS="--add-opens=java.base/java.lang=ALL-UNNAMED --add-opens=java.xml/javax.xml.namespace=ALL-UNNAMED --add-opens=java.base/java.util=ALL-UNNAMED --add-opens=java.base/java.util.concurrent=ALL-UNNAMED"

# Ejecutamos Maven
mvn clean install "-DskipTests" "-DskipMunitTests"

Write-Host " "
Write-Host "SUCCESS: Proceso terminado." -ForegroundColor Green

Pause