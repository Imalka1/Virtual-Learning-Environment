package lk.ijse.vle.repository;

import lk.ijse.vle.entity.StudentChequePayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentChequePaymentRepository extends JpaRepository<StudentChequePayment, Integer> {
    @Query(value = "select studentChequePaymentId,totalFee,amount,paymentDate from studentchequepayment sc,registration r where sc.registration_registrationId=r.registrationId && r.registrationId=?1", nativeQuery = true)
    List<Object[]> getPaymentData(String regId);
}
