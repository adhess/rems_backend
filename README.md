# Real Estate Management System

This project was created to make the world a better place.

### Project setup:
To add secrets to intellij environment variables :

```
Edit configuration > environment variables and add:

spring.datasource.url: jdbc:postgresql://localhost:5432/postgres
spring.datasource.username: postgres
spring.datasource.password: postgres
spring.jpa.database: postgresql
spring.datasource.platform: postgres
spring.datasource.initialization-mode: always

spring.security.oauth2.client.registration.google.clientId: «clientId»
spring.security.oauth2.client.registration.google.clientSecret: «clientSecret»

spring.security.oauth2.client.registration.facebook.clientId: «clientId»
spring.security.oauth2.client.registration.facebook.clientSecret: «clientSecret»
```

