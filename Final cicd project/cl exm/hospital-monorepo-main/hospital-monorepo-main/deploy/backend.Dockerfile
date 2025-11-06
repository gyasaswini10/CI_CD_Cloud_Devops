FROM maven:3.9-eclipse-temurin-21 AS builder
ARG REPO
WORKDIR /build

# install git
RUN apt-get update && apt-get install -y git && rm -rf /var/lib/apt/lists/*

# clone the backend repo and build
RUN git clone ${REPO} app
WORKDIR /build/app
RUN mvn -B -DskipTests package

FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=builder /build/app/target/*.jar app.jar
EXPOSE 8081
ENV JAVA_OPTS="-Xms256m -Xmx512m"
ENTRYPOINT ["sh","-c","java $JAVA_OPTS -jar /app/app.jar"]
