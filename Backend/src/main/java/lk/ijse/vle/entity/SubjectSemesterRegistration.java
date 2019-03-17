package lk.ijse.vle.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class SubjectSemesterRegistration {
    @Id
    private String subSemRegId;
    @ManyToOne
    private SemesterRegistration semesterRegistration;
    @ManyToOne
    private Subject subject;

    public SubjectSemesterRegistration() {
    }

    public String getSubSemRegId() {
        return subSemRegId;
    }

    public void setSubSemRegId(String subSemRegId) {
        this.subSemRegId = subSemRegId;
    }

    public SemesterRegistration getSemesterRegistration() {
        return semesterRegistration;
    }

    public void setSemesterRegistration(SemesterRegistration semesterRegistration) {
        this.semesterRegistration = semesterRegistration;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "SubjectSemesterRegistration{" +
                "subSemRegId='" + subSemRegId + '\'' +
                ", semesterRegistration=" + semesterRegistration +
                ", subject=" + subject +
                '}';
    }
}
