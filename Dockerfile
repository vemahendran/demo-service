FROM maven:3.6-jdk-8-alpine AS thick

WORKDIR /microservice
COPY . .
RUN mvn -B clean install -Dmaven.test.skip=true

FROM openjdk:8-jre-alpine AS thin

WORKDIR /microservice
COPY --from=thick /microservice/starter.sh .
COPY --from=thick /microservice/target/demo-service-1.0.0.jar .

RUN chmod 755 starter.sh
RUN apk --no-cache add bash

CMD bash -c "./starter.sh"
