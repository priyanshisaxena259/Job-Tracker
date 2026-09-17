# Job-Tracker – Job & Application Tracking System

## 1. Project Overview

Job-Tracker is a console-based Java application developed to manage job opportunities, job applications and interviews.

The system allows users to add, view, search, update and delete job records. It also provides application tracking, interview scheduling, statistics and report generation.

The project is developed using Core Java and demonstrates Object-Oriented Programming, exception handling, collections, file handling, interfaces, enums and multithreading.

---

## 2. Objectives

The main objectives of the project are:

- To manage job postings efficiently.
- To maintain job application records.
- To track application statuses.
- To schedule and view interviews.
- To search jobs using keywords.
- To generate application statistics.
- To store data using file handling.
- To demonstrate important Core Java concepts.

---

## 3. Features

### Job Management

- Add a new job
- View all jobs
- Search jobs by title or location
- Find a job using its ID
- Update job details
- Delete a job

### Application Management

- Apply for a job
- View all applications
- Find an application using its ID
- Update application status
- Delete an application

### Interview Management

- Schedule interviews
- View scheduled interviews
- Store interview date and time
- Store interview type and meeting link

### Reports

- Display job and application statistics
- Count selected, rejected, and interview-stage applications
- Generate a text report

---

## 4. Technologies Used

- Java
- Object-Oriented Programming
- Java Collections Framework
- File Handling
- Exception Handling
- Multithreading
- Interfaces
- Enums
- VS Code

---

## 5. Project Structure

```text
JobTracker/
│
├── src/
│   ├── Main.java
│   │
│   ├── model/
│   │   ├── User.java
│   │   ├── Candidate.java
│   │   ├── Recruiter.java
│   │   ├── Job.java
│   │   ├── Application.java
│   │   ├── Interview.java
│   │   ├── Trackable.java
│   │   │
│   │   └── enums/
│   │       ├── JobType.java
│   │       └── ApplicationStatus.java
│   │
│   ├── service/
│   │   ├── JobService.java
│   │   ├── ApplicationService.java
│   │   └── ReportService.java
│   │
│   ├── exception/
│   │   ├── JobNotFoundException.java
│   │   └── ApplicationNotFoundException.java
│   │
│   └── util/
│       └── FileManager.java
│
├── data/
│   ├── jobs.txt
│   ├── applications.txt
│   └── interviews.txt
│
├── reports/
│   └── jobtracker_report.txt
│
├── README.md
└── statement.md
