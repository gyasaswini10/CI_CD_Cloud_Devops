FROM eclipse-temurin:21-jdk AS build
WORKDIR /workspace

# copy source in (assumes this Dockerfile will be placed in the backend repo root)
COPY . /workspace
RUN mvn -B -DskipTests package

FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /workspace/target/*.jar app.jar
EXPOSE 8081
ENTRYPOINT ["sh","-c","java -jar /app/app.jar"]
