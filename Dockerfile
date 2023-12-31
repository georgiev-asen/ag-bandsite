# Build stage

FROM eclipse-temurin:17-jdk-jammy AS build
ENV HOME=/usr/app

ARG pg_port=5432
ENV PG_PORT=$pg_port

ARG pg_host=localhost
ENV PG_HOST=$pg_host

RUN mkdir -p $HOME
WORKDIR $HOME
ADD . $HOME
RUN chmod -R 777 ./mvnw
RUN --mount=type=cache,target=/root/.m2 ./mvnw -f $HOME/pom.xml clean package -DskipTests

# Package stage

FROM eclipse-temurin:17-jre-jammy
ARG JAR_FILE=/usr/app/target/*.jar

COPY --from=build $JAR_FILE /app/bandsite.jar
EXPOSE 8080
ENTRYPOINT java -jar /app/bandsite.jar
