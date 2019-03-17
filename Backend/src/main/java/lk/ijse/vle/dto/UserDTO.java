package lk.ijse.vle.dto;

public class UserDTO {
    private String userID;
    private String userName;
    private String userPassword;
    private String accountType;
    private boolean authenticate;
    private String profileImage;

    public UserDTO() {
    }

    public UserDTO(String userID, String userName, String userPassword, String accountType, boolean authenticate, String profileImage) {
        this.userID = userID;
        this.userName = userName;
        this.userPassword = userPassword;
        this.accountType = accountType;
        this.authenticate = authenticate;
        this.profileImage = profileImage;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public boolean isAuthenticate() {
        return authenticate;
    }

    public void setAuthenticate(boolean authenticate) {
        this.authenticate = authenticate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }
}
