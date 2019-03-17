package lk.ijse.vle.service.impl;

import lk.ijse.vle.dto.IntakeDTO;
import lk.ijse.vle.entity.Intake;
import lk.ijse.vle.repository.IntakeRepository;
import lk.ijse.vle.service.IntakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class IntakeServiceImpl implements IntakeService {

    @Autowired
    private IntakeRepository intakeRepository;

    @Override
    public ArrayList<IntakeDTO> getAllMonths() {
        List<Intake> intakes = intakeRepository.findAll();
        ArrayList<IntakeDTO> intakeDTOS = new ArrayList<>();
        for (Intake intake : intakes) {
            IntakeDTO intakeDTO = new IntakeDTO();
            intakeDTO.setIntakeMonth(intake.getIntakeMonth());
            intakeDTOS.add(intakeDTO);
        }
        return intakeDTOS;
    }
}
