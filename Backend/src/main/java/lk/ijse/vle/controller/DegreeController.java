package lk.ijse.vle.controller;

import lk.ijse.vle.dto.DegreeDTO;
import lk.ijse.vle.service.DegreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/degree")
public class DegreeController {

    @Autowired
    private DegreeService degreeService;

    @GetMapping(value = "/graduationTypeAndFee", produces = MediaType.APPLICATION_JSON_VALUE)
    public DegreeDTO getGraduationTypeAndFee(@RequestParam(value = "degree", required = false) String degree) { return degreeService.getGraduationTypeAndFee(degree); }

//    @GetMapping(value = "/courseFee", produces = MediaType.APPLICATION_JSON_VALUE)
//    public DegreeDTO getCourseFee(@RequestParam(value = "degree", required = false) String degree) { return degreeService.getCourseFee(degree); }

    @GetMapping(value = "/coursesViaFaculty", produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<DegreeDTO> loadCoursesViaFaculty(@RequestParam(value = "faculty", required = false) String faculty) { return degreeService.loadCoursesViaFaculty(faculty); }
}
