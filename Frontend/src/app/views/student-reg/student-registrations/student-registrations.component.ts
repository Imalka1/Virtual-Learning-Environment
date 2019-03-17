import {Component, OnInit} from '@angular/core';
import {Faculty} from "../../../dtos/faculty";
import {Degree} from "../../../dtos/degree";
import {Intake} from "../../../dtos/intake";
import {ActivatedRoute, Router} from "@angular/router";
import {Student} from "../../../dtos/student";
import "../../../../assets/js/data-tables.js";
import {LoginStatus} from "../../../classes/login-status";
import {FacultyService} from "../../../services/common/faculty/faculty.service";
import {DegreeService} from "../../../services/common/degree/degree.service";
import {IntakeService} from "../../../services/common/intake/intake.service";
import {StudentRegistrationService} from "../../../services/student-reg/student-registration/student-registration.service";
import {WizardColorService} from "../../../services/common/wizard-color/wizard-color.service";
import {UndergraduateDetails} from "../../../dtos/registration/undergraduate-details";
import {Registration} from "../../../dtos/registration/registration";
import {PostgraduateDetails} from "../../../dtos/registration/postgraduate-details";

declare var loadDatatable: any;

@Component({
  selector: 'app-student-registrations',
  templateUrl: './student-registrations.component.html',
  styleUrls: ['./student-registrations.component.css']
})
export class StudentRegistrationsComponent implements OnInit {
  p: number = 1;
  selectedRow: string = "";
  graduationType: string = "Undergraduate";
  registration: Registration = new Registration();
  faculty: Faculty = new Faculty();
  degree: Degree = new Degree();
  intake: Intake = new Intake();
  underGraduate: UndergraduateDetails = new UndergraduateDetails();
  postGraduate: PostgraduateDetails = new PostgraduateDetails();
  registrations: Array<Registration> = new Array();
  faculties: Array<Faculty> = new Array();
  months: Array<Intake> = new Array();
  degrees: Array<Degree> = new Array();
  inputs: Array<boolean> = [false, false, false, false, false, false, false, false];

  constructor(private route: ActivatedRoute, private router: Router, private facultyService: FacultyService, private intakeService: IntakeService, private degreeService: DegreeService, private studentRegistrationService: StudentRegistrationService, private wizardColor: WizardColorService) {
    this.registration.student = new Student();
    this.registration.degree = this.degree;
    this.registration.degree.faculty = this.faculty;
    this.registration.intake = this.intake;
  }

  ngOnInit() {
    this.loadAllFacultiesIntakes();
    this.loadRegistrationDataToTable();
  }

  /*Submit data to next page*/
  saveRegistration() {
    // if (this.checkInputFields()) {
    //   this.underGraduate.registration = this.registration;
    //   this.studentRegistrationService.setUndergraduate(this.underGraduate);
    //   // if (this.loginStatus() == 5) {
    //   //   this.studentRegistrationService.saveUnderGraduateRegistration_FreePortal(this.underGraduate).subscribe(
    //   //     (result) => {
    //   //       this.studentRegistrationService.setEmailReply(result);
    //   //       this.wizardColor.setStudentWizardGreen(2);
    //   //       this.router.navigate(['/root/main/student-reg/student-summary']);
    //   //     }
    //   //   );
    //   // } else if (this.loginStatus() == 2) {
    //   //   this.wizardColor.setStudentWizardGreen(3);
    //   //   this.router.navigate(['/root/main/student-reg/semester-payments']);
    //   // }
    // } else {
    //   this.postGraduate.registration = this.registration;
    //   this.studentRegistrationService.setPostgraduate(this.postGraduate);
    //   // if (this.loginStatus() == 5) {
    //   //   this.studentRegistrationService.savePostGraduateRegistration_FreePortal(this.postGraduate).subscribe(
    //   //     (result) => {
    //   //       this.studentRegistrationService.setEmailReply(result);
    //   //       this.wizardColor.setStudentWizardGreen(2);
    //   //       this.router.navigate(['/root/main/student-reg/student-summary']);
    //   //     }
    //   //   );
    //   // } else if (this.loginStatus() == 2) {
    //   //   this.wizardColor.setStudentWizardGreen(3);
    //   //   this.router.navigate(['/root/main/student-reg/semester-payments']);
    //   // }
    // }
    if (this.registration.registrationId == undefined) {
      this.underGraduate.registration = this.registration;
      this.postGraduate.registration = this.registration;
      this.studentRegistrationService.setRegistration(this.underGraduate, this.postGraduate, this.graduationType, this.registration);
      this.wizardColor.setStudentWizardGreen(2);
      this.router.navigate(['/root/main/student-reg/student-payments']);
    }else{

    }
  }

  resetId() {
    this.registration = new Registration();
    this.registration.student = new Student();
    this.registration.degree = this.degree;
    this.registration.degree.faculty = this.faculty;
    this.registration.intake = this.intake;
    this.underGraduate = new UndergraduateDetails();
    this.postGraduate = new PostgraduateDetails();
  }

  nextPage(): void {
    this.underGraduate.registration = this.registration;
    this.postGraduate.registration = this.registration;
    this.studentRegistrationService.setRegistration(this.underGraduate, this.postGraduate, this.graduationType, this.registration);
    this.wizardColor.setStudentWizardGreen(2);
    this.router.navigate(['/root/main/student-reg/student-payments']);
  }

