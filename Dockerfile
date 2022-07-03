FROM openjdk:18-jdk-alpine
COPY build/libs/imgtagger-*.jar imgtagger.jar
ENTRYPOINT ["java","-jar","/imgtagger.jar"]
