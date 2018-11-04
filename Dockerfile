FROM java:8
FROM maven:alpine

LABEL maintainer=“jesusm.sanchez93@gmail.com”
WORKDIR /app
COPY . /app

RUN mvn clean install

RUN ls target -a
EXPOSE 8080

ENTRYPOINT ["java","-jar","target/sap-test-backend-0.0.1-SNAPSHOT.war"]