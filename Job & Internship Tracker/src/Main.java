import model.Application;
import model.Job;
import model.Interview;
import model.enums.ApplicationStatus;
import model.enums.JobType;
import service.ApplicationService;
import service.JobService;
import service.ReportService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner =
            new Scanner(System.in);

    private static final JobService jobService =
            new JobService();

    private static final ApplicationService applicationService =
            new ApplicationService();

    private static final ReportService reportService =
            new ReportService(
                    jobService,
                    applicationService
            );

    public static void main(String[] args) {

        System.out.println(
                "\n================================"
        );

        System.out.println(
                "       JOB TRACKER SYSTEM"
        );

        System.out.println(
                "================================"
        );

        boolean running = true;

        while (running) {

            displayMainMenu();

            int choice = readInt("Enter your choice: ");

            switch (choice) {

                case 1:
                    jobMenu();
                    break;

                case 2:
                    applicationMenu();
                    break;

                case 3:
                    interviewMenu();
                    break;

                case 4:
                    reportMenu();
                    break;

                case 0:
                    running = false;
                    System.out.println(
                            "\nThank you for using JobTracker!"
                    );
                    break;

                default:
                    System.out.println(
                            "Invalid choice. Try again."
                    );
            }
        }

        scanner.close();
    }

    // =====================================
    // MAIN MENU
    // =====================================

    private static void displayMainMenu() {

        System.out.println(
                "\n========== MAIN MENU =========="
        );

        System.out.println(
                "1. Job Management"
        );

        System.out.println(
                "2. Application Management"
        );

        System.out.println(
                "3. Interview Management"
        );

        System.out.println(
                "4. Reports"
        );

        System.out.println(
                "0. Exit"
        );
    }

    // =====================================
    // JOB MENU
    // =====================================

    private static void jobMenu() {

        boolean back = false;

        while (!back) {

            System.out.println(
                    "\n========== JOB MANAGEMENT =========="
            );

            System.out.println("1. Add Job");
            System.out.println("2. View All Jobs");
            System.out.println("3. Search Job");
            System.out.println("4. Find Job by ID");
            System.out.println("5. Update Job");
            System.out.println("6. Delete Job");
            System.out.println("0. Back");

            int choice =
                    readInt("Enter your choice: ");

            switch (choice) {

                case 1:
                    addJob();
                    break;

                case 2:
                    jobService.viewAllJobs();
                    break;

                case 3:
                    searchJob();
                    break;

                case 4:
                    findJob();
                    break;

                case 5:
                    updateJob();
                    break;

                case 6:
                    deleteJob();
                    break;

                case 0:
                    back = true;
                    break;

                default:
                    System.out.println(
                            "Invalid choice."
                    );
            }
        }
    }

    // =====================================
    // ADD JOB
    // =====================================

    private static void addJob() {

        System.out.println(
                "\n========== ADD JOB =========="
        );

        int jobId =
                readInt("Enter Job ID: ");

        int recruiterId =
                readInt("Enter Recruiter ID: ");

        String title =
                readString("Enter Job Title: ");

        String description =
                readString("Enter Description: ");

        String location =
                readString("Enter Location: ");

        double salary =
                readDouble("Enter Salary: ");

        JobType jobType =
                chooseJobType();

        LocalDate deadline =
                readDate("Enter Deadline (YYYY-MM-DD): ");

        Job job = new Job(
                jobId,
                recruiterId,
                title,
                description,
                location,
                salary,
                jobType,
                deadline
        );

        jobService.addJob(job);
    }

    // =====================================
    // CHOOSE JOB TYPE
    // =====================================

    private static JobType chooseJobType() {

        System.out.println("\nSelect Job Type:");

        JobType[] types =
                JobType.values();

        for (int i = 0; i < types.length; i++) {

            System.out.println(
                    (i + 1) + ". " + types[i]
            );
        }

        int choice =
                readInt("Enter choice: ");

        if (choice < 1 ||
                choice > types.length) {

            System.out.println(
                    "Invalid choice. FULL_TIME selected."
            );

            return JobType.FULL_TIME;
        }

        return types[choice - 1];
    }

    // =====================================
    // SEARCH JOB
    // =====================================

    private static void searchJob() {

        String keyword =
                readString("Enter title/location: ");

        jobService.searchJobs(keyword);
    }

    // =====================================
    // FIND JOB
    // =====================================

    private static void findJob() {

        int id =
                readInt("Enter Job ID: ");

        try {

            Job job =
                    jobService.getJobById(id);

            System.out.println(job);

        } catch (Exception e) {

            System.out.println(
                    e.getMessage()
            );
        }
    }

    // =====================================
    // UPDATE JOB
    // =====================================

    private static void updateJob() {

        int id =
                readInt("Enter Job ID to update: ");

        try {

            Job oldJob =
                    jobService.getJobById(id);

            System.out.println(
                    "\nCurrent Job:"
            );

            System.out.println(oldJob);

            String title =
                    readString("New Title: ");

            String description =
                    readString("New Description: ");

            String location =
                    readString("New Location: ");

            double salary =
                    readDouble("New Salary: ");

            JobType jobType =
                    chooseJobType();

            LocalDate deadline =
                    readDate("New Deadline (YYYY-MM-DD): ");

            Job updatedJob =
                    new Job(
                            id,
                            oldJob.getRecruiterId(),
                            title,
                            description,
                            location,
                            salary,
                            jobType,
                            deadline
                    );

            jobService.updateJob(updatedJob);

        } catch (Exception e) {

            System.out.println(
                    e.getMessage()
            );
        }
    }

    // =====================================
    // DELETE JOB
    // =====================================

    private static void deleteJob() {

        int id =
                readInt("Enter Job ID to delete: ");

        try {

            jobService.deleteJob(id);

        } catch (Exception e) {

            System.out.println(
                    e.getMessage()
            );
        }
    }

    // =====================================
    // APPLICATION MENU
    // =====================================

    private static void applicationMenu() {

        boolean back = false;

        while (!back) {

            System.out.println(
                    "\n===== APPLICATION MANAGEMENT ====="
            );

            System.out.println("1. Apply for Job");
            System.out.println("2. View Applications");
            System.out.println("3. Find Application");
            System.out.println("4. Update Application Status");
            System.out.println("5. Delete Application");
            System.out.println("0. Back");

            int choice =
                    readInt("Enter your choice: ");

            switch (choice) {

                case 1:
                    addApplication();
                    break;

                case 2:
                    applicationService
                            .viewAllApplications();
                    break;

                case 3:
                    findApplication();
                    break;

                case 4:
                    updateApplicationStatus();
                    break;

                case 5:
                    deleteApplication();
                    break;

                case 0:
                    back = true;
                    break;

                default:
                    System.out.println(
                            "Invalid choice."
                    );
            }
        }
    }

    // =====================================
    // ADD APPLICATION
    // =====================================

    private static void addApplication() {

        System.out.println(
                "\n========== APPLY FOR JOB =========="
        );

        int applicationId =
                readInt("Application ID: ");

        int candidateId =
                readInt("Candidate ID: ");

        int jobId =
                readInt("Job ID: ");

        String coverLetter =
                readString("Cover Letter: ");

        Application application =
                new Application(
                        applicationId,
                        candidateId,
                        jobId,
                        LocalDate.now(),
                        ApplicationStatus.APPLIED,
                        coverLetter
                );

        applicationService
                .addApplication(application);
    }

    // =====================================
    // FIND APPLICATION
    // =====================================

    private static void findApplication() {

        int id =
                readInt("Enter Application ID: ");

        try {

            Application application =
                    applicationService
                            .getApplicationById(id);

            System.out.println(application);

        } catch (Exception e) {

            System.out.println(
                    e.getMessage()
            );
        }
    }

    // =====================================
    // UPDATE APPLICATION STATUS
    // =====================================

    private static void updateApplicationStatus() {

        int id =
                readInt("Application ID: ");

        ApplicationStatus[] statuses =
                ApplicationStatus.values();

        System.out.println(
                "\nSelect new status:"
        );

        for (int i = 0;
             i < statuses.length;
             i++) {

            System.out.println(
                    (i + 1) + ". " + statuses[i]
            );
        }

        int choice =
                readInt("Enter choice: ");

        if (choice < 1 ||
                choice > statuses.length) {

            System.out.println(
                    "Invalid status."
            );

            return;
        }

        ApplicationStatus status =
                statuses[choice - 1];

        try {

            applicationService.updateStatus(
                    id,
                    status
            );

        } catch (Exception e) {

            System.out.println(
                    e.getMessage()
            );
        }
    }

    // =====================================
    // DELETE APPLICATION
    // =====================================

    private static void deleteApplication() {

        int id =
                readInt("Application ID: ");

        try {

            applicationService
                    .deleteApplication(id);

        } catch (Exception e) {

            System.out.println(
                    e.getMessage()
            );
        }
    }

    // =====================================
    // INTERVIEW MENU
    // =====================================

    private static void interviewMenu() {

        boolean back = false;

        while (!back) {

            System.out.println(
                    "\n===== INTERVIEW MANAGEMENT ====="
            );

            System.out.println("1. Schedule Interview");
            System.out.println("2. View Interviews");
            System.out.println("0. Back");

            int choice =
                    readInt("Enter your choice: ");

            switch (choice) {

                case 1:
                    addInterview();
                    break;

                case 2:
                    applicationService
                            .viewInterviews();
                    break;

                case 0:
                    back = true;
                    break;

                default:
                    System.out.println(
                            "Invalid choice."
                    );
            }
        }
    }

    // =====================================
    // ADD INTERVIEW
    // =====================================

    private static void addInterview() {

        System.out.println(
                "\n========== SCHEDULE INTERVIEW =========="
        );

        int interviewId =
                readInt("Interview ID: ");

        int applicationId =
                readInt("Application ID: ");

        LocalDate date =
                readDate(
                        "Interview Date (YYYY-MM-DD): "
                );

        int hour =
                readInt("Hour (0-23): ");

        int minute =
                readInt("Minute (0-59): ");

        String type =
                readString("Interview Type: ");

        String link =
                readString("Meeting Link: ");

        LocalDateTime dateTime =
                LocalDateTime.of(
                        date.getYear(),
                        date.getMonthValue(),
                        date.getDayOfMonth(),
                        hour,
                        minute
                );

        Interview interview =
                new Interview(
                        interviewId,
                        applicationId,
                        dateTime,
                        type,
                        link
                );

        applicationService
                .addInterview(interview);
    }

    // =====================================
    // REPORT MENU
    // =====================================

    private static void reportMenu() {

        boolean back = false;

        while (!back) {

            System.out.println(
                    "\n========== REPORTS =========="
            );

            System.out.println(
                    "1. View Statistics"
            );

            System.out.println(
                    "2. Generate Report File"
            );

            System.out.println(
                    "0. Back"
            );

            int choice =
                    readInt("Enter your choice: ");

            switch (choice) {

                case 1:
                    reportService
                            .displayStatistics();
                    break;

                case 2:
                    reportService
                            .generateReport();
                    break;

                case 0:
                    back = true;
                    break;

                default:
                    System.out.println(
                            "Invalid choice."
                    );
            }
        }
    }

    // =====================================
    // INPUT METHODS
    // =====================================

    private static int readInt(String message) {

        while (true) {

            try {

                System.out.print(message);

                return Integer.parseInt(
                        scanner.nextLine()
                );

            } catch (NumberFormatException e) {

                System.out.println(
                        "Please enter a valid number."
                );
            }
        }
    }

    private static double readDouble(String message) {

        while (true) {

            try {

                System.out.print(message);

                return Double.parseDouble(
                        scanner.nextLine()
                );

            } catch (NumberFormatException e) {

                System.out.println(
                        "Please enter a valid amount."
                );
            }
        }
    }

    private static String readString(String message) {

        System.out.print(message);

        return scanner.nextLine();
    }

    private static LocalDate readDate(String message) {

        while (true) {

            try {

                System.out.print(message);

                return LocalDate.parse(
                        scanner.nextLine()
                );

            } catch (Exception e) {

                System.out.println(
                        "Please use YYYY-MM-DD format."
                );
            }
        }
    }
}