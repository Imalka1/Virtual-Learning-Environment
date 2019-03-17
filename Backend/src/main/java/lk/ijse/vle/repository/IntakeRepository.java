package lk.ijse.vle.repository;

import lk.ijse.vle.entity.Intake;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IntakeRepository extends JpaRepository<Intake, Integer> {
    @Query(value = "SELECT intakeId FROM intake WHERE intakeMonth=?1", nativeQuery = true)
    String getIntakeMonthId(String intakeMonth);
}
