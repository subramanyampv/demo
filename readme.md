
---Running With maven

Checkout from git

run  ./mvnw spring-boot:run

The application can be accessed at http://localhost:8080/user/accreditation



----Running With Docker

./mvnw spring-boot:build-image

docker run -it -p8080:8080 demo:0.0.1-SNAPSHOT

The application can be accessed at http://localhost:8080/user/accreditation

