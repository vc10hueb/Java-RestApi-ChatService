FROM openjdk:8-jre
MAINTAINER Vincent Hueber <vc10hueb@gmail.com>
COPY target/example-service.war example-service.war

ENTRYPOINT ["/usr/local/openjdk-8/bin/java"]
CMD ["-jar", "/example-service.war"]
