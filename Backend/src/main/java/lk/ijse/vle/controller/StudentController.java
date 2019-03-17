package lk.ijse.vle.controller;

import lk.ijse.vle.dto.*;
import lk.ijse.vle.service.PaymentService;
import lk.ijse.vle.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/student")
public class StudentController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private PaymentService paymentService;

    @PostMapping(value = "/submitStudentRegistration", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public EmailDTO submitStudentRegistration(@RequestBody RegistrationCarrierDTO registrationCarrierDTO) {
        return studentService.submitStudentRegistrationFreePortal(registrationCarrierDTO);
    }

    @PostMapping(value = "/updateStudent", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean updateStudent(@RequestBody StudentDTO studentDTO) {
        return studentService.updateStudent(studentDTO);
    }

    @GetMapping(value = "/getAllStudentData", produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<StudentDTO> getAllStudentData() {
        return studentService.getAllStudentData();
    }

    @GetMapping(value = "/getStudentData", produces = MediaType.APPLICATION_JSON_VALUE)
    public StudentDTO getStudentData(@RequestParam("studentId") String studentId) {
        return studentService.getStudentData(studentId);
    }

    @GetMapping(value = "/getAllStudentRegistrations", produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<RegistrationDTO> getAllStudentRegistrations(@RequestParam("studentId") String studentId) {
        return studentService.getAllStudentRegistrations(studentId);
    }

    @GetMapping(value = "/getUndergraduateData", produces = MediaType.APPLICATION_JSON_VALUE)
    public UndergraduateDetailsDTO getUndergraduateData(@RequestParam("regId") String regId) {
        return studentService.getUndergraduateData(regId);
    }

    @GetMapping(value = "/getPaymentData", produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<PaymentDTO> getPaymentData(@RequestParam("regId") String regId) {
        return paymentService.getPaymentData(regId);
    }

    @GetMapping(value = "/getPostgraduateData", produces = MediaType.APPLICATION_JSON_VALUE)
    public PostgraduateDetailsDTO getPostgraduateData(@RequestParam("regId") String regId) {
        return studentService.getPostgraduateData(regId);
    }
}
