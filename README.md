# Secure Weather API

A Spring Boot backend that provides weather data through authenticated APIs.  
Users can register, log in, fetch weather information for a city, and view their search history.

The focus of this project is building a secure and structured backend with JWT authentication, external API integration, and clean separation of concerns.

---

## What this project does

- Handles user authentication using JWT
- Fetches weather data from an external API
- Stores user-specific search history
- Secures endpoints using Spring Security
- Uses a layered architecture for maintainability

---

## Tech stack

- Java 17
- Spring Boot
- Spring Security
- JWT
- Maven
- MySQL

---

## Project structure

src/main/java/com/gangatharan/weather_app

controller → API layer
service → business logic
repository → database access
entity → database models
dto → request/response objects
security → authentication & JWT
config → configuration
exception → global error handling

---

## Running locally

### 1. Clone the repository

```bash
git clone https://github.com/Gangathat/Weather-app.git
cd Weather-app

```

### 2. Configure application

Update application.yaml:

spring:
  datasource:
    url: jdbc:mysql://localhost:3306/weather_db
    username: your_username
    password: your_password

weather:
  api:
    key: YOUR_API_KEY

### 3. Run the application

mvn clean install
mvn spring-boot:run

App runs at:
http://localhost:8080

### Authentication

JWT-based authentication is used.

Flow:

1. Register or login
2. Receive JWT token
3. Send token in header

Authorization: Bearer <token>

### API Endpoints
* Authentication
* POST /auth/register → Create a new user
* POST /auth/login → Login and receive JWT

###  Weather
* GET /weather?city=Chennai
*  Returns weather data for the city
*  Requires authentication

###  Search History
* GET /history → Get previous searches
* POST /history → Save search

### Example usage
 * Login
    curl -X POST http://localhost:8080/auth/login \
   -H "Content-Type: application/json" \
   -d '{"username":"user","password":"pass"}'

### Get Weather

     curl -X GET "http://localhost:8080/weather?city=Chennai" \
    -H "Authorization: Bearer <token>"
