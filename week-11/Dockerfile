#FROM eclipse-temurin:25-jre
#WORKDIR /app
#COPY target/*.jar /app.jar
#EXPOSE 8080
#ENTRYPOINT ["java", "-jar", "/app.jar"]



# =========================
# Stage 1: Build
# =========================
FROM maven:3.9-eclipse-temurin-25 AS build

WORKDIR /app

# 1. Copy pom.xml only
COPY pom.xml .

# 2. Download dependencies
RUN mvn dependency:go-offline

# 3. Copy source code
COPY src ./src

# 4. Build JAR
RUN mvn clean package


# =========================
# Stage 2: Runtime
# =========================
FROM eclipse-temurin:25-jre

WORKDIR /app

# 5. Copy JAR from Build Stage
COPY --from=build /app/target/*.jar app.jar

# 6. Expose application port
EXPOSE 8080

# 7. Run Spring Boot
ENTRYPOINT ["java", "-jar", "app.jar"]