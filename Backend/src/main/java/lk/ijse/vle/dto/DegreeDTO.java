package lk.ijse.vle.dto;

public class DegreeDTO {
    private FacultyDTO faculty;
    private String degreeName;
    private String graduationType;
    private double courseFee;

    public DegreeDTO() {
    }

    public DegreeDTO(FacultyDTO faculty, String degreeName, String graduationType, double courseFee) {
        this.faculty = faculty;
        this.degreeName = degreeName;
        this.graduationType = graduationType;
        this.courseFee = courseFee;
    }

    public FacultyDTO getFaculty() {
        return faculty;
    }

    public void setFaculty(FacultyDTO faculty) {
        this.faculty = faculty;
    }

    public double getCourseFee() {
        return courseFee;
    }

    public void setCourseFee(double courseFee) {
        this.courseFee = courseFee;
    }

    public String getDegreeName() {
        return degreeName;
    }

    public void setDegreeName(String degreeName) {
        this.degreeName = degreeName;
    }

    public String getGraduationType() {
        return graduationType;
    }

    public void setGraduationType(String graduationType) {
        this.graduationType = graduationType;
    }
}
