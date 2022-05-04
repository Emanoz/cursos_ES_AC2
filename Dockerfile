FROM openjdk:17-jdk-alpine
VOLUME /tmp
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 8080
CMD java -XX:+UseContainerSupport -Xmx512m -jar curso-0.0.1-SNAPSHOT.jar.original
