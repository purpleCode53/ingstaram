FROM openjdk:17
ADD /build/libs/*.jar demo.jar
ENTRYPOINT ["java","-jar","/demo.jar"]