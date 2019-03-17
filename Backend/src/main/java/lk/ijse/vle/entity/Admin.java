package lk.ijse.vle.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Admin {
    @Id
    private String adminID;
    private String title;
    private String nameWithInitials;
    private String fullName;
    private String address;
    private String dateOfBirth;
    private String email;
    private String telephone;
    private String gender;
    private String adminPassword;
    private String profileImage;
    private int dataIndex;

    public Admin() {
    }

    public Admin(String adminID, String title, String nameWithInitials, String fullName, String address, String dateOfBirth, String email, String telephone, String gender, String adminPassword, String profileImage, int dataIndex) {
        this.adminID = adminID;
        this.title = title;
        this.nameWithInitials = nameWithInitials;
        this.fullName = fullName;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.telephone = telephone;
        this.gender = gender;
        this.adminPassword = adminPassword;
        this.profileImage = profileImage;
        this.dataIndex = dataIndex;
    }

    public String getAdminID() {
        return adminID;
    }

    public void setAdminID(String adminID) {
        this.adminID = adminID;
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

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public int getDataIndex() {
        return dataIndex;
    }

    public void setDataIndex(int dataIndex) {
        this.dataIndex = dataIndex;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminID='" + adminID + '\'' +
                ", title='" + title + '\'' +
                ", nameWithInitials='" + nameWithInitials + '\'' +
                ", fullName='" + fullName + '\'' +
                ", address='" + address + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", gender='" + gender + '\'' +
                ", adminPassword='" + adminPassword + '\'' +
                ", profileImage='" + profileImage + '\'' +
                ", dataIndex=" + dataIndex +
                '}';
    }
}
