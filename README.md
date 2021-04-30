# Merchant Application

## Table of contents
* [Web Services  ](#web-services)
* [Technologies](#technologies)
* [Setup](#setup)
* [Features](#features)
* [Contact](#contact)

## Web Services  
#### Path web WSDL:  
>Merchant Webservice  
* http://localhost:8686/ws/merchants?wsdl
>Product Webservice  
* http://localhost:8686/ws/products?wsdl
>MerchantProduct Webservice  
* http://localhost:8686/ws/merchantProducts?wsdl

## Technologies
The application is built with the following dependencies:
* Spring context 5.2.14.RELEASE for Spring container and DI  
* Spring orm for Object relational mapping  
* Junit 4.13.2 for the Unit tests  
* Lombok 1.18.20 to auto generate Getters, Setters, equals ... methods  
* Maven to manage build, tests and dependencies  
* Git for versioning    
* Java 8  
* Jax-ws  
* PostgreSQL 42.2.19 for Database  
* Hibernate 5.4.30.Final  

## Setup
1 - Create Database `merchant-database` in your PostgreSQL  
2 - Open the file `sql-queries.sql` in your PostgreSQL and run it to create Database tables  
3 - Clone the repository in your workspace `git clone https://github.com/imad-berkati/merchant-application.git`  
4 - Run this maven command in your project root directory `mvn install exec:java`  
5 - Use SoapUI to test webservices  
Note:  
Make sure your `8686` port is not already in use.  

## Features   
* Add / Update / Delete / fetch Merchants.
* Add / Update / Delete / fetch Products.
* Associate a product to a merchant.

TODO list by priority:  
* Configure Tomcat and add web.xml / sun-jaxws.xml
* Add more Jax-ws annotations.
* Create custom exceptions.
* Add Logs.
* Fetch merchant with his associated products.
* Add Jacoco library for test reports and coverage.

## Contact
Contact: berkati.imad@gmail.com