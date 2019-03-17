package lk.ijse.vle.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Degree {
    @Id
    private String degreeId;
    private String degreeName;
    private String graduationType;
    private double courseFee;
    private int dataIndex;
    @ManyToOne
    private Faculty faculty;

    public Degree() {
    }

    public Degree(String degreeId, String degreeName, String graduationType, double courseFee, int dataIndex, Faculty faculty) {
        this.degreeId = degreeId;
        this.degreeName = degreeName;
        this.graduationType = graduationType;
        this.courseFee = courseFee;
        this.dataIndex = dataIndex;
        this.faculty = faculty;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public double getCourseFee() {
        return courseFee;
    }

    public void setCourseFee(double courseFee) {
        this.courseFee = courseFee;
    }

    public String getDegreeId() {
        return degreeId;
    }

    public void setDegreeId(String degreeId) {
        this.degreeId = degreeId;
    }

    public int getDataIndex() {
        return dataIndex;
    }

    public void setDataIndex(int dataIndex) {
        this.dataIndex = dataIndex;
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

    @Override
    public String toString() {
        return "Degree{" +
                "degreeId='" + degreeId + '\'' +
                ", degreeName='" + degreeName + '\'' +
                ", graduationType='" + graduationType + '\'' +
                ", courseFee=" + courseFee +
                ", dataIndex=" + dataIndex +
                ", faculty=" + faculty +
                '}';
    }
}
