package lk.ijse.vle.service.impl;

import lk.ijse.vle.dto.DegreeDTO;
import lk.ijse.vle.repository.DegreeRepository;
import lk.ijse.vle.service.DegreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class DegreeServiceImpl implements DegreeService {

    @Autowired
    private DegreeRepository degreeRepository;

    @Override
    public ArrayList<DegreeDTO> loadCoursesViaFaculty(String faculty) {
        List<String> courses = degreeRepository.loadCoursesViaFaculty(faculty);
        ArrayList<DegreeDTO> degreeDTOS = new ArrayList<>();
        for (String degree : courses) {
            DegreeDTO degreeDTO = new DegreeDTO();
            degreeDTO.setDegreeName(degree);
            degreeDTOS.add(degreeDTO);
        }
        return degreeDTOS;
    }

    @Override
    public DegreeDTO getGraduationTypeAndFee(String degree) {
        List<Object[]> graduationTypeAndFeeList = degreeRepository.getGraduationTypeAndFee(degree);
        DegreeDTO degreeDTO = new DegreeDTO();
        for(Object[] graduationTypeAndFee:graduationTypeAndFeeList){
            degreeDTO.setGraduationType(graduationTypeAndFee[0].toString());
            degreeDTO.setCourseFee(Double.parseDouble(graduationTypeAndFee[1].toString()));
        }
        return degreeDTO;
    }

    @Override
    public DegreeDTO getCourseFee(String degree) {
        String courseFee = degreeRepository.getCourseFee(degree);
        DegreeDTO degreeDTO = new DegreeDTO();
        degreeDTO.setCourseFee(Double.parseDouble(courseFee));
        return degreeDTO;
    }
}
