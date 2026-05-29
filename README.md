# Class Booking System

## 1. Project Overview

The Class Booking System is a Spring Boot application that enables parents to book educational course offerings for their children. The system manages courses, teachers, parents, offerings, sessions, and bookings while preventing scheduling conflicts and supporting timezone conversion.

### Key Features

* Course Management
* Teacher Management
* Parent Management
* Offering Management
* Session Management
* Booking Management
* Conflict Detection
* Timezone Conversion
* Validation
* Exception Handling
* Concurrency Handling

---

## 2. Tech Stack Used

### Backend

* Java 17
* Spring Boot
* Spring Data JPA
* Hibernate

### Database

* MySQL

### Build Tool

* Maven

### Testing

* Postman

### Version Control

* Git
* GitHub

---

## 3. Setup Instructions

### Clone Repository

```bash
git clone <repository-url>
cd classbooking
```

### Build Project

```bash
mvn clean install
```

### Run Application

```bash
mvn spring-boot:run
```

Or run:

```text
ClassbookingApplication.java
```

from your IDE.

---

## 4. Environment Variables Required

The following configuration is required in application.properties:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/classbooking
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

Update the username and password according to your local MySQL setup.

---

## 5. API Documentation

### Course APIs

#### Create Course

POST /courses

Request Body

```json
{
  "name": "AI basics"
}
```

#### Get All Courses

GET /courses

---

### Teacher APIs

#### Create Teacher

POST /teachers

Request Body

```json
{
  "name": "Leela prasanna",
  "timezone": "Asia/Kolkata"
}
```

#### Get All Teachers

GET /teachers

---

### Parent APIs

#### Create Parent

POST /parents

Request Body

```json
{
  "name": "Haritha",
  "timezone": "America/New_York"
}
```

#### Get All Parents

GET /parents

---

### Offering APIs

#### Create Offering

POST /offerings

Request Body

```json
{
  "batchName": "Weekend Batch",
  "course": {
    "id": 1
  },
  "teacher": {
    "id": 1
  }
}
```

#### Get All Offerings

GET /offerings

---

### Session APIs

#### Create Session

POST /sessions

Request Body

```json
{
  "startTime": "2026-06-07T18:00:00",
  "endTime": "2026-06-07T19:00:00",
  "offering": {
    "id": 1
  }
}
```

#### Get All Sessions

GET /sessions

#### Get Sessions in Parent Timezone

GET /sessions/parent/{parentId}

---

### Booking APIs

#### Create Booking

POST /bookings

Request Body

```json
{
  "parent": {
    "id": 1
  },
  "offering": {
    "id": 1
  }
}
```

#### Get All Bookings

GET /bookings

---

## 6. Database Schema Overview

### Course

| Column |
| ------ |
| id     |
| name   |

### Teacher

| Column   |
| -------- |
| id       |
| name     |
| timezone |

### Parent

| Column   |
| -------- |
| id       |
| name     |
| timezone |

### Offering

| Column     |
| ---------- |
| id         |
| batch_name |
| course_id  |
| teacher_id |

### Session

| Column      |
| ----------- |
| id          |
| start_time  |
| end_time    |
| offering_id |

### Booking

| Column      |
| ----------- |
| id          |
| parent_id   |
| offering_id |

### Relationships

* One Course → Many Offerings
* One Teacher → Many Offerings
* One Offering → Many Sessions
* One Parent → Many Bookings
* One Booking → One Offering

---

## 7. Assumptions Made

* A parent can book multiple offerings.
* Multiple parents can book the same offering.
* A parent cannot book offerings that contain overlapping session timings.
* Teacher and parent timezones are stored using valid IANA timezone identifiers (e.g., Asia/Kolkata, America/New_York).
* Session timings are created by teachers and displayed to parents in their local timezone.

---

## 8. Concurrency Handling Approach

To handle simultaneous booking requests, the booking creation process is protected using:

```java
@Transactional
public synchronized Booking saveBooking(...)
```

This ensures:

* Only one booking request is processed at a time.
* Race conditions are avoided.
* Conflict checks are performed on the latest booking data.
* Data consistency is maintained during concurrent requests.

---

## 9. Timezone Handling Approach

The application supports users in different geographical regions.

### Implementation

* Teachers store their timezone.
* Parents store their timezone.
* Session timings are created in the teacher's timezone.
* When parents view sessions, timings are converted into the parent's timezone using Java Time API.

### Technologies Used

* ZoneId
* ZonedDateTime

### Example

Teacher Timezone:

```text
Asia/Kolkata
```

Parent Timezone:

```text
America/New_York
```

Session Time:

```text
18:00 IST
```

Converted Time:

```text
08:30 EDT
```

---

## 10. Steps to Run the Application Locally

### Step 1

Install:

* Java 17
* Maven
* MySQL

### Step 2

Create Database:

```sql
CREATE DATABASE classbooking;
```

### Step 3

Configure application.properties

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/classbooking
spring.datasource.username=root
spring.datasource.password=your_password
```

### Step 4

Build Project

```bash
mvn clean install
```

### Step 5

Run Spring Boot Application

```bash
mvn spring-boot:run
```

### Step 6

Test APIs using Postman

Example:

```http
POST http://localhost:8080/courses
GET http://localhost:8080/courses
POST http://localhost:8080/bookings
GET http://localhost:8080/sessions/parent/1
```

The application will be available at:

```text
http://localhost:8080
```
