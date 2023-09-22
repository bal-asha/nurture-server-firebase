FROM azul/zulu-openjdk:17-latest
VOLUME /tmp
RUN ls -lart
COPY build/libs/nurture-server-1.0.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]