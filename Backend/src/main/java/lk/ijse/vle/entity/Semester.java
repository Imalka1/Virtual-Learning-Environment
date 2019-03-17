package lk.ijse.vle.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Semester {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int semesterId;
    private String semesterName;

    public Semester() {
    }

    public int getSemesterId() {
        return semesterId;
    }

    public void setSemesterId(int semesterId) {
        this.semesterId = semesterId;
    }

    public String getSemesterName() {
        return semesterName;
    }

    public void setSemesterName(String semesterName) {
        this.semesterName = semesterName;
    }

    @Override
    public String toString() {
        return "Semester{" +
                "semesterId=" + semesterId +
                ", semesterName='" + semesterName + '\'' +
                '}';
    }
}
