package model;

public class Candidate extends User {

    private String skills;
    private String education;
    private String experience;

    // Constructor
    public Candidate(
            int userId,
            String name,
            String email,
            String phone,
            String skills,
            String education,
            String experience) {

        super(userId, name, email, phone);

        this.skills = skills;
        this.education = education;
        this.experience = experience;
    }

    // Getters
    public String getSkills() {
        return skills;
    }

    public String getEducation() {
        return education;
    }

    public String getExperience() {
        return experience;
    }

    // Setters
    public void setSkills(String skills) {
        this.skills = skills;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    // Method overriding
    @Override
    public void displayProfile() {

        System.out.println("\n===== CANDIDATE PROFILE =====");

        displayBasicInfo();

        System.out.println("Skills     : " + skills);
        System.out.println("Education  : " + education);
        System.out.println("Experience : " + experience);
    }
}