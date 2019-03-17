package lk.ijse.vle.entity;

import javax.persistence.*;

@Entity
public class StudentChequePayment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentChequePaymentId;
    @OneToOne
    private Registration registration;
    private String chequeNumber;
    private String bankName;
    private String branch;
    private String accNumber;
    private String paymentDate;
    private double amount;
    private double totalFee;

    public StudentChequePayment() {
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(double totalFee) {
        this.totalFee = totalFee;
    }

    public int getStudentChequePaymentId() {
        return studentChequePaymentId;
    }

    public void setStudentChequePaymentId(int studentChequePaymentId) {
        this.studentChequePaymentId = studentChequePaymentId;
    }

    public Registration getRegistration() {
        return registration;
    }

    public void setRegistration(Registration registration) {
        this.registration = registration;
    }

    public String getChequeNumber() {
        return chequeNumber;
    }

    public void setChequeNumber(String chequeNumber) {
        this.chequeNumber = chequeNumber;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(String accNumber) {
        this.accNumber = accNumber;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    @Override
    public String toString() {
        return "StudentChequePayment{" +
                "studentChequePaymentId=" + studentChequePaymentId +
                ", registration=" + registration +
                ", chequeNumber='" + chequeNumber + '\'' +
                ", bankName='" + bankName + '\'' +
                ", branch='" + branch + '\'' +
                ", accNumber='" + accNumber + '\'' +
                ", paymentDate='" + paymentDate + '\'' +
                ", amount=" + amount +
                ", totalFee=" + totalFee +
                '}';
    }
}
