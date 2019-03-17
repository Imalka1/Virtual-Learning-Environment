package lk.ijse.vle.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Registration {
    @Id
    private String registrationId;
    @ManyToOne
    private Student student;
    @ManyToOne
    private Degree degree;
    @ManyToOne
    private Intake intake;
    private String date;

    public Registration() {
    }

    public Registration(String registrationId, Student student, Degree degree, Intake intake, String date) {
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

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    public Intake getIntake() {
        return intake;
    }

    public void setIntake(Intake intake) {
        this.intake = intake;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Registration{" +
                "registrationId='" + registrationId + '\'' +
                ", student=" + student +
                ", degree=" + degree +
                ", intake=" + intake +
                ", date='" + date + '\'' +
                '}';
    }
}
