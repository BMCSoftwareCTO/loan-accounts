# Financial accounts Service - Service to handle loan accounts
This project is a micro-service container for Financial Inc loan app.  It is focused on handles accounts for loans.

## Getting Started
To get started you can clone the loan-accounts repository and build with gradle.

### Prerequisites
You will only need to install the following dependency
* Java 

## Build and Run
```
* git clone https://github.com/bmcsoftwarecto/loan-accounts.git
* cd loan-accounts
* ./gradlew build
* cd build/libs
* java -jar financial-loan-account-0.1.0.jar
```
This will then allow you to make REST calls to ssh's endpoints.
The api is documented through [Swagger](http://swagger.io/) which allows you to see and test apis through
http://<host>:9061/swagger-ui.html
### Intellij
In order to run in intellij you must first run 
```
./gradlew cleanIdea idea
```
This will allow the swagger libraries to be loaded correctly.

## Build Docker Image
If you want to build a docker image, make sure you have docker installed and usable from your commandline.  After building the product with gradle, run the following from the base loan-accounts directory.  
```
docker build -t loan-accounts .
```
This will give you an image called loan-accounts.  To run it do the following
```
docker run -p 9061:9061 --name loan-accounts loan-accounts
```
This will create a container called loan-accounts.  At this point it will only point to the default application.properties.  If you would like to utilize your own application.properties.  You will need to create the properties file in your system and pass it to the container.  The add the volume and pass in arguments as follow.  The below assumes your properties file (application.properties) is stored in your /tmp folder.
```
docker run -p 9061:9061 -v /tmp:/tmp/properties --name loan-accounts loan-accounts --spring.config.location=/tmp/properties/application.properties
```
