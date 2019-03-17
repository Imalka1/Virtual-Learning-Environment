package lk.ijse.vle.dto;

public class FacultyDTO {
    private int facultyId;
    private String facultyName;

    public FacultyDTO() {
    }

    public FacultyDTO(int facultyId, String facultyName) {
        this.facultyId = facultyId;
        this.facultyName = facultyName;
    }

    public int getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(int facultyId) {
        this.facultyId = facultyId;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }
}
