package lk.ijse.vle.dto;

public class RegistrationDTO {
    private String registrationId;
    private StudentDTO student;
    private DegreeDTO degree;
    private IntakeDTO intake;
    private String date;

    public RegistrationDTO() {
    }

    public RegistrationDTO(String registrationId, StudentDTO student, DegreeDTO degree, IntakeDTO intake, String date) {
        this.registrationId = registrationId;
        this.student = student;
        this.degree = degree;
        this.intake = intake;
        this.date = date;
    }

    public String getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(String registrationId) {
        this.registrationId = registrationId;
    }

    public StudentDTO getStudent() {
        return student;
    }

    public void setStudent(StudentDTO student) {
        this.student = student;
    }

    public DegreeDTO getDegree() {
        return degree;
    }

    public void setDegree(DegreeDTO degree) {
        this.degree = degree;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public IntakeDTO getIntake() {
        return intake;
    }

    public void setIntake(IntakeDTO intake) {
        this.intake = intake;
    }
}
