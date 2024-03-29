#!/bin/bash

SPRING_PROFILE=${SPRING_PROFILE:-development}
SHIP_APPLICATION_URL=${SHIP_APPLICATION_URL:-http://blackpearlserv-service:9090/blackpearlserv/v1.0}

java -Xmx768m \
    -Dspring.profiles.active=${SPRING_PROFILE} \
    -Doutgoing.connection.url=${SHIP_APPLICATION_URL} \
    -jar demo-service-1.0.0.jar
