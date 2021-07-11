#Overview
This is a basic chat messaging service for users.
NOTE: The database practices for managing user information is insecure. This
is strictly for demonstration purposes only. In a production like environment
an active directory layer would replace the user service.

#Development
The artifact built by this project is a WAR that can be deployed via tomcat.

Spring Boot command can also be used `java -jar java_messaging_service.war`

The best way to deploy new code is using the dev profile 
`java -jar message_service.war --spring.profiles-active=dev`

##Database
The application uses a postgresql database. 
When deployed as an application within the context of a Tomcat app server, 
the WAR expects a JNDI data source. On the tomcat server add to the configuration 
file `$CATALINA_BASE/conf/message_service.properties` 
the following entry `spring.datasource.jndi-name/jdbc/message`.

##Docker
The `db-docker-setup.sh` automates the process of creating the database.

To create the schema and populate the database `mvn flyway:migrate`.

###Docker Compose
A docker compose will run and initialize the database and application `docker-compose up`