FROM openjdk:17-jdk-alpine
WORKDIR /cursos_ES_AC2
COPY target/*.jar /cursos_ES_AC2/curso-0.0.1-SNAPSHOT.jar
EXPOSE 8080
CMD java -XX:+UseContainerSupport -Xmx512m -jar curso-0.0.1-SNAPSHOT.jar
