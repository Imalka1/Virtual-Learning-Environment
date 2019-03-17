package lk.ijse.vle.dto;

public class UndergraduateDetailsDTO {
    private RegistrationDTO registration;
    private String alResults;
    private String yearAl;
    private String zscore;
    private String school;

    public UndergraduateDetailsDTO() {
    }

    public UndergraduateDetailsDTO(RegistrationDTO registration, String alResults, String yearAl, String zscore, String school) {
        this.registration = registration;
        this.alResults = alResults;
        this.yearAl = yearAl;
        this.zscore = zscore;
        this.school = school;
    }

    public RegistrationDTO getRegistration() {
        return registration;
    }

    public void setRegistration(RegistrationDTO registration) {
        this.registration = registration;
    }

    public String getAlResults() {
        return alResults;
    }

    public void setAlResults(String alResults) {
        this.alResults = alResults;
    }

    public String getYearAl() {
        return yearAl;
    }

    public void setYearAl(String yearAl) {
        this.yearAl = yearAl;
    }

    public String getZscore() {
        return zscore;
    }

    public void setZscore(String zscore) {
        this.zscore = zscore;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }
}
