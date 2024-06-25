FROM maven:3.9.7-amazoncorretto-21-debian-bookworm AS builder

WORKDIR /usr/src/gateway
COPY pom.xml .
RUN mvn -B dependency:go-offline

COPY . .
RUN mvn package -DskipTests

# app
FROM amazoncorretto:21.0.3

WORKDIR /app
COPY --from=builder /usr/src/gateway/target/gateway-0.0.1.jar .

EXPOSE 8000
ENTRYPOINT ["java", "-jar", "/app/gateway-0.0.1.jar"]