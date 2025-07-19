# Используем официальный образ Java 21
FROM eclipse-temurin:21-jdk

# Устанавливаем рабочую директорию
WORKDIR /app

# Копируем скомпилированный jar-файл
COPY target/AeroSign-1.0-SNAPSHOT.jar app.jar

# Открываем порт, на котором работает Spring Boot
EXPOSE 8080

# Запускаем приложение
ENTRYPOINT ["java", "-jar", "app.jar"]