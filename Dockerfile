ARG BASE_IMAGE="openjdk:18-alpine"
ARG BUILDER_IMAGE="gradle:jdk18-alpine"

#Builderstage for Gradle Dependencies Cache
FROM --platform=linux/amd64 ${BUILDER_IMAGE} as builder

#WORKDIR /build
#COPY build.gradle.kts settings.gradle.kts /build/
#RUN gradle bootJar -x test --parallel --continue > /dev/null 2>&1 || true

WORKDIR /usr/src/app

COPY . .

RUN  chmod +x gradlew && \
     gradle bootJar --refresh-dependencies && \
     cp $(find ./build/libs/* ! -name '*plain*') app.jar && \
     mv app.jar ../ && rm -rf * && mv ../app.jar .

FROM --platform=linux/amd64 ${BASE_IMAGE}

ENV PORT=8081

LABEL maintainer="cchuyong@naver.com"
LABEL title="magcloud-backend"

COPY --from=builder /usr/src/app/app.jar /usr/src/app/app.jar

EXPOSE ${PORT}/tcp

STOPSIGNAL SIGTERM

ENTRYPOINT ["java","-jar","-Dspring.profiles.active=${BUILD_LEVEL}","app.jar"]
