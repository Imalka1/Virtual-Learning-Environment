package lk.ijse.vle.controller;

import lk.ijse.vle.dto.EmailDTO;
import lk.ijse.vle.dto.FacultyDTO;
import lk.ijse.vle.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/faculty")
public class FacultyController {

    @Autowired
    private FacultyService facultyService;

    @GetMapping(value = "/facultyNames", produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<FacultyDTO> getAllFaculties() {
        return facultyService.getAllFaculties();
    }

}
