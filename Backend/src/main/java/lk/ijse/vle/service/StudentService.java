package lk.ijse.vle.service;

import lk.ijse.vle.dto.*;

import java.util.ArrayList;

public interface StudentService {

    EmailDTO submitStudentRegistrationFreePortal(RegistrationCarrierDTO registrationCarrierDTO);

    boolean updateStudent(StudentDTO studentDTO);

    ArrayList<StudentDTO> getAllStudentData();

    StudentDTO getStudentData(String studentId);

    ArrayList<RegistrationDTO> getAllStudentRegistrations(String studentId);

    UndergraduateDetailsDTO getUndergraduateData(String regId);

    PostgraduateDetailsDTO getPostgraduateData(String regId);
}
