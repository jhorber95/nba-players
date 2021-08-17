# Readme

### Reference Documentation

Before you can build this project, you must install and configure the following dependencies on your machine:

1. [Maven][]: We use Maven to build and download Java dependencies
2. Java 8 or upper


## Building

### Packaging as jar

To build the final jar and optimize the application for production, run:

```
./mvnw clean install

```

### Run app

Execute next command: 

```
./mvnw spring-boot:run

```

### Check functionality

There is an api, you must navigate to [http://localhost:8080/pairs/{{height}}](http://localhost:8080pairs/139) in your browser or a rest client app.


### Testing

To launch your application's tests, run:

```
./mvnw verify
```


[Maven]: https://maven.apache.org/download.cgi
