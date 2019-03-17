package lk.ijse.vle.repository;

import lk.ijse.vle.entity.StudentCardPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentCardPaymentRepository extends JpaRepository<StudentCardPayment, Integer> {
    @Query(value = "select studentCardPaymentId,totalFee,amount,paymentDate from studentcardpayment sc,registration r where sc.registration_registrationId=r.registrationId && r.registrationId=?1", nativeQuery = true)
    List<Object[]> getPaymentData(String regId);
}
