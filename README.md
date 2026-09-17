# Job-Tracker – Job & Application Tracking System

## 1. Overview of the Project

Job-Tracker is a Core Java based console application developed to manage job opportunities, job applications and interview information in an organized manner.

The system allows users to add, view, search, update and delete job records. It also allows users to create and manage job applications, update application statuses, schedule interviews and generate basic application statistics and reports.

The project uses Java file handling for storing data persistently in text files. It demonstrates important Core Java and Object-Oriented Programming concepts through a modular and practical application.

---

## 2. Features

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
- Count selected, rejected and interview-stage applications
- Generate a text report

---

## 3. Technologies / Tools Used

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

## 4. Steps to Install & Run the Project

### Prerequisites

Make sure the following are installed:

- Java JDK 17 or compatible version
- Visual Studio Code
- Java Extension Pack for VS Code

### Step 1: Clone the Repository

Open a terminal and run:
```
git clone https://github.com/priyanshisaxena259/JobTracker.git
```

### Step 2: Navigate to the Project Directory
```
cd Job-Tracker
```
### Step 3: Open the Project in Visual Studio Code
```
code .
```

### Step 4: Compile the Project

Open the VS Code terminal and run:
```
javac -d out src/Main.java src/model/*.java src/model/enums/*.java src/service/*.java src/exception/*.java src/util/*.java
```

### Step 5: Run the Project

After successful compilation, run:
```
java -cp out Main
```
### Step 6: Use the Application

The JobTracker main menu will appear in the terminal:
```
========== JOB TRACKER ==========

1. Job Management
2. Application Management
3. Interview Management
4. Reports
5. Exit
```
Select the required option and follow the instructions displayed by the application.

## Instructions for Testing

1. Run the application using the installation steps above.
2. Test **Job Management**: Add, View, Search, Update, and Delete jobs.
3. Test **Application Management**: Apply, View, Find, Update Status, and Delete applications.
4. Test **Interview Management**: Schedule and View interviews.
5. Test **Reports**: View statistics and generate the report.
6. Test **Error Handling**: Enter an invalid ID and verify that an appropriate error message is displayed.
7. Restart the application and verify that saved data is still available.

All major features should work without unexpected errors.

## Screenshots
<img width="445" height="853" alt="Screenshot 2026-09-17 235109" src="https://github.com/user-attachments/assets/8a36e3a5-a565-43c6-970c-1c9cb1db1870" />

<img width="378" height="868" alt="Screenshot 2026-09-17 235159" src="https://github.com/user-attachments/assets/c4ed1e41-cd23-4781-a869-682c80996c25" />
