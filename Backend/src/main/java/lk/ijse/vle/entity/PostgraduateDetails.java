package lk.ijse.vle.entity;

import javax.persistence.*;

@Entity
public class PostgraduateDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int postgraduateId;
    @OneToOne
    private Registration registration;
    private String qualifications;
    private String institute;
    private String year;
    private int dataIndex;

    public PostgraduateDetails() {
    }

    public PostgraduateDetails(Registration registration, String qualifications, String institute, String year, int dataIndex) {
        this.registration = registration;
        this.qualifications = qualifications;
        this.institute = institute;
        this.year = year;
        this.dataIndex = dataIndex;
    }

    public int getDataIndex() {
        return dataIndex;
    }

    public void setDataIndex(int dataIndex) {
        this.dataIndex = dataIndex;
    }

    public int getPostgraduateId() {
        return postgraduateId;
    }

    public void setPostgraduateId(int postgraduateId) {
        this.postgraduateId = postgraduateId;
    }

    public Registration getRegistration() {
        return registration;
    }

    public void setRegistration(Registration registration) {
        this.registration = registration;
    }

    public String getQualifications() {
        return qualifications;
    }

    public void setQualifications(String qualifications) {
        this.qualifications = qualifications;
    }

    public String getInstitute() {
        return institute;
    }

    public void setInstitute(String institute) {
        this.institute = institute;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "PostgraduateDetails{" +
                "postgraduateId=" + postgraduateId +
                ", registration=" + registration +
                ", qualifications='" + qualifications + '\'' +
                ", institute='" + institute + '\'' +
                ", year='" + year + '\'' +
                ", dataIndex=" + dataIndex +
                '}';
    }
}
