FROM openjdk:17-jdk-slim
WORKDIR '/app'
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8080
COPY . .

CMD ["java", "-jar", "/app.jar"]