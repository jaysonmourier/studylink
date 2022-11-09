# studylink

Studylink est une application universitaire pour garder contact avec les anciens étudiants.

## Installation

Pour simplifier le déploiement, le projet utilise Docker. 

```
git clone git@github.com:jaysonmourier/studylink.git
```

```
cd studylink
cd studylink_api
```

```
./mvnw clean package
```

```
docker build . -t studylink_app
cd ..
docker-compose up -d
```

Une fois lancé, l'application est disponible sur http://localhost:8080