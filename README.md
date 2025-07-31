# PrepGenie - Interview Question Management System 

PrepGenie is a backend-only web application designed to simplify the management and organisation of interview preparation questions. Whether you're a student, job seeker, or mentor, PrepGenie helps you keep track of questions by topic, difficulty level, and role relevance.

---

##  Features

- Add interview questions with:
  - Question title & description
  - Topic (e.g. Arrays, OOPs)
  - Difficulty (Easy, Medium, Hard)
  - Role relevance (SDE, Backend, Full Stack etc.)

- Retrieve questions based on:
  - ID
  - Topic
  - Difficulty
  - Role

- Delete questions
- Pagination support for easy browsing
- In-memory H2 database (easy to test without setup)
- Spring Data JPA integration

---

## 🛠️ Tech Stack

- **Java 17**
- **Spring Boot 3**
- **Spring Web**
- **Spring Data JPA**
- **H2 Database (for dev testing)**
- **Lombok**

---

##  Project Structure
PrepGenie/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/
│       │       └── prepgenie/
│       │           ├── controller/        # REST API controllers
│       │           ├── model/             # Entity classes (e.g., Question.java)
│       │           ├── repository/        # Spring Data JPA repositories
│       │           ├── service/           # Service layer for business logic
│       │           └── PrepGenieApplication.java # Main Spring Boot application
│       └── resources/
│           └── application.properties     # Spring Boot configuration
├── .gitignore                              # Git ignored files
├── pom.xml                                 # Maven dependencies and project config
└── README.md                               # Project documentation




