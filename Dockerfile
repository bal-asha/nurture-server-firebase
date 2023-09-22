FROM azul/zulu-openjdk:17-latest
VOLUME /tmp
RUN ls -lart /home/user/.local/tmp
RUN ls -lart /home/user/.local/tmp/buildkit-mount3279944996
COPY ./build/libs/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]