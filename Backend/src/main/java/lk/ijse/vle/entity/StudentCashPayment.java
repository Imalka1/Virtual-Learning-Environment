package lk.ijse.vle.entity;

import javax.persistence.*;

@Entity
public class StudentCashPayment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentCashPaymentId;
    @OneToOne
    private Registration registration;
    private String paymentDate;
    private double amount;
    private double totalFee;

    public StudentCashPayment() {
    }

    public double getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(double totalFee) {
        this.totalFee = totalFee;
    }

    public int getStudentCashPaymentId() {
        return studentCashPaymentId;
    }

    public void setStudentCashPaymentId(int studentCashPaymentId) {
        this.studentCashPaymentId = studentCashPaymentId;
    }

    public Registration getRegistration() {
        return registration;
    }

    public void setRegistration(Registration registration) {
        this.registration = registration;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "StudentCashPayment{" +
                "studentCashPaymentId=" + studentCashPaymentId +
                ", registration=" + registration +
                ", paymentDate='" + paymentDate + '\'' +
                ", amount=" + amount +
                ", totalFee=" + totalFee +
                '}';
    }
}
