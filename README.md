[![CircleCI](https://dl.circleci.com/status-badge/img/gh/jaysonmourier/studylink/tree/main.svg?style=svg)](https://dl.circleci.com/status-badge/redirect/gh/jaysonmourier/studylink/tree/main)
[![License](https://img.shields.io/badge/License-Apache_2.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
# studylink

Studylink est une application universitaire pour garder contact avec les anciens étudiants.

## Installation

### Installer les dépendances

Pour faire fonctionner le projet, vous devez avoir certaine dépendance.
- JDK 17 : https://openjdk.org/projects/jdk/17/
- Flutter : https://docs.flutter.dev/get-started/install
- Docker : https://docs.docker.com/get-docker/

⚠️ Il est important d'ajouter Flutter à votre PATH pour le bon fonctionnement du script build.sh !

Linux:
```
export PATH="$PATH:$HOME/[path to the directory you have installed flutter]/flutter/bin"
```

Mac:
```
export PATH=[PATH_TO_FLUTTER_GIT_DIRECTORY]/flutter/bin:$PATH
```

### Cloner et installer le projet

```
git clone git@github.com:jaysonmourier/studylink.git
cd studylink
```

```
./build.sh
```

Une fois lancé, l'application est disponible sur http://localhost:8080
