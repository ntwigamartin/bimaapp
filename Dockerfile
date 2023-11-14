FROM maven:3.8.4-openjdk-11 AS build

WORKDIR /app

COPY pom.xml .

RUN mvn dependency:go-offline

COPY src ./src

RUN mvn clean && mvn compile && mvn package -DskipTests

FROM jboss/wildfly:latest

USER jboss

ENV WILDFLY_USER=admin \
    WILDFLY_PASSWORD=admin

COPY --from=build /app/target/bimaapp.war /opt/jboss/wildfly/standalone/deployments/

EXPOSE 8080 9990

VOLUME /opt/jboss/wildfly/standalone/configuration

HEALTHCHECK --interval=1m --timeout=10s \
    CMD curl -f http://localhost:8080/bimaapp/ || exit 1

ENTRYPOINT ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]
