./mvnw clean package
docker build --no-cache -t test1-app .
docker run -p 8080:8080 test1-app
