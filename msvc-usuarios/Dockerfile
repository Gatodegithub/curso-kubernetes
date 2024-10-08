ARG MSVC_NAME=msvc-usuarios

FROM openjdk:17-alpine AS builder

ARG MSVC_NAME

WORKDIR /app/$MSVC_NAME
# Posicionado desde curso-kubernetes copio el pom.xml a /app
COPY ./pom.xml /app
COPY ./$MSVC_NAME/.mvn ./.mvn
COPY ./$MSVC_NAME/mvnw .
COPY ./$MSVC_NAME/pom.xml .

RUN ./mvnw dependency:resolve

COPY ./$MSVC_NAME/src ./src

# Posicionado en /app/msvc-usuarios
RUN ./mvnw clean package -DskipTests

FROM openjdk:17-alpine

ARG MSVC_NAME

WORKDIR /app

RUN mkdir ./logs

ARG TARGET_FOLDER=/app/$MSVC_NAME/target

COPY --from=builder $TARGET_FOLDER/msvc-usuarios-0.0.1-SNAPSHOT.jar .
ARG PORT_APP=8001
ENV PORT $PORT_APP
EXPOSE $PORT

#ENTRYPOINT ["java", "-jar", "msvc-usuarios-0.0.1-SNAPSHOT.jar"]
## Esto se ejecuta en el docker run, no al crear la imagen
CMD ["java", "-jar", "msvc-usuarios-0.0.1-SNAPSHOT.jar"]
