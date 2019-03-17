import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {WizardColorService} from "../../../services/common/wizard-color/wizard-color.service";
import {LoginStatus} from "../../../classes/login-status";
import "../../../../assets/js/data-tables.js";
import {StudentRegistrationService} from '../../../services/student-reg/student-registration/student-registration.service';
import {Registration} from '../../../dtos/registration/registration';
import {Student} from "../../../dtos/student";
import {Faculty} from "../../../dtos/faculty";
import {Degree} from "../../../dtos/degree";

declare var loadDatatable: any;

@Component({
  selector: 'app-semester-registration',
  templateUrl: './semester-registration.component.html',
  styleUrls: ['./semester-registration.component.css']
})
export class SemesterRegistrationComponent implements OnInit {
  p: number = 1;
  registration: Registration = new Registration();

  constructor(private router: Router, private wizardColor: WizardColorService, private studentRegistrationService: StudentRegistrationService) {
    this.registration.student = new Student();
    this.registration.degree = new Degree();
    this.registration.degree.faculty = new Faculty();
  }

  ngOnInit() {
    this.registration = this.studentRegistrationService.getRegistration();
    loadDatatable();
  }

  previousPage(): void {
    this.wizardColor.setStudentWizardGreen(2);
    this.router.navigate(['/root/main/student-reg/student-payments']);
  }

  nextPage(): void {
    this.wizardColor.setStudentWizardGreen(4);
    this.router.navigate(['/root/main/student-reg/semester-payments']);
  }

  loadDepartments(){

  }

  /*Get login status*/
  loginStatus(): number {
    return LoginStatus.getLoginStatus();
  }
}
