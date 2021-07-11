FROM openjdk:8-jre
MAINTAINER Vincent Hueber <vc10hueb@gmail.com>
COPY target/message-service.war message-service.war

ENTRYPOINT ["/usr/local/openjdk-8/bin/java"]
CMD ["-jar", "/message-service.war"]
