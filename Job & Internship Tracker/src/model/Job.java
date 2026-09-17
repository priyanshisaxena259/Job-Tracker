package model;

import java.time.LocalDate;
import model.enums.JobType;

public class Job {

    private int jobId;
    private int recruiterId;
    private String title;
    private String description;
    private String location;
    private double salary;
    private JobType jobType;
    private LocalDate deadline;

    // Constructor
    public Job(
            int jobId,
            int recruiterId,
            String title,
            String description,
            String location,
            double salary,
            JobType jobType,
            LocalDate deadline) {

        this.jobId = jobId;
        this.recruiterId = recruiterId;
        this.title = title;
        this.description = description;
        this.location = location;
        this.salary = salary;
        this.jobType = jobType;
        this.deadline = deadline;
    }

    // Getters
    public int getJobId() {
        return jobId;
    }

    public int getRecruiterId() {
        return recruiterId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getLocation() {
        return location;
    }

    public double getSalary() {
        return salary;
    }

    public JobType getJobType() {
        return jobType;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    // Setters
    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setJobType(JobType jobType) {
        this.jobType = jobType;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    // Display job information
    @Override
    public String toString() {

        return "\n===== JOB =====" +
                "\nJob ID      : " + jobId +
                "\nRecruiter ID: " + recruiterId +
                "\nTitle       : " + title +
                "\nDescription : " + description +
                "\nLocation    : " + location +
                "\nSalary      : " + salary +
                "\nJob Type    : " + jobType +
                "\nDeadline    : " + deadline;
    }
}