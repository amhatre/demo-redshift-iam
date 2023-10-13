# Connect to Redshift
This project helps test connectivity to a Redshift database. The connectivity test is 
inspired from the [Redshift docs](https://docs.aws.amazon.com/redshift/latest/mgmt/connecting-in-code.html).

## Run locally

### Build
This project requires jdk 11.

To build the project jar run 

    mvn package

### Run 
Run the jar using command

    java "-Dredshift.jdbc.url=<jdbc url>" "-Dredshift.jdbc.username=<username>" "-Dredshift.jdbc.password=<password>" -jar demo-redshift-iam-0.0.1-SNAPSHOT.jar

Logs printed on the console will indicate if the connection succeeded or not. All the table names will be printed
along with a message "Finished connectivity test." at the end. This proves the connection works.

## Docker

### Build
Build a docker image by running below command at the root folder

    docker build -t demo-redshift-iam .

### Run 

    docker run -it --rm -e JAVA_TOOL_OPTIONS="-Dredshift.jdbc.url=<jdbc url> -Dredshift.jdbc.username=<username> -Dredshift.jdbc.password=<password>" --name demo-redshift-iam demo-redshift-iam