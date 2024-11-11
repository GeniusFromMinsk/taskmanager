# Используем официальный образ OpenJDK 17 на основе slim-версии
FROM openjdk:17-jdk-slim

# Устанавливаем рабочую директорию внутри контейнера
WORKDIR /app

# Копируем JAR файл в контейнер
COPY target/notification-1.0-SNAPSHOT.jar notification.jar

# Указываем переменную окружения для имени сервиса
ENV SERVICE_NAME=notification

# Открываем порт, на котором будет работать приложение
EXPOSE 8080

# Запускаем приложение
ENTRYPOINT ["java", "-jar", "notification.jar"]