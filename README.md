# Makersharks Supplier Search API

This repository contains the implementation of a RESTful API built using Spring Boot for Makersharks. It allows buyers to search for manufacturers based on their customized requirements such as location, nature of business, and manufacturing processes.

## Features

* Search for manufacturers by location, business scale, and manufacturing capabilities.
* Paginated responses for large result sets.
* Input validation and error handling.

## Prerequisites

To run this application, you will need:

* JDK 11 or later
* Maven 3.6 or later
* An IDE like IntelliJ IDEA or Visual Studio Code
* PostgresSQL Database (recommended, but H2 in-memory database can also be used for testing purposes)

## Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/your-username/makersharks-api.git
   cd makersharks-api
   ```
2. Configure the `application.properties` file with the appropriate database settings:

   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/makersharks
   spring.datasource.username=mysql
   spring.datasource.password=yourpassword
   spring.jpa.hibernate.ddl-auto=update
   ```
3. Run the application:

   ```bash
   mvn spring-boot:run
   ```

## Usage

### Search Manufacturers

To search for manufacturers based on specified criteria, use the following POST request:

curl -X POST http://localhost:9090/api/supplier/query
-H 'Content-Type: application/json'
-d '{
"location": "India",
"natureOfBusiness": "SMALL_SCALE",
"manufacturingProcesses": ["THREE_D_PRINTING"],
"page": 0,
"size": 10
}'

### API Response

The API will return a paginated list of suppliers matching the search criteria, including details such as supplier\_id, company\_name, website, and more.

## Security

Implement encryption and decryption mechanisms for securely storing and accessing data in the database.(TODO). Use JWT (JSON Web Token) for authentication to secure the API.(TODO)
Validate inputs to prevent SQL injection attacks.(TODO)

## Exception Handling

Global exception handling is in place to manage input validation errors and other common issues gracefully.

## Unit Tests

Unit tests for various components of the application are available in the `src/test` directory. Run them using Maven:

```bash
mvn test
```

## Documentation

For detailed API documentation, navigate to `http://localhost:8080/swagger-ui.html` after starting the application.
