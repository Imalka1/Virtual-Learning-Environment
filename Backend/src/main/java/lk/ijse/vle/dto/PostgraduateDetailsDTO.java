package lk.ijse.vle.dto;

public class PostgraduateDetailsDTO {
    private RegistrationDTO registration;
    private String qualifications;
    private String institute;
    private String year;

    public PostgraduateDetailsDTO() {
    }

    public PostgraduateDetailsDTO(RegistrationDTO registration, String qualifications, String institute, String year) {
        this.registration = registration;
        this.qualifications = qualifications;
        this.institute = institute;
        this.year = year;
    }

    public RegistrationDTO getRegistration() {
        return registration;
    }

    public void setRegistration(RegistrationDTO registration) {
        this.registration = registration;
    }

    public String getQualifications() {
        return qualifications;
    }

    public void setQualifications(String qualifications) {
        this.qualifications = qualifications;
    }

    public String getInstitute() {
        return institute;
    }

    public void setInstitute(String institute) {
        this.institute = institute;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
