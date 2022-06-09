FROM java:8
EXPOSE 8080
ARG JAR_FILE
ADD target/demo_jpa-1.0.0.jar /application.jar
ENTRYPOINT ["java", "-jar","/application.jar"]