#!/bin/bash

DB_IMAGE=message_db_image
SERVICE_IMAGE=message_service_image

echo "Building database image $DB_IMAGE..."
docker build -t $DB_IMAGE --no-cache ./src/main/docker/database
echo "OK - $DB_IMAGE successfully built."

echo "Building service image $SERVICE_IMAGE..."
docker build -t $SERVICE_IMAGE --no-cache
echo "OK - $SERVICE_IMAGE successfully built."
