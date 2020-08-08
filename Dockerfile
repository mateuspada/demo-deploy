FROM adoptopenjdk/openjdk11-openj9:x86_64-alpine-jdk-11.0.5_10_openj9-0.17.0-slim AS base
ENV LANG C.UTF-8
WORKDIR /app

FROM adoptopenjdk/maven-openjdk11 AS build
WORKDIR /src
COPY ./ /src

RUN mvn -f /src/pom.xml clean install -U -DskipTests

RUN rm -f /src/target/*sources.jar
RUN cp -a /src/target/demo-deploy*.jar /app.jar

FROM base AS final
COPY --from=build /app.jar .
CMD java -jar /app/app.jar
