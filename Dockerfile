FROM openjdk:17-oracle
COPY target/projeto_etb.jar app-1.0.0.jar
ENTRYPOINT [ "java", "-jar", "app-1.0.0.jar" ]