package lk.ijse.vle.dto;

public class EmailDTO {
    private String emailAddress;
    private int verNumber;
    private String reply;
    private String userName;

    public EmailDTO(String emailAddress, int verNumber, String reply, String userName) {
        this.emailAddress = emailAddress;
        this.verNumber = verNumber;
        this.reply = reply;
        this.userName = userName;
    }

    public EmailDTO() {

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public int getVerNumber() {
        return verNumber;
    }

    public void setVerNumber(int verNumber) {
        this.verNumber = verNumber;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }
}
