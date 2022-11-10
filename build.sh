#!/bin/bash

DIR=studylink_api
MVN=studylink_api/mvnw
if [ -d "$DIR" ];
then
    if [ -f "$MVN" ];
    then
        if docker info > /dev/null 2>&1;
        then
            cd studylink_api
            ./mvnw clean package
            docker build . -t studylink_app
            docker-compose up -d
        else
            echo "This script uses docker, and it isn't running - please start docker and try again!"
        fi
    else
        echo "$MVN not found!"
    fi
    
else
	echo "$DIR directory does not exist."
    echo "Please clone github.com/jaysonmourier/studylink"
fi
