package lk.ijse.vle.repository;

import lk.ijse.vle.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, String> {
    @Query(value = "SELECT studentID,nameWithInitials,profileImage FROM student WHERE (email=?1 || studentID=?1) && studentPassword=?2", nativeQuery = true)
    List<Object[]> getLogin(String userName, String userPassword);

    @Query(value = "SELECT max(dataIndex) FROM student where year(curdate())", nativeQuery = true)
    String getMaxId(String date);

    @Query(value = "select registrationId,nameWithInitials,degreeName,graduationType,date from student s,registration r,degree d where s.studentID=r.student_studentID && d.degreeId=r.degree_degreeId && s.studentID=?1", nativeQuery = true)
    List<Object[]> getAllStudentRegistrations(String studentId);

    @Query(value = "select registrationId,studentID,facultyName,degreeName,intakeMonth,school,zscore,yearAl,alResults,courseFee from registration r,student s,faculty f,degree d,intake i,undergraduatedetails u where f.facultyId=d.faculty_facultyId && s.studentID=r.student_studentID && i.intakeId=r.intake_intakeId && d.degreeId=r.degree_degreeId && r.registrationId=u.registration_registrationId && r.registrationId=?1", nativeQuery = true)
    List<Object[]> getUndergraduateData(String regId);

    @Query(value = "select studentID,nameWithInitials,email,dataIndex from student order by 4 desc", nativeQuery = true)
    List<Object[]> getAllStudents();
}
