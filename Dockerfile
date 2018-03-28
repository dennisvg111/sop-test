FROM anapsix/alpine-java

COPY /target/sop-1.0-SNAPSHOT.jar /home/sop-1.0-SNAPSHOT.jar

CMD ["java","-jar","/home/sop-1.0-SNAPSHOT.jar"]