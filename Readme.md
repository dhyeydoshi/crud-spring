# Spring Boot CRUD Application

A simple CRUD (Create, Read, Update, Delete) application built with Spring Boot and PostgreSQL. This application demonstrates basic CRUD operations on a `User` entity.

## Prerequisites

- **Java Development Kit (JDK)**: Version 21
- **Gradle Build Tool**
- **PostgreSQL**: Database server
- **IDE**: Optional
- **cURL** or **Postman**: For testing the endpoints

## Setup Instructions

### 1. Clone the Repository

```bash
git clone https://github.com/dhyeydoshi/crud-spring.git
cd crud-spring
```

### 2. Set up the Database

- Install PostgreSQL if not already installed.
- Create a database named `crud_db`.

### 3. Configure the Database

- Open `src/main/resources/application.properties` file.
- Update the username, and password.

```properties
spring.datasource.username=your_postgres_username
spring.datasource.password=your_postgres_password
```

### 4. Build and Run the Application

```properties
.\gradlew.bat build
.\gradlew.bat bootRun
```

### 5. Test the Application
- Open a web browser and visit `http://localhost:8080/users`.
- Use cURL or Postman to test the endpoints.
- For example, using cURL on terminal/command prompt, to create a new user:

```bash
curl -X POST http://localhost:8080/users -H "Content-Type: application/json" -d "{\"name\": \"Alice\", \"email\": \"alice@example.com\"}"
```

- To delete a user:

```bash
curl -X DELETE http://localhost:8080/users/{id}
```
- To view all users:

```bash
curl -X GET http://localhost:8080/users
```

- To update a user:

```bash
curl -X PUT http://localhost:8080/users/{id} -H "Content-Type: application/json" -d "{\"name\": \"Alice Smith\", \"email\": \a@example.com\"}"
```