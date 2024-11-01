# Spring Boot Project: Exception Handling

This project is a Spring Boot application that demonstrates comprehensive exception handling techniques, including `constraint violations`, `method argument validation errors`, `data integrity issues`, and `custom exceptions`. The application is designed to provide a robust framework for managing errors effectively while performing CRUD (Create, Read, Update, Delete) operations

## Features
- `Spring Boot:` A framework to build stand-alone, production-grade Spring-based applications.
- `Maven:` Dependency management and build automation.
- `JPA:` Java Persistence API for database operations.
- `MariaDB:` Relational database management system used for storing application data.
- `Custom Exception Handling:` Custom exception handling for DataIntegrityViolationException, CostraintViolationException, MethodArguementNotValidException and Custom Exceptions.
- `Validation:` Input validation to prevent data integrity violations.
- `Swagger:` API documentation and testing.
- `valid:` annotation is used in Java to trigger validation on an object based on constraints defined in its fields, ensuring that the data meets specified criteria before processing.

## Technologies Used
- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- MariaDB (can be replaced with any other database)
- Swagger

## Getting Started

### Prerequisites

- Java 8 or higher
- Maven 3.6 or higher

### Installation

1. Clone the repository:
   ```sh
   git clone https://github.com/Vivek1099/Springboot-with-AllExceptionHandling.git
   
2. Configure the database:

    Update the src/main/resources/application.properties file with your database connection details:
     ```sh
    spring.datasource.url=jdbc:mariadb://localhost:3306/your_database_name
    spring.datasource.username=your_username
    spring.datasource.password=your_password
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true
   
3. Build the project:
   ```sh
     mvn clean install
4. Run the application:
   ```sh
     mvn spring-boot:run
The application will start on http://localhost:8080.

### Endpoints

1. Test Endpoint
      - URL: `/test`
      - Method: GET
      - Description: Test the API to ensure it's running
      - Response: "This is Method Arguement Not Valid Exception Test"

2. Save Data
      - URL: `/save`
      - Method: POST
      - Description: Add new user data.
      - Request Body: json in postman
        
        ```sh
        {
          "fname":"Bhumi",
          "lname":"Singh",
          "age":20,
          "address":"Ranchi",
          "accno":562890256,
          "email":"bhumi12@gmail.com",
          "pincode":234561,
          "phoneno":7982357681
        }

3. Show Data
      - URL: `/all`
      - Method: GET
      - Description: Returns a list of all customers data.
        
        ```sh
        [
          {
              "cid": 1,
              "accno": "112098437",
              "fname": "Rohit",
              "lname": "Kumar",
              "address": "Ranchi",
              "pincode": "833470",
              "age": 20,
              "email": "rohitkr@gmail.com",
              "phoneno": "7804563487"
          },
          {
              "cid": 12,
              "accno": "112098435",
              "fname": "Rahul",
              "lname": "Singh",
              "address": "Mango",
              "pincode": "238678",
              "age": 20,
              "email": "rahul@gmail.com",
              "phoneno": "7804563488"
          }
        ]
  
4. Retreving Data Using name and customerId.
      - URL: `/byid/{cid}` or `/byname/{fname}/{lname}`
      - Method: GET
      - Description: Returns user data of specific id/name.
      
        ```sh
        {
          "cid": 1,
          "accno": "112098437",
          "fname": "Rohit",
          "lname": "Kumar",
          "address": "Ranchi",
          "pincode": "833470",
          "age": 20,
          "email": "rohitkr@gmail.com",
          "phoneno": "7804563487"
        }

5. Updating Users data
      - URL: `/update/{cid}`
      - Method: PATCH
      - Description: Updates all fields of data.
      
        ```sh
        {
          "fname":"",
          "lname":"",
          "age":null,
          "address":"",
          "accno":null,
          "email":"",
          "pincode":null,
          "phoneno":null
        }

6. Deletion of User data
      - URL: `/delete/{userId}`
      - Method: DELETE
      - Description: Delete user data of provided id.

7. Validation
      - Fname: First name cannot be blank.
      - Lname: Last name cannot be blank.
      - Account Number: Account number cannot be blank
      - Email: It should not be empty and should be proper email.
      - Mobile Number: It should not be empty and should be a proper mobile number.
      - Address: It should not be empty.
      - Age: It should be not empty and the age should be minimum 18.
      - Pincode: It should not be empty.


## Exception Handling
The application includes a global exception handler that captures all exceptions and returns a meaningful error response.
1. Method Arguement Not Valid Exception
    ```sh
    {
    "pincode": "Pincode cannot be empty",
    "fname": "First Name cannot be blank",
    "lname": "Last Name cannot be blank",
    "address": "Address cannot be empty",
    "accno": "Enter the Bank account number",
    "age": "must be greater than or equal to 18",
    "phoneno": "Phone Number should not be empty",
    "email": "Email should not be empty"
    }
2. Constraint Violation Exception
   ```sh
     {
    "pincode": "Please enter valid pincode",
    "accno": "Please Enter the valid account number",
    "age": "must be greater than or equal to 18",
    "phoneno": "Please enter valid phone number",
    "email": "Enter valid Email"
    }
3. Data Integrity Exception
   ```sh
   Database error occurred.
4. Custom Exception
   ```sh
   Id Not Found...!!
   Name Not Found...!!
   Account Not Found...!!

## Project Structure

- Bank: Entity class representing a customer profile.
- BankRepository: Repository interface for CRUD operations on customer profiles.
- BankController: REST controller for handling cuatomer-related requests.
- GlobalExceptionHandler: Global exception handler for validation errors.
- BankConfiguration: Model Mapper configuration for updating customers fields.
- IdNotFountException: Custom Exceptions if customer id is not present. 
- AccountNotFoundException: Custom Exceptions if customer account is not present.
- NameNotFoundException: Custom Exceptions if customer name is not present.


