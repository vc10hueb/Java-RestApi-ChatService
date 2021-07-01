#!/bin/bash

DB_IMAGE=example_db_image
SERVICE_IMAGE=example_service_image

if [[ "$docker image -q $DB_IMAGE 2> /dev/null"]]; then
  echo "Deleting $DB_IMAGE..."
  docker rmi $DB_IMAGE
fi

echo "OK - $DB_IMAGE successfully removed."

if [[ "$docker images -q $SERVICE_IMAGE 2> /dev/null" == "" ]]; then
  echo "Deleting $SERVICE_IMAGE..."
  docker rmi $SERVICE_IMAGE
fi
echo "OK - $SERVICE_IMAGE successfully removed."
