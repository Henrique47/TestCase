FROM adoptopenjdk/openjdk11:jre-11.0.11_9-alpine
ADD build/libs/testeCase.jar testeCase.jar
ENTRYPOINT ["java","-jar","/testeCase.jar"]