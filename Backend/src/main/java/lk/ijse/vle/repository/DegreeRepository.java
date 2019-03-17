package lk.ijse.vle.repository;

import lk.ijse.vle.entity.Degree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DegreeRepository extends JpaRepository<Degree, String> {

    @Query(value = "SELECT degreeName FROM degree d,faculty f WHERE d.faculty_facultyId=f.facultyId AND f.facultyName=?1", nativeQuery = true)
    List<String> loadCoursesViaFaculty(String faculty);

    @Query(value = "SELECT graduationType,courseFee FROM degree WHERE degreeName=?1", nativeQuery = true)
    List<Object[]> getGraduationTypeAndFee(String degree);

    @Query(value = "SELECT courseFee FROM degree WHERE degreeName=?1", nativeQuery = true)
    String getCourseFee(String degree);

    @Query(value = "SELECT degreeId FROM degree WHERE degreeName=?1", nativeQuery = true)
    String getDegreeId(String degree);
}
