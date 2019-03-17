package lk.ijse.vle.repository;

import lk.ijse.vle.entity.UndergraduateDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UndergraduateDetailsRepository extends JpaRepository<UndergraduateDetails, Integer> {
    @Query(value = "SELECT max(ug.dataIndex) FROM undergraduatedetails ug,registration r,degree d,faculty f where ug.registration_registrationId=r.registrationId && r.degree_degreeId=d.degreeId && d.degreeName=?1 && year(r.date)=?2", nativeQuery = true)
    String getMaxId(String degreeName, String date);
}
