FROM azul/zulu-openjdk:17-latest
VOLUME /tmp
RUN cd /tmp
RUN pwd
RUN ls -lrt
COPY build/libs/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]