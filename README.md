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
prepgenie/
├── src/
│ ├── main/
│ │ ├── java/com/prepgenie/
│ │ │ ├── controller/ # REST APIs
│ │ │ ├── model/ # Entity classes
│ │ │ ├── repository/ # JPA Repositories
│ │ │ ├── service/ # Business logic
│ │ │ └── PrepGenieApplication.java
│ │ └── resources/
│ │ └── application.properties
├── .gitignore
├── pom.xml
└── README.md



