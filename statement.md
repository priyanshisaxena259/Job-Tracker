# Job-Tracker – Project Statement

## 1. Project Title

**Job-Tracker – Job and Application Tracking System**

---

## 2. Problem Statement

Managing job opportunities and keeping track of job applications manually can become difficult when a candidate applies to multiple positions.

It can be challenging to remember:

- Which jobs have been applied for
- Application status
- Interview schedules
- Job details and deadlines
- Overall application progress

The Job-Tracker system provides a simple console-based solution for organizing this information in one place.

---

## 3. Project Objective

The objective of this project is to develop a Java-based application that can:

1. Store and manage job information.
2. Search and retrieve job records.
3. Track job applications.
4. Update application statuses.
5. Schedule and view interviews.
6. Generate application statistics.
7. Store information using file handling.
8. Demonstrate important Core Java concepts.

---

## 4. Scope of the Project

The system focuses on basic job and application management.

The major modules are:

### Job Management

Users can:

- Add jobs
- View all jobs
- Search jobs
- Find jobs using their ID
- Update job information
- Delete jobs

### Application Management

Users can:

- Create job applications
- View applications
- Find applications by ID
- Update application status
- Delete applications

### Interview Management

Users can:

- Schedule interviews
- Store interview date and time
- Store interview type
- Store meeting links
- View scheduled interviews

### Report Management

The system can:

- Display application statistics
- Count selected applications
- Count rejected applications
- Count interview-stage applications
- Generate a text-based report

---

## 5. Technologies Used

The project is developed using:

- Java
- VS Code
- Java Collections Framework
- Java I/O
- Exception Handling
- Multithreading
- Interfaces
- Enums

The project uses local text files for data storage and does not require an external database.

---

## 6. Object-Oriented Programming Concepts

The project demonstrates the following OOP concepts:

### Encapsulation

Class variables are declared private and accessed through getters and setters.

### Inheritance

The `Candidate` and `Recruiter` classes inherit from the `User` class.

### Abstraction

`User` is an abstract class containing the abstract method `displayProfile()`.

### Method Overriding

`Candidate` and `Recruiter` provide their own implementations of `displayProfile()`.

### Polymorphism

Overridden methods allow different subclasses of `User` to provide different implementations of the same method.

### Interface

The `Trackable` interface defines the `displayStatus()` method, which is implemented by the `Application` class.

### Enums

The project uses:

- `JobType`
- `ApplicationStatus`

to represent predefined values.

---

## 7. Exception Handling

Custom exceptions are used to handle invalid operations.

The project contains:

- `JobNotFoundException`
- `ApplicationNotFoundException`

These exceptions are used when a requested job or application cannot be found.

---

## 8. File Handling

The project uses Java I/O to store data locally.

The `FileManager` class handles operations such as:

- Creating folders
- Writing data
- Appending data
- Reading data
- Deleting files
- Generating reports

The main data files are:

```text
data/jobs.txt
data/applications.txt
data/interviews.txt
