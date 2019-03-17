package lk.ijse.vle.repository;

import lk.ijse.vle.entity.StudentCashPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentCashPaymentRepository extends JpaRepository<StudentCashPayment, Integer> {
    @Query(value = "select studentCashPaymentId,totalFee,amount,paymentDate from studentcashpayment sc,registration r where sc.registration_registrationId=r.registrationId && r.registrationId=?1", nativeQuery = true)
    List<Object[]> getPaymentData(String regId);
}