  previousPage(): void {
    this.wizardColor.setStudentWizardGreen(0);
    this.router.navigate(['/root/main/student-reg/student-details']);
  }

  /*--------------------------------------------Get data from fields----------------------------------------------------*/

  /*Save undergraduate or postgraduate data to local storage*/
  saveToLocalStorage() {
    let reg_details: any = [this.registration.intake.intakeMonth];
    for (let i = 0; i < reg_details.length; i++) {
      if (reg_details[i] != null) {
        if (reg_details[i] != "") {
          localStorage.setItem('student-registration' + i, reg_details[i]);
        }
      }
    }
    if (this.checkInputFields()) {
      let reg_details1: any = [this.underGraduate.school, this.underGraduate.zscore, this.underGraduate.yearAl, this.underGraduate.alResults];
      for (let i = 3; i < reg_details1.length + 3; i++) {
        if (reg_details1[i - 3] != null) {
          if (reg_details1[i - 3] != "") {
            localStorage.setItem('student-registration' + i, reg_details1[i - 3]);
          }
        }
      }
    } else {
      let reg_details2: any = [this.postGraduate.institute, this.postGraduate.year, this.postGraduate.qualifications];
      for (let i = 7; i < reg_details2.length + 7; i++) {
        if (reg_details2[i - 7] != null) {
          if (reg_details2[i - 7] != "") {
            localStorage.setItem('student-registration' + i, reg_details2[i - 7]);
          }
        }
      }
    }
  }

  /*---------------------------------------------Set data to fields-----------------------------------------------------*/

  /*Load Faculties and Intakes*/
  loadAllFacultiesIntakes() {
    this.intakeService.getAllMonths().subscribe(
      (result) => {
        this.months = result;
        if (localStorage.getItem('student-registration0') == null) {
          localStorage.setItem('student-registration0', this.months[0].intakeMonth)
        }
        this.registration.intake.intakeMonth = localStorage.getItem('student-registration0');

        this.facultyService.getAllFaculties().subscribe(
          (result) => {
            this.faculties = result;
            if (localStorage.getItem('student-registration1') == null) {
              this.registration.degree.faculty.facultyName = this.faculties[0].facultyName;
              localStorage.setItem('student-registration1', this.faculties[0].facultyName)
            } else {
              this.registration.degree.faculty.facultyName = localStorage.getItem('student-registration1');
            }
            this.loadCoursesViaFaculty(true);
          }
        )
      }
    )
  }

  /*Load courses(degree) via faculty*/
  loadCoursesViaFaculty(getItem: boolean) {
    this.degreeService.loadCoursesViaFaculty(this.registration.degree.faculty.facultyName).subscribe(
      (result) => {
        this.degrees = result;
        if (localStorage.getItem('student-registration2') == null || !getItem) {
          this.registration.degree.degreeName = this.degrees[0].degreeName;
        } else if (getItem) {
          this.registration.degree.degreeName = localStorage.getItem('student-registration2');
        }
        localStorage.setItem('student-registration1', this.registration.degree.faculty.facultyName);
        localStorage.setItem('student-registration2', this.registration.degree.degreeName)
        this.loadInputFields();
      }
    )
  }

  /*Set undergraduate or postgraduate data via local storage*/
  loadInputFields(): void {
    let degree: Degree;
    this.degreeService.getGraduationTypeAndFee(this.registration.degree.degreeName).subscribe(
      (result) => {
        degree = result;
        this.graduationType = degree.graduationType;
        this.registration.degree.graduationType = degree.graduationType;
        this.registration.degree.courseFee = degree.courseFee;
        localStorage.setItem('student-registration2', this.registration.degree.degreeName);
        if (this.checkInputFields()) {
          this.underGraduate.school = localStorage.getItem('student-registration3');
          this.underGraduate.zscore = localStorage.getItem('student-registration4')
          this.underGraduate.yearAl = localStorage.getItem('student-registration5');
          this.underGraduate.alResults = localStorage.getItem('student-registration6');
        } else {
          this.postGraduate.institute = localStorage.getItem('student-registration7');
          this.postGraduate.year = localStorage.getItem('student-registration8');
          this.postGraduate.qualifications = localStorage.getItem('student-registration9');
        }
      }
    )
  }

  /*Load data to table*/
  loadRegistrationDataToTable() {
    this.studentRegistrationService.getAllRegistrationData(this.studentRegistrationService.getStudent().studentID).subscribe(
      (result) => {
        this.registrations = result;
        loadDatatable();
      }
    )
  }

  /*Load data to fields (when click on table)*/
  selectRegistration(tableData: Registration) {
    this.selectedRow = tableData.registrationId;
    this.graduationType = tableData.degree.graduationType;
    if (tableData.degree.graduationType == "Undergraduate") {
      this.studentRegistrationService.getUndergraduateData(tableData.registrationId).subscribe(
        (result) => {
          this.underGraduate = result;
          this.registration = this.underGraduate.registration;
        }
      );
    } else {
      this.studentRegistrationService.getPostgraduateData(tableData.registrationId).subscribe(
        (result) => {
          this.postGraduate = result;
          this.registration = this.postGraduate.registration;
        }
      );
    }
  }

  /*----------------------------------------------------Booleans--------------------------------------------------------*/

  /*Check whether undergraduate or postgraduate*/
  checkInputFields(): boolean {
    return this.graduationType == "Undergraduate";
  }

  /*Get login status*/
  loginStatus(): number {
    return LoginStatus.getLoginStatus();
  }
}
