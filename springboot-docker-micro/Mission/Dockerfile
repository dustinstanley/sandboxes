FROM java:8
VOLUME /tmp
ADD build/libs/Mission.jar app.jar
EXPOSE 8080
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java", "-Dspring.data.mongodb.uri=mongodb://mongodb/microserviceblog", "-Djava.security.egd=file:/dev/./urandom", "-jar","/app.jar"]