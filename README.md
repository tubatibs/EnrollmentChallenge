# Getting Started

## Spring Boot Application:
Used spring initializer to generate template project with all required maven spring dependencies.  To maeke it easy to review keeping all files in same package.

#### EnrollmentApplication
Spring Boot application with different annotations for configuration, repositories and component scans.

#### MemberEntity: 
Entity object with table column and other validations configured. This design uses same object for dependents and enrollees.  All dependents will have enrollee id and zero for enrollee him/her self. This is to avoid redundancy.  

#### MemberRepository:  
CRUD operations repository used to take advantage of spring framework existing functionalities.

#### MemberService:  
Contains individual methods to satisfy the challenge requirements.

#### MemberController: 
Rest controller to publish RestFull services.


## H2 Database:
Used H2 database as embedded for this challenge, because it is very light weight and 100% pure java and integrates with SpringBoot effectively. If required database can 
be changed very easily as using Java Persistence API. 

Simple one table approach to handle enrolle and dependents.
Please refer screenshot: H2-DB-enrollment.jpg

Executable jar file embedded will all required dependent libraries.  Ready to integrate with front end.

Maven Build:   mvn clean install

Start Embedded jar: java -jar target/enrollment-0.0.1-SNAPSHOT.jar <pass environment application.properties>

Make sure following URL works after starting   http://localhost:8080/memberEntities

## Swagger UI - Open API v3 -ReSTfull API and associated model Test cases

	// Add a new enrollee
	addEnrollee(MemberEntity enrollee) 

	// Modify an existing enrollee
	modifyEnrolee(MemberEntity enrollee)

	// Remove an enrollee entirely - soft delete to set activation status as FALSE
	removeEnroleeEntirely(long id)

	// Add dependents to an enrollee
	addDependent(MemberEntity dependent)

	// Remove dependents from an enrollee
	removeDependent(int memberId)

	// Modify existing dependents
	modifyDependent(MemberEntity dependent)

Please refer screenshot: Swagger-MemberJson.JPG

## Future state/Opertunities for improvements

Opertunities to improvements with more business validations like dates, coverages and other items. API's load data from/to different sources. 

Data model enhancements or customizations with auditing and others

Making sure 12 Factor Micro Services Methodology to support SaaS and ready to be deployed in any cloud providers.

Swagger API enhancements and SSL implementation for RestFull services and Data and/or password encryption

Containerzation with Docker or kubernatives, based on volume.

Performance, scalling and dash board and  monitoring. 

## About
Really enjoyed working on this challenge,   

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.3.4.RELEASE/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.3.4.RELEASE/maven-plugin/reference/html/#build-image)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/2.3.4.RELEASE/reference/htmlsingle/#using-boot-devtools)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.3.4.RELEASE/reference/htmlsingle/#boot-features-developing-web-applications)
* [Rest Repositories](https://docs.spring.io/spring-boot/docs/2.3.4.RELEASE/reference/htmlsingle/#howto-use-exposing-spring-data-repositories-rest-endpoint)
* [JDBC API](https://docs.spring.io/spring-boot/docs/2.3.4.RELEASE/reference/htmlsingle/#boot-features-sql)
* [Spring Boot Actuator](https://docs.spring.io/spring-boot/docs/2.3.4.RELEASE/reference/htmlsingle/#production-ready)
* [Datadog](https://docs.spring.io/spring-boot/docs/2.3.4.RELEASE/reference/html/production-ready-features.html#production-ready-metrics-export-datadog)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)
* [Accessing JPA Data with REST](https://spring.io/guides/gs/accessing-data-rest/)
* [Accessing Neo4j Data with REST](https://spring.io/guides/gs/accessing-neo4j-data-rest/)
* [Accessing MongoDB Data with REST](https://spring.io/guides/gs/accessing-mongodb-data-rest/)
* [Accessing Relational Data using JDBC with Spring](https://spring.io/guides/gs/relational-data-access/)
* [Managing Transactions](https://spring.io/guides/gs/managing-transactions/)
* [Building a RESTful Web Service with Spring Boot Actuator](https://spring.io/guides/gs/actuator-service/)

