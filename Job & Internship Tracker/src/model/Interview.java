package model;

import java.time.LocalDateTime;

public class Interview {

    private int interviewId;
    private int applicationId;
    private LocalDateTime interviewDate;
    private String interviewType;
    private String meetingLink;

    // Constructor
    public Interview(
            int interviewId,
            int applicationId,
            LocalDateTime interviewDate,
            String interviewType,
            String meetingLink) {

        this.interviewId = interviewId;
        this.applicationId = applicationId;
        this.interviewDate = interviewDate;
        this.interviewType = interviewType;
        this.meetingLink = meetingLink;
    }

    // Getters
    public int getInterviewId() {
        return interviewId;
    }

    public int getApplicationId() {
        return applicationId;
    }

    public LocalDateTime getInterviewDate() {
        return interviewDate;
    }

    public String getInterviewType() {
        return interviewType;
    }

    public String getMeetingLink() {
        return meetingLink;
    }

    // Setters
    public void setInterviewDate(LocalDateTime interviewDate) {
        this.interviewDate = interviewDate;
    }

    public void setInterviewType(String interviewType) {
        this.interviewType = interviewType;
    }

    public void setMeetingLink(String meetingLink) {
        this.meetingLink = meetingLink;
    }

    // Display interview
    @Override
    public String toString() {

        return "\n===== INTERVIEW =====" +
                "\nInterview ID  : " + interviewId +
                "\nApplication ID: " + applicationId +
                "\nDate & Time   : " + interviewDate +
                "\nType          : " + interviewType +
                "\nMeeting Link  : " + meetingLink;
    }
}