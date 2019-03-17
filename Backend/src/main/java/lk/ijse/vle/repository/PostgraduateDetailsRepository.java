package lk.ijse.vle.repository;

import lk.ijse.vle.entity.PostgraduateDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PostgraduateDetailsRepository extends JpaRepository<PostgraduateDetails,Integer> {
    @Query(value = "SELECT max(pg.dataIndex) FROM postgraduatedetails pg,registration r,degree d,faculty f where pg.registration_registrationId=r.registrationId && r.degree_degreeId=d.degreeId && d.degreeName=?1 && year(r.date)=?2", nativeQuery = true)
    String getMaxId(String degreeName, String date);
}
