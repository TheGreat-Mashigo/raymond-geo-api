### STAGE 1: Build ###

FROM maven:3-openjdk-11 AS MAVEN_BUILD

MAINTAINER Raymond Mashigo

RUN mkdir /build
COPY pom.xml /build/
COPY src /build/src/
WORKDIR /build/
RUN mvn package

### STAGE 2: Run ###

FROM openjdk:11
WORKDIR /app
COPY --from=MAVEN_BUILD /build/target/raymond-shape-api.jar raymond-shape-api.jar
ENV JAVA_OPTS=""
EXPOSE 8080
#ENTRYPOINT exec java $JAVA_OPTS -jar /raymond-shape-api.jar
ENTRYPOINT ["java","-jar","raymond-shape-api.jar"]
