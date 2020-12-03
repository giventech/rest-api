# TEAM, MEMBERS and TEAM_MEMBERS
### Create rest-controllers, services, datasource, dao, entity

# Getting Started

## Requirements

For building and running the application you need:
-  Git
- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)


### Clone
To get started you can simply clone this repository using git:
```
git clone https://github.com/giventech/res-api.git
cd rest-api
```

### Build an executable JAR


You can run the application from the command line using:
```
mvn spring-boot:run
```
Or you can build a single executable JAR file that contains all the necessary dependencies, classes, and resources with:
```
mvn clean package
```

Then you can run the JAR file with:

```shell
`java -jar api-0.0.1-SNAPSHOT.jar`
```

Another way is to execute the `main` method in the `com.giventech.ApiApplication` class from your IDE. 



## Running  the application locally

There are several ways to run a Spring Boot application on your local machine. 

- Once you have the executable jar ready place it the folder of your choice from that folder run the command below to start the Spring Boot Server 



## Test the application locally
Access the application on localhost:8080:

### Return ok ( this will return a simple when calling for your browser
http://localhost:8080/returnok


### Add a team 

Use CURL to test that a records is being added:
(Windows terminal needs escape characters)
curl -d "{\"name\":\"new team\"}" -H "Content-Type: application/json"   http://localhost:8080/team




## Backlog (Engineering improvement)

### Development Pipeline Improvement backlog

* REST API consumer resilience to downgraded downstream api - 
* CI/CD build pipeline for other contributor to contribute e.g. github/heroku
* Integrate HystrixDashBoard to trace back issues that arose whilst accessing the services 

### Resilience / UX  / Software Architecture 
* Add Retry mechanism to allow to reduce instance of fallbacks and invalid results coming from downgraded API 
* Sketch high level architecture diagram
  

# References
### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)

### Guides
The following guides illustrate how to use some features concretely:

* [Circuit Breaker](https://spring.io/guides/gs/circuit-breaker/)
* [Client Side Load Balancing with Ribbon and Spring Cloud](https://spring.io/guides/gs/client-side-load-balancing/)
* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)



### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.3.1.RELEASE/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.3.1.RELEASE/maven-plugin/reference/html/#build-image)
* [Spring Security](https://docs.spring.io/spring-boot/docs/2.3.1.RELEASE/reference/htmlsingle/#boot-features-security)
* [OAuth2 Client](https://docs.spring.io/spring-boot/docs/2.3.1.RELEASE/reference/htmlsingle/#boot-features-security-oauth2-client)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.3.1.RELEASE/reference/htmlsingle/#boot-features-developing-web-applications)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.3.1.RELEASE/reference/htmlsingle/#boot-features-jpa-and-spring-data)
* [JDBC API](https://docs.spring.io/spring-boot/docs/2.3.1.RELEASE/reference/htmlsingle/#boot-features-sql)
* [Spring Data JDBC](https://docs.spring.io/spring-data/jdbc/docs/current/reference/html/)
* [OAuth2 Resource Server](https://docs.spring.io/spring-boot/docs/2.3.1.RELEASE/reference/htmlsingle/#boot-features-security-oauth2-server)

### Guides
The following guides illustrate how to use some features concretely:

* [Securing a Web Application](https://spring.io/guides/gs/securing-web/)
* [Spring Boot and OAuth2](https://spring.io/guides/tutorials/spring-boot-oauth2/)
* [Authenticating a User with LDAP](https://spring.io/guides/gs/authenticating-ldap/)
* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Accessing Relational Data using JDBC with Spring](https://spring.io/guides/gs/relational-data-access/)
* [Managing Transactions](https://spring.io/guides/gs/managing-transactions/)
* [Using Spring Data JDBC](https://github.com/spring-projects/spring-data-examples/tree/master/jdbc/basics)

~~~~
Questions
---------

Why do I need to create and a registry name in AWS ?
Why can't it just be the same name as the images I am building


1)  Set the correct access policies  for the user

{
   "Version":"2012-10-17",
   "Statement":[
      {
         "Sid":"ListImagesInRepository",
         "Effect":"Allow",
         "Action":[
            "ecr:ListImages"
         ],
         "Resource":"arn:aws:ecr:ap-southeast-2:331166605245:repository/demo"
      },
      {
         "Sid":"GetAuthorizationToken",
         "Effect":"Allow",
         "Action":[
            "ecr:GetAuthorizationToken"
         ],
         "Resource":"*"
      },
      {
         "Sid":"ManageRepositoryContents",
         "Effect":"Allow",
         "Action":[
                "ecr:BatchCheckLayerAvailability",
                "ecr:GetDownloadUrlForLayer",
                "ecr:GetRepositoryPolicy",
                "ecr:DescribeRepositories",
                "ecr:ListImages",
                "ecr:DescribeImages",
                "ecr:BatchGetImage",
                "ecr:InitiateLayerUpload",
                "ecr:UploadLayerPart",
                "ecr:CompleteLayerUpload",
                "ecr:PutImage"
         ],
         "Resource":"arn:aws:ecr:ap-southeast-2:331166605245:repository/demo"
      }
   ]
}


2) Build the image locally

docker build -t prioritisation-api -f ./prioritisation-api/Dockerfile ./prioritisation-api  --build-arg REPOSITORY_URL=docker.io  --build-arg SPRING_PROFILE=dev
3) Login to docker registry 
aws ecr get-login-password --region ap-southeast-2 | docker login --username AWS --password-stdin 331166605245.dkr.ecr.ap-southeast-2.amazonaws.com
Login Succeeded

4) Tag the image into exisiting repository (name)

docker tag prioritisation-api:latest 331166605245.dkr.ecr.ap-southeast-2.amazonaws.com/demo:latest

5) Push the image on the registry:
docker push  331166605245.dkr.ecr.ap-southeast-2.amazonaws.com/demo:latest