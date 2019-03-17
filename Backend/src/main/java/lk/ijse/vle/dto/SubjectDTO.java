package lk.ijse.vle.dto;

public class SubjectDTO {
    private String subjectId;
    private String subjectName;
    private SubjectSemesterRegistrationDTO subjectSemesterRegistration;
    private DegreeDTO degree;
    private LecturerDTO lecturer;
    private SemesterDTO semester;

    public SubjectDTO() {
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public SubjectSemesterRegistrationDTO getSubjectSemesterRegistration() {
        return subjectSemesterRegistration;
    }

    public void setSubjectSemesterRegistration(SubjectSemesterRegistrationDTO subjectSemesterRegistration) {
        this.subjectSemesterRegistration = subjectSemesterRegistration;
    }

    public DegreeDTO getDegree() {
        return degree;
    }

    public void setDegree(DegreeDTO degree) {
        this.degree = degree;
    }

    public LecturerDTO getLecturer() {
        return lecturer;
    }

    public void setLecturer(LecturerDTO lecturer) {
        this.lecturer = lecturer;
    }

    public SemesterDTO getSemester() {
        return semester;
    }

    public void setSemester(SemesterDTO semester) {
        this.semester = semester;
    }

    @Override
    public String toString() {
        return "SubjectDTO{" +
                "subjectId='" + subjectId + '\'' +
                ", subjectName='" + subjectName + '\'' +
                ", subjectSemesterRegistration=" + subjectSemesterRegistration +
                ", degree=" + degree +
                ", lecturer=" + lecturer +
                ", semester=" + semester +
                '}';
    }
}
