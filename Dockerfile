FROM openjdk:11

COPY target/demo-redshift-iam-0.0.1-SNAPSHOT.jar demo-redshift-iam.jar

ENTRYPOINT ["java","-jar","/demo-redshift-iam.jar"]