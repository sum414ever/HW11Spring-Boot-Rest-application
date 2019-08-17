FROM alpine

RUN apk add openjdk8\
        openjdk8 --repository=http://dlcdn.alpinelinux.org/alpine/edge/community \
        maven

VOLUME /home/springapp

WORKDIR /home/springapp

COPY ./ /home/springapp

ARG JAR_FILE=target/hw11-0.0.1-SNAPSHOT.jar

EXPOSE 8083

ADD ${JAR_FILE} test.jar

CMD java -jar test.jar