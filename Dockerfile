FROM maven:3.8.4-openjdk-11 AS build

WORKDIR /app

COPY pom.xml .

RUN mvn dependency:go-offline

COPY . .

RUN mvn clean && mvn compile && mvn package -DskipTests

FROM jboss/wildfly
# FROM jboss/wildfly:latest

USER jboss

ENV WILDFLY_USER=admin \
    WILDFLY_PASSWORD=admin

COPY --from=build /app/target/bimaapp.war /opt/jboss/wildfly/standalone/deployments/

# RUN rm -rf /opt/jboss/wildfly/modules/system/layers/base/com/mysql/

# RUN rm -f /opt/jboss/wildfly/standalone/configuration/standalone.xml

COPY --from=build /app/mysql/ /opt/jboss/wildfly/modules/system/layers/base/com/

# COPY --from=build /app/standalone.xml /opt/jboss/wildfly/standalone/configuration/

EXPOSE 8080 9990

# VOLUME /opt/jboss/wildfly/standalone/configuration

HEALTHCHECK --interval=1m --timeout=10s \
    CMD curl -f http://localhost:8080/bimaapp/ || exit 1

ENTRYPOINT ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]