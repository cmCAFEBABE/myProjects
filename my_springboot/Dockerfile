FROM java:8
VOLUME /tmp
ADD target/my_springboot-0.0.1-SNAPSHOT.jar my_springboot.jar
ENV JAVA_OPTS=""
ENTRYPOINT exec java $JAVA_OPTS -jar /my_springboot.jar
