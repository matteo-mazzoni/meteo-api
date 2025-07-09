# Usa un'immagine Java con JDK
FROM eclipse-temurin:17-jdk-alpine

# Cartella di lavoro dentro il container
WORKDIR /app

# Copia il jar già compilato (vedi più avanti il build)
COPY target/meteoapi-0.0.1-SNAPSHOT.jar app.jar

# Espone la porta dell'app
EXPOSE 8080

# Comando per avviare Spring Boot
ENTRYPOINT ["java", "-jar", "app.jar"]