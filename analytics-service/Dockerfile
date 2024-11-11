# Используем официальный образ OpenJDK 17 на основе slim-версии
FROM openjdk:17-jdk-slim

# Устанавливаем рабочую директорию внутри контейнера
WORKDIR /app

# Копируем JAR файл в контейнер
COPY target/analytics-service-1.0-SNAPSHOT.jar analytics-service.jar

# Указываем переменную окружения для имени сервиса
ENV SERVICE_NAME=analytics-service

# Открываем порт, на котором будет работать приложение
EXPOSE 8081

# Запускаем приложение
ENTRYPOINT ["java", "-jar", "analytics-service.jar"]