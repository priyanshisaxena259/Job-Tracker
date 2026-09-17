package model;

import java.time.LocalDate;
import model.enums.ApplicationStatus;

public class Application implements Trackable{

    private int applicationId;
    private int candidateId;
    private int jobId;
    private LocalDate applicationDate;
    private ApplicationStatus status;
    private String coverLetter;

    // Constructor
    public Application(
            int applicationId,
            int candidateId,
            int jobId,
            LocalDate applicationDate,
            ApplicationStatus status,
            String coverLetter) {

        this.applicationId = applicationId;
        this.candidateId = candidateId;
        this.jobId = jobId;
        this.applicationDate = applicationDate;
        this.status = status;
        this.coverLetter = coverLetter;
    }

    // Getters
    public int getApplicationId() {
        return applicationId;
    }

    public int getCandidateId() {
        return candidateId;
    }

    public int getJobId() {
        return jobId;
    }

    public LocalDate getApplicationDate() {
        return applicationDate;
    }

    public ApplicationStatus getStatus() {
        return status;
    }

    public String getCoverLetter() {
        return coverLetter;
    }

    // Setters
    public void setStatus(ApplicationStatus status) {
        this.status = status;
    }

    public void setCoverLetter(String coverLetter) {
        this.coverLetter = coverLetter;
    }

    // Display application
    @Override
    public String toString() {

        return "\n===== APPLICATION =====" +
                "\nApplication ID : " + applicationId +
                "\nCandidate ID   : " + candidateId +
                "\nJob ID         : " + jobId +
                "\nApplication Date: " + applicationDate +
                "\nStatus         : " + status +
                "\nCover Letter   : " + coverLetter;
    }
@Override
public void displayStatus() {

    System.out.println(
            "Application " + applicationId +
            " status: " + status
    );
}

}