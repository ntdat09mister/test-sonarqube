# ---------- Build stage ----------
FROM docker.io/maven:3.9.6-eclipse-temurin-17 AS builder

WORKDIR /app
COPY pom.xml .
COPY src ./src

# Build và đóng gói JAR (bỏ qua test để build nhanh)
RUN mvn clean package -DskipTests

# ---------- Run stage ----------
FROM docker.io/eclipse-temurin:17-jdk

WORKDIR /app

# Copy file JAR từ stage builder
COPY --from=builder /app/target/*.jar app.jar

# Mở cổng mặc định của Spring Boot
EXPOSE 8080

# Run app
ENTRYPOINT ["java", "-jar", "app.jar"]
