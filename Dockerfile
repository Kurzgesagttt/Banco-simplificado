# build
FROM maven:3.8.8-amazoncorretto-21-al2023 as build
WORKDIR /build

COPY . .

RUN mvn clean package -DskipTests

# run
FROM amazoncorretto:21.0.5
WORKDIR /app

COPY --from=build ./build/target/*.jar ./banco_api.jar

EXPOSE 8080
EXPOSE 9090

ENV DATASOURCE_URL=''
ENV MAIL_USERNAME=''
ENV MAIL_PASSWORD=''

ENV TZ='America/Sao_Paulo'

ENTRYPOINT java -jar banco_api.jar