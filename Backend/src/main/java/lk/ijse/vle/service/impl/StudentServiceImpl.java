package lk.ijse.vle.service.impl;

import lk.ijse.vle.dto.*;
import lk.ijse.vle.entity.*;
import lk.ijse.vle.repository.*;
import lk.ijse.vle.service.StudentService;
import lk.ijse.vle.utilities.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private DegreeRepository degreeRepository;
    @Autowired
    private IntakeRepository intakeRepository;
    @Autowired
    private UndergraduateDetailsRepository undergraduateDetailsRepository;
    @Autowired
    private PostgraduateDetailsRepository postgraduateDetailsRepository;
    @Autowired
    private RegistrationRepository registrationRepository;
    @Autowired
    private StudentChequePaymentRepository studentChequePaymentRepository;
    @Autowired
    private StudentCardPaymentRepository studentCardPaymentRepository;
    @Autowired
    private StudentCashPaymentRepository studentCashPaymentRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public EmailDTO submitStudentRegistrationFreePortal(RegistrationCarrierDTO registrationCarrierDTO) {
        EmailDTO emailDTO = new EmailDTO();
        if (registrationCarrierDTO.getGraduationType().equals("Undergraduate")) {
            Student student;
            if (registrationCarrierDTO.getSubmitType().equals("Free")) {
                student = setStudent(registrationCarrierDTO.getUnderGraduate().getRegistration());
            } else {
                student = studentRepository.findById(registrationCarrierDTO.getUnderGraduate().getRegistration().getStudent().getStudentID()).get();
            }

            Registration registration = setRegistration(student, registrationCarrierDTO.getUnderGraduate().getRegistration());

            UndergraduateDetails undergraduateDetails = new UndergraduateDetails();
            undergraduateDetails.setAlResults(registrationCarrierDTO.getUnderGraduate().getAlResults());
            undergraduateDetails.setYearAl(registrationCarrierDTO.getUnderGraduate().getYearAl());
            undergraduateDetails.setZscore(registrationCarrierDTO.getUnderGraduate().getZscore());
            undergraduateDetails.setSchool(registrationCarrierDTO.getUnderGraduate().getSchool());
            undergraduateDetails.setRegistration(registration);

            String maxRegId = undergraduateDetailsRepository.getMaxId(registrationCarrierDTO.getUnderGraduate().getRegistration().getDegree().getDegreeName(), new SimpleDateFormat("yyyy").format(new Date()));
            undergraduateDetails.setDataIndex(setMaxId(maxRegId, registration));

            studentRepository.save(student);
            registrationRepository.save(registration);
            setPayment(registrationCarrierDTO, registration);
            undergraduateDetailsRepository.save(undergraduateDetails);

            emailDTO = EmailService.getEmailService().sendEmail(student.getStudentPassword(), registrationCarrierDTO.getUnderGraduate(), registration.getRegistrationId(), student.getStudentID());
            emailDTO.setReply(emailDTO.getReply() + "," + registration.getRegistrationId() + "," + student.getStudentID());

        } else if (registrationCarrierDTO.getGraduationType().equals("Postgraduate")) {
            Student student;
            if (registrationCarrierDTO.getSubmitType().equals("Free")) {
                student = setStudent(registrationCarrierDTO.getPostGraduate().getRegistration());
            } else {
                student = studentRepository.findById(registrationCarrierDTO.getPostGraduate().getRegistration().getStudent().getStudentID()).get();
            }

            Registration registration = setRegistration(student, registrationCarrierDTO.getPostGraduate().getRegistration());

            PostgraduateDetails postgraduateDetails = new PostgraduateDetails();
            postgraduateDetails.setInstitute(registrationCarrierDTO.getPostGraduate().getInstitute());
            postgraduateDetails.setYear(registrationCarrierDTO.getPostGraduate().getYear());
            postgraduateDetails.setQualifications(registrationCarrierDTO.getPostGraduate().getQualifications());
            postgraduateDetails.setRegistration(registration);

            String maxRegId = postgraduateDetailsRepository.getMaxId(registrationCarrierDTO.getPostGraduate().getRegistration().getDegree().getDegreeName(), new SimpleDateFormat("yyyy").format(new Date()));
            postgraduateDetails.setDataIndex(setMaxId(maxRegId, registration));

            studentRepository.save(student);
            registrationRepository.save(registration);
            setPayment(registrationCarrierDTO, registration);
            postgraduateDetailsRepository.save(postgraduateDetails);

            emailDTO = EmailService.getEmailService().sendEmail(student.getStudentPassword(), registrationCarrierDTO.getPostGraduate(), registration.getRegistrationId(), student.getStudentID());
            emailDTO.setReply(emailDTO.getReply() + "," + registration.getRegistrationId() + "," + student.getStudentID());
        }
        return emailDTO;
    }

    @Override
    public boolean updateStudent(StudentDTO studentDTO) {
        RegistrationDTO registrationDTO = new RegistrationDTO();
        registrationDTO.setStudent(studentDTO);
        Student studentObj = studentRepository.findById(studentDTO.getStudentID()).get();
        studentObj.setTitle(studentDTO.getTitle());
        studentObj.setNameWithInitials(studentDTO.getNameWithInitials());
        studentObj.setFullName(studentDTO.getFullName());
        studentObj.setAddress(studentDTO.getAddress());
        studentObj.setDateOfBirth(studentDTO.getDateOfBirth());
        studentObj.setEmail(studentDTO.getEmail());
        studentObj.setTelephone(studentDTO.getTelephone());
        studentObj.setGender(studentDTO.getGender());
        studentRepository.save(studentObj);
        return true;
    }

    @Override
    public ArrayList<StudentDTO> getAllStudentData() {
        List<Object[]> students = studentRepository.getAllStudents();
        ArrayList<StudentDTO> studentDTOS = new ArrayList<>();
        for (Object[] student : students) {
            StudentDTO studentDTO = new StudentDTO();
            studentDTO.setStudentID(student[0].toString());
            studentDTO.setNameWithInitials(student[1].toString());
            studentDTO.setEmail(student[2].toString());
            studentDTOS.add(studentDTO);
        }
        return studentDTOS;
    }

    @Override
    public StudentDTO getStudentData(String studentId) {
        Student student = studentRepository.findById(studentId).get();
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setStudentID(student.getStudentID());
        studentDTO.setTitle(student.getTitle());
        studentDTO.setNameWithInitials(student.getNameWithInitials());
        studentDTO.setFullName(student.getFullName());
        studentDTO.setAddress(student.getAddress());
        studentDTO.setDateOfBirth(student.getDateOfBirth());
        studentDTO.setEmail(student.getEmail());
        studentDTO.setTelephone(student.getTelephone());
        studentDTO.setGender(student.getGender());
        return studentDTO;
    }

    @Override
    public ArrayList<RegistrationDTO> getAllStudentRegistrations(String studentId) {
        List<Object[]> allStudentRegistrations = studentRepository.getAllStudentRegistrations(studentId);
        ArrayList<RegistrationDTO> registrationDTOS = new ArrayList<>();
        for (Object[] studentRegistration : allStudentRegistrations) {
            StudentDTO studentDTO = new StudentDTO();
            studentDTO.setNameWithInitials(studentRegistration[1].toString());
            DegreeDTO degreeDTO = new DegreeDTO();
            degreeDTO.setDegreeName(studentRegistration[2].toString());
            degreeDTO.setGraduationType(studentRegistration[3].toString());
            RegistrationDTO registrationDTO = new RegistrationDTO();
            registrationDTO.setRegistrationId(studentRegistration[0].toString());
            registrationDTO.setDate(studentRegistration[4].toString());
            registrationDTO.setStudent(studentDTO);
            registrationDTO.setDegree(degreeDTO);
            registrationDTOS.add(registrationDTO);
        }
        return registrationDTOS;
    }

    @Override
    public UndergraduateDetailsDTO getUndergraduateData(String regId) {
        List<Object[]> undergraduateDetails = studentRepository.getUndergraduateData(regId);
        UndergraduateDetailsDTO undergraduateDetailsDTO = new UndergraduateDetailsDTO();
        for (Object[] undergraduateData : undergraduateDetails) {
            IntakeDTO intakeDTO = new IntakeDTO();
            intakeDTO.setIntakeMonth(undergraduateData[4].toString());

            FacultyDTO facultyDTO = new FacultyDTO();
            facultyDTO.setFacultyName(undergraduateData[2].toString());

            DegreeDTO degreeDTO = new DegreeDTO();
            degreeDTO.setDegreeName(undergraduateData[3].toString());
            degreeDTO.setFaculty(facultyDTO);
            degreeDTO.setCourseFee(Double.parseDouble(undergraduateData[9].toString()));

            StudentDTO studentDTO = new StudentDTO();
            studentDTO.setStudentID(undergraduateData[1].toString());

            RegistrationDTO registrationDTO = new RegistrationDTO();
            registrationDTO.setRegistrationId(undergraduateData[0].toString());
            registrationDTO.setIntake(intakeDTO);
            registrationDTO.setStudent(studentDTO);
            registrationDTO.setDegree(degreeDTO);

            undergraduateDetailsDTO.setSchool(undergraduateData[5].toString());
            undergraduateDetailsDTO.setZscore(undergraduateData[6].toString());
            undergraduateDetailsDTO.setYearAl(undergraduateData[7].toString());
            undergraduateDetailsDTO.setAlResults(undergraduateData[8].toString());
            undergraduateDetailsDTO.setRegistration(registrationDTO);
        }
        return undergraduateDetailsDTO;
    }

    @Override
    public PostgraduateDetailsDTO getPostgraduateData(String regId) {
        return null;
    }

    /*Set Student*/
    private Student setStudent(RegistrationDTO registrationDTO) {
        Student student = new Student();
        student.setTitle(registrationDTO.getStudent().getTitle());
        student.setNameWithInitials(registrationDTO.getStudent().getNameWithInitials());
        student.setFullName(registrationDTO.getStudent().getFullName());
        student.setAddress(registrationDTO.getStudent().getAddress());
        student.setDateOfBirth(registrationDTO.getStudent().getDateOfBirth());
        student.setEmail(registrationDTO.getStudent().getEmail());
        student.setTelephone(registrationDTO.getStudent().getTelephone());
        student.setGender(registrationDTO.getStudent().getGender());
        student.setProfileImage("No");
        int randomNumber = getRandomNumber();
        student.setStudentPassword(randomNumber + "");

        String maxStudentId = studentRepository.getMaxId(new SimpleDateFormat("yyyy").format(new Date()));
        if (maxStudentId != null) {
            int id = Integer.parseInt(maxStudentId);
            student.setStudentID(new SimpleDateFormat("yyyy").format(new Date()) + "S" + (id + 1));
            student.setDataIndex(id + 1);
        } else {
            student.setStudentID(new SimpleDateFormat("yyyy").format(new Date()) + "S1");
            student.setDataIndex(1);
        }
        return student;
    }

    /*Set Registration*/
    private Registration setRegistration(Student student, RegistrationDTO registrationDTO) {
        Registration registration = new Registration();
        registration.setDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        registration.setStudent(student);
        String degreeId = degreeRepository.getDegreeId(registrationDTO.getDegree().getDegreeName());
        Degree degree = degreeRepository.findById(degreeId).get();
        registration.setDegree(degree);
        String intakeMonthId = intakeRepository.getIntakeMonthId(registrationDTO.getIntake().getIntakeMonth());
        Intake intake = intakeRepository.findById(Integer.parseInt(intakeMonthId)).get();
        registration.setIntake(intake);
        return registration;
    }

    private int setMaxId(String maxId, Registration registration) {
        if (maxId != null) {
            int id = Integer.parseInt(maxId);
            registration.setRegistrationId(new SimpleDateFormat("yyyy").format(new Date()) + registration.getDegree().getDegreeId() + (id + 1));
            return id + 1;
        } else {
            registration.setRegistrationId(new SimpleDateFormat("yyyy").format(new Date()) + registration.getDegree().getDegreeId() + "1");
            return 1;
        }
    }

    private void setPayment(RegistrationCarrierDTO registrationCarrierDTO, Registration registration) {
        if (registrationCarrierDTO.getPayType().equals("Cash")) {
            StudentCashPayment studentCashPayment = new StudentCashPayment();
            studentCashPayment.setAmount(registrationCarrierDTO.getCashPay().getAmount());
            studentCashPayment.setTotalFee(registrationCarrierDTO.getCashPay().getTotalFee());
            studentCashPayment.setPaymentDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
            studentCashPayment.setRegistration(registration);
            studentCashPaymentRepository.save(studentCashPayment);
        } else if (registrationCarrierDTO.getPayType().equals("Card")) {
            StudentCardPayment studentCardPayment = new StudentCardPayment();
            studentCardPayment.setAmount(registrationCarrierDTO.getCardPay().getAmount());
            studentCardPayment.setTotalFee(registrationCarrierDTO.getCardPay().getTotalFee());
            studentCardPayment.setCardNumber(registrationCarrierDTO.getCardPay().getCardNumber());
            studentCardPayment.setExpiryDate(registrationCarrierDTO.getCardPay().getExpiryDate());
            studentCardPayment.setNameOnCard(registrationCarrierDTO.getCardPay().getNameOnCard());
            studentCardPayment.setPaymentDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
            studentCardPayment.setSecurityCode(registrationCarrierDTO.getCardPay().getSecurityCode());
            studentCardPayment.setZipCode(registrationCarrierDTO.getCardPay().getZipCode());
            studentCardPayment.setRegistration(registration);
            studentCardPaymentRepository.save(studentCardPayment);
        } else if (registrationCarrierDTO.getPayType().equals("Cheque")) {
            StudentChequePayment studentChequePayment = new StudentChequePayment();
            studentChequePayment.setAccNumber(registrationCarrierDTO.getChequePay().getAccNumber());
            studentChequePayment.setAmount(registrationCarrierDTO.getChequePay().getAmount());
            studentChequePayment.setTotalFee(registrationCarrierDTO.getChequePay().getTotalFee());
            studentChequePayment.setBankName(registrationCarrierDTO.getChequePay().getBankName());
            studentChequePayment.setBranch(registrationCarrierDTO.getChequePay().getBranch());
            studentChequePayment.setChequeNumber(registrationCarrierDTO.getChequePay().getChequeNumber());
            studentChequePayment.setPaymentDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
            studentChequePayment.setRegistration(registration);
            studentChequePaymentRepository.save(studentChequePayment);
        }
    }

    private int getRandomNumber() {
        Random random = new Random();
        int number = 0;
        do {
            number = random.nextInt(1000000) + 1;
        } while (number < 100000);
        return number;
    }
}
