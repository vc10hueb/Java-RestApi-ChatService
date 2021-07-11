#!/bin/bash

IMAGE=message_service_db_image
CONTAINER=message-service-db
PORT=6011

if [[ "docker images -q $IMAGE 2> /dev/null" == ""]]; then
  docker build -t $IMAGE --no-cache ./src/main/docker/database
fi


RUNNING = $(docker inspect --format="{{ .State.Running }}" $CONTAINER 2> /dev/null)

if [ $? -eq 1]; then
  echo "$CONTAINER does not exist, creating now..."
  docker run --name $CONTAINER -d -p $IMAGE "$PORT:5432"
else
  docker start $CONTAINER
fi

STARTED=$(docker inspect --format="{{ .State.StartedAt }}" $CONTAINER)

echo "OK - $CONTAINER is running. StartedAt: $STARTED"

echo "OK - The database is started and can be accessed using localhost:$PORT"
