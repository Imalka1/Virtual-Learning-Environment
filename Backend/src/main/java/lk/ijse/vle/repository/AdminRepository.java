package lk.ijse.vle.repository;

import lk.ijse.vle.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AdminRepository extends JpaRepository<Admin, String> {
    @Query(value = "SELECT adminID,nameWithInitials,profileImage FROM admin WHERE (email=?1 || adminID=?1) && adminPassword=?2", nativeQuery = true)
    List<Object[]> getLogin(String userName, String userPassword);
}
