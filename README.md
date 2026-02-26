Recipe Management Application using SpringBoot (REST API)

Project Overview

The **Recipe Management REST API** is a backend application built using **Spring Boot** that allows users to store, retrieve, update, and delete recipe information. The application loads recipe data from a JSON file during startup, saves it into a MySQL database, and exposes RESTful APIs for interaction.

This project demonstrates the use of **Spring Boot**, **Spring Data JPA**, **Hibernate ORM**, and **Jackson JSON parsing** following a clean layered architecture.

---

## 🎯 Objectives

* Parse recipe data from a JSON file
* Store recipe information in a relational database
* Provide REST APIs to manage recipes
* Demonstrate JPA/Hibernate usage without writing SQL queries
* Enable easy local setup and API testing

---

## 🏗️ Project Architecture

```
src/main/java/com/example/recipes
│
├── controller      → REST API controllers
├── service         → Business logic
├── repository      → JPA repository interfaces
├── entity          → JPA entity classes (POJOs)
├── config          → DataLoader and configuration classes
└── RecipesApplication.java

src/main/resources
├── application.properties
├── US_recipes_null.json
└── schema.sql (optional)
```

---

## 🛠️ Technologies Used

* Java
* Spring Boot
* Spring Web (REST APIs)
* Spring Data JPA
* Hibernate ORM
* MySQL
* Jackson (JSON parsing)
* Maven

---

## 📂 Features

* Automatic JSON data ingestion at application startup
* CRUD operations on recipes
* Database interaction using JPA repositories
* No manual SQL queries required
* Validation and basic error handling
* Easy API testing using Postman or curl

---

## 🗄️ Database Schema

### Recipes Table

```sql
CREATE TABLE recipes (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255),
    description TEXT,
    prep_time INT,
    cook_time INT,
    total_time INT,
    ingredients TEXT,
    instructions TEXT
);
```

---

## ⚙️ Setup Instructions

### 1️⃣ Prerequisites

* Java 17 or higher
* Maven
* MySQL Server
* IDE (IntelliJ / Eclipse / VS Code)

---

### 2️⃣ Database Configuration

Create a MySQL database:

```sql
CREATE DATABASE recipes_db;
```

Update `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/recipes_db
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
```

---

### 3️⃣ Run the Application

```bash
mvn clean install
mvn spring-boot:run
```

The application will start at:

```
http://localhost:8080
```

On startup:

* JSON file is read
* Data is inserted into the database (only if table is empty)

---

## 🔁 JSON Data Loading

* JSON file location: `src/main/resources/US_recipes_null.json`
* Loaded automatically using `CommandLineRunner`
* Keys are ignored and only recipe values are parsed

---

## 🌐 API Endpoints

### ➤ Get All Recipes

```
GET /api/recipes/top
GET /api/recipes/top?limit=5
```

**Response (200 OK)**

```json
[
  {
    "id": 8453,
    "title": "Rava Dosa",
    "cuisine": "South Indian",
    "rating": null,
    "description": "A lentil batter which is dipped with chutney",
    "nutrients": {
        "calories": "500 kcal",
        "carbohydrateContent": "60 g",
        "proteinContent": "6 g",
        "fatContent": "25 g"
    },
    "serves": "6 servings",
    "prep_time": 20,
    "cook_time": 40,
    "total_time": 60
}
.
.
.
.
]
```


```
POST /api/recipes
```

**Request Body**

```json
{
"title": "Rava Dosa",
"cuisine": "South Indian",
"prep_time": 20,
"cook_time": 40,
"description": "A lentil batter which is dipped with chutney",
"nutrients": {
"calories": "500 kcal",
"carbohydrateContent": "60 g",
"proteinContent": "6 g",
"fatContent": "25 g"
},
"serves": "6 servings"
}
```

**Response (201 Created)**

```json
{
    "id": 8453,
    "title": "Rava Dosa",
    "cuisine": "South Indian",
    "rating": null,
    "description": "A lentil batter which is dipped with chutney",
    "nutrients": {
        "calories": "500 kcal",
        "carbohydrateContent": "60 g",
        "proteinContent": "6 g",
        "fatContent": "25 g"
    },
    "serves": "6 servings",
    "prep_time": 20,
    "cook_time": 40,
    "total_time": 60
}
```



## 🧪 API Testing

You can test APIs using:

* Postman
* Swagger
* Thunder Client

---

## 📦 Maven Dependencies (Key)

* spring-boot-starter-web
* spring-boot-starter-data-jpa
* mysql-connector-j
* jackson-databind

---


