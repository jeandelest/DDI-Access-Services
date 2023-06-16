FROM maven:3.6.2 as mvn
WORKDIR /DDI-Access-Services
COPY ./ /DDI-Access-Services/
RUN mvn -B -f /DDI-Access-Services/pom.xml package

MAINTAINER hugobouttes

FROM openjdk:17-jdk-alpin
COPY --from=mvn DDI-Access-Services/target/rmes-0.0.4-BetaElastic.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]