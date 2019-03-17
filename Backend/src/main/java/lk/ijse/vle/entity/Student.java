package lk.ijse.vle.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {
    @Id
    private String studentID;
    private String title;
    private String nameWithInitials;
    private String fullName;
    private String address;
    private String dateOfBirth;
    private String email;
    private String telephone;
    private String gender;
    private String studentPassword;
    private String profileImage;
    private int dataIndex;

    public Student() {
    }

    public Student(String studentID, String title, String nameWithInitials, String fullName, String address, String dateOfBirth, String email, String telephone, String gender, String studentPassword, String profileImage, int dataIndex) {
        this.studentID = studentID;
        this.title = title;
        this.nameWithInitials = nameWithInitials;
        this.fullName = fullName;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.telephone = telephone;
        this.gender = gender;
        this.studentPassword = studentPassword;
        this.profileImage = profileImage;
        this.dataIndex = dataIndex;
    }

    public int getDataIndex() {
        return dataIndex;
    }

    public void setDataIndex(int dataIndex) {
        this.dataIndex = dataIndex;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNameWithInitials() {
        return nameWithInitials;
    }

    public void setNameWithInitials(String nameWithInitials) {
        this.nameWithInitials = nameWithInitials;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getStudentPassword() {
        return studentPassword;
    }

    public void setStudentPassword(String studentPassword) {
        this.studentPassword = studentPassword;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentID='" + studentID + '\'' +
                ", title='" + title + '\'' +
                ", nameWithInitials='" + nameWithInitials + '\'' +
                ", fullName='" + fullName + '\'' +
                ", address='" + address + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", gender='" + gender + '\'' +
                ", studentPassword='" + studentPassword + '\'' +
                ", profileImage='" + profileImage + '\'' +
                ", dataIndex=" + dataIndex +
                '}';
    }
}
