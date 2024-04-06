FROM azul/zulu-openjdk:17-latest
VOLUME /tmp
COPY build/libs/*.jar demo.jar
ENTRYPOINT ["java","-jar","/demo.jar"]
