ARG REPOSITORY_URL

FROM ${REPOSITORY_URL}/openjdk:11-jdk-slim as builder
WORKDIR application
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} prioritisation-api.jar

RUN java -Djarmode=layertools -jar prioritisation-api.jar extract

ARG REPOSITORY_URL
FROM ${REPOSITORY_URL}/openjdk:11-jdk-slim
WORKDIR application
COPY --from=builder application/dependencies/ ./
COPY --from=builder application/snapshot-dependencies/ ./
COPY --from=builder application/spring-boot-loader/ ./
COPY --from=builder application/application/ ./
COPY ./entrypoint.sh  /

RUN chmod +x /entrypoint.sh

ARG SPRING_PROFILE
ENV SPRING_PROFILES_ACTIVE=${SPRING_PROFILE}

EXPOSE 9000
ENTRYPOINT ["/entrypoint.sh"]
