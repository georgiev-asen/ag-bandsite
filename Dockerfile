# Build stage

FROM eclipse-temurin:17-jdk-jammy AS build
ENV HOME=/usr/app

ARG PG_PORT=2222
ENV ENV_PG_PORT=$PG_PORT

RUN mkdir -p $HOME
WORKDIR $HOME
ADD . $HOME
RUN chmod -R 777 ./mvnw
RUN --mount=type=cache,target=/root/.m2 ./mvnw -f $HOME/pom.xml clean package

# Package stage

FROM eclipse-temurin:17-jre-jammy
ARG JAR_FILE=/usr/app/target/*.jar

COPY --from=build $JAR_FILE /app/bandsite.jar
EXPOSE 8080
ENTRYPOINT java -jar /app/bandsite.jar
