package service;

import exception.ApplicationNotFoundException;
import model.Application;
import model.Interview;
import model.enums.ApplicationStatus;
import util.FileManager;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ApplicationService {

    private final FileManager fileManager;

    private final String APPLICATION_FILE = "applications.txt";
    private final String INTERVIEW_FILE = "interviews.txt";

    private ArrayList<Application> applications;
    private ArrayList<Interview> interviews;

    // Constructor
    public ApplicationService() {

        fileManager = new FileManager();

        applications = new ArrayList<>();
        interviews = new ArrayList<>();

        loadApplications();
        loadInterviews();
    }

    // =========================
    // ADD APPLICATION
    // =========================

    public void addApplication(Application application) {

        applications.add(application);

        saveApplications();

        System.out.println("Application added successfully!");
    }

    // =========================
    // VIEW APPLICATIONS
    // =========================

    public void viewAllApplications() {

        if (applications.isEmpty()) {

            System.out.println("No applications available.");

            return;
        }

        System.out.println("\n========== ALL APPLICATIONS ==========");

        for (Application application : applications) {

            System.out.println(application);
        }
    }

    // =========================
    // FIND APPLICATION
    // =========================

    public Application getApplicationById(int id)
            throws ApplicationNotFoundException {

        for (Application application : applications) {

            if (application.getApplicationId() == id) {

                return application;
            }
        }

        throw new ApplicationNotFoundException(
                "Application with ID " + id + " was not found."
        );
    }

    // =========================
    // UPDATE STATUS
    // =========================

    public void updateStatus(
            int applicationId,
            ApplicationStatus newStatus)
            throws ApplicationNotFoundException {

        Application application =
                getApplicationById(applicationId);

        application.setStatus(newStatus);

        saveApplications();

        System.out.println(
                "Application status updated successfully!"
        );
    }

    // =========================
    // DELETE APPLICATION
    // =========================

    public void deleteApplication(int id)
            throws ApplicationNotFoundException {

        Application application =
                getApplicationById(id);

        applications.remove(application);

        saveApplications();

        System.out.println(
                "Application deleted successfully!"
        );
    }

    // =========================
    // ADD INTERVIEW
    // =========================

    public void addInterview(Interview interview) {

        interviews.add(interview);

        saveInterviews();

        System.out.println(
                "Interview scheduled successfully!"
        );
    }

    // =========================
    // VIEW INTERVIEWS
    // =========================

    public void viewInterviews() {

        if (interviews.isEmpty()) {

            System.out.println("No interviews scheduled.");

            return;
        }

        System.out.println("\n========== INTERVIEWS ==========");

        for (Interview interview : interviews) {

            System.out.println(interview);
        }
    }

    // =========================
    // SAVE APPLICATIONS
    // =========================

    private void saveApplications() {

        StringBuilder data = new StringBuilder();

        for (Application application : applications) {

            data.append(application.getApplicationId())
                    .append("|");

            data.append(application.getCandidateId())
                    .append("|");

            data.append(application.getJobId())
                    .append("|");

            data.append(application.getApplicationDate())
                    .append("|");

            data.append(application.getStatus())
                    .append("|");

            data.append(application.getCoverLetter())
                    .append("\n");
        }

        fileManager.saveData(
                APPLICATION_FILE,
                data.toString()
        );
    }

    // =========================
    // LOAD APPLICATIONS
    // =========================

    private void loadApplications() {

        List<String> lines =
                fileManager.readData(APPLICATION_FILE);

        for (String line : lines) {

            try {

                String[] parts = line.split("\\|");

                if (parts.length != 6) {
                    continue;
                }

                int applicationId =
                        Integer.parseInt(parts[0]);

                int candidateId =
                        Integer.parseInt(parts[1]);

                int jobId =
                        Integer.parseInt(parts[2]);

                LocalDate applicationDate =
                        LocalDate.parse(parts[3]);

                ApplicationStatus status =
                        ApplicationStatus.valueOf(parts[4]);

                String coverLetter =
                        parts[5];

                Application application =
                        new Application(
                                applicationId,
                                candidateId,
                                jobId,
                                applicationDate,
                                status,
                                coverLetter
                        );

                applications.add(application);

            } catch (Exception e) {

                System.out.println(
                        "Could not load an application from file."
                );
            }
        }
    }

    // =========================
    // SAVE INTERVIEWS
    // =========================

    private void saveInterviews() {

        StringBuilder data = new StringBuilder();

        for (Interview interview : interviews) {

            data.append(interview.getInterviewId())
                    .append("|");

            data.append(interview.getApplicationId())
                    .append("|");

            data.append(interview.getInterviewDate())
                    .append("|");

            data.append(interview.getInterviewType())
                    .append("|");

            data.append(interview.getMeetingLink())
                    .append("\n");
        }

        fileManager.saveData(
                INTERVIEW_FILE,
                data.toString()
        );
    }

    // =========================
    // LOAD INTERVIEWS
    // =========================

    private void loadInterviews() {

        List<String> lines =
                fileManager.readData(INTERVIEW_FILE);

        for (String line : lines) {

            try {

                String[] parts = line.split("\\|");

                if (parts.length != 5) {
                    continue;
                }

                int interviewId =
                        Integer.parseInt(parts[0]);

                int applicationId =
                        Integer.parseInt(parts[1]);

                LocalDateTime interviewDate =
                        LocalDateTime.parse(parts[2]);

                String interviewType =
                        parts[3];

                String meetingLink =
                        parts[4];

                Interview interview =
                        new Interview(
                                interviewId,
                                applicationId,
                                interviewDate,
                                interviewType,
                                meetingLink
                        );

                interviews.add(interview);

            } catch (Exception e) {

                System.out.println(
                        "Could not load an interview from file."
                );
            }
        }
    }

    // =========================
    // GET APPLICATIONS
    // =========================

    public ArrayList<Application> getApplications() {

        return applications;
    }
}