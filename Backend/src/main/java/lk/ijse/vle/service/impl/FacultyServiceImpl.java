package lk.ijse.vle.service.impl;

import lk.ijse.vle.dto.FacultyDTO;
import lk.ijse.vle.entity.Faculty;
import lk.ijse.vle.repository.FacultyRepository;
import lk.ijse.vle.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class FacultyServiceImpl implements FacultyService {

    @Autowired
    private FacultyRepository facultyRepository;

    @Override
    public ArrayList<FacultyDTO> getAllFaculties() {
        List<Faculty> faculties = facultyRepository.findAll();
        ArrayList<FacultyDTO> facultyDTOS = new ArrayList<>();
        for (Faculty faculty : faculties) {
            FacultyDTO facultyDTO = new FacultyDTO();
            facultyDTO.setFacultyName(faculty.getFacultyName());
            facultyDTOS.add(facultyDTO);
        }
        return facultyDTOS;
    }
}
