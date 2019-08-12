# demo-service
A sample spring boot application

#### Commands
```
mvn clean install -Dmaven.test.skip=true
java -jar target/demo-service-1.0.0.jar
```

Docker commands:
```
docker build -t vemahendran:demo-service .
docker run --name demo-spring -p 9090:9090 vemahendran/demo-service
```

To delete the container name:
```
docker rm -f <container_id>
```
