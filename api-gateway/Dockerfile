FROM openjdk:11
WORKDIR usr/src
#ENV MYSQL_DATABASE=demo
#ENV MYSQL_USER=root
#ENV MYSQL_PASSWORD=Root@123
#ENV MYSQL_CI_URL=jdbc:mysql://localhost:33060/demo
ADD ./target/api-gateway-service-0.0.1-SNAPSHOT.jar usr/src/api-gateway-service-0.0.1-SNAPSHOT.jar
EXPOSE 8010
ENTRYPOINT ["java","-jar","usr/src/api-gateway-service-0.0.1-SNAPSHOT.jar"]