FROM eclipse-temurin:17-alpine AS builder

ADD ./gradle gradle/
ADD ./gradlew gradlew
ADD ./settings.gradle.kts settings.gradle.kts
ADD ./build.gradle.kts build.gradle.kts
ADD ./src src/

RUN ./gradlew --version

RUN ./gradlew build -x test --no-daemon

FROM eclipse-temurin:17-alpine
WORKDIR /usr/src/app
COPY --from=builder build/libs/event-sourcing.jar /usr/src/app/event-sourcing.jar

ENV JAVA_OPTS=""

CMD java $JAVA_OPTS -jar event-sourcing.jar
