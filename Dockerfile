FROM azul/zulu-openjdk:17-latest
VOLUME /tmp
RUN ls -lart
COPY build/libs/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]