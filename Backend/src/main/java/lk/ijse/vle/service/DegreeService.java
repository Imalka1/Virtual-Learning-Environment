package lk.ijse.vle.service;

import lk.ijse.vle.dto.DegreeDTO;

import java.util.ArrayList;

public interface DegreeService {

    ArrayList<DegreeDTO> loadCoursesViaFaculty(String faculty);

    DegreeDTO getGraduationTypeAndFee(String degree);

    DegreeDTO getCourseFee(String degree);
}
