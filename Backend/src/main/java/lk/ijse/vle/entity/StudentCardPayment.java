package lk.ijse.vle.entity;

import javax.persistence.*;

@Entity
public class StudentCardPayment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentCardPaymentId;
    @OneToOne
    private Registration registration;
    private String cardNumber;
    private String nameOnCard;
    private String expiryDate;
    private String securityCode;
    private String zipCode;
    private String paymentDate;
    private double amount;
    private double totalFee;

    public StudentCardPayment() {
    }

    public double getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(double totalFee) {
        this.totalFee = totalFee;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public int getStudentCardPaymentId() {
        return studentCardPaymentId;
    }

    public void setStudentCardPaymentId(int studentCardPaymentId) {
        this.studentCardPaymentId = studentCardPaymentId;
    }

    public Registration getRegistration() {
        return registration;
    }

    public void setRegistration(Registration registration) {
        this.registration = registration;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getNameOnCard() {
        return nameOnCard;
    }

    public void setNameOnCard(String nameOnCard) {
        this.nameOnCard = nameOnCard;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "StudentCardPayment{" +
                "studentCardPaymentId=" + studentCardPaymentId +
                ", registration=" + registration +
                ", cardNumber='" + cardNumber + '\'' +
                ", nameOnCard='" + nameOnCard + '\'' +
                ", expiryDate='" + expiryDate + '\'' +
                ", securityCode='" + securityCode + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", paymentDate='" + paymentDate + '\'' +
                ", amount=" + amount +
                ", totalFee=" + totalFee +
                '}';
    }
}
