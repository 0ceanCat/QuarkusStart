# desafio
This is a start up exercise of Quarkus.

## Tests
In order to run all the tests:
Run `mvn clean test integration-test`.

# Quarkus without Docker
How to run the application:
`./mvnw compile quarkus:dev`

# Quarkus with Docker
Inside the project:
Run `docker build -f src/main/Docker/Dockerfile.jvm -t desafio/labseq .`

Run `docker run -i --rm -p 8080:8080 desafio/labseq`

# How to interact with backend
Open the front-end page in a browser:
`frontend/labseqPage.html`


# API documentation
swagger-ui: `http://localhost:8080/q/swagger-ui/`
