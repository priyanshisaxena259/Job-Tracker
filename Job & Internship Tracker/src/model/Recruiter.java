package model;

public class Recruiter extends User {

    private String companyName;
    private String companyEmail;

    // Constructor
    public Recruiter(
            int userId,
            String name,
            String email,
            String phone,
            String companyName,
            String companyEmail) {

        super(userId, name, email, phone);

        this.companyName = companyName;
        this.companyEmail = companyEmail;
    }

    // Getters
    public String getCompanyName() {
        return companyName;
    }

    public String getCompanyEmail() {
        return companyEmail;
    }

    // Setters
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setCompanyEmail(String companyEmail) {
        this.companyEmail = companyEmail;
    }

    // Method overriding
    @Override
    public void displayProfile() {

        System.out.println("\n===== RECRUITER PROFILE =====");

        displayBasicInfo();

        System.out.println("Company       : " + companyName);
        System.out.println("Company Email : " + companyEmail);
    }
}