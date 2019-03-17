package lk.ijse.vle.repository;

import lk.ijse.vle.entity.Registration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationRepository extends JpaRepository<Registration, String> {
}
