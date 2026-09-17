package service;

import model.Application;
import model.Job;
import model.enums.ApplicationStatus;
import util.FileManager;

import java.util.List;

public class ReportService {

    private final JobService jobService;
    private final ApplicationService applicationService;
    private final FileManager fileManager;

    // Constructor
    public ReportService(
            JobService jobService,
            ApplicationService applicationService) {

        this.jobService = jobService;
        this.applicationService = applicationService;
        this.fileManager = new FileManager();
    }

    // =========================
    // DISPLAY STATISTICS
    // =========================

    public void displayStatistics() {

        List<Job> jobs =
                jobService.getJobs();

        List<Application> applications =
                applicationService.getApplications();

        int selected = 0;
        int rejected = 0;
        int interviews = 0;

        for (Application application : applications) {

            if (application.getStatus()
                    == ApplicationStatus.SELECTED) {

                selected++;
            }

            if (application.getStatus()
                    == ApplicationStatus.REJECTED) {

                rejected++;
            }

            if (application.getStatus()
                    == ApplicationStatus.INTERVIEW) {

                interviews++;
            }
        }

        System.out.println("\n========== STATISTICS ==========");

        System.out.println(
                "Total Jobs         : " + jobs.size()
        );

        System.out.println(
                "Total Applications : " + applications.size()
        );

        System.out.println(
                "Selected           : " + selected
        );

        System.out.println(
                "Rejected           : " + rejected
        );

        System.out.println(
                "Interviews         : " + interviews
        );
    }

    // =========================
    // GENERATE REPORT
    // =========================

    public void generateReport() {

        Thread reportThread = new Thread(() -> {

            String report = createReport();

            fileManager.saveReport(
                    "jobtracker_report.txt",
                    report
            );

        });

        reportThread.start();

        try {

            reportThread.join();

        } catch (InterruptedException e) {

            Thread.currentThread().interrupt();

            System.out.println(
                    "Report generation interrupted."
            );
        }
    }

    // =========================
    // CREATE REPORT CONTENT
    // =========================

    private String createReport() {

        List<Job> jobs =
                jobService.getJobs();

        List<Application> applications =
                applicationService.getApplications();

        int selected = 0;
        int rejected = 0;
        int interviews = 0;

        for (Application application : applications) {

            if (application.getStatus()
                    == ApplicationStatus.SELECTED) {

                selected++;
            }

            if (application.getStatus()
                    == ApplicationStatus.REJECTED) {

                rejected++;
            }

            if (application.getStatus()
                    == ApplicationStatus.INTERVIEW) {

                interviews++;
            }
        }

        StringBuilder report =
                new StringBuilder();

        report.append("==============================\n");
        report.append("       JOB TRACKER REPORT\n");
        report.append("==============================\n\n");

        report.append("Total Jobs         : ")
                .append(jobs.size())
                .append("\n");

        report.append("Total Applications : ")
                .append(applications.size())
                .append("\n");

        report.append("Selected           : ")
                .append(selected)
                .append("\n");

        report.append("Rejected           : ")
                .append(rejected)
                .append("\n");

        report.append("Interviews         : ")
                .append(interviews)
                .append("\n\n");

        report.append("==============================\n");
        report.append("           JOBS\n");
        report.append("==============================\n");

        for (Job job : jobs) {

            report.append("\n")
                    .append(job)
                    .append("\n");
        }

        report.append("\n==============================\n");
        report.append("       APPLICATIONS\n");
        report.append("==============================\n");

        for (Application application : applications) {

            report.append("\n")
                    .append(application)
                    .append("\n");
        }

        return report.toString();
    }
}