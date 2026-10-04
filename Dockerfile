# Stage 1: Build the app securely inside a container (Alpine is fine for compiling)
FROM maven:3.9.6-eclipse-temurin-17-alpine AS builder
WORKDIR /build
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Minimal runtime image (Switching to full Ubuntu-based JRE for Spring AI native compatibility)
FROM eclipse-temurin:17-jre-jammy
WORKDIR /app
COPY --from=builder /build/target/mcp-site-management-server-0.0.1-SNAPSHOT.jar mcp-site-management-server.jar
ENTRYPOINT ["java", "-jar", "mcp-site-management-server.jar"]
