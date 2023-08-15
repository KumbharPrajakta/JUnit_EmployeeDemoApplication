FROM openjdk:17
LABEL maintainer = "com.ait"
ADD target/*.jar demoapplication.jar
ENTRYPOINT ["java","-jar","demoapplication.jar"]



