# Student Management REST API

A simple REST API built with **Spring Boot** to manage student records. I built this as a backend project to practice Spring REST concepts — covers basic CRUD operations, input validation, and filtering by branch or CGPA.

---

## Tech Used

- Java 17
- Spring Boot 3.2
- Spring Data JPA
- H2 in-memory database (no setup needed)
- Maven

---

## How to Run

Make sure you have Java 17 and Maven installed.

```bash
git clone https://github.com/yourusername/student-management-api.git
cd student-management-api
mvn spring-boot:run
```

App starts on `http://localhost:8080`

A few sample student records are auto-loaded when the app starts so you can test right away.

You can also open the H2 console at `http://localhost:8080/h2-console`  
(JDBC URL: `jdbc:h2:mem:studentdb`, username: `sa`, no password)

---

## API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/students` | Get all students |
| GET | `/api/students/{id}` | Get student by ID |
| POST | `/api/students` | Add a new student |
| PUT | `/api/students/{id}` | Update student details |
| DELETE | `/api/students/{id}` | Delete a student |
| GET | `/api/students/branch/{branch}` | Filter by branch (e.g. CSE) |
| GET | `/api/students/top?minCgpa=8.5` | Get students with CGPA >= value |

---

## Sample Request (POST)

```json
POST /api/students
Content-Type: application/json

{
  "name": "Md Safiullah",
  "email": "safiullah0036@gmail.com",
  "branch": "CSE",
  "cgpa": 8.7,
  "admissionYear": 2021
}
```

---

## Sample Response

```json
{
  "id": 1,
  "name": "Md Safiullah",
  "email": "safiullah0036@gmail.com",
  "branch": "CSE",
  "cgpa": 8.7,
  "admissionYear": 2021
}
```

---

## What I Learned / Covered

- Setting up a Spring Boot project from scratch
- Writing REST controllers with proper HTTP status codes
- Using JPA repositories with custom query methods
- Bean validation with `@Valid`, `@NotBlank`, `@Email`
- Exception handling inside service layer
- Testing endpoints with Postman

---

## Project Structure

```
src/main/java/com/safiullah/studentapi/
├── StudentManagementApiApplication.java
├── DataLoader.java
├── controller/
│   └── StudentController.java
├── model/
│   └── Student.java
├── repository/
│   └── StudentRepository.java
└── service/
    └── StudentService.java
```

---

## Notes

- Email is used as a unique identifier — duplicate emails are rejected
- H2 is used to keep things simple (data resets on restart, which is fine for demo)
- Tested all endpoints manually using Postman
