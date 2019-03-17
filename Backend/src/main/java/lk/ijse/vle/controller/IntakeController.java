package lk.ijse.vle.controller;

import lk.ijse.vle.dto.IntakeDTO;
import lk.ijse.vle.service.IntakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/intake")
public class IntakeController {

    @Autowired
    private IntakeService intakeService;

    @GetMapping(value = "/intakeMonths", produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<IntakeDTO> getAllMonths() {
        return intakeService.getAllMonths();
    }
}
