# Dockerfile

# https://www.nginx.com/
# https://hub.docker.com/_/nginx


FROM openjdk:17
LABEL maintainer="My Blog Project for Spring Boot"
ARG JAR_FILE_PATH=SpringBoot_FullStack-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE_PATH} blog.jar
ENTRYPOINT ["java", "-jar", "/blog.jar"]
EXPOSE 4040 9999
CMD ["cmd 1"]