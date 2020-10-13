FROM openjdk:11
EXPOSE 8080
ADD target/spring-boot-searcher.jar spring-boot-searcher.jar
ENTRYPOINT ["java", "-jar", "/spring-boot-searcher.jar"]