package lk.ijse.vle.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class SemesterRegistration {
    @Id
    private String semRegId;
    private String semRegName;
    @ManyToOne
    private Registration registration;
    @ManyToOne
    private Semester semester;

    public SemesterRegistration() {
    }

    public String getSemRegId() {
        return semRegId;
    }

    public void setSemRegId(String semRegId) {
        this.semRegId = semRegId;
    }

    public String getSemRegName() {
        return semRegName;
    }

    public void setSemRegName(String semRegName) {
        this.semRegName = semRegName;
    }

    public Registration getRegistration() {
        return registration;
    }

    public void setRegistration(Registration registration) {
        this.registration = registration;
    }

    public Semester getSemester() {
        return semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }

    @Override
    public String toString() {
        return "SemesterRegistration{" +
                "semRegId='" + semRegId + '\'' +
                ", semRegName='" + semRegName + '\'' +
                ", registration=" + registration +
                ", semester=" + semester +
                '}';
    }
}
