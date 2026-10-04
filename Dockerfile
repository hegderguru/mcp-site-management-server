FROM openjdk:17-ea-5-jdk-alpine3.13
ADD target/mcp-site-management-server-0.0.1-SNAPSHOT.jar mcp-site-management-server.jar
ENTRYPOINT ["java","-jar","/mcp-site-management-server.jar"]