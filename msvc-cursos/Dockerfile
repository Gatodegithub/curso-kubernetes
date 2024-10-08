FROM openjdk:17-alpine AS builder

WORKDIR /app/msvc-cursos
# Posicionado desde curso-kubernetes copio el pom.xml a /app
COPY ./pom.xml /app
COPY ./msvc-cursos/.mvn ./.mvn
COPY ./msvc-cursos/mvnw .
COPY ./msvc-cursos/pom.xml .

RUN ./mvnw dependency:resolve

COPY ./msvc-cursos/src ./src

# Posicionado en /app/msvc-cursos
RUN ./mvnw clean package -DskipTests

FROM openjdk:17-alpine

WORKDIR /app

RUN mkdir ./logs

COPY --from=builder /app/msvc-cursos/target/msvc-cursos-0.0.1-SNAPSHOT.jar .

EXPOSE 8002

#ENTRYPOINT ["java", "-jar", "msvc-cursos-0.0.1-SNAPSHOT.jar"]
CMD ["java", "-jar", "msvc-cursos-0.0.1-SNAPSHOT.jar"]
