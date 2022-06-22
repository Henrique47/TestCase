### REQUISTOS PARA EXECUÇÃO DO PROJETO 
JAVA 11

GRADLE  7.4.2 OU SUPERIOR

Instrução para Instalação do Gradle
https://gradle.org/install/

### PARA EXECUÇÃO VIA JAR ( VIA TERMINAL)
gradle build

java -jar build\libs\testeCase.jar

### PARA EXECUÇÃO VIA DOCKER
gradle build

docker build -t testcase .

docker run -dp 8080:8080 testcase

## Endpoints aplicação
### Health-check

http://localhost:8080/health-check/liveness

### Verification 
http://localhost:8080/verification/{password}

Substutir {password} pelo senha que deseja realizar a validação.

