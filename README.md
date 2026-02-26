##  Recipe Management Application using SpringBoot (REST API)

Project Overview

The **Recipe Management REST API** is a backend application built using **Spring Boot** that allows users to store, retrieve recipe information. The application loads recipe data from a JSON file during startup, saves it into a MySQL database, and exposes RESTful APIs for interaction.

This project demonstrates the use of **Spring Boot**, **Spring Data JPA**, **Hibernate ORM**, and **Jackson JSON parsing** following a clean layered architecture.

---

##  Objectives

* Parse recipe data from a JSON file
* Store recipe information in a relational database
* Provide REST APIs to manage recipes
* Demonstrate JPA/Hibernate usage without writing SQL queries
* Enable easy local setup and API testing

---

##  Project Architecture

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

##  Technologies Used

* Java
* Spring Boot
* Spring Web (REST APIs)
* Spring Data JPA
* Hibernate ORM
* MySQL
* Jackson (JSON parsing)
* Maven

---

##  Features

* Automatic JSON data ingestion at application startup
* CRUD operations on recipes
* Database interaction using JPA repositories
* No manual SQL queries required
* Validation and basic error handling
* Easy API testing using Postman or curl

---

##  Database Schema

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

##  Setup Instructions

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

##  JSON Data Loading

* JSON file location: `src/main/resources/US_recipes_null.json`
* Loaded automatically using `CommandLineRunner`
* Keys are ignored and only recipe values are parsed

---

##  API Endpoints

### ➤ Get All Recipes

```
GET /api/recipes/top
GET /api/recipes/top?limit=5
```

**Response (200 OK)**

```json
{
    "data": [
        {
            "id": 8302,
            "title": "Green Chile Chicken Casserole",
            "cuisine": "Tex-Mex Recipes",
            "rating": 5.0,
            "description": "This easy casserole layers corn tortillas, chicken, green chiles, and tomatillos for an easy Tex-Mex dinner reminiscent of enchiladas.",
            "nutrients": {
                "calories": "420 kcal",
                "fatContent": "20 g",
                "fiberContent": "8 g",
                "sugarContent": "4 g",
                "sodiumContent": "1064 mg",
                "proteinContent": "33 g",
                "cholesterolContent": "107 mg",
                "carbohydrateContent": "27 g",
                "saturatedFatContent": "8 g",
                "unsaturatedFatContent": "0 g"
            },
            "serves": "8 servings",
            "prep_time": 30,
            "cook_time": 25,
            "total_time": 55
        },
        {
            "id": 8318,
            "title": "Air Fryer Turkey Fajitas",
            "cuisine": "Tex-Mex Recipes",
            "rating": 5.0,
            "description": "Turkey breast is seasoned with Mexican-inspired spices, herbs, and lime juice and air-fried with vegetables for an easy fajita dish that's bursting with flavor.",
            "nutrients": {
                "calories": "247 kcal",
                "fatContent": "7 g",
                "fiberContent": "4 g",
                "sugarContent": "5 g",
                "sodiumContent": "81 mg",
                "proteinContent": "32 g",
                "cholesterolContent": "82 mg",
                "carbohydrateContent": "15 g",
                "saturatedFatContent": "1 g",
                "unsaturatedFatContent": "0 g"
            },
            "serves": "4 servings",
            "prep_time": 20,
            "cook_time": 30,
            "total_time": 50
        },
        {
            "id": 8295,
            "title": "Authentic Fire-Roasted Tex-Mex Salsa",
            "cuisine": "Tex-Mex Recipes",
            "rating": 5.0,
            "description": "Fire up that broiler to make your own roasted tomato salsa blended with jalapenos, onion, and cilantro.",
            "nutrients": {
                "calories": "14 kcal",
                "fatContent": "0 g",
                "fiberContent": "1 g",
                "sugarContent": "2 g",
                "sodiumContent": "343 mg",
                "proteinContent": "1 g",
                "carbohydrateContent": "3 g",
                "unsaturatedFatContent": "0 g"
            },
            "serves": "8 servings",
            "prep_time": 10,
            "cook_time": 10,
            "total_time": 20
        },
        {
            "id": 8301,
            "title": "Mexican Black Bean and Turkey Wraps",
            "cuisine": "Tex-Mex Recipes",
            "rating": 5.0,
            "description": "These easy ground turkey wraps will feed the whole family with a lean yet filling combo of green chiles, spices, brown rice, and black beans.",
            "nutrients": {
                "calories": "403 kcal",
                "fatContent": "11 g",
                "fiberContent": "10 g",
                "sugarContent": "6 g",
                "sodiumContent": "1883 mg",
                "proteinContent": "31 g",
                "cholesterolContent": "90 mg",
                "carbohydrateContent": "45 g",
                "saturatedFatContent": "3 g",
                "unsaturatedFatContent": "0 g"
            },
            "serves": "4 servings",
            "prep_time": 10,
            "cook_time": 35,
            "total_time": 45
        },
        {
            "id": 8299,
            "title": "Tex-Mex Air Fryer Hash Browns",
            "cuisine": "Tex-Mex Recipes",
            "rating": 5.0,
            "description": "Use an air fryer to make this crispy, tasty potato hash featuring bell peppers and jalapenos with Tex-Mex seasoning.",
            "nutrients": {
                "calories": "186 kcal",
                "fatContent": "4 g",
                "fiberContent": "5 g",
                "sugarContent": "3 g",
                "sodiumContent": "79 mg",
                "proteinContent": "4 g",
                "carbohydrateContent": "34 g",
                "saturatedFatContent": "1 g",
                "unsaturatedFatContent": "0 g"
            },
            "serves": "4 servings",
            "prep_time": 15,
            "cook_time": 30,
            "total_time": 45
        }
    ]
}
```



### ➤ Add new recipe (POST)
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



##  API Testing

You can test APIs using:

* Postman
* Swagger
* Thunder Client

---

##  Maven Dependencies (Key)

* spring-boot-starter-web
* spring-boot-starter-data-jpa
* mysql-connector-j
* jackson-databind

---


