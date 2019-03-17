package lk.ijse.vle.entity;

import javax.persistence.*;

@Entity
public class UndergraduateDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int undergraduateId;
    @OneToOne
    private Registration registration;
    private String alResults;
    private String yearAl;
    private String zscore;
    private String school;
    private int dataIndex;

    public UndergraduateDetails() {
    }

    public UndergraduateDetails(Registration registration, String alResults, String yearAl, String zscore, String school, int dataIndex) {
        this.registration = registration;
        this.alResults = alResults;
        this.yearAl = yearAl;
        this.zscore = zscore;
        this.school = school;
        this.dataIndex = dataIndex;
    }

    public int getDataIndex() {
        return dataIndex;
    }

    public void setDataIndex(int dataIndex) {
        this.dataIndex = dataIndex;
    }

    public int getUndergraduateId() {
        return undergraduateId;
    }

    public void setUndergraduateId(int undergraduateId) {
        this.undergraduateId = undergraduateId;
    }

    public Registration getRegistration() {
        return registration;
    }

    public void setRegistration(Registration registration) {
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

    @Override
    public String toString() {
        return "UndergraduateDetails{" +
                "undergraduateId=" + undergraduateId +
                ", registration=" + registration +
                ", alResults='" + alResults + '\'' +
                ", yearAl='" + yearAl + '\'' +
                ", zscore='" + zscore + '\'' +
                ", school='" + school + '\'' +
                ", dataIndex=" + dataIndex +
                '}';
    }
}
