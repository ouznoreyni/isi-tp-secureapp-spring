# Guide simplifié pour Spring Boot avec MySQL (sans Tomcat externe)

## Environnement
- JDK 17
- Maven
- MySQL

## Configuration

1. Assurez-vous que MySQL est installé et en cours d'exécution.

2. Créez la base de données :
   ```sql
   CREATE DATABASE secureapp;
   ```

3. Configurez `application.properties`  , Compiler et exécuter le project:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/secureapp
   spring.datasource.username=votre_utilisateur
   spring.datasource.password=votre_mot_de_passe
   spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
   spring.jpa.hibernate.ddl-auto=update
   server.port=8080
   ```


## Dépendances principales
- spring-boot-starter-web
- spring-boot-starter-data-jpa
- mysql-connector-j
- springdoc-openapi-starter-webmvc-ui (pour Swagger)
