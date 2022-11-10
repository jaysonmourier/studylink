cd studylink_api

./mvnw clean package

docker build . -t studylink_app

cd ..

docker-compose up